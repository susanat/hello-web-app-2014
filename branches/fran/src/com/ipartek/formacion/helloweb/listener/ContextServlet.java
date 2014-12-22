package com.ipartek.formacion.helloweb.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.ipartek.formacion.helloweb.constantes.Constantes;

/**
 * Application Lifecycle Listener implementation class ContextServlet
 *
 */
public class ContextServlet implements ServletContextListener {

	private int contador = 0;

	/**
	 * @see ServletContextListener#contextInitialized(ServletContextEvent)
	 */
	public void contextInitialized(ServletContextEvent sce) {
		sce.getServletContext()
				.setAttribute(Constantes.ATT_CONTADMIN, contador);
		sce.getServletContext().setAttribute(Constantes.ATT_CONTUSER, contador);
	}

	/**
	 * @see ServletContextListener#contextDestroyed(ServletContextEvent)
	 */
	public void contextDestroyed(ServletContextEvent sce) {
		sce.getServletContext().setAttribute(Constantes.ATT_CONTADMIN, 0);
		sce.getServletContext().setAttribute(Constantes.ATT_CONTUSER, 0);
	}

}
