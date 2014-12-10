package com.ipartek.formacion.helloweb.controller;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.helloweb.Constantes;
import com.ipartek.formacion.helloweb.bean.Message;
import com.ipartek.formacion.helloweb.bean.Persona;
import com.ipartek.formacion.helloweb.i18n.Idioma;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	RequestDispatcher dispatch = null;
	// variable de sesion
	HttpSession session = null;

	// parametros

	String pUser = null;
	String pPass = null;
	String pIdioma = Idioma.INGLES.getLocale();
	ResourceBundle messages = null;

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
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// cargar ficher de mensajes

		/*
		 * COMO REDIRIGIR UN JSP:************************************
		 */
		// recuperar session
		session = request.getSession();

		// recoger parametros del login

		getParameters(request);

		loadMensajes();

		// validar el usuario

		if (validarUserAdmin()) {

			dispatch = request.getRequestDispatcher(Constantes.JSP_BACK_INDEX);
			Persona p = new Persona(pUser, 0);
			p.setRol(Persona.Rol.ADMINISTRADOR);
			session.setAttribute(Constantes.USER_SESSION, p);

		} else if (validarUser()) {

			// correcto: redirigir a saludo.jsp
			dispatch = request.getRequestDispatcher(Constantes.JSP_SALUDO);
			// guardar usuario en sesion
			// TODO recuperar usuario de la BBDD
			Persona p = new Persona(pUser, 0);
			session.setAttribute(Constantes.USER_SESSION, p);
		}
		// incorrecto: enviar de nuevo a login.jsp
		else {
			dispatch = request.getRequestDispatcher(Constantes.JSP_LOGIN);
			Message msg = new Message(
					messages.getString("msg.login.incorrect"),
					Message.MSG_TYPE_DANGER);
			request.setAttribute(Constantes.MSG_KEY, msg);
		}
		// despachar o servir JSP
		dispatch.forward(request, response);

	}

	private void loadMensajes() {
		Locale locale = new Locale(pIdioma.split("_")[0], pIdioma.split("_")[1]);
		messages = ResourceBundle.getBundle(Constantes.PROPERTY_I18N, locale);

		// guardar en session el language
		session.setAttribute(Constantes.USER_LANGUAGE, pIdioma);

	}

	/**
	 * Recoger parametros de request
	 * 
	 * @param request
	 */
	private void getParameters(HttpServletRequest request) {
		pUser = request.getParameter(Constantes.PARAMETRO_USER);
		pPass = request.getParameter(Constantes.PARAMETRO_PASS);
		pIdioma = request.getParameter(Constantes.PARAMETRO_IDIOMA);

	}

	/**
	 * Valida el susario y contraseña de un usuario administrador
	 * 
	 * @return true si todos los datos son correctos y false en caso contrario
	 */

	private boolean validarUserAdmin() {
		boolean rdo = false;
		if (Constantes.ADMIN_USER.equals(pUser)
				&& Constantes.ADMIN_PASS.equals(pPass)) {
			rdo = true;

		}
		return rdo;

	}

	/**
	 * Valida el susario y contraseña de un usuario normal
	 * 
	 * @return true si todos los datos son correctos y false en caso contrario
	 */

	private boolean validarUser() {
		boolean rdo = false;
		if (Constantes.USER_USER.equals(pUser)
				&& Constantes.USER_PASS.equals(pPass)) {
			rdo = true;

		}
		return rdo;

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
