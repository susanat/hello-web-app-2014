package com.ipartek.formacion.helloweb.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.helloweb.bean.Mensaje;
import com.ipartek.formacion.helloweb.bean.Persona;
import com.ipartek.formacion.helloweb.constantes.Constantes;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RequestDispatcher rd = null;
	private HttpSession session = null;

	private String pUser = null;
	private String pPass = null;

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

		// Recuperar session
		session = request.getSession();

		// Recoger parámetros del login
		getParameters(request);
		// Validar el usuario

		if (Constantes.USER.equals(pUser) && Constantes.PASS.equals(pPass)) {
			// Si es ADMINISTRADOR, redirigir al backoffice
			rd = request.getRequestDispatcher(Constantes.JSP_BACK_INDEX);
			// Guardar usuario en sesión
			Persona p = new Persona(pUser, 0);
			p.setRole(Persona.Rol.ADMINISTRADOR);
			session.setAttribute(Constantes.USER_SESSION, p);
		} else if (Constantes.USER_USER.equals(pUser)
				&& Constantes.PASS_USER.equals(pPass)) {
			// Si es USER, redirigir al saludo
			rd = request.getRequestDispatcher(Constantes.JSP_SALUDO);
			Persona p = new Persona(pUser, 0);
			session.setAttribute(Constantes.USER_SESSION, p);
		} else {
			// Si no, reenviar al login
			rd = request.getRequestDispatcher(Constantes.JSP_LOGIN);
			Mensaje mensaje = new Mensaje(Constantes.MSG_LOGIN_INCORRECT, Mensaje.MsgType.LOG, Constantes.COD_LOGIN_INCORRECT);
			request.setAttribute(Constantes.MSG_KEY,
					mensaje);
		}
		// Despachar el jsp
		rd.forward(request, response);
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
	 * Recoger parámetros de la petición.
	 * 
	 * @param request
	 *            Objeto de petición.
	 */
	private void getParameters(HttpServletRequest request) {
		pUser = request.getParameter(Constantes.PARAMETRO_USER);
		pPass = request.getParameter(Constantes.PARAMETRO_PASS);
	}
}
