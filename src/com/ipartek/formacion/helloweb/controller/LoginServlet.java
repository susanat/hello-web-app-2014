package com.ipartek.formacion.helloweb.controller;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
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
import com.ipartek.formacion.helloweb.i18n.Idioma;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private final static Logger log = Logger.getLogger("ACCESOS");

	RequestDispatcher dispatch = null;
	HttpSession session = null;

	ResourceBundle messages = null;

	// parametros
	String pUser = null;
	String pPass = null;
	String pIdioma = Idioma.INGLES.getLocale();
	boolean pRecuerdame = false;

	private HttpServletRequest request;
	private HttpServletResponse response;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		log.trace("Init");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		this.request = request;
		this.response = response;

		// recuperar session
		session = request.getSession();
		session.setMaxInactiveInterval(60);

		if (!checkSession(request)) {

			// TODO funciona session si el navegador tiene deshabilitado las
			// cookies

			// TODO Forward HttpServletResponse.encodeUrl

			// recoger parametros del login
			getParameters(request);

			loadMessages();

			// validar el usuario
			validateUser(request);
		}

		// despachar o servir JSP
		dispatch.forward(request, response);

	}

	/**
	 * Check si existe usuario en session y cargar el dispatcher segun su rol
	 * 
	 * @param request
	 * @return true si existe session de usario, false en caso contrario
	 */
	private boolean checkSession(HttpServletRequest request) {
		boolean resul = false;

		if (session.getAttribute(Constantes.USER_SESSION) != null) {
			Persona usuario = (Persona) session
					.getAttribute(Constantes.USER_SESSION);
			// segun Rol cargar el dispatcher
			switch (usuario.getRol()) {
			case ADMINISTRADOR:
				dispatch = request
						.getRequestDispatcher(Constantes.JSP_BACK_INDEX);
				resul = true;
				break;

			case USER:
				dispatch = request.getRequestDispatcher(Constantes.JSP_SALUDO);
				resul = true;
				break;
			}// end switch

		}

		return resul;
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
			log.info("acceso usuario NORMAL [" + pUser + "," + pPass + "]");

			gestionCookies();

			// Administrador: ir a backoffice
		} else if (Constantes.USER_ADMIN_NAME.equals(pUser)
				&& Constantes.USER_ADMIN_PASS.equals(pPass)) {

			dispatch = request.getRequestDispatcher(Constantes.JSP_BACK_INDEX);
			// guardar usuario en session
			// TODO recuperar usuario de la BBDD
			Persona p = new Persona(pUser, 0);
			Persona.Rol rol = Constantes.USER_ADMIN_PASS.equals(pPass) ? Persona.Rol.ADMINISTRADOR
					: Persona.Rol.USER;
			p.setRol(rol);
			session.setAttribute(Constantes.USER_SESSION, p);
			log.info("acceso usuario ADMIN [" + pUser + "," + pPass + "]");

			gestionCookies();

			// entrada sin submitar el formulario
		} else if ((pUser == null) && (pPass == null)) {
			log.trace("entrada sin submitar formulario");
			dispatch = request.getRequestDispatcher(Constantes.JSP_LOGIN);

			// Si no Validado: retornar al login
		} else {
			// incorrecto: enviar de nuevo a login.jsp
			dispatch = request.getRequestDispatcher(Constantes.JSP_LOGIN);

			Mensaje msg = new Mensaje(
					messages.getString("msg.login.incorrect"),
					Mensaje.MSG_TYPE_DANGER);
			request.setAttribute(Constantes.MSG_KEY, msg);

			// TODO cambiar por mensajes de Properties
			log.warn("Usuario incorrecto [" + pUser + "," + pPass + "]");
		}

	}

	private void gestionCookies() {

		Cookie cUser = new Cookie(Constantes.COOKIE_USER_NAME, pUser);
		Cookie cPass = new Cookie(Constantes.COOKIE_USER_PASS, pPass);
		Cookie cIdiom = new Cookie(Constantes.COOKIE_USER_IDIOM, pIdioma);

		cUser.setMaxAge(60 * 60 * 24 * 30); // 1 mes
		cPass.setMaxAge(60 * 60 * 24 * 30); // 1 mes
		cIdiom.setMaxAge(60 * 60 * 24 * 30); // 1 mes

		// Si no quiere recordar expiramos cookies
		if (!pRecuerdame) {
			cUser.setMaxAge(0);
			cPass.setMaxAge(0);
			cIdiom.setMaxAge(0);

		}

		response.addCookie(cUser);
		response.addCookie(cPass);
		response.addCookie(cIdiom);

	}

	/**
	 * Recoger parametros de request
	 */
	private void getParameters(HttpServletRequest request) {
		pUser = request.getParameter(Constantes.PARAMETRO_USER);
		pPass = request.getParameter(Constantes.PARAMETRO_PASS);
		pIdioma = request.getParameter(Constantes.PARAMETRO_IDIOMA);
		pRecuerdame = (request.getParameter(Constantes.PARAMETRO_RECUERDAME) == null) ? false
				: true;
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

	private void loadMessages() {

		if (pIdioma == null) {
			pIdioma = Idioma.INGLES.getLocale();
			log.warn("NO viene parametro idioma, Ponemos " + pIdioma
					+ " por defecto");
		}
		Locale locale = new Locale(pIdioma.split("_")[0], pIdioma.split("_")[1]);
		messages = ResourceBundle.getBundle(Constantes.PROPERTI_I18N, locale);

		// guardar en session el language
		session.setAttribute(Constantes.USER_LANGUAGE, pIdioma);

		log.debug("cargados mensajes de properties " + Constantes.PROPERTI_I18N
				+ " " + locale);

	}

}
