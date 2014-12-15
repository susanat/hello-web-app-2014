package com.ipartek.formacion.helloweb.listener;



import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.ipartek.formacion.helloweb.model.ModeloPersona;

/**
 * Application Lifecycle Listener implementation class InitListener
 *
 */
public class InitListener implements ServletContextListener, ServletContextAttributeListener {

	public static ModeloPersona modelPersona = null;
	private final static Logger log = Logger.getLogger(InitListener.class);

	public static boolean LOAD_ERROR = false;
	public static String LOAD_ERROR_MSG = null;
	public static String PATH_LOG4J = "WEB-INF/conf/log4j.properties";

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
	public void contextInitialized(ServletContextEvent sce) {

		loadLog4j(sce);
		if (!LOAD_ERROR) {
		log.info("Inicializar Contexto Servlet");

		// TODO conexion BBDD
			log.info("Establecer conexion BBDD OK");
		// TODO cargar modelos de datos
			initModelPersona();
			log.info("Modelo Persona Cargado");
		} else {
			System.out.println("Error cargando LOG4J");
		}
    }

	/**
	 * Cargar la configuracion de Log4j
	 * 
	 * @param sce
	 */
	private void loadLog4j(ServletContextEvent sce) {
		String pathReal = sce.getServletContext().getRealPath("/");
		PropertyConfigurator.configure(pathReal + PATH_LOG4J);
		/*
		 * if (!LogManager.getCurrentLoggers().hasMoreElements()) { LOAD_ERROR =
		 * true; LOAD_ERROR_MSG = Constantes.MSG_ERR_LOAD_LOG4J; }
		 */
		log.info("LOG Cargado");

	}

	private void initModelPersona() {
		modelPersona = new ModeloPersona();
		ModeloPersona.createTable();

	}

	/**
	 * @see ServletContextListener#contextDestroyed(ServletContextEvent)
	 */
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("Destruyendo Contexto Servlet");
		// TODO cerrar conexion BBDD
		System.out.println("Desconexion BBDD OK");
		// TODO Liberar memoria y poner a null variables
		System.out.println("Liberado memoria");
	}

	/**
	 * @see ServletContextAttributeListener#attributeAdded(ServletContextAttributeEvent)
	 */
    public void attributeAdded(ServletContextAttributeEvent arg0)  { 
		// TODO attributeAdded
    }

	/**
     * @see ServletContextAttributeListener#attributeReplaced(ServletContextAttributeEvent)
     */
    public void attributeReplaced(ServletContextAttributeEvent arg0)  { 
		// TODO attributeReplaced
    }

	/**
     * @see ServletContextAttributeListener#attributeRemoved(ServletContextAttributeEvent)
     */
    public void attributeRemoved(ServletContextAttributeEvent arg0)  { 
		// TODO attributeRemoved
    }

	
}
