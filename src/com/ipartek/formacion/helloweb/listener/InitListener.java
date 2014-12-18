package com.ipartek.formacion.helloweb.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.ipartek.formacion.helloweb.Constantes;
import com.ipartek.formacion.helloweb.model.ModeloCalificacion;
import com.ipartek.formacion.helloweb.model.ModeloIdioma;
import com.ipartek.formacion.helloweb.model.ModeloPersona;
import com.ipartek.formacion.helloweb.model.ModeloRol;

/**
 * Application Lifecycle Listener implementation class InitListener
 *
 */
public class InitListener implements ServletContextListener, ServletContextAttributeListener {

	private final static Logger log = Logger.getLogger(InitListener.class);
	public static final String PATH_LOG4J = "WEB-INF/conf/log4j.properties";

	public static boolean LOAD_ERROR = false;
	public static String LOAD_ERROR_MSG = null;

	public static ModeloIdioma modeloIdioma = null;
	public static ModeloRol modeloRole = null;
	public static ModeloPersona modeloPersona = null;
	public static ModeloCalificacion modeloCalificacion = null;

	/**
	 * @see ServletContextListener#contextInitialized(ServletContextEvent)
	 */
	public void contextInitialized(final ServletContextEvent sce) {
		loadLog4j(sce);

		if (!LOAD_ERROR) {
			// TODO establecer conexion
			log.info("Establecer conexion BBDD OK");

			initModelPersona();
			initModelCalificacion();
			initModelRole();
			log.info("Modelos cargados");

		} else {
			System.out.println("Error cargando LOG4J");
		}
	}

	/**
	 * Cargar la configuracion de Log4J
	 *
	 * @param sce
	 */
	private void loadLog4j(final ServletContextEvent sce) {
		try {
			final String pathReal = sce.getServletContext().getRealPath("/");
			PropertyConfigurator.configure(pathReal + PATH_LOG4J);
			// check configuration, si no hay apender == null ha fallado la
			// carga
			// de configuración
			if (null == LogManager.exists("ACCESOS")) {
				LOAD_ERROR = true;
				LOAD_ERROR_MSG = Constantes.MSG_ERR_LOAD_LOG4J;
			}
			log.debug("LOG cargado");
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see ServletContextListener#contextDestroyed(ServletContextEvent)
	 */
	public void contextDestroyed(final ServletContextEvent sce) {
		System.out.println("Destruyendo Contexto Servlet");
		// TODO cerrar conexion bbdd
		System.out.println("Desconexion BBDD OK");
		// TODO liberar memoria y poner a null varaibles
		System.out.println("Liberado memoria");
		modeloPersona = null;

	}

	/**
	 * @see ServletContextAttributeListener#attributeAdded(ServletContextAttributeEvent)
	 */
	public void attributeAdded(final ServletContextAttributeEvent scab) {
		// TODO attributeAdded
	}

	/**
	 * @see ServletContextAttributeListener#attributeReplaced(ServletContextAttributeEvent)
	 */
	public void attributeReplaced(final ServletContextAttributeEvent scab) {
		// TODO attributeReplaced
	}

	/**
	 * @see ServletContextAttributeListener#attributeRemoved(ServletContextAttributeEvent)
	 */
	public void attributeRemoved(final ServletContextAttributeEvent scab) {
		// TODO attributeRemoved
	}

	private void initModelPersona() {
		modeloPersona = new ModeloPersona();
		ModeloPersona.createTable();
	}

	private void initModelCalificacion() {
		modeloCalificacion = new ModeloCalificacion();
		ModeloCalificacion.createTable();

		modeloIdioma = new ModeloIdioma();
		ModeloIdioma.createTable();
	}

	private void initModelRole() {
		modeloRole = new ModeloRol();
		ModeloRol.createTable();
	}

}
