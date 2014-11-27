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
		// recuperar sesion
		session = request.getSession();
		response.setContentType("text/html");

		// recoger parametros del login
		getParameter(request);
		// Validar usuario
		if (Constantes.USER.equals(pUser) && Constantes.PASS.equals(pPass)) {
			// correcto: redirigir a saludo.jsp
			dispatch = request.getRequestDispatcher(Constantes.JSP_SALUDO);
			// Guardar usuario en sesion
			Persona p = new Persona(pUser, 0);
			session.setAttribute(Constantes.USER_SESSION, p);

		} else {
			if (Constantes.USER_ADMIN.equals(pUser)
					&& Constantes.PASS_ADMIN.equals(pPass)) {
				// correcto: ES ADMIN redirigir a saludo.jsp
				dispatch = request
						.getRequestDispatcher(Constantes.JSP_SALUDO_ADMIN);
				// Guardar usuario en sesion
				Persona p = new Persona(pUser, 0);
				session.setAttribute(Constantes.USER_SESSION, p);

			} else {
				// incorrecto: enviar de nuevo al login.jsp
				dispatch = request.getRequestDispatcher(Constantes.JSP_LOGIN);
				request.setAttribute(Constantes.MSG_KEY,
						Constantes.MSG_LOGIN_INCORRECT);
			}
		}

		dispatch.forward(request, response);
	}

	/**
	 * recoger parametros de request
	 */

	private void getParameter(HttpServletRequest request) {
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
		response.setContentType("text/html");
		doGet(request, response);
	}

}
