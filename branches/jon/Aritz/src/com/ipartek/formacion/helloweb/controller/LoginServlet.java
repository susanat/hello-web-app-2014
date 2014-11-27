package com.ipartek.formacion.helloweb.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.bean.Persona;
import com.ipartek.formacion.helloweb.Constantes;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RequestDispatcher dispatch = null;
	HttpSession sesion = null;
	private String pUser = null;
	private String pPass = null;

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
		sesion = request.getSession();

		// parametros del login.jsp
		getParameters(request);

		// validar usuario
		if (Constantes.USER.equals(pUser) && Constantes.PASS.equals(pPass)
				|| Constantes.USER_ADMIN.equals(pUser)
				&& Constantes.PASS_ADMIN.equals(pPass)) {

			if (Constantes.USER_ADMIN.equals(pUser)
					&& Constantes.PASS_ADMIN.equals(pPass)) {
				// correcto: redirigir a saludo.jsp
				dispatch = request
						.getRequestDispatcher(Constantes.JSP_BACKOFFICE);

			} else {
				// correcto: redirigir a saludo.jsp
				dispatch = request.getRequestDispatcher(Constantes.JSP_SALUDO);
			}
			// guardar usuario en sesion
			Persona p = new Persona(pUser, 0);
			sesion.setAttribute(Constantes.USER_SESSION, p);

		} else {
			// incorrecto : volver a login.jsp
			dispatch = request.getRequestDispatcher(Constantes.JSP_LOGIN);
			request.setAttribute(Constantes.MSG_KEY,
					Constantes.MSG_LOGIN_INCORRECT);
		}

		// despachar o servir jsp
		dispatch.forward(request, response);
	}

	/**
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

		/*
		 * response.setContentType("text/html"); PrintWriter out =
		 * response.getWriter(); out.println("<html>"); out.println("<head>");
		 * out.println("<title>Hello Servlet!</title>"); out.println("</head>");
		 * out.println("<body>"); out.println("<h1>Peticion tipo post</h1>");
		 * out.println("</body>"); out.println("</html>");
		 */

		doGet(request, response);
	}

}
