package com.ipartek.formacion.helloweb.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.ipartek.formacion.helloweb.Constantes;
import com.ipartek.formacion.helloweb.bean.Mensaje;
import com.ipartek.formacion.helloweb.bean.Persona;

/**
 * Servlet implementation class LogoutServlet
 */
// public class LogoutServlet extends HttpServlet {
public class LogoutServlet extends HttpServlet {

	// private final static Logger log = Logger.getLogger(LogoutServlet.class);
	private final static Logger log = Logger.getLogger("ACCESOS");

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		/*
		 * mensajeLog(TipoMensajeLog.TRACE, "Inicializado LogoutServlet");
		 * mensajeLog(TipoMensajeLog.DEBUG, "Inicializado LogoutServlet");
		 * mensajeLog(TipoMensajeLog.INFO, "Inicializado LogoutServlet");
		 * mensajeLog(TipoMensajeLog.WARN, "Inicializado LogoutServlet");
		 * mensajeLog(TipoMensajeLog.ERROR, "Inicializado LogoutServlet");
		 * mensajeLog(TipoMensajeLog.FATAL, "Inicializado LogoutServlet");
		 */
		/*
		 * loadLog4j(); log.trace("Inicializado LogoutServlet");
		 * log.debug("Inicializado LogoutServlet");
		 * log.info("Inicializado LogoutServlet");
		 * log.warn("Inicializado LogoutServlet");
		 * log.error("Inicializado LogoutServlet");
		 * log.fatal("Inicializado LogoutServlet");
		 */
	}

	/**
	 * Cargar la configuracion de Log4j
	 */
	/*
	 * private void loadLog4j() {
	 * PropertyConfigurator.configure(Constantes.PATH_LOG);
	 * log.info("LOG Cargado"); }
	 */

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
		
		if (null != session.getAttribute(Constantes.USER_SESSION)){
			Persona usuario = (Persona) session
					.getAttribute(Constantes.USER_SESSION);
			log.trace("Deslogeando a " + usuario.toString());
		}else{
			log.warn("usuario en session es nulo");
		}
		// poner a null la session
		// session.setAttribute(Constantes.USER_SESSION, null);
		session.removeAttribute(Constantes.USER_SESSION);
		log.trace("usuario removido de session");
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
