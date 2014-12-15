package com.ipartek.formacion.helloweb.controller;

import java.io.IOException;

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

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LogoutServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// recuperar session del usuario
		HttpSession session = request.getSession();
		// poner a null la session
		// session.setAttribute(Constantes.USER_SESSION, null);
		session.removeAttribute(Constantes.USER_SESSION);
		// otra alternativa - eliminar toda la session del usuario
		// session.invalidate();

		// frowar a login
		Mensaje msg = new Mensaje(Constantes.MSG_LOGOUT, Mensaje.MSG_TYPE_INFO);
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
		// TODO Auto-generated method stub
	}

}
