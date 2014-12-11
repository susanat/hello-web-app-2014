package com.ipartek.formacion.helloweb.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.helloweb.Constantes;
import com.ipartek.formacion.helloweb.bean.Message;

//http://www.javatpoint.com/servlet-http-session-login-and-logout-example
/**
 * Servlet implementation class LogoutServlet
 */
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RequestDispatcher dispatch = null;
	HttpSession session = null;

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
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequestGET(request, response);

	}

	// método encargado de la gestión del método GET
	protected void processRequestGET(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// recuperar sesion
		session = request.getSession();
		// poner el objeto de la sesion a null
		session.removeAttribute(Constantes.USER_SESSION);
		// redireccionar a login
		dispatch = request.getRequestDispatcher(Constantes.JSP_LOGIN);
		// request.setAttribute(Constantes.MSG_KEY_OUT, Constantes.MSG_LOGOUT);
		Message msg = new Message(Constantes.MSG_LOGOUT, Message.MSG_TYPE_INFO);
		request.setAttribute(Constantes.MSG_KEY, msg);
		dispatch.forward(request, response);

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
