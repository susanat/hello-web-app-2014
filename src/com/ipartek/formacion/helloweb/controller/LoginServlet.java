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
    RequestDispatcher dispath = null;
    HttpSession session = null;

    // parametros
    String pUser = null;
    String pPass = null;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
	super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    @Override
    protected void doGet(HttpServletRequest request,
	    HttpServletResponse response) throws ServletException, IOException {

	/*
	 * response.setContentType("text/html"); PrintWriter out =
	 * response.getWriter(); out.println("<html>"); out.println("<head>");
	 * out.println("<title>Hello Servlet</title>"); out.println("</head>");
	 * out.println("<body>"); out.println("<h1>Peticion tipo GET</h1>");
	 * out.println("</body>"); out.println("</html>");
	 */

	// recuperar session
	session = request.getSession();

	// recoger parametros del login
	getParameters(request);

	// validar usuario
	validarUser(request);

	// despachar o servir JSP.
	dispath.forward(request, response);
    }

    /**
     * Comprobar los datos del login y mirar si el roll es "administrador" o
     * "usuario"
     * 
     * <ol>
     * <li>Adminstrador: ir al backoffice</li>
     * <li>Usuario: voy a saluda</li>
     * <li>Si no validado; retornar al login</li>
     * </ol>
     * 
     * 
     * 
     * 
     */
    private void validarUser(HttpServletRequest request) {

	// Usuario: voy a saluda
	if (Constantes.USER_USER_NAME.equals(pUser)
		&& Constantes.USER_USER_PASS.equals(pPass)) {
	    // => correcto: rediriguir a saludo.jsp // dispath, se carga le
	    // dices donde quieres ir y con el forward lo envias ES NECESARIO
	    dispath = request.getRequestDispatcher(Constantes.JSP_SALUDO);

	    // guardar ususario en session(a un usuario por lo que la sacamos de
	    // request)
	    // TODO recuperar usuario de la BBDD
	    Persona p = new Persona(pUser, 0);
	    session.setAttribute(Constantes.USER_SESSION, p);

	    // Adminstrador: ir al backoffice
	} else if (Constantes.USER_ADMIN_NAME.equals(pUser)
		&& Constantes.USER_ADMIN_PASS.equals(pPass)) {
	    dispath = request.getRequestDispatcher(Constantes.JSP_BACKOFFICES);
	    Persona p = new Persona(pUser, 0);
	    p.setRol(Persona.Rol.ADMINISTRADOR);
	    session.setAttribute(Constantes.USER_SESSION, p);

	} else {
	    // => incorrecto: enviar de nuevo a login.jsp
	    dispath = request.getRequestDispatcher(Constantes.JSP_LOGIN);
	    // se pasa con setAttribute
	    request.setAttribute(Constantes.MSG_KEY,
		    Constantes.MSG_LOGIN_INCORRECT);
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

}
