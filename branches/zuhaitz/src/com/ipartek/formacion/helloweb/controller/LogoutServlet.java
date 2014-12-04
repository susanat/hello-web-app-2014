package com.ipartek.formacion.helloweb.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.helloweb.Constantes;
import com.ipartek.formacion.helloweb.util.Mensaje;

/**
 * Servlet implementation class LogoutServlet
 */
public class LogoutServlet extends HttpServlet {

	private static final long serialVersionUID = 6606004389468135663L;

	RequestDispatcher dispatch = null;
	HttpSession session = null;

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
	protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException,
	IOException {
		session = request.getSession();
		session.setAttribute(Constantes.USER_SESSION, null);

		dispatch = request.getRequestDispatcher(Constantes.JSP_LOGIN);
		final Mensaje msg = new Mensaje("alert alert-info", Constantes.MSG_LOGOUT);
		request.setAttribute(Constantes.MSG_KEY, msg);
		// request.setAttribute(Constantes.MSG_KEY, Constantes.MSG_LOGOUT);

		dispatch.forward(request, response);
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

}
