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
import com.ipartek.formacion.helloweb.bean.Calificacion;
import com.ipartek.formacion.helloweb.bean.Mensaje;
import com.ipartek.formacion.helloweb.i18n.I18n;
import com.ipartek.formacion.helloweb.listener.InitListener;
import com.ipartek.formacion.helloweb.model.ModeloCalificacion;
import com.ipartek.formacion.helloweb.util.MensajesIdiomas;

/**
 * Servlet implementation class CalificacionServlet.
 */
public class CalificacionServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	RequestDispatcher dispatcher = null;
	HttpSession session = null;
	ResourceBundle messages = null;

	Mensaje msg;

	int id = Calificacion.ID_NULL;
	String pIdioma = Constantes.DEFAULT_LANG;

	@Override
	public void init(final ServletConfig config) throws ServletException {
		super.init(config);
		InitListener.modeloCalificacion = new ModeloCalificacion();
	}

	@Override
	protected void service(final HttpServletRequest request, final HttpServletResponse response)
			throws ServletException, IOException {

		pIdioma = I18n.getBrowserLocale(request.getLocale());

		try {
			id = Integer.parseInt(request.getParameter("id"));
		} catch (final Exception e) {
			id = Calificacion.ID_NULL;
		}

		super.service(request, response);
	}

	@Override
	public void destroy() {
		super.destroy();
		InitListener.modeloCalificacion = null;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException,
	IOException {
		session = request.getSession();
		messages = MensajesIdiomas.loadMessages(pIdioma, session);

		// Comprobar si es getAll o getById, para ir a list.jsp o form.jsp
		if (id == Calificacion.ID_NULL) {
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
	 * Insert de un registro.
	 *
	 * @param request
	 */
	private void insert(final HttpServletRequest request) {
		final Calificacion c = getParametersCalificacion(request);

		if (c != null) {
			InitListener.modeloCalificacion.insert(c);
			// TODO comprobar la inserción
			msg = new Mensaje(Mensaje.MSG_TYPE_SUCCESS, messages.getString("msg.reg.inserted"));
		} else {
			msg = new Mensaje(Mensaje.MSG_TYPE_DANGER, messages.getString("msg.err.parameters"));
		}

		request.setAttribute(Constantes.ATTR_CALIFICACION, c);
		dispatcher = request.getRequestDispatcher(Constantes.JSP_BACKOFFICE_CALIFICACION_FORM);
	}

	/**
	 * Modifica los datos de una <code>Calificacion</code> y forward a list.jsp.
	 *
	 * @param request
	 */
	private void update(final HttpServletRequest request) {
		final Calificacion c = getParametersCalificacion(request);

		if (c != null) {
			c.setId(id);
			InitListener.modeloCalificacion.update(c);
			msg = new Mensaje(Mensaje.MSG_TYPE_WARNING, messages.getString("msg.reg.updated"));
		} else {
			msg = new Mensaje(Mensaje.MSG_TYPE_DANGER, messages.getString("msg.err.parameters"));
		}

		request.setAttribute(Constantes.ATTR_CALIFICACION, c);
		dispatcher = request.getRequestDispatcher(Constantes.JSP_BACKOFFICE_CALIFICACION_FORM);
	}

	/**
	 * Elimina la <code>Calificacion</code> por su ID y retorna al list.jsp.
	 *
	 * @param request
	 */
	private void delete(final HttpServletRequest request) {
		// if (modelo.delete(id)) {
		if (InitListener.modeloCalificacion.delete(id)) {
			msg = new Mensaje(Mensaje.MSG_TYPE_SUCCESS, messages.getString("msg.reg.deleted"));
		} else {
			msg = new Mensaje(Mensaje.MSG_TYPE_DANGER, messages.getString("msg.err.delete"));
		}

		getAll(request);
		dispatcher = request.getRequestDispatcher(Constantes.JSP_BACKOFFICE_CALIFICACION_LIST);
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
	 * Recoger parámetros de la request y crear <code>Calificacion</code>.
	 *
	 * @param request
	 * @return p <code>Persona</code> inicializada con los parámetros de la
	 *         request, en caso de fallo null
	 */
	private Calificacion getParametersCalificacion(final HttpServletRequest request) {
		Calificacion c = null;

		try {
			c = new Calificacion(0, "");
			if (request.getParameter("valor") != null) {
				c.setValor(Integer.parseInt(request.getParameter("valor")));
			}
			c.setTexto(request.getParameter("texto"));
		} catch (final Exception e) {
			c = null;
			e.printStackTrace();
		}

		return c;
	}

	/**
	 * Si hay una id va al detalle de la <code>Calificacion</code>.
	 *
	 * @param request
	 */
	private void getById(final HttpServletRequest request) {
		request.setAttribute(Constantes.ATTR_CALIFICACION, InitListener.modeloCalificacion.getById(id));
		dispatcher = request.getRequestDispatcher(Constantes.JSP_BACKOFFICE_CALIFICACION_FORM);
	}

	/**
	 * Si no hay id va a la lista de <code>Calificacion</code>.
	 *
	 * @param request
	 */
	private void getAll(final HttpServletRequest request) {
		request.setAttribute(Constantes.ATTR_CALIFICACIONES, InitListener.modeloCalificacion.getAll());
		dispatcher = request.getRequestDispatcher(Constantes.JSP_BACKOFFICE_CALIFICACION_LIST);
	}

}
