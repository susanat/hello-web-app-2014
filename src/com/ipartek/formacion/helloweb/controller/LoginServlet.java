package com.ipartek.formacion.helloweb.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.helloweb.Constantes;
import com.ipartek.formacion.helloweb.Rol;
import com.ipartek.formacion.helloweb.bean.Mensaje;
import com.ipartek.formacion.helloweb.bean.Persona;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    RequestDispatcher dispatch = null;
    HttpSession session = null;

    // parametros
    String pUser = "";
    String pPass = "";

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
	super();
	// TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    @Override
    protected void doGet(HttpServletRequest request,
	    HttpServletResponse response) throws ServletException, IOException {
	// cargar fichero de mensajes
	loadMessages();

	// recuperar sesion
	session = request.getSession();

	// recoger parametros del login
	getParameters(request);

	// validar usuario
	validateUser(request);

	// despachar o servir JSP
	dispatch.forward(request, response);
    }

    /**
     * Comprobar los datos del Login y mirar si el rol es "administrador" o
     * "usuario"
     *
     * <ol>
     * <li>Administrador: ir a backoffice</li>
     * <li>Usuario: ir a backoffice</li>
     * <li >Si no validado: retornar al login</li>
     * <ol>
     *
     */
    private void validateUser(HttpServletRequest request) {
	// Administrador: ir a backoffice
	if (Constantes.USER_ADMIN.equals(pUser)
		&& Constantes.PASS_ADMIN.equals(pPass)) {
	    // correcto: redirigir a un JSP
	    dispatch = request.getRequestDispatcher(Constantes.JSP_BACK_INDEX);

	    // guardar datos en session
	    // TODO recuperar usuario de la BD
	    Persona p = new Persona(pUser, 0, Rol.ADMINISTRADOR);
	    session.setAttribute(Constantes.USER_SESSION, p);

	    // Usuario: ir a backoffice
	} else if (Constantes.USER.equals(pUser)
		&& Constantes.PASS.equals(pPass)) {

	    // correcto: redirigir a un JSP
	    dispatch = request.getRequestDispatcher(Constantes.JSP_SALUDO);

	    // guardar datos en session
	    // TODO recuperar usuario de la BD
	    Persona p = new Persona(pUser, 0, Rol.USUARIO);
	    session.setAttribute(Constantes.USER_SESSION, p);

	} else {

	    // incorrecto: enviar de nuevo a login.jsp
	    dispatch = request.getRequestDispatcher(Constantes.JSP_LOGIN);
	    Mensaje msg = new Mensaje(Constantes.MSG_LOGIN_INCORRECT,
		    Constantes.MSG_DANGER, 4);
	    request.setAttribute(Constantes.MSG_KEY, msg);

	}

    }

    /**
     * Recoger parametros de request
     */
    private void getParameters(HttpServletRequest request) {
	pUser = request.getParameter(Constantes.PARAMETRO_USER);
	pPass = request.getParameter(Constantes.PARAMETRO_PASS);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    @Override
    protected void doPost(HttpServletRequest request,
	    HttpServletResponse response) throws ServletException, IOException {

	doGet(request, response);
    }

    /**
     * Carga los mensajes con el idioma establecido
     */
    private void loadMessages() {
	// TODO Terminar de implementar

    }
}
