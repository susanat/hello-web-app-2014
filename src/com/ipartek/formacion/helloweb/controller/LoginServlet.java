package com.ipartek.formacion.helloweb.controller;

import java.io.IOException;
import java.util.ResourceBundle;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.ipartek.formacion.helloweb.Constantes;
import com.ipartek.formacion.helloweb.bean.Mensaje;
import com.ipartek.formacion.helloweb.bean.Persona;
import com.ipartek.formacion.helloweb.bean.Role;
import com.ipartek.formacion.helloweb.i18n.I18n;
import com.ipartek.formacion.helloweb.util.EIdioma;
import com.ipartek.formacion.helloweb.util.ERole;
import com.ipartek.formacion.helloweb.util.MensajesIdiomas;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = -986747240512475180L;
	private final static Logger log = Logger.getLogger("ACCESOS");

	private RequestDispatcher dispatch = null;
	private HttpSession session = null;
	private ResourceBundle messages = null;

	// Parámetros
	private String pUser = null;
	private String pPass = null;
	private String pIdioma = EIdioma.INGLES.getLocale();
	private boolean pRecuerdame = false;

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
		// Recuperar session
		session = request.getSession();
		pIdioma = I18n.getBrowserLocale(request.getLocale());

		// Comprueba si hay session logueada
		if (!checkSession(request)) {
			// Recoger parámetros del login
			getParameters(request);

			// Validar el usuario
			validateUser(request, response);
		}

		// Cargar los mensajes en el idioma correspondiente
		messages = MensajesIdiomas.loadMessages(pIdioma, session);

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
	 * Check si existe usuario en session y cargar el dispatcher según su rol.
	 *
	 * @param request
	 * @return true si existe session de usuario, false en caso contrario
	 */
	private boolean checkSession(final HttpServletRequest request) {
		boolean res = false;

		if (session.getAttribute(Constantes.USER_SESSION) != null) {
			final Persona usuario = (Persona) session.getAttribute(Constantes.USER_SESSION);

			if (usuario.getRole().getNombre().equalsIgnoreCase(ERole.ADMINISTRADOR.toString())) {
				dispatch = request.getRequestDispatcher(Constantes.JSP_BACKOFFICE_INDEX);
				res = true;
			} else if (usuario.getRole().getNombre().equalsIgnoreCase(ERole.USER.toString())) {
				dispatch = request.getRequestDispatcher(Constantes.JSP_SALUDO);
				res = true;
			} else {
				dispatch = request.getRequestDispatcher(Constantes.JSP_LOGIN);
			}
		}

		return res;
	}

	/**
	 * Recoger parámetros de request.
	 */
	private void getParameters(final HttpServletRequest request) {
		pUser = request.getParameter(Constantes.PARAMETRO_USER);
		pPass = request.getParameter(Constantes.PARAMETRO_PASS);
		pIdioma = request.getParameter(Constantes.PARAMETRO_LANG);
		pRecuerdame = (request.getParameter(Constantes.PARAMETRO_RECUERDAME)) == null ? false : true;
	}

	/**
	 * Comprobar los datos del login y comprobar si el rol es "administrador" o
	 * "usuario".
	 * <ol>
	 * <li>Usuario: ir a saluda</li>
	 * <li>Aministrador: va al Backoffice</li>
	 * <li>Si no Validado: retornar al login</li>
	 * </ol>
	 *
	 * @param request
	 *            HttpServletRequest con la request
	 * @param response
	 */
	private void validateUser(final HttpServletRequest request, final HttpServletResponse response) {
		// Usuario
		if (Constantes.USER_USER_NAME.equals(pUser) && Constantes.USER_USER_PASS.equals(pPass)) {
			// Correcto: redirigir a saludo.jsp
			dispatch = request.getRequestDispatcher(Constantes.JSP_SALUDO);
			final Persona p = new Persona(pUser, 0, new Role("User"));
			session.setAttribute(Constantes.USER_SESSION, p);
			session.setAttribute(Constantes.USER_LANGUAGE, pIdioma);
			log.info("Acceso usuario USER " + pUser + " /// " + pPass);
			gestionCookies(request, response);

			// Administrador
		} else if (Constantes.USER_ADMIN_NAME.equals(pUser) && Constantes.USER_ADMIN_PASS.equals(pPass)) {
			// Correcto: redirigir a saludo.jsp
			dispatch = request.getRequestDispatcher(Constantes.JSP_BACKOFFICE_INDEX);
			final Persona p = new Persona(pUser, 0, new Role("Administrador"));
			session.setAttribute(Constantes.USER_SESSION, p);
			session.setAttribute(Constantes.USER_LANGUAGE, pIdioma);
			log.info("Acceso usuario ADMIN " + pUser + " /// " + pPass);
			gestionCookies(request, response);

			// Entrada sin submitar el formulario
		} else if ((pUser == null) && (pPass == null)) {
			log.trace("Entrada sin submitar el formulario");
			dispatch = request.getRequestDispatcher(Constantes.JSP_LOGIN);

			// No Validado retornar al login
		} else {
			// Incorrecto: enviar de nuevo a login.jsp
			dispatch = request.getRequestDispatcher(Constantes.JSP_LOGIN);
			final Mensaje msg = new Mensaje(Mensaje.MSG_TYPE_WARNING, messages.getString("msg.login_incorrect"));
			request.setAttribute(Constantes.MSG_KEY, msg);
		}
	}

	private void gestionCookies(final HttpServletRequest request, final HttpServletResponse response) {
		final Cookie cUser = new Cookie(Constantes.COOKIE_USER_NAME, pUser);
		final Cookie cPass = new Cookie(Constantes.COOKIE_USER_PASS, pPass);
		final Cookie cLang = new Cookie(Constantes.COOKIE_USER_LANG, pIdioma);

		// Si no quiere recordar expiramos cookies
		if (!pRecuerdame) {
			cUser.setMaxAge(0);
			cPass.setMaxAge(0);
			cLang.setMaxAge(0);
		} else {
			// Si quiere recordar que las cookies duren un mes
			cUser.setMaxAge(60 * 60 * 24 * 30);
			cPass.setMaxAge(60 * 60 * 24 * 30);
			cLang.setMaxAge(60 * 60 * 24 * 30);
		}

		response.addCookie(cUser);
		response.addCookie(cPass);
		response.addCookie(cLang);
	}
}
