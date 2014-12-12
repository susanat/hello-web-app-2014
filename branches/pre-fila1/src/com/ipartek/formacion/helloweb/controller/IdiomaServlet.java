package com.ipartek.formacion.helloweb.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.helloweb.Constantes;
import com.ipartek.formacion.helloweb.bean.Idioma;
import com.ipartek.formacion.helloweb.bean.Mensaje;
import com.ipartek.formacion.helloweb.listener.InitListener;

/**
 * Servlet implementation class IdiomaServlet
 */
public class IdiomaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    RequestDispatcher dispatcher = null;
    // ModeloPersona model = null;
    Mensaje msg = null;
    int id = Idioma.ID_NULL; // identificador Persona

    /**
     * @see Servlet#init(ServletConfig)
     */
    @Override
    public void init(final ServletConfig config) throws ServletException {
	// TODO Auto-generated method stub
    }

    @Override
    public void destroy() {
	super.destroy();
	// model=null;
    }

    @Override
    protected void service(final HttpServletRequest req,
	    final HttpServletResponse resp) throws ServletException,
	    IOException {

	// recoger paramtro identificador Persona
	try {
	    id = Integer.parseInt(req.getParameter(Constantes.FORM_IDIOMA_ID));
	} catch (final Exception e) {
	    id = Idioma.ID_NULL;
	}

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

	if (id == Idioma.ID_NULL) {
	    getAll(request);
	} else {
	    getById(request);
	}

	dispatcher.forward(request, response);
    }

    private void getById(final HttpServletRequest request) {

	final Idioma i = InitListener.modelIdioma.getById(id);
	// pasamos los atributos
	request.setAttribute(Constantes.ATT_IDIOMA, i);
	// forward a la vista del formulario
	dispatcher = request
		.getRequestDispatcher(Constantes.JSP_BACKOFFICE_IDIOMA_FORM);
    }

    private void getAll(final HttpServletRequest request) {

	final ArrayList<Idioma> idiomas = InitListener.modelIdioma.getAll();
	// pasamos los atributos
	request.setAttribute(Constantes.ATT_IDIOMAS, idiomas);
	// forward a la vista
	dispatcher = request
		.getRequestDispatcher(Constantes.JSP_BACKOFFICE_IDIOMA_LIST);

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    @Override
    protected void doPost(final HttpServletRequest request,
	    final HttpServletResponse response) throws ServletException,
	    IOException {
	// check Operacion
	final String op = request.getParameter(Constantes.OP_KEY);
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
     * Actulizar los datos de una Idioma, foward a form.jsp
     *
     * @param request
     */
    private void update(final HttpServletRequest request) {

	final Idioma i = getParametrosIdioma(request);
	if (i != null) {
	    // modificar
	    i.setId(id);
	    // TODO comprobar que realmente se a modificado
	    // model.update(p);
	    InitListener.modelIdioma.update(i);
	    // enviar atributos
	    msg = new Mensaje(Constantes.MSG_REG_UPDATE,
		    Mensaje.MSG_TYPE_SUCCESS);
	} else {
	    msg = new Mensaje(Constantes.MSG_ERR_PARAMETERS,
		    Mensaje.MSG_TYPE_DANGER);
	}

	request.setAttribute(Constantes.ATT_PERSONA, i);

	// forward vista
	dispatcher = request
		.getRequestDispatcher(Constantes.JSP_BACKOFFICE_IDIOMA_FORM);

    }

    /**
     * Recoger los parametros de la request y crear <code>Idioma</code>. Tambien
     * gestiona los mensajes para el usuario
     *
     * @param request
     * @return <code>Idioma</code> inicializada con los parametros de la
     *         request, en caso de fallo null
     */
    private Idioma getParametrosIdioma(final HttpServletRequest request) {
	Idioma i = null;
	try {
	    i = new Idioma("");
	    request.setCharacterEncoding("UTF-8");
	    i.setId(Integer.parseInt(request
		    .getParameter(Constantes.FORM_IDIOMA_ID)));
	    i.setLenguaje(request.getParameter(Constantes.FORM_IDIOMA_LENGUAJE));
	    i.setPais(request.getParameter(Constantes.FORM_IDIOMA_PAIS));
	    i.setTexto(request.getParameter(Constantes.FORM_IDIOMA_TEXTO));
	    i.setLocale(request.getParameter(Constantes.FORM_IDIOMA_LOCALE));
	} catch (final Exception e) {
	    i = null;
	    e.printStackTrace();
	}

	return i;
    }

    /**
     * Elimina el Idioma por su ID y nos retorna a list.jsp
     *
     * @param request
     */
    private void delete(final HttpServletRequest request) {

	// if (model.delete(id) ){
	if (InitListener.modelIdioma.delete(id)) {
	    msg = new Mensaje(Constantes.MSG_REG_DELETE,
		    Mensaje.MSG_TYPE_WARNING);
	} else {
	    msg = new Mensaje(Constantes.MSG_ERR_REG_DELETE,
		    Mensaje.MSG_TYPE_DANGER);
	}
	getAll(request);

    }

    /**
     * Si no existe la Operacion a realizar mensaje y forward al list.jsp
     *
     * @param request
     */
    private void opNotSuported(final HttpServletRequest request) {
	getAll(request);
	msg = new Mensaje(Constantes.MSG_NOT_ALLOWED, Mensaje.MSG_TYPE_DANGER);
    }

    /**
     * Crear un nuevo Idioma e insertarlo en la BBDD
     *
     * @param request
     */
    private void create(final HttpServletRequest request) {
	// recoger parametros y validar
	final Idioma i = getParametrosIdioma(request);

	if (i != null) {
	    // insertarlo
	    // TODO comprobar la inserccion
	    // model.insert(p);
	    InitListener.modelIdioma.insert(i);
	    // enviar atributos
	    msg = new Mensaje(Constantes.MSG_REG_CREATE,
		    Mensaje.MSG_TYPE_SUCCESS);
	} else {
	    msg = new Mensaje(Constantes.MSG_ERR_PARAMETERS,
		    Mensaje.MSG_TYPE_DANGER);
	}

	request.setAttribute(Constantes.ATT_IDIOMA, i);

	// forward vista
	dispatcher = request
		.getRequestDispatcher(Constantes.JSP_BACKOFFICE_IDIOMA_FORM);

    }
}
