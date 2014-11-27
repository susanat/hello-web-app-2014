package com.ipartek.formacion.helloweb.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.helloweb.Constantes;
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
	// recuperar sesion
	session = request.getSession();

	// recoger parametros del login
	getParameters(request);

	if (Constantes.USER_ADMIN.equals(pUser)
		&& Constantes.PASS_ADMIN.equals(pPass)) {
	    // correcto: redirigir a un JSP
	    dispatch = request.getRequestDispatcher(Constantes.JSP_SALUDO);

	    // guardar datos en session
	    // TODO recuperar usuario de la BD
	    Persona p = new Persona(pUser, 0);
	    session.setAttribute(Constantes.USER_SESSION, p);
	}

	// validar usuario
	if (Constantes.USER.equals(pUser) && Constantes.PASS.equals(pPass)) {

	    // correcto: redirigir a un JSP
	    dispatch = request.getRequestDispatcher(Constantes.JSP_SALUDO);

	    // guardar datos en session
	    // TODO recuperar usuario de la BD
	    Persona p = new Persona(pUser, 0);
	    session.setAttribute(Constantes.USER_SESSION, p);

	} else {

	    // incorrecto: enviar de nuevo a login.jsp
	    dispatch = request.getRequestDispatcher(Constantes.JSP_LOGIN);
	    request.setAttribute(Constantes.MSG_KEY,
		    Constantes.MSG_LOGIN_INCORRECT);

	}

	// despachar o servir JSP
	dispatch.forward(request, response);
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

}
