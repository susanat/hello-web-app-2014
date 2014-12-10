package com.ipartek.formacion.helloweb.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.helloweb.Constantes;
import com.ipartek.formacion.helloweb.bean.Mensaje;
import com.ipartek.formacion.helloweb.bean.Persona;
import com.ipartek.formacion.helloweb.model.ModeloPersona;

/**
 * Servlet implementation class PersonasServlet
 */
public class PersonaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	RequestDispatcher dispatcher = null;
	ModeloPersona model = null;
	Mensaje msg = null;
	int id = Persona.ID_NULL;// identificador persona

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

		// TODO comprobar autorizaciones del usuario

		// recoger paramtro identificador Persona
		try {
			id = Integer.parseInt(req.getParameter("id"));

		} catch (Exception e) {
			id = Persona.ID_NULL;
		}

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
		if (id == Persona.ID_NULL) {
			getAll(request);
		} else {
			getById(request);
		}

		// forward a la vista
		dispatcher.forward(request, response);
	}

	private void getById(HttpServletRequest request) {

		// acceder al modelo
		Persona p = model.getById(id);

		// pasamos los atributos
		request.setAttribute(Constantes.ATT_PERSONA, p);

		dispatcher = request
				.getRequestDispatcher(Constantes.JSP_BACK_PERSONA_FORM);

	}

	private void getAll(HttpServletRequest request) {

		// acceder al modelo
		ArrayList<Persona> personas = model.getAll();

		// pasamos los atributos
		request.setAttribute(Constantes.ATT_PERSONAS, personas);

		dispatcher = request
				.getRequestDispatcher(Constantes.JSP_BACK_PERSONA_LIST);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// chek operacion
		String op = request.getParameter(Constantes.OP_KEY);
		if (Constantes.OP_UPDATE.equals(op)) {
			update(request);
		} else if (Constantes.OP_DELETE.equals(op)) {
			delete(request);
		} else if (Constantes.OP_CREATE.equals(op)) {
			create(request);
		} else {
			opNotSuported(request);
		}

		request.setAttribute(Constantes.MSG_KEY, msg);

		dispatcher.forward(request, response);

	}

	/**
	 * si no existe la operaciona arealizar mensaje y forwar al lisado.jsp
	 *
	 * @param request
	 */
	private void opNotSuported(HttpServletRequest request) {

		getAll(request);
		msg = new Mensaje(Constantes.MSG_NOT_ALLOWED, Mensaje.MSG_TYPE_DANGER);

	}

	/**
	 * crear nueva persona e insertarla en la bbdd
	 *
	 * @param request
	 */
	private void create(HttpServletRequest request) {
		// recoger parametros
		Persona p = getParametrosPersona(request);

		if (p != null) {
			// insert
			// TODO comprobar insert
			model.insert(p);

			msg = new Mensaje(Constantes.MSG_REG_CREATE,
					Mensaje.MSG_TYPE_SUCCESS);
		} else {
			msg = new Mensaje(Constantes.MSG_ERROR_PARAMETERS,
					Mensaje.MSG_TYPE_DANGER);
		}

		// enviar atributos
		request.setAttribute(Constantes.ATT_PERSONA, p);

		// forward
		dispatcher = request
				.getRequestDispatcher(Constantes.JSP_BACK_PERSONA_FORM);

	}

	/**
	 * elimina la perona por su id y retorna a listado.jsp
	 *
	 * @param request
	 */
	private void delete(HttpServletRequest request) {

		if (model.delete(id)) {
			msg = new Mensaje(Constantes.MSG_REG_DELETE,
					Mensaje.MSG_TYPE_WARNING);
		} else {
			msg = new Mensaje(Constantes.MSG_REG_NOT_DELETE,
					Mensaje.MSG_TYPE_DANGER);
		}

		getAll(request);
		// request.setAttribute(Constantes.MSG_KEY, msg);
		// forward
		// dispatcher =
		// request.getRequestDispatcher(Constantes.JSP_BACK_PERSONA_LIST);

	}

	/**
	 * actualizar los datos de una persona y forward a form.jsp
	 *
	 * @param request
	 */
	private void update(HttpServletRequest request) {

		Persona p = getParametrosPersona(request);

		if (p != null) {

			// modificar
			p.setId(id);
			// TODO comprobar que realmente se a modificado
			model.update(p);

			msg = new Mensaje(Constantes.MSG_REG_UPDATE,
					Mensaje.MSG_TYPE_SUCCESS);
		} else {
			msg = new Mensaje(Constantes.MSG_ERROR_PARAMETERS,
					Mensaje.MSG_TYPE_DANGER);
		}

		request.setAttribute(Constantes.ATT_PERSONA, p);

		// forward
		dispatcher = request
				.getRequestDispatcher(Constantes.JSP_BACK_PERSONA_FORM);

	}

	/**
	 * Recoger los parametros de la request crear <code>Persona</code> Tambien
	 * gestiona los mensajes para el usuario
	 *
	 * @param request
	 * @return <code>Persona</code> inicializada con los parametros de la
	 *         request
	 */
	private Persona getParametrosPersona(HttpServletRequest request) {
		Persona p = null;

		try {

			p = new Persona("");
			p.setNombre(request.getParameter("nombre"));
			p.setEdad(Integer.parseInt(request.getParameter("edad")));
			p.setRoll(Persona.Roll.valueOf(request.getParameter("roll")));

		} catch (Exception e) {

			p = null;
			e.printStackTrace();
		}

		return p;
	}

}
