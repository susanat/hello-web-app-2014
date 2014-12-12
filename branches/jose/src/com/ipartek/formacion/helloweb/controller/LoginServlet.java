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
import com.ipartek.formacion.helloweb.bean.Mensaje;
import com.ipartek.formacion.helloweb.bean.Persona;
import com.ipartek.formacion.helloweb.i18n.Idioma;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	RequestDispatcher dispatch = null;
	HttpSession session = null;
	ResourceBundle messages = null;

	// parametros
	String pUser = null;
	String pPass = null;
	String pIdioma = Idioma.INGLES.getLocale();

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


		// recuperar session
		session = request.getSession();

		// recoger parametros del login
		getParameters(request);

		// Cargar fichero de mensajes
		LoadMensajes();

		// validar el usuario
		validateUser(request);

		// despachar o servir JSP
		dispatch.forward(request, response);

	}

	private void LoadMensajes() {
		// TODO Terminar de implementarlo
		/*
		 * String idioma = request.getParameter(Constantes.IDIOMA_KEY); String
		 * valorIdioma = Constantes.IDIOMA_ES; if (idioma != null) { if
		 * (Constantes.IDIOMA_ES.equals(idioma) ||
		 * Constantes.IDIOMA_EU.equals(idioma) ||
		 * Constantes.IDIOMA_EN.equals(idioma)) { valorIdioma = idioma; } }
		 * request.getSession().setAttribute(Constantes.IDIOMA_KEY,
		 * valorIdioma);
		 */
		Locale locale = new Locale(pIdioma.split("_")[0], pIdioma.split("_")[1]);
		messages = ResourceBundle.getBundle(
				Constantes.PROPERTI_I18N, locale);
		// guardar en session el language
		session.setAttribute(Constantes.USER_LANGUAGE, pIdioma);

	}

	/**
	 * Comprobar los datos del Login y mirar si el rol es "administrador" o
	 * "usuario"
	 * 
	 * <ol>
	 * <li>Usuario: ir a saluda</li>
	 * <li>Administrador: ir a backoffice</li>
	 * <li>Si no Validado: retornar al login</li>
	 * </ol>
	 * 
	 * 
	 */
	private void validateUser(HttpServletRequest request) {

		// Usuario: ir a saluda
		if (Constantes.USER_USER_NAME.equals(pUser)
				&& Constantes.USER_USER_PASS.equals(pPass)) {
			// correcto: rediriguir a saludo.jsp
			dispatch = request.getRequestDispatcher(Constantes.JSP_SALUDO);
			// guardar usuario en session
			// TODO recuperar usuario de la BBDD
			Persona p = new Persona(pUser, 0);
			session.setAttribute(Constantes.USER_SESSION, p);

			// Administrador: ir a backoffice
		} else if (Constantes.USER_ADMIN_NAME.equals(pUser)
				&& Constantes.USER_ADMIN_PASS.equals(pPass)) {

			dispatch = request.getRequestDispatcher(Constantes.JSP_BACK_INDEX);
			// guardar usuario en session
			// TODO recuperar usuario de la BBDD
			Persona p = new Persona(pUser, 0);
			p.setRol(Persona.Rol.ADMINISTRADOR);
			session.setAttribute(Constantes.USER_SESSION, p);

			// Si no Validado: retornar al login
		} else {
			// incorrecto: enviar de nuevo a login.jsp
			dispatch = request.getRequestDispatcher(Constantes.JSP_LOGIN);
			/*
			 * Mensaje msg = new Mensaje(Constantes.MSG_LOGIN_INCORRECTO,
			 * Mensaje.MSG_TYPE_DANGER);
			 */
			Mensaje msg = new Mensaje(
					messages.getString("msg.login.incorrect"),
					Mensaje.MSG_TYPE_DANGER);
			request.setAttribute(Constantes.MSG_KEY, msg);
		}

	}

	/**
	 * Recoger parametros de request
	 */
	private void getParameters(HttpServletRequest request) {
		pUser = request.getParameter(Constantes.PARAMETRO_USER);
		pPass = request.getParameter(Constantes.PARAMETRO_PASS);
		pIdioma = request.getParameter(Constantes.PARAMETRO_IDIOMA);
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