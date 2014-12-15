package com.ipartek.formacion.helloweb.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * Servlet implementation class BaseServlet
 */
public class BaseServlet extends HttpServlet {
	private final static Logger log = Logger.getLogger("ACCESOS");

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		loadLog4j(config);
	}

	public void mensajeLog(TipoMensajeLog tipo, String mensaje) {
		switch (tipo) {
		case FATAL:
			log.fatal(mensaje);
			break;
		case ERROR:
			log.error(mensaje);
			break;
		case WARN:
			log.warn(mensaje);
			break;
		case INFO:
			log.info(mensaje);
			break;
		case DEBUG:
			log.debug(mensaje);
			break;
		case TRACE:
			log.trace(mensaje);
			break;

		default:
			break;
		}
	}
	/**
	 * Cargar la configuracion de Log4j
	 */
	private void loadLog4j(ServletConfig config) {
		String pathReal = config.getServletContext().getRealPath("/");
		PropertyConfigurator.configure(pathReal
				+ "WEB-INFaaa/conf/log4j.properties");
		log.info("LOG Cargado");
	}

	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BaseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	public enum TipoMensajeLog {
		FATAL, ERROR, WARN, INFO, DEBUG, TRACE
	}
}
