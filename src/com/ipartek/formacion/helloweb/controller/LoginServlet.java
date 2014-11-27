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
import com.ipartek.formacion.helloweb.util.Rol;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    RequestDispatcher dispatch = null;
    HttpSession sesion = null;

    // Parametros
    String pUser = null;
    String pPass = null;

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
	response.setContentType("text/html");

	// recuperar sesion
	sesion = request.getSession();

	// recoger parametros del login
	getParameters(request);
	// Validar el usuario

	// TODO: Meterlo en funcion
	if (Constantes.USUARIO.equals(pUser)
		&& Constantes.USUARIO_PASS.equals(pPass)) {
	    // Usuario de rol usuario: vamos a saludo
	    dispatch = request.getRequestDispatcher(Constantes.JSP_SALUDO);

	    // TODO: Recuperar usuario de la base de datos
	    Persona p = new Persona(pUser, 0);
	    sesion.setAttribute(Constantes.USER_SESSION, p);

	} else if (Constantes.USER_ADMIN_NAME.equals(pUser)
		&& Constantes.USER_ADMIN_PASS.equals(pPass)) {
	    // Usuario de tipo administrador, tiene que ir al backoffice
	    dispatch = request.getRequestDispatcher(Constantes.JSP_BACKOFFICE);
	    Persona p = new Persona(pUser, 0);
	    p.setRol(Rol.ADMINISTRADOR);
	    sesion.setAttribute(Constantes.USER_SESSION, p);
	} else {
	    // Incorrecto: Enviar de nuevo a login.jsp
	    dispatch = request.getRequestDispatcher(Constantes.JSP_LOGIN);
	    request.setAttribute(Constantes.MSG_KEY,
		    Constantes.MSG_LOGIN_INCORRECT);
	}

	// despachar o servir el jsp

	dispatch.forward(request, response);
    }

    /**
     * Recoger parametros de request
     *
     * @param request
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
