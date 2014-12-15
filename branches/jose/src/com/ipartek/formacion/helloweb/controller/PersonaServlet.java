package com.ipartek.formacion.helloweb.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.ipartek.formacion.helloweb.Constantes;
import com.ipartek.formacion.helloweb.bean.Mensaje;
import com.ipartek.formacion.helloweb.bean.Persona;
import com.ipartek.formacion.helloweb.listener.InitListener;

/**
 * Servlet implementation class PersonaServlet
 */
public class PersonaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private final static Logger log = Logger.getLogger(PersonaServlet.class);

	// ModeloPersona model;
	RequestDispatcher dispatcher;
	Mensaje msg;
	int id = Persona.ID_NULL; // Identificador persona

	@Override
	public void init(javax.servlet.ServletConfig config)
			throws ServletException {
		super.init(config);
		// model = new ModeloPersona();
		// msg = new Mensaje();

	}

	@Override
	public void destroy() {
		super.destroy();
		// model = null;
		InitListener.modelPersona = null;
		msg = null;
	};

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO comprobar la autorizacion del usuario
		try {
			id = Integer.parseInt(req.getParameter("id"));
		} catch (Exception e) {
			// TODO log
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
		dispatcher.forward(request, response);
	}

	private void getById(HttpServletRequest request) {
		// acceder al modelo
		// Persona p = model.getById(id);
		Persona p = InitListener.modelPersona.getById(id);
		// pasamos los atributos
		request.setAttribute(Constantes.ATT_PERSONA, p);
		// forward a la vista
		dispatcher = request
				.getRequestDispatcher(Constantes.JSP_BACK_PERSONA_FORM);
	}

	private void getAll(HttpServletRequest request) {
		// acceder al modelo
		ArrayList<Persona> personas = InitListener.modelPersona.getAll();

		// pasamos los atributos
		request.setAttribute(Constantes.ATT_PERSONAS, personas);

		// forward a la vista
		dispatcher = request
				.getRequestDispatcher(Constantes.JSP_BACK_PERSONA_LIST);
		log.debug(personas.size() + " recuperadas");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// recoger la operacion a ejecutar
		String operacion = request.getParameter(Constantes.OP_KEY);
		// mirar que funcion se ejecuta
		if (Constantes.OP_UPDATE.equals(operacion)) {
			update(request);
		} else if (Constantes.OP_DELETE.equals(operacion)) {
			delete(request);
		} else if (Constantes.OP_CREATE.equals(operacion)) {
			create(request);
		} else {
			opNotSuported(request);
		}
		request.setAttribute(Constantes.MSG_KEY, msg);
		dispatcher.forward(request, response);
	}

	/**
	 * Si no existe la operacion a realizar mensaje y forward al list.jsp
	 * 
	 * @param request
	 */
	private void opNotSuported(HttpServletRequest request) {
		// dispatcher = request
		// .getRequestDispatcher(Constantes.JSP_BACK_PERSONA_LIST);
		getAll(request);
		msg = new Mensaje(Constantes.MSG_NOT_ALLOWED, Mensaje.MSG_TYPE_DANGER);

	}

	/**
	 * 
	 * @param request
	 */
	private void create(HttpServletRequest request) {
		// recoger parametros y validar
		Persona p = getParametros(request);

		if (p != null) {
			// insertarlo
			// TODO comprobar la inserccion
			// model.insert(p);
			InitListener.modelPersona.insert(p);
			msg = new Mensaje(Constantes.MSG_REG_CREATE,
					Mensaje.MSG_TYPE_SUCCESS);
		} else {
			msg = new Mensaje(Constantes.MSG_ERR_PARAMETERS,
					Mensaje.MSG_TYPE_DANGER);
		}
		// enviar atributos
		request.setAttribute(Constantes.ATT_PERSONA, p);

		// forward vista
		dispatcher = request
				.getRequestDispatcher(Constantes.JSP_BACK_PERSONA_FORM);

	}

	/**
	 * Recoger el id de la Persona a eliminar y borrarla de la lista
	 * 
	 * @param request
	 */
	private void delete(HttpServletRequest request) {
		// obtener el ID de la Persona
		// id = Integer.parseInt(request.getParameter("id"));
		// borrar a la Persona con ese ID de la lista
		// if (model.delete(id)) {
		if (InitListener.modelPersona.delete(id)) {
			msg = new Mensaje(Constantes.MSG_REG_DELETE,
					Mensaje.MSG_TYPE_SUCCESS);
			log.info("Persona eliminada con ID=" + id);
		} else {
			msg = new Mensaje(Constantes.MSG_ERR_REG_DELETE,
					Mensaje.MSG_TYPE_DANGER);
			log.error(Constantes.MSG_ERR_REG_DELETE + " con ID=" + id);
		}
		getAll(request);

		// forward vista
		// dispatcher = request
		// .getRequestDispatcher(Constantes.JSP_BACK_PERSONA_LIST);

	}

	/**
	 * Actualizar los datos de una persona, forward a form.jsp
	 * 
	 * @param request
	 */
	private void update(HttpServletRequest request) {
		// recoger parametros y validar
		Persona p = getParametros(request);
		if (p != null) {
			p.setId(id);
			// TODO comprobar que realmente se ha modificado
			// actualizarlo
			//model.update(p);
			InitListener.modelPersona.update(p);
			msg = new Mensaje(Constantes.MSG_REG_UPDATE, Mensaje.MSG_TYPE_INFO);
		} else {
			msg = new Mensaje(Constantes.MSG_ERR_PARAMETERS,
					Mensaje.MSG_TYPE_DANGER);
		}
		// enviar atributos
		request.setAttribute(Constantes.ATT_PERSONA, p);

		// forward vista
		dispatcher = request
				.getRequestDispatcher(Constantes.JSP_BACK_PERSONA_FORM);

	}

	/**
	 * Recoger los parametros de la request y crear <code>Persona</code> Tambien
	 * gestiona los mensajes para el usuario
	 * 
	 * @param request
	 * @return <code>Persona</code> inicializa con los parametros de la request,
	 *         en caso de fallo null
	 */
	private Persona getParametros(HttpServletRequest request) {
		Persona p = null;

		try {

			p = new Persona("");
			p.setNombre(request.getParameter("name"));
			p.setEdad(Integer.parseInt(request.getParameter("edad")));
			p.setRol(Persona.Rol.valueOf(request.getParameter("rol")));
			// TODO obtener ROL
			// msg = "Persona creada";
		} catch (Exception e) {
			p = null;
			// msg = "Error creando Persona";
			e.printStackTrace();
		}
		return p;
	}

}
