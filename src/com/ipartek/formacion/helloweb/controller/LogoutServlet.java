package com.ipartek.formacion.helloweb.controller;

import java.io.IOException;
import java.util.ResourceBundle;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.helloweb.Constantes;
import com.ipartek.formacion.helloweb.bean.Mensaje;
import com.ipartek.formacion.helloweb.i18n.I18n;
import com.ipartek.formacion.helloweb.i18n.Idioma;
import com.ipartek.formacion.helloweb.util.MensajesIdiomas;

/**
 * Servlet implementation class LogoutServlet
 */
public class LogoutServlet extends HttpServlet {

	private static final long serialVersionUID = 6606004389468135663L;

	RequestDispatcher dispatch = null;
	HttpSession session = null;

	ResourceBundle messages = null;

	String pIdioma = Idioma.INGLES.getLocale();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LogoutServlet() {
		super();
	}

	@Override
	protected void service(final HttpServletRequest request, final HttpServletResponse response)
			throws ServletException, IOException {
		pIdioma = I18n.getBrowserLocale(request.getLocale());
		super.service(request, response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException,
			IOException {
		session = request.getSession();
		session.removeAttribute(Constantes.USER_SESSION);
		// session.setAttribute(Constantes.USER_SESSION, null);

		messages = MensajesIdiomas.loadMessages(pIdioma, session);

		dispatch = request.getRequestDispatcher(Constantes.JSP_LOGIN);
		final Mensaje msg = new Mensaje(Mensaje.MSG_TYPE_INFO, messages.getString("msg.logout"));
		request.setAttribute(Constantes.MSG_KEY, msg);

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
