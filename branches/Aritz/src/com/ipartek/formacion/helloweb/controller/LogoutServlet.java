package com.ipartek.formacion.helloweb.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.helloweb.Constantes;
import com.ipartek.formacion.helloweb.bean.Mensaje;

/**
 * Servlet implementation class LogoutServlet
 */
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	RequestDispatcher dispatch = null;

	// private String pUser = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LogoutServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// recuperar sesionde usuario
		HttpSession sesion = request.getSession();

		// poner a null su sesion
		sesion.removeAttribute(Constantes.USER_SESSION);

		dispatch = request.getRequestDispatcher(Constantes.JSP_LOGIN);
		request.setAttribute(Constantes.MSG_KEY, Constantes.MSG_LOGOUT_CORRECT);

		// despachar o servir jsp
		Mensaje msg = new Mensaje(Constantes.MSG_LOGOUT_CORRECT,
				Mensaje.MSG_TYPE_INFO);
		request.setAttribute(Constantes.MSG_KEY, msg);
		request.getRequestDispatcher(Constantes.JSP_LOGIN).forward(request,
				response);
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
