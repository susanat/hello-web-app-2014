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
import com.ipartek.formacion.helloweb.listener.InitListener;

/**
 * Servlet implementation class CalificacionServlet.
 */
public class CalificacionServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    RequestDispatcher dispatcher;

    Mensaje msg = null;
    int id = Calificacion.ID_NULL; // identificador persona

    /**
     * Se ejecuta una sola vez e inicializa el Servlet.
     */
    @Override
    public void init(ServletConfig config) throws ServletException {
	// TODO Auto-generated method stub
	super.init(config);

    }

    /**
     * Destruye la conexion.
     */
    @Override
    public void destroy() {
	super.destroy();

    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
	    throws ServletException, IOException {
	// TODO Comprobar autorizacion del usuario
	try {
	    id = Integer.parseInt(req.getParameter("id"));
	} catch (Exception e) {
	    id = Calificacion.ID_NULL;

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

	// recoger parametros

	try {
	    id = Integer.parseInt(request.getParameter("id"));
	} catch (Exception e) {
	    // TODO log
	}

	// comprobar si es getAll o getById

	if (id == Calificacion.ID_NULL) {
	    getAll(request);
	} else {
	    getById(request);
	}

	dispatcher.forward(request, response);
    }

    private void getById(HttpServletRequest request) {
	Calificacion p = InitListener.modeloCalificacion.getById(id);
	// pasamos los atributos
	request.setAttribute(Constantes.ATT_CALIFICACION, p);
	// cargamos el dispatcher

	// TODO CAMBIAR A FORM CALIFICACION
	dispatcher = request
		.getRequestDispatcher(Constantes.JSP_BACK_CALIFICACION_FORM);

    }

    private void getAll(HttpServletRequest request) {
	// acceder al modelo

	ArrayList<Calificacion> calificaciones = InitListener.modeloCalificacion
		.getAll();

	// pasamos los atributos
	request.setAttribute(Constantes.ATT_CALIFICACION, calificaciones);

	// forward a la vista
	dispatcher = request
		.getRequestDispatcher(Constantes.JSP_BACK_CALIFICACION_LIST);

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    @Override
    protected void doPost(HttpServletRequest request,
	    HttpServletResponse response) throws ServletException, IOException {
	// check Operacion
	String op = request.getParameter(Constantes.OP_KEY);

	if (Constantes.OP_DELETE.equals(op)) {
	    delete(request);

	} else if (Constantes.OP_UPDATE.equals(op)) {
	    update(request);

	} else if (Constantes.OP_CREATE.equals(op)) {
	    create(request);
	} else {
	    opNotSuported(request);
	}

	request.setAttribute(Constantes.MSG_KEY, msg);
	dispatcher.forward(request, response);

    }

    /**
     * Si no existe la Operación a realizar mensaje y forward al list.jsp
     *
     * @param request
     */
    private void opNotSuported(HttpServletRequest request) {
	getAll(request);
	msg = new Mensaje(Constantes.MSG_NOT_ALLOWED, Constantes.MSG_WARNING, 3);
	;

    }

    /**
     * Crear nueva persona e insertarla en la BBDD
     *
     * @param request
     */
    private void create(HttpServletRequest request) {
	Calificacion p = getParametrosCalificacion(request);
	if (p != null) {
	    // instertalo
	    // TODO comprobar la inserccion
	    InitListener.modeloCalificacion.insert(p);
	    msg = new Mensaje(Constantes.MSG_REG_CREATE,
		    Constantes.MSG_SUCCESS, 1);
	} else {
	    msg = new Mensaje(Constantes.MSG_ERR_PARAMETERS,
		    Constantes.MSG_DANGER, 4);
	}

	// enviar atributos
	request.setAttribute(Constantes.ATT_CALIFICACION, p);
	// forward a la vista
	dispatcher = request
		.getRequestDispatcher(Constantes.JSP_BACK_CALIFICACION_FORM);
    }

    /**
     * Actualizar los datos de una <code>Persona</code>, forward a form.jsp
     *
     * @param request
     */
    private void update(HttpServletRequest request) {
	// recoger parametros
	Calificacion p = getParametrosCalificacion(request);
	if (p != null) {
	    // modificar
	    p.setId(id);
	    // TODO comprobar que realmente se ha modificado
	    InitListener.modeloCalificacion.update(p);
	    // enviar atributos
	    msg = new Mensaje(Constantes.MSG_REG_UPDATE,
		    Constantes.MSG_SUCCESS, 1);
	} else {
	    msg = new Mensaje(Constantes.MSG_ERR_PARAMETERS,
		    Constantes.MSG_DANGER, 4);
	}

	request.setAttribute(Constantes.ATT_CALIFICACION, p);

	// forward a la vista
	dispatcher = request
		.getRequestDispatcher(Constantes.JSP_BACK_CALIFICACION_FORM);
    }

    /**
     * Elimina la <code>Persona</code> por su <code>id</code> y nos retorna a
     * <code>list.jsp</code>
     *
     * @param request
     */
    private void delete(HttpServletRequest request) {

	if (InitListener.modeloCalificacion.delete(id)) {
	    msg = new Mensaje(Constantes.MSG_REG_DELETE,
		    Constantes.MSG_SUCCESS, 1);
	} else {
	    msg = new Mensaje(Constantes.MSG_ERR_PARAMETERS,
		    Constantes.MSG_DANGER, 4);
	}
	getAll(request);
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
    private Calificacion getParametrosCalificacion(HttpServletRequest request) {
	Calificacion p = null;
	try {
	    p = new Calificacion(0);
	    p.setValor(Integer.parseInt(request.getParameter("valor")));
	    p.setDescripcion(request.getParameter("descripcion"));

	} catch (Exception e) {
	    p = null;
	    e.printStackTrace();
	}

	return p;

    }

}
