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
	HttpSession sesion = null;

	ResourceBundle messages = null;

	private String pUser = null;
	private String pPass = null;
	private String pIdioma = Idioma.INGLES.getLocale();

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

		// recuperar sesion
		sesion = request.getSession();

		// parametros del login.jsp
		getParameters(request);

		// cargar ficheros de mensajes
		loadMessages();

		// validar usuario
		validarUser(request, response);

		// despachar o servir jsp
		dispatch.forward(request, response);
	}

	/**
	 * comprobar datos del usuario y si tiene rolde admin o de user
	 *
	 * <ol>
	 * <li>admin: ir a backoffice</li>
	 * <li>user: ir a saluda</li>
	 * <li>si no existe/validado: ir a login</li>
	 * </ol>
	 *
	 * @param request
	 * @param response
	 */
	protected void validarUser(HttpServletRequest request,
			HttpServletResponse response) {
		if (Constantes.USER_ADMIN.equals(pUser)
				&& Constantes.PASS_ADMIN.equals(pPass)) {
			// correcto: redirigir a saludo.jsp
			dispatch = request.getRequestDispatcher(Constantes.JSP_BACK_INDEX);

			// guardar usuario en sesion
			Persona p = new Persona(pUser, 0);
			p.setRoll(Persona.Roll.ADMINISTRADOR);
			sesion.setAttribute(Constantes.USER_SESSION, p);

		} else if (Constantes.USER.equals(pUser)
				&& Constantes.PASS.equals(pPass)) {

			// correcto: redirigir a saludo.jsp
			dispatch = request.getRequestDispatcher(Constantes.JSP_SALUDO);

			// guardar usuario en sesion
			Persona p = new Persona(pUser, 0);
			sesion.setAttribute(Constantes.USER_SESSION, p);

		} else {
			// incorrecto : volver a login.jsp
			dispatch = request.getRequestDispatcher(Constantes.JSP_LOGIN);
			Mensaje msg = new Mensaje(
					messages.getString("msg.login.incorrect"),
					Mensaje.MSG_TYPE_DANGER);
			request.setAttribute(Constantes.MSG_KEY, msg);
		}

	}

	/**
	 *
	 * @param request
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

		/*
		 * response.setContentType("text/html"); PrintWriter out =
		 * response.getWriter(); out.println("<html>"); out.println("<head>");
		 * out.println("<title>Hello Servlet!</title>"); out.println("</head>");
		 * out.println("<body>"); out.println("<h1>Peticion tipo post</h1>");
		 * out.println("</body>"); out.println("</html>");
		 */

		doGet(request, response);
	}

	private void loadMessages() {

		Locale locale = new Locale(pIdioma.split("_")[0], pIdioma.split("_")[1]);
		messages = ResourceBundle.getBundle(Constantes.PROPERTY_I18N, locale);

		// guardar en sesiion el lenguage
		sesion.setAttribute(Constantes.USER_LANGUAGE, pIdioma);

	}

}
