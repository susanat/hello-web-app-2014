package com.ipartek.formacion.helloweb.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.helloweb.bean.Mensaje;
import com.ipartek.formacion.helloweb.bean.Persona;
import com.ipartek.formacion.helloweb.constantes.Constantes;
import com.ipartek.formacion.helloweb.model.ModeloPersona;

/**
 * Servlet implementation class PersonaServlet
 */
public class PersonaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ModeloPersona model = null;
	// private String msg = "";
	private RequestDispatcher dispatcher;
	private Mensaje objMensaje;
	private ResourceBundle messages;

	// private final static Logger log = Logger.getLogger(PersonaServlet.class);

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		model = new ModeloPersona();
	}

	@Override
	public void destroy() {
		super.destroy();
		model = null;
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// log.info("Peticion realizada");

		// Aquí podriamos comprobar la autorización del usuario que hace la
		// petición
		// Si esta autorizado se le deja servir a los métodos doGet, doPost...
		// Si no esta autorizado se le bloquea el servicio
		super.service(req, resp);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// comprobar si es getAll o getById
		if (request.getParameter("id") == null) {
			getAll(request);
		} else {
			getById(request);
		}
		// redirigir a la vista
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		messages = ResourceBundle
				.getBundle("com.ipartek.formacion.helloweb.i18n.i18nmesages_"
						+ request.getSession().getAttribute(
								Constantes.USER_SESSION_IDIOMA));

		if (Constantes.OP_INSERT
				.equals(request.getParameter(Constantes.OP_KEY))) {
			insertar(request);
		} else if (Constantes.OP_UPDATE.equals(request
				.getParameter(Constantes.OP_KEY))) {
			actualizar(request);
		} else if (Constantes.OP_DELETE.equals(request
				.getParameter(Constantes.OP_KEY))) {
			eliminar(request);
		} else {
			opNotSuport(request);
		}
		request.setAttribute(Constantes.MSG_KEY, objMensaje);
		dispatcher.forward(request, response);
	}

	/**
	 * Si no existe la operación a realizar, mensaje y forward al list.jsp
	 */
	private void opNotSuport(HttpServletRequest request) {
		// Recargar la lista
		getAll(request);
		// Mensaje despues por si acaso el método crea otro mensaje
		objMensaje = new Mensaje(messages.getString("mensaje.not_allowed"),
				// Constantes.MSG_NOT_ALLOWED,
				Mensaje.MsgType.LOG, Constantes.COD_NOT_ALLOWED);
		// msg = Constantes.MSG_NOT_ALLOWED;
	}

	/**
	 * Obtener una persona por su id.
	 * 
	 * @param request
	 */
	private void getById(HttpServletRequest request) {
		// acceder al modelo
		Persona persona = model.getById(Integer.parseInt(request
				.getParameter("id")));
		// pasamos los atributos
		request.setAttribute(Constantes.ATT_PERSONA, persona);
		dispatcher = request
				.getRequestDispatcher(Constantes.JSP_BACK_PERSONA_FORM);
	}

	/**
	 * Obtener todas las personas.
	 * 
	 * @param request
	 */
	private void getAll(HttpServletRequest request) {
		// acceder al modelo
		ArrayList<Persona> personas = model.getAll();
		// pasamos los atributos
		request.setAttribute(Constantes.ATT_PERSONAS, personas);
		dispatcher = request
				.getRequestDispatcher(Constantes.JSP_BACK_PERSONA_LIST);
	}

	/**
	 * Eliminar una persona.
	 * 
	 * @param request
	 * @param i
	 *            id de la persona
	 */
	private void eliminar(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));

		if (model.delete(id)) {
			objMensaje = new Mensaje(messages.getString("mensaje.reg_delete"),
					// Constantes.MSG_REG_DELETE,
					Mensaje.MsgType.REG, Constantes.COD_REG_DELETE);
			// msg = Constantes.MSG_REG_DELETE;
		} else {
			objMensaje = new Mensaje(messages.getString("mensaje.err_delete"),
					// Constantes.MSG_ERR_DELETE,
					Mensaje.MsgType.ERR, Constantes.COD_ERR_DELETE);
			// msg = Constantes.MSG_ERR_DELETE;
		}
		// Recargar la lista
		getAll(request);
	}

	/**
	 * Actualizar una persona.
	 * 
	 * @param request
	 * @param p
	 *            persona
	 */
	private void actualizar(HttpServletRequest request) {
		// recoger parámetros
		Persona p = getParametros(request);

		if (p != null) {
			model.update(p);
			objMensaje = new Mensaje(messages.getString("mensaje.reg_update"),
					// Constantes.MSG_REG_UPDATE,
					Mensaje.MsgType.REG, Constantes.COD_REG_UPDATE);
			// msg = Constantes.MSG_REG_UPDATE;
		} else {
			objMensaje = new Mensaje(messages.getString("mensaje.err_param"),
					// Constantes.MSG_ERR_PARAM,
					Mensaje.MsgType.ERR, Constantes.COD_ERR_PARAM);
			// msg = Constantes.MSG_ERR_PARAM;
		}

		request.setAttribute(Constantes.ATT_PERSONA, p);
		// forward a la vista
		dispatcher = request
				.getRequestDispatcher(Constantes.JSP_BACK_PERSONA_FORM);
	}

	/**
	 * Crear una persona nueva.
	 * 
	 * @param request
	 * @param p
	 *            persona
	 */
	private void insertar(HttpServletRequest request) {
		// recoger parámetros
		Persona p = getParametros(request);

		if (p != null) {
			// insertarlo
			model.insert(p);
			objMensaje = new Mensaje(messages.getString("mensaje.reg_create"),
					// Constantes.MSG_REG_CREATE,
					Mensaje.MsgType.REG, Constantes.COD_REG_CREATE);
			// msg = Constantes.MSG_REG_CREATE;
		} else {
			objMensaje = new Mensaje(messages.getString("mensaje.err_param"),
					// Constantes.MSG_ERR_PARAM,
					Mensaje.MsgType.ERR, Constantes.COD_ERR_PARAM);
			// msg = Constantes.MSG_ERR_PARAM;
		}

		request.setAttribute(Constantes.ATT_PERSONA, p);
		// forward a la vista
		dispatcher = request
				.getRequestDispatcher(Constantes.JSP_BACK_PERSONA_FORM);
	}

	/**
	 * Recoger los parámetros del formulario de creación de persona.
	 * 
	 * @param request
	 *            objeto de petición
	 * @return objeto <code>Persona</code> con los parámetros, null si no se ha
	 *         podido crear el objeto
	 */
	private Persona getParametros(HttpServletRequest request) {
		Persona p = null;
		try {
			p = new Persona("");
			p.setId(Integer.parseInt(request.getParameter("id")));
			p.setNombre(request.getParameter("nombre"));
			p.setEdad(Integer.parseInt(request.getParameter("edad")));
			p.setRole(Persona.Rol.valueOf(request.getParameter("rol")));
		} catch (Exception e) {
			p = null;
			e.printStackTrace();
		}
		return p;
	}

}
