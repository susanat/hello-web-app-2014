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
import com.ipartek.formacion.helloweb.bean.Calificacion;
import com.ipartek.formacion.helloweb.bean.Mensaje;
import com.ipartek.formacion.helloweb.bean.Persona;
import com.ipartek.formacion.helloweb.listener.InitListener;

/**
 * Servlet implementation class CalificacionServlet
 */
public class CalificacionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	RequestDispatcher dispatcher = null;
	Mensaje msg = null;
	int id = Persona.ID_NULL; // identificador Calificacion
	Calificacion c = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CalificacionServlet() {
		super();

	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		msg = new Mensaje("");
	}

	@Override
	public void destroy() {
		super.destroy();
		msg = null;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// comprobar si es getAll o getById
		if (id == Calificacion.ID_NULL) {
			getAll(request);
		} else {
			getById(request);
		}

		dispatcher.forward(request, response);
	}

	private void getById(HttpServletRequest request) {
		Calificacion c = InitListener.modelCalificacion.getById(id);
		// pasamos los atributos
		request.setAttribute(Constantes.ATT_CALIFICACION, c);
		// forward a la vista del formulario
		dispatcher = request
				.getRequestDispatcher(Constantes.JSP_BACK_PERSONA_FORM);

	}

	private void getAll(HttpServletRequest request) {
		ArrayList<Calificacion> calificacion = InitListener.modelCalificacion
				.getAll();
		// pasamos los atributos
		request.setAttribute(Constantes.ATT_CALIFICACIONES, calificacion);
		// forward a la vista
		dispatcher = request
				.getRequestDispatcher(Constantes.JSP_BACK_PERSONA_LIST);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// check Operacion
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

	private void opNotSuported(HttpServletRequest request) {
		getAll(request);
		msg = new Mensaje(Constantes.MSG_NOT_ALLOWED, Mensaje.MSG_TYPE_DANGER);

	}

	/**
	 * Elimina la Calificacion por su ID y nos retorna a list.jsp
	 * 
	 * @param request
	 */
	private void delete(HttpServletRequest request) {

		if (InitListener.modelCalificacion.delete(id)) {
			msg = new Mensaje(Constantes.MSG_REG_DELETE,
					Mensaje.MSG_TYPE_SUCCESS);
		} else {
			msg = new Mensaje(Constantes.MSG_ERR_REG_DELETE,
					Mensaje.MSG_TYPE_DANGER);
		}
		getAll(request);

	}

	private void update(HttpServletRequest request) {
		Calificacion c = getParametrosCalificacion(request);
		if (c != null) {
			// modificar
			c.setId(id);
			// TODO comprobar que realmente se a modificado
			InitListener.modelCalificacion.update(c);
			// enviar atributos
			msg = new Mensaje(Constantes.MSG_REG_UPDATE,
					Mensaje.MSG_TYPE_SUCCESS);
		} else {
			msg = new Mensaje(Constantes.MSG_ERR_PARAMETERS,
					Mensaje.MSG_TYPE_DANGER);
		}

		request.setAttribute(Constantes.ATT_CALIFICACION, c);

		// forward vista
		dispatcher = request
				.getRequestDispatcher(Constantes.JSP_BACK_PERSONA_FORM);

	}

	private Calificacion getParametrosCalificacion(HttpServletRequest request) {
		Calificacion p = null;
		try {
			c = new Calificacion();
			c.setClave(Integer.parseInt(request.getParameter("nota")));
			c.setDescripcion(request.getParameter("descripcion"));

		} catch (Exception e) {
			p = null;
			e.printStackTrace();
		}

		return p;
	}

	/**
	 * Crear nueva calificacion e insertarla en la BBDD
	 * 
	 * @param request
	 */
	private void create(HttpServletRequest request) {
		// recoger parametros y validar
		Calificacion c = getParametrosCalificacion(request);

		if (c != null) {
			// insertarlo
			// TODO comprobar la inserccion
			InitListener.modelCalificacion.insert(c);
			// enviar atributos
			msg = new Mensaje(Constantes.MSG_REG_CREATE,
					Mensaje.MSG_TYPE_SUCCESS);
		} else {
			msg = new Mensaje(Constantes.MSG_ERR_PARAMETERS,
					Mensaje.MSG_TYPE_DANGER);
		}

		request.setAttribute(Constantes.ATT_CALIFICACION, c);

		// forward vista
		dispatcher = request
				.getRequestDispatcher(Constantes.JSP_BACK_PERSONA_FORM);

	}

}
