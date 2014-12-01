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

/**
 * Servlet implementation class PersonaServlet
 */
public class PersonaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ModeloPersona model = null;
	RequestDispatcher dispatcher = null;
	String msg = "";
	int id = Persona.ID_NULL;

	// Solo se ejecuta la primera vez. No se ejecuta ninguna peticion
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		model = new ModeloPersona();
	}

	// Es autmoatico en el TomCat
	@Override
	public void destroy() {
		super.destroy();
		model = null;
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO comprobar Autorizacion del usuario
		super.service(req, resp);
		id = Persona.ID_NULL;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// recoger parametros

		try {
			id = Integer.parseInt(request.getParameter("id"));
		} catch (Exception e) {
			// TODO log
		}

		// comprobar si es getALL o getById
		if (id != Persona.ID_NULL) {
			getById(request);

		} else {
			getAll(request);

		}

		// forward(redirigir) a la vista

		dispatcher.forward(request, response);

	}

	private void getById(HttpServletRequest request) {
		Persona p = model.getById(id);
		request.setAttribute(Constantes.ATT_PERSONA, p);
		dispatcher = request
				.getRequestDispatcher(Constantes.JSP_BACK_PERSONA_FORM);

	}

	private void getAll(HttpServletRequest request) {
		ArrayList<Persona> personas = model.getAll();
		request.setAttribute(Constantes.ATT_PERSONAS, personas);
		dispatcher = request
				.getRequestDispatcher(Constantes.JSP_BACK_PERSONA_LIST);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// recoger parametros y validar
		Persona p = getParametrosPersona(request);

		// insertarlo

		model.insert(p);

		// enviar atributos
		request.setAttribute(Constantes.MSG_KEY, msg);
		request.setAttribute(Constantes.ATT_PERSONA, p);

		// forward a la vista

		dispatcher = request
				.getRequestDispatcher(Constantes.JSP_BACK_PERSONA_FORM);
		dispatcher.forward(request, response);
	}

	/**
	 * Recoger los parametros de la request y crear <code>Persona</code>.
	 * Tambien gestiona los mensajes para el usuario.
	 * 
	 * @param request
	 * @return <code>Persona</code> inicializada con los parametros de la
	 *         request, en caso de fallo null
	 */

	private Persona getParametrosPersona(HttpServletRequest request) {
		Persona p = new Persona("");

		try {
			p.setNombre(request.getParameter("name"));// el parametro es el k le
														// he
														// puesto en el
														// formulario
			p.setEdad(Integer.parseInt(request.getParameter("edad")));
			msg = "Persona creada";
		}

		catch (Exception e) {
			p = null;
			msg = "Error creando Persona";
			e.printStackTrace();
		}
		return p;

	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		super.doDelete(req, resp);
		int id = Integer.parseInt(req.getParameter("id"));
		model.delete(id);

	}

}
