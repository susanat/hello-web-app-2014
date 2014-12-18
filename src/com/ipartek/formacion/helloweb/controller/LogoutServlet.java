package com.ipartek.formacion.helloweb.controller;

import java.io.IOException;
import java.util.ResourceBundle;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.ipartek.formacion.helloweb.Constantes;
import com.ipartek.formacion.helloweb.bean.Mensaje;
import com.ipartek.formacion.helloweb.bean.Persona;
import com.ipartek.formacion.helloweb.filter.JspFilter;
import com.ipartek.formacion.helloweb.i18n.I18n;
import com.ipartek.formacion.helloweb.util.EIdioma;
import com.ipartek.formacion.helloweb.util.MensajesIdiomas;

/**
 * Servlet implementation class LogoutServlet
 */
public class LogoutServlet extends HttpServlet {

	private static final long serialVersionUID = 6606004389468135663L;

	private final static Logger log = Logger.getLogger(JspFilter.class);

	RequestDispatcher dispatch = null;
	HttpSession session = null;

	ResourceBundle messages = null;
	String pIdioma = EIdioma.INGLES.getLocale();

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

		if (null != session.getAttribute(Constantes.USER_SESSION)) {
			final Persona usuario = (Persona) session.getAttribute(Constantes.USER_SESSION);
			log.trace("Deslogueando a: " + usuario.toString());
		} else {
			log.warn("Usuario en session es null");
		}

		messages = MensajesIdiomas.loadMessages(pIdioma, session);

		// Invalidar session
		log.trace("Logout bajo petición del usuario");
		session.invalidate();
		// session.removeAttribute(Constantes.USER_SESSION);

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
