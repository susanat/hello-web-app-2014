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

	// validar el usuario
	if (comprobarUsuario()) {
	    // => correcto: rediriguir a saludo.jsp // dispath, se carga le
	    // dices donde quieres ir y con el forward lo envias ES NECESARIO
	    dispath = request.getRequestDispatcher(Constantes.JSP_SALUDO);

	    // Comprobamos el nombre del usuario

	    validarURL();

	    // guardar ususario en session(a un usuario por lo que la sacamos de
	    // request)
	    // TODO recuperar usuario de la BBDD
	    Persona p = new Persona(pUser, 0);
	    session.setAttribute(Constantes.USER_SESSION, p);

	} else {
	    // => incorrecto: enviar de nuevo a login.jsp
	    dispath = request.getRequestDispatcher(Constantes.JSP_LOGIN);
	    // se pasa con setAttribute
	    request.setAttribute(Constantes.MSG_KEY,
		    Constantes.MSG_LOGIN_INCORRECT);
	}

	// despachar o servir JSP.
	dispath.forward(request, response);
    }

    private void validarURL() {

	if (Constantes.USER.equals(pUser == "admin")
		&& Constantes.PASS.equals(pPass == "admin")) {
	}

    }

    private boolean comprobarUsuario() {

	boolean resul = false;

	if (Constantes.USER.equals(pUser) && Constantes.PASS.equals(pPass)) {
	    resul = true;
	}
	return resul;

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
