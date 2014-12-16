package com.ipartek.formacion.helloweb.controler;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.helloweb.bean.Persona;
import com.ipartek.formacion.helloweb.listener.InitListener;
import com.ipartek.formacion.helloweb.util.Constante;

/**
 * Servlet implementation class PersonaServlet
 */
public class PersonaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    // ModeloPersona model;
    RequestDispatcher dispatcher;
    String msg = "";
    int id;
    Persona p = null;
    ArrayList<Persona> personas = null;
    int action;

    /**
     *
     */
    @Override
    public void init(final ServletConfig config) throws ServletException {
	// TODO Auto-generated method stub
	super.init(config);
	id = Persona.ID_NULL;
	// model = new ModeloPersona();
    }

    /**
     *
     */
    @Override
    public void destroy() {
	// TODO Auto-generated method stub
	super.destroy();
	// model = null;
    }

    /**
     * @see HttpServlet#HttpServlet()
     */
    public PersonaServlet() {
	super();
    }

    @Override
    protected void service(final HttpServletRequest req,
	    final HttpServletResponse resp) throws ServletException,
	    IOException {
	p = null;
	getParametros(req);
	super.service(req, resp);
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    @Override
    protected void doGet(final HttpServletRequest request,
	    final HttpServletResponse response) throws ServletException,
	    IOException {

	// comprobar si es getAll o getById o borrar o editar
	if (action > Persona.ID_NULL) {// borrar o editar
	    if (action == Constante.OP_REMOVE) {
		deletePersonaGet(request);
	    } else {
		updatePersonaGet(request);
	    }
	} else {// si es getAll o getById
	    if (id > Persona.ID_NULL) {
		getById(request);
	    } else {
		getAll(request);
	    }
	}

	// redirigir / foward a la vista
	dispatcher.forward(request, response);

    }

    private void updatePersonaGet(final HttpServletRequest request) {
	p = InitListener.modelPersona.getById(id);
	request.setAttribute(Constante.ATT_OPERACION, Constante.OP_UPDATE);
	request.setAttribute(Constante.ATT_PERSONA, p);
	dispatcher = request
		.getRequestDispatcher(Constante.JSP_BACKOFFICE_PERSONA_FORM);
    }

    private void deletePersonaGet(final HttpServletRequest request) {
	p = InitListener.modelPersona.getById(id);
	request.setAttribute(Constante.ATT_OPERACION, Constante.OP_REMOVE);
	request.setAttribute(Constante.ATT_PERSONA, p);
	dispatcher = request
		.getRequestDispatcher(Constante.JSP_BACKOFFICE_PERSONA_FORM);
    }

    private void getById(final HttpServletRequest request) {
	// getPersona
	// acceder al modelo
	p = InitListener.modelPersona.getById(id);
	// pasamos los atributos
	request.setAttribute(Constante.ATT_PERSONA, p);
	dispatcher = request
		.getRequestDispatcher(Constante.JSP_BACKOFFICE_PERSONA_FORM);
    }

    private void getAll(final HttpServletRequest request) {
	personas = InitListener.modelPersona.getAll();
	// pasamos los atributos
	request.setAttribute(Constante.ATT_PERSONAS, personas);
	dispatcher = request
		.getRequestDispatcher(Constante.JSP_BACKOFFICE_PERSONA_LIST);
    }

    private void getParametros(final HttpServletRequest request) {
	if (request.getParameter("id") == null) {
	    id = Persona.ID_NULL;
	} else {
	    try {
		id = Integer.parseInt(request.getParameter("id"));
	    } catch (NumberFormatException e) {

	    }
	}
	if (request.getParameter(Constante.OP_KEY) == null) {
	    action = Persona.ID_NULL;
	} else {
	    try {
		action = Integer.parseInt(request
			.getParameter(Constante.OP_KEY));
	    } catch (NumberFormatException e) {

	    }
	}
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    @Override
    protected void doPost(final HttpServletRequest request,
	    final HttpServletResponse response) throws ServletException,
	    IOException {
	// recoger parametros

	switch (action) {
	case Constante.OP_CREATE:
	    insertPersona(request);
	    break;
	case Constante.OP_REMOVE:
	    deletePersonaPost(request);
	    break;
	case Constante.OP_UPDATE:
	    updatePersonaPost(request);
	    break;
	default:
	    opNotSupported(request);
	}

	// validar parametros
	request.setAttribute(Constante.MSG_KEY, msg);
	dispatcher.forward(request, response);
    }

    /**
     * Si no existe la operacion a realizar mensaje y foward a list.jsp
     *
     * @param request
     */
    private void opNotSupported(final HttpServletRequest request) {
	getAll(request);
	request.setAttribute(Constante.MSG_KEY, Constante.MSG_ERROR);
    }

    private void updatePersonaPost(final HttpServletRequest request) {
	p = postParametros(request);
	if (p != null) {
	    if (InitListener.modelPersona.update(p) > Persona.ID_NULL) {
		msg = Constante.MSG_UPDATE;
	    } else {
		msg = Constante.MSG_ERROR_BBDD;
	    }
	} else {
	    msg = Constante.MSG_ERROR;
	}

	getAll(request);
    }

    private void deletePersonaPost(final HttpServletRequest request) {
	// acceso DDBB
	if (InitListener.modelPersona.delete(id)) {
	    msg = Constante.MSG_REMOVE;
	} else {
	    msg = Constante.MSG_ERROR_BBDD;
	}
	// enviar atributos
	getAll(request);
    }

    private void insertPersona(final HttpServletRequest request) {
	p = postParametros(request);
	if (p != null) {
	    if (InitListener.modelPersona.insert(p) > Persona.ID_NULL) {
		// enviar atributos
		request.setAttribute(Constante.ATT_PERSONA, p);
		request.setAttribute(Constante.OP_KEY, Constante.OP_UPDATE);
		// mensaje
		msg = Constante.MSG_CREATE;

	    } else {
		msg = Constante.MSG_ERROR_BBDD;
	    }
	} else {
	    msg = Constante.MSG_ERROR;
	}
	// foward a la vista
	dispatcher = request
		.getRequestDispatcher(Constante.JSP_BACKOFFICE_PERSONA_FORM);
    }

    /**
     * Recoge los datos y crea una persona
     *
     * @param request
     * @return <code>Persona</code>
     */
    private Persona postParametros(final HttpServletRequest request) {
	Persona p = null;
	try {
	    p = new Persona();
	    p.setNombre(request.getParameter("name"));
	    p.setEdad(Integer.parseInt(request.getParameter("edad")));
	    p.setUserName(request.getParameter("nombreUsuario"));
	    p.setCodigo(id);
	} catch (Exception e) {
	    p = null;
	    // Logger.getLogger(e.getStackTrace());
	    msg = "Error creando Persona";
	}

	return p;
    }
}
