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
import com.ipartek.formacion.helloweb.util.Mensaje;
import com.ipartek.formacion.helloweb.util.Rol;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = -986747240512475180L;

	RequestDispatcher dispatch = null;
	HttpSession session = null;

	// Parámetros
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
	protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException,
			IOException {
		session = request.getSession();// Recuperar session

		getParameters(request);// Recoger parámetros del login
		validateUser(request);// Validar el usuario

		dispatch.forward(request, response);// Despachar o servir JSP
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(final HttpServletRequest request, final HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	/**
	 * Recoger parametros de request
	 */
	private void getParameters(final HttpServletRequest request) {
		pUser = request.getParameter(Constantes.PARAMETRO_USER);
		pPass = request.getParameter(Constantes.PARAMETRO_PASS);
	}

	/**
	 * Comprobar los datos del login y comprobar si el rol es "administrador" o
	 * "usuario"
	 * <ol>
	 * <li>Usuario: ir a saluda</li>
	 * <li>Aministrador: va al Backoffice</li>
	 * <li>Si no Validado: retornar al login</li>
	 * </ol>
	 *
	 * @param request
	 *            HttpServletRequest con la request
	 */
	private void validateUser(final HttpServletRequest request) {
		// Usuario
		if (Constantes.USER_USER_NAME.equals(pUser) && Constantes.USER_USER_PASS.equals(pPass)) {
			// Correcto: redirigir a saludo.jsp
			dispatch = request.getRequestDispatcher(Constantes.JSP_SALUDO);
			// Guardar usuario en session
			// TODO recuperar usuario de la BBDD
			final Persona p = new Persona(pUser, 0, Rol.USUARIO);
			session.setAttribute(Constantes.USER_SESSION, p);

			// Administrador
		} else if (Constantes.USER_ADMIN_NAME.equals(pUser) && Constantes.USER_ADMIN_PASS.equals(pPass)) {
			// Correcto: redirigir a saludo.jsp
			dispatch = request.getRequestDispatcher(Constantes.JSP_BACKOFFICE_INDEX);
			// Guardar usuario en session
			// TODO recuperar usuario de la BBDD
			final Persona p = new Persona(pUser, 0, Rol.ADMINISTRADOR);
			session.setAttribute(Constantes.USER_SESSION, p);
			// No Validado
		} else {
			// Incorrecto: enviar de nuevo a login.jsp
			dispatch = request.getRequestDispatcher(Constantes.JSP_LOGIN);
			final Mensaje msg = new Mensaje("alert alert-warning", Constantes.MSG_LOGIN_INCORRECT);
			request.setAttribute(Constantes.MSG_KEY, msg);
			// request.setAttribute(Constantes.MSG_KEY,
			// Constantes.MSG_LOGIN_INCORRECT);
		}
	}
}
