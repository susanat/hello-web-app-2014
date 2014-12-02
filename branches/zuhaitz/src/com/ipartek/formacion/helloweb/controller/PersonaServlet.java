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
import com.ipartek.formacion.helloweb.bean.Persona;
import com.ipartek.formacion.helloweb.model.ModeloPersona;
import com.ipartek.formacion.helloweb.util.Rol;

/**
 * Servlet implementation class PersonaServlet.
 */
public class PersonaServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	RequestDispatcher dispatcher = null;
	ModeloPersona modelo = null;
	String msg = "";
	int id = Persona.ID_NULL;

	@Override
	public void init(final ServletConfig config) throws ServletException {
		super.init(config);
		modelo = new ModeloPersona();
	}

	@Override
	protected void service(final HttpServletRequest request, final HttpServletResponse response)
			throws ServletException, IOException {

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
		final Persona p = getParametersPersona(request);

		switch (Integer.parseInt(request.getParameter("op"))) {

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
			msg = Constantes.MSG_REG_INSERTED;
		} else {
			msg = Constantes.MSG_ERR_PARAMETERS;
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
			// TODO comprobar que realmente se ha modificado
			modelo.update(p);
			msg = Constantes.MSG_REG_UPDATED;
		} else {
			msg = Constantes.MSG_ERR_PARAMETERS;
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
			msg = Constantes.MSG_REG_DELETED;
		} else {
			msg = Constantes.MSG_ERR_DELETE;
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
		msg = Constantes.MSG_OP_NOT_SUPPORTED;
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
			p.setNombre(request.getParameter("name"));
			p.setEdad(Integer.parseInt(request.getParameter("edad")));
			p.setRol(Rol.valueOf(request.getParameter("rol")));
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
		final ArrayList<Persona> personas = modelo.getAll();
		request.setAttribute(Constantes.ATTR_PERSONAS, personas);
		dispatcher = request.getRequestDispatcher(Constantes.JSP_BACKOFFICE_PERSONA_LIST);
	}

}
