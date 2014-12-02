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
 * Servlet implementation class PersonaServlet.
 */
public class PersonaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    RequestDispatcher dispatcher;
    ModeloPersona model = null;
    String msg = null;
    int id = Persona.ID_NULL; // identificador persona

    /**
     * Se ejecuta una sola vez e inicializa el Servlet.
     */
    @Override
    public void init(ServletConfig config) throws ServletException {
	// TODO Auto-generated method stub
	super.init(config);
	model = new ModeloPersona();

    }

    /**
     * Destruye la conexion.
     */
    @Override
    public void destroy() {
	super.destroy();
	model = null;
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
	    throws ServletException, IOException {
	// TODO Comprobar autorizacion del usuario
	id = Persona.ID_NULL;
	super.service(req, resp);

    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    @Override
    protected void doGet(HttpServletRequest request,
	    HttpServletResponse response) throws ServletException, IOException {

	// recoger parametros

	try {
	    id = Integer.parseInt(request.getParameter("id"));
	} catch (Exception e) {
	    // TODO log
	}

	// comprobar si es getAll o getById

	if (id == Persona.ID_NULL) {
	    getAll(request);
	} else {
	    getById(request);
	}

	dispatcher.forward(request, response);
    }

    private void getById(HttpServletRequest request) {
	Persona p = model.getById(id);
	// pasamos los atributos
	request.setAttribute(Constantes.ATT_PERSONA, p);
	// cargamos el dispatcher
	dispatcher = request
		.getRequestDispatcher(Constantes.JSP_BACK_PERSONA_FORM);

    }

    private void getAll(HttpServletRequest request) {
	// acceder al modelo

	ArrayList<Persona> personas = model.getAll();

	// pasamos los atributos
	request.setAttribute(Constantes.ATT_PERSONAS, personas);

	// forward a la vista
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
	// recoger parametros
	Persona p = getParametrosPersona(request);

	// instertalo
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
     * También gestiona los mensajes para el usuario.
     *
     * @param request
     *            .
     * @return <code>Persona</code> inicializada con los parametros de la
     *         request, en caso de fallo null.
     */
    private Persona getParametrosPersona(HttpServletRequest request) {
	Persona p = null;
	try {
	    p = new Persona("");
	    p.setNombre(request.getParameter("nombre"));
	    p.setEdad(Integer.parseInt(request.getParameter("edad")));
	    msg = "Persona creada";
	} catch (Exception e) {
	    p = null;
	    msg = "Error creando Persona";
	    e.printStackTrace();
	}

	return p;

    }

}
