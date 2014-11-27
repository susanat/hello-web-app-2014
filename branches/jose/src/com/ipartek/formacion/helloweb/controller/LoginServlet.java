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

	// parametros
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
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		/*
		 * // Pintamos la PAGINA response.setContentType("text/html");
		 * PrintWriter out = response.getWriter(); out.println("<html>");
		 * out.println("<head>"); out.println("<title>Hello Servlet</title>");
		 * out.println("</head>"); out.println("<body>");
		 * out.println("<h1>Peticion de GET</h1>"); out.println("</body>");
		 * out.println("</html>");
		 */

		// recuperar session
		session = request.getSession();

		// recoger parametros del login
		getParameters(request);
		// validar el usuario
		if (validarParametros()) {
			// guardar usuario en sesion
			Persona p = new Persona(pUser, 0);
			session.setAttribute(Constantes.USER_SESSION, p);
			// TODO recuperar usuario de la BBDD
			if (esAdministrador()) {
				dispatch = request.getRequestDispatcher(Constantes.JSP_BACKOFFICE);
			} else {
				// correcto: rediriguir a saludo.jsp
				dispatch = request.getRequestDispatcher(Constantes.JSP_SALUDO);
			}
		} else {
			// incorrecto: enviar de nuevo a login.jsp
			dispatch = request.getRequestDispatcher(Constantes.JSP_LOGIN);
			request.setAttribute(Constantes.MSG_KEY,
					Constantes.MSG_LOGIN_INCORRECTO);
		}

		// despachar o server JSP
		dispatch.forward(request, response);

	}

	/**
	 * Recoger parametros del request
	 * 
	 * @param request
	 */
	private void getParameters(HttpServletRequest request) {
		pUser = request.getParameter(Constantes.PARAMETRO_USER);
		pPass = request.getParameter(Constantes.PARAMETRO_PASS);
	}

	/**
	 * Devuelve si el usuario y el password es valido
	 * 
	 * @return {@code boolean}
	 * <ul>
	 * 	<li>True - si el usuario NO es vacio y el password es correcto</li>
	 * 	<li>False - eoc</li>
	 * </ul>
	 */
	private boolean validarParametros() {

		// boolean bUsuarioValido =
		// Constantes.USER_ADMIN.equals(pUser)?true:false;
		boolean bUsuarioValido = false;
		if (pUser != null) {
			if (!pUser.isEmpty()) {
				bUsuarioValido = true;
			}
		}
		boolean bPasswordValido = Constantes.PASS.equals(pPass) ? true : false;

		return (bUsuarioValido && bPasswordValido);
	}

	/**
	 * Devuelve is el usuario es administrador o no
	 * 
	 * @return {@code boolean}
	 * <ul>
	 * 	<li>True -  si el usuario es administrador</li>
	 * 	<li>False - eoc</li>
	 * </ul>
	 */
	private boolean esAdministrador() {
		boolean bUsuarioValido = Constantes.USER_ADMIN.equals(pUser) ? true
				: false;
		boolean bPasswordValido = Constantes.PASS_ADMIN.equals(pPass) ? true
				: false;

		return (bUsuarioValido && bPasswordValido);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
