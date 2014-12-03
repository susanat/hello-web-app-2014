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
import com.ipartek.formacion.helloweb.bean.Message;
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

    // Inicializa el servlet, se ejecuta una sola vez
    @Override
    public void init(ServletConfig config) throws ServletException {

	super.init(config);
	model = new ModeloPersona();
    }

    // Destruye el servlet
    @Override
    public void destroy() {
	super.destroy();
	model = null;

    }

    /**
     * @see HttpServlet#HttpServlet()
     */
    public PersonaServlet() {
	super();
	// TODO Auto-generated constructor stub
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse resp)
	    throws ServletException, IOException {

	try {
	    id = Integer.parseInt(request.getParameter("id"));
	} catch (Exception e) {
	    // TODO log de la traza
	    id = Persona.ID_NULL;
	}
	// TODO comprobar autorizacion del usuario

	super.service(request, resp);
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    @Override
    protected void doGet(HttpServletRequest request,
	    HttpServletResponse response) throws ServletException, IOException {

	// recoger parametros
	if (id == Persona.ID_NULL) {
	    // quiere todos
	    ArrayList<Persona> personas = model.getAll();
	    request.setAttribute(Constantes.ATT_PERSONAS, personas);
	    dispatcher = request
		    .getRequestDispatcher(Constantes.JSP_BACKOFFICE_PERSONA_LIST);
	} else {
	    // quiere uno
	    Persona p = model.getByID(id);
	    request.setAttribute(Constantes.ATT_PERSONA, p);
	    request.setAttribute("accion", request.getAttribute("accion"));
	    dispatcher = request
		    .getRequestDispatcher(Constantes.JSP_BACKOFFICE_PERSONA_FORM);
	}

	request.setAttribute(Constantes.MSG_KEY, msg);
	// forward a la vista correspondiente
	dispatcher.forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    @Override
    protected void doPost(HttpServletRequest request,
	    HttpServletResponse response) throws ServletException, IOException {
	if (request.getParameter(Constantes.OP_KEY)
		.equals(Constantes.OP_DELETE)) {
	    // queremos borrar
	    delete(request);
	} else if (request.getParameter(Constantes.OP_KEY).equals(
		Constantes.OP_UPDATE)) {
	    // queremos actualizar
	    update(request);
	} else if (request.getParameter(Constantes.OP_KEY).equals(
		Constantes.OP_CREATE)) {
	    // queremos crear
	    create(request);

	} else {
	    // operacion no valida
	    opNotSupported(request);
	}

	// forward a la vista (formulario)

	dispatcher.forward(request, response);
    }

    /**
     * Si no existe la operacion a realizar mensaje y redireccion (forward al
     * listado)
     *
     * @param request
     */
    private void opNotSupported(HttpServletRequest request) {
	// quiere todos
	// TODO: Meter todo hasta el request.setAttribute en una funcion
	ArrayList<Persona> personas = model.getAll();
	request.setAttribute(Constantes.ATT_PERSONAS, personas);
	dispatcher = request
		.getRequestDispatcher(Constantes.JSP_BACKOFFICE_PERSONA_LIST);
	msg = Constantes.MSG_UNAUTHORIZED;

    }

    /**
     * Crear nueva persona e insertarla en la base de datos
     *
     * @param request
     */
    private void create(HttpServletRequest request) {
	// recoger parametros, validarlos y crear persona
	Message mes = new Message();
	Persona p = getParametros(request);
	if (p != null) {
	    // insertarlo
	    // TODO: Comprobar si se ha insertado correctamente
	    model.insert(p);
	    mes.setMsg(Constantes.MSG_REG_CREATED);
	    mes.setType(Constantes.ALERT_TYPE_SUCCESS);

	} else {
	    msg = Constantes.MSG_ERROR_PARAMETERS;
	    mes.setMsg(Constantes.MSG_ERROR_PARAMETERS);
	    mes.setType(Constantes.ALERT_TYPE_DANGER);
	}

	// enviar atributos
	ArrayList<Persona> personas = model.getAll();
	request.setAttribute("accion", Constantes.LETRERO_DETALLE);
	request.setAttribute(Constantes.ATT_MENSAJE, mes);
	request.setAttribute(Constantes.ATT_PERSONA, p);
	request.setAttribute(Constantes.ATT_PERSONAS, personas);
	dispatcher = request
		.getRequestDispatcher(Constantes.JSP_BACKOFFICE_PERSONA_LIST);

    }

    /**
     * Elimina la persona por su id y nos retorna al listado
     *
     * @param request
     */
    private void delete(HttpServletRequest request) {
	id = Integer.parseInt(request.getParameter("id"));
	Message mes = new Message();
	if (model.delete(id)) {
	    // borrado correcto
	    msg = Constantes.MSG_REG_DELETED;
	    mes.setMsg(Constantes.MSG_REG_DELETED);
	    mes.setType(Constantes.ALERT_TYPE_SUCCESS);

	} else {
	    // borrado no realizado
	    msg = Constantes.MSG_REG_NOT_DELETED;
	    mes.setMsg(Constantes.MSG_REG_NOT_DELETED);
	    mes.setType(Constantes.ALERT_TYPE_DANGER);
	}
	ArrayList<Persona> personas = model.getAll();
	request.setAttribute(Constantes.ATT_PERSONAS, personas);
	request.setAttribute(Constantes.ATT_MENSAJE, mes);
	dispatcher = request
		.getRequestDispatcher(Constantes.JSP_BACKOFFICE_PERSONA_LIST);

    }

    /**
     * Actualizar los datos de una persona
     *
     * @param request
     */
    private void update(HttpServletRequest request) {
	Message mes = new Message();
	Persona p = getParametros(request);
	if (p != null) {
	    p.setId(id);
	    model.update(p);
	    msg = Constantes.MSG_REG_UPDATED;
	    mes.setMsg(Constantes.MSG_REG_UPDATED);
	    mes.setType(Constantes.ALERT_TYPE_SUCCESS);

	} else {
	    msg = Constantes.MSG_ERROR_PARAMETERS;
	    mes.setMsg(Constantes.MSG_NOT_UPDATED);
	    mes.setType(Constantes.ALERT_TYPE_DANGER);
	}
	ArrayList<Persona> personas = model.getAll();
	request.setAttribute(Constantes.ATT_PERSONAS, personas);
	request.setAttribute(Constantes.ATT_PERSONA, p);
	request.setAttribute(Constantes.ATT_MENSAJE, mes);
	dispatcher = request
		.getRequestDispatcher(Constantes.JSP_BACKOFFICE_PERSONA_LIST);

    }

    /**
     * Recoger los parametros de la request y crear <code>Persona</code> Tambien
     * gestiona los mensajes para el usuario
     *
     * @param request
     * @return <code>Persona</code> inicializada con los parametros de la
     *         request, en caso de fallo devuelve null
     */

    private Persona getParametros(HttpServletRequest request) {
	Persona p = null;

	try {
	    p = new Persona("");
	    p.setNombre(request.getParameter("name"));
	    p.setEdad(Integer.parseInt(request.getParameter("edad")));
	    p.setRol(Persona.Rol.valueOf(request.getParameter("rol")));

	} catch (Exception e) {
	    p = null;

	    e.printStackTrace();
	}
	return p;
    }

}
