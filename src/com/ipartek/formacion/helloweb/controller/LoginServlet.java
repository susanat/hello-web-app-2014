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

import com.ipartek.formacion.helloweb.bean.Mensaje;
import com.ipartek.formacion.helloweb.bean.Persona;
import com.ipartek.formacion.helloweb.constantes.Constantes;
import com.ipartek.formacion.helloweb.i18n.I18n;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RequestDispatcher rd = null;
	private HttpSession session = null;
	private ResourceBundle messages = null;

	private String pUser = null;
	private String pPass = null;
	private String pIdioma = null;
	private boolean pRecuerdame = false;

	private final static Logger log = Logger.getLogger("ACCESOS");

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

		if (!checkSession(request)) {
			// Recoger parámetros del login
			getParameters(request);

			loadMessage(request);

			log.info(I18n.getStringParametros(messages, "ejem.parametros",
					"uno", "dos"));

			// String.format(messages.getString("ejem.parametros"),
			// {"uno","dos"})

			// Validar el usuario
			if (Constantes.USER.equals(pUser) && Constantes.PASS.equals(pPass)) {
				log.info(pUser + " ha entrado");

				// Si es ADMINISTRADOR, redirigir al backoffice
				rd = request.getRequestDispatcher(Constantes.JSP_BACK_INDEX);
				// Guardar usuario en sesión
				Persona p = new Persona(pUser, 0);
				p.setRole(Persona.Rol.ADMINISTRADOR);
				session.setAttribute(Constantes.USER_SESSION, p);

				gestionCookies(request, response);
			} else if (Constantes.USER_USER.equals(pUser)
					&& Constantes.PASS_USER.equals(pPass)) {
				log.info(pUser + " ha entrado");

				// Si es USER, redirigir al saludo
				rd = request.getRequestDispatcher(Constantes.JSP_SALUDO);
				Persona p = new Persona(pUser, 0);
				session.setAttribute(Constantes.USER_SESSION, p);

				gestionCookies(request, response);
			} else {
				log.warn(pUser + " ha intentado entrar");

				// Si no, reenviar al login
				rd = request.getRequestDispatcher(Constantes.JSP_LOGIN);
				// Mensaje mensaje = new Mensaje(Constantes.MSG_LOGIN_INCORRECT,
				// Mensaje.MsgType.LOG, Constantes.COD_LOGIN_INCORRECT);
				Mensaje mensaje = new Mensaje(
						messages.getString("mensaje.login_incorrecto"),
						Mensaje.MsgType.LOG, Constantes.COD_LOGIN_INCORRECT);
				request.setAttribute(Constantes.MSG_KEY, mensaje);
			}
		}

		// Despachar el jsp
		rd.forward(request, response);
	}

	private void gestionCookies(HttpServletRequest request,
			HttpServletResponse response) {
		// Crear cookie con el usuario
		Cookie cUser = new Cookie(Constantes.COOKIE_USER_NAME, pUser);
		Cookie cPass = new Cookie(Constantes.COOKIE_USER_PASS, pPass);
		Cookie cIdioma = new Cookie(Constantes.COOKIE_USER_IDIOMA, pIdioma);
		if (!pRecuerdame) {
			// Si no quiere que se recuerde, borrar la cookie
			cUser.setMaxAge(0);
			cPass.setMaxAge(0);
			cIdioma.setMaxAge(0);
		} else {
			cUser.setMaxAge(30 * 24 * 60 * 60);
			cPass.setMaxAge(30 * 24 * 60 * 60);
			cIdioma.setMaxAge(30 * 24 * 60 * 60);
		}

		response.addCookie(cUser);
		response.addCookie(cPass);
		response.addCookie(cIdioma);
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
		pIdioma = request.getParameter(Constantes.PARAMETRO_IDIOMA);
		pRecuerdame = (request.getParameter(Constantes.PARAMETRO_RECUERDAME) == null) ? false
				: true;

	}

	private void loadMessage(HttpServletRequest request) {
		if (pIdioma == null) {
			pIdioma = I18n.getBrowserLocale(request.getLocale());
		}
		messages = ResourceBundle
				.getBundle("com.ipartek.formacion.helloweb.i18n.i18nmesages_"
						+ pIdioma);
		// + I18n.getBrowserLocale(request.getLocale()));

		session.setAttribute(Constantes.USER_SESSION_IDIOMA, pIdioma);
	}

	private boolean checkSession(HttpServletRequest request) {
		boolean resul = false;
		if ((Persona) session.getAttribute(Constantes.USER_SESSION) != null) {
			Persona p = (Persona) session.getAttribute(Constantes.USER_SESSION);
			if (Persona.Rol.ADMINISTRADOR.equals(p.getRole())) {
				rd = request.getRequestDispatcher(Constantes.JSP_BACK_INDEX);
				resul = true;
			} else if (Persona.Rol.USER.equals(p.getRole())) {
				rd = request.getRequestDispatcher(Constantes.JSP_SALUDO);
				resul = true;
			}
		}
		return resul;
	}

}
