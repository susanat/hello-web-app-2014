package com.ipartek.formacion.helloweb.controller;

import java.io.IOException;
import java.util.ResourceBundle;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.helloweb.Constantes;
import com.ipartek.formacion.helloweb.bean.Mensaje;
import com.ipartek.formacion.helloweb.bean.Persona;
import com.ipartek.formacion.helloweb.i18n.I18n;
import com.ipartek.formacion.helloweb.i18n.Idioma;
import com.ipartek.formacion.helloweb.model.ModeloPersona;
import com.ipartek.formacion.helloweb.util.MensajesIdiomas;
import com.ipartek.formacion.helloweb.util.Rol;

/**
 * Servlet implementation class PersonaServlet.
 */
public class PersonaServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	RequestDispatcher dispatcher = null;
	HttpSession session = null;
	ResourceBundle messages = null;

	ModeloPersona modelo = null;
	Mensaje msg;

	int id = Persona.ID_NULL;
	String pIdioma = Idioma.INGLES.getLocale();

	@Override
	public void init(final ServletConfig config) throws ServletException {
		super.init(config);
		modelo = new ModeloPersona();
	}

	@Override
	protected void service(final HttpServletRequest request, final HttpServletResponse response)
			throws ServletException, IOException {

		pIdioma = I18n.getBrowserLocale(request.getLocale());

		// Recoger el id de Persona
		try {
			id = Integer.parseInt(request.getParameter("id"));
		} catch (final Exception e) {
			id = Persona.ID_NULL;
		}

		super.service(request, response);
	}

	@Override
	public void destroy() {
		super.destroy();
		modelo = null;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException,
			IOException {
		session = request.getSession();// Recuperar session
		messages = MensajesIdiomas.loadMessages(pIdioma, session);

		// Comprobar si es getAll o getById
		if (id == Persona.ID_NULL) {
			getAll(request);
		} else {
			getById(request);
		}

		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(final HttpServletRequest request, final HttpServletResponse response)
			throws ServletException, IOException {

		switch (Integer.parseInt(request.getParameter(Constantes.OP_CRUD))) {

		case Constantes.OP_INSERT:
			insert(request);
			break;

		case Constantes.OP_UPDATE:
			update(request);
			break;

		case Constantes.OP_DELETE:
			delete(request);
			break;

		default:
			opNotSupported(request);
		}

		request.setAttribute(Constantes.MSG_KEY, msg);
		dispatcher.forward(request, response);
	}

	/**
	 * Insert de un registro y gestión de mensajes al usuario.
	 *
	 * @param request
	 */
	private void insert(final HttpServletRequest request) {
		final Persona p = getParametersPersona(request);

		if (p != null) {
			modelo.insert(p);
			// TODO comprobar la inserción
			// msg = Constantes.MSG_REG_INSERTED;
			msg = new Mensaje(Mensaje.MSG_TYPE_SUCCESS, messages.getString("msg.reg.inserted"));
		} else {
			// msg = Constantes.MSG_ERR_PARAMETERS;
			msg = new Mensaje(Mensaje.MSG_TYPE_DANGER, messages.getString("msg.err.parameters"));
		}

		request.setAttribute(Constantes.ATTR_PERSONA, p);
		dispatcher = request.getRequestDispatcher(Constantes.JSP_BACKOFFICE_PERSONA_FORM);
	}

	/**
	 * Modifica los datos de una Persona y forward a list.jsp.
	 *
	 * @param request
	 */
	private void update(final HttpServletRequest request) {
		final Persona p = getParametersPersona(request);

		if (p != null) {
			p.setId(id);
			modelo.update(p);
			msg = new Mensaje(Mensaje.MSG_TYPE_WARNING, messages.getString("msg.reg.updated"));
		} else {
			msg = new Mensaje(Mensaje.MSG_TYPE_DANGER, messages.getString("msg.err.parameters"));
		}

		request.setAttribute(Constantes.ATTR_PERSONA, p);
		dispatcher = request.getRequestDispatcher(Constantes.JSP_BACKOFFICE_PERSONA_FORM);
	}

	/**
	 * Elimina la Persona por su ID y retorna al list.jsp.
	 *
	 * @param request
	 */
	private void delete(final HttpServletRequest request) {
		if (modelo.delete(id)) {
			msg = new Mensaje(Mensaje.MSG_TYPE_SUCCESS, messages.getString("msg.reg.deleted"));
		} else {
			msg = new Mensaje(Mensaje.MSG_TYPE_DANGER, messages.getString("msg.err.delete"));
		}

		getAll(request);
		dispatcher = request.getRequestDispatcher(Constantes.JSP_BACKOFFICE_PERSONA_LIST);
	}

	/**
	 * Si no existe la operación a realizar mensaje y forward a list.jsp.
	 *
	 * @param request
	 */
	private void opNotSupported(final HttpServletRequest request) {
		getAll(request);
		msg = new Mensaje(Mensaje.MSG_TYPE_DANGER, messages.getString("msg.op.not_supported"));
	}

	/**
	 * Recoger parámetros de la request y crear <code>Persona</code>.
	 *
	 * @param request
	 * @return p <code>Persona</code> inicializada con los parámetros de la
	 *         request, en caso de fallo null
	 */
	private Persona getParametersPersona(final HttpServletRequest request) {
		Persona p = null;

		try {
			p = new Persona("");
			p.setNombre(request.getParameter("nombre"));
			if (request.getParameter("edad") != null) {
				p.setEdad(Integer.parseInt(request.getParameter("edad")));
			}
			if (request.getParameter("rol") != null) {
				p.setRol(Rol.valueOf(request.getParameter("rol")));
			}
		} catch (final Exception e) {
			p = null;
			e.printStackTrace();
		}

		return p;
	}

	/**
	 * Si hay una id va al detalle de la <code>Persona</code>.
	 *
	 * @param request
	 */
	private void getById(final HttpServletRequest request) {
		request.setAttribute(Constantes.ATTR_PERSONA, modelo.getById(id));
		dispatcher = request.getRequestDispatcher(Constantes.JSP_BACKOFFICE_PERSONA_FORM);
	}

	/**
	 * Si no hay id va a la lista de Personas.
	 *
	 * @param request
	 */
	private void getAll(final HttpServletRequest request) {
		request.setAttribute(Constantes.ATTR_PERSONAS, modelo.getAll());
		dispatcher = request.getRequestDispatcher(Constantes.JSP_BACKOFFICE_PERSONA_LIST);
	}

}
