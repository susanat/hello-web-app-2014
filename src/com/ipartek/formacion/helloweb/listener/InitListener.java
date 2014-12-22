package com.ipartek.formacion.helloweb.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.ipartek.formacion.helloweb.model.ModeloPersona;

/**
 * Application Lifecycle Listener implementation class InitListener
 *
 */
public class InitListener implements ServletContextListener,
		ServletContextAttributeListener {

	private final static Logger log = Logger.getLogger(InitListener.class);
	public static boolean LOAD_ERROR = false;
	public static String LOAD_ERROR_MSG = null;

	/**
	 * Default constructor.
	 */
	public InitListener() {
		System.out.println("Default constructor");
	}

	/**
	 * @see ServletContextListener#contextInitialized(ServletContextEvent)
	 */
	public void contextInitialized(ServletContextEvent sce) {
		loadLog4(sce);

		if (!LOAD_ERROR) {
			/*
			 * log.trace("trace"); log.debug("debug"); log.info("info");
			 * log.warn("warn"); log.error("error"); log.fatal("fatal");
			 */

			log.info("Inicializar contexto server");

			ModeloPersona.createTable();
		} else {
			System.out.println("Error al cargar log4j");
		}
	}

	/**
	 * Cargar la configuración de Log4j.
	 */
	private void loadLog4(ServletContextEvent sce) {
		PropertyConfigurator.configure(sce.getServletContext().getRealPath("/")
				+ "WEB-INF/conf/log4j.properties");
		if (LogManager.exists("ACCESOS") == null) {
			LOAD_ERROR = true;
			LOAD_ERROR_MSG = "ERROR";
		} else {
			log.info("LOG cargado");
		}
	}

	/**
	 * @see ServletContextAttributeListener#attributeAdded(ServletContextAttributeEvent)
	 */
	public void attributeAdded(ServletContextAttributeEvent scab) {
		// TODO Auto-generated method stub
	}

	/**
	 * @see ServletContextAttributeListener#attributeReplaced(ServletContextAttributeEvent)
	 */
	public void attributeReplaced(ServletContextAttributeEvent scab) {
		// TODO Auto-generated method stub
	}

	/**
	 * @see ServletContextAttributeListener#attributeRemoved(ServletContextAttributeEvent)
	 */
	public void attributeRemoved(ServletContextAttributeEvent scab) {
		// TODO Auto-generated method stub
	}

	/**
	 * @see ServletContextListener#contextDestroyed(ServletContextEvent)
	 */
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("Destruir contexto");
		System.out.println("Desconectar de la bbdd");
		System.out.println("Liberar memoria poniendo a null");
		ModeloPersona.truncateTable();
	}

}
