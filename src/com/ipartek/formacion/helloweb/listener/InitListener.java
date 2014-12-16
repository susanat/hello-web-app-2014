package com.ipartek.formacion.helloweb.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.ipartek.formacion.helloweb.model.ModeloPersona;
import com.ipartek.formacion.helloweb.model.ModeloRol;

/**
 * Application Lifecycle Listener implementation class InitListener
 *
 */
public class InitListener implements ServletContextListener,
	ServletContextAttributeListener {

    public static boolean LOAD_ERROR = false;
    public static String LOAD_ERROR_MSG = null;

    private final static Logger log = Logger.getLogger(InitListener.class);
    public static ModeloPersona modelPersona = null;
    public static ModeloRol modelRole = null;

    /**
     * Default constructor.
     */
    public InitListener() {

    }

    /**
     * Cargar la configuracion de Log4j
     */
    private void loadLog4j(ServletContextEvent sce) {
	String prefix = sce.getServletContext().getRealPath("/");
	PropertyConfigurator
	.configure("C:/desarrollo/apache-tomcat-6.0.37/webapps/log4j.properties");

	// TODO: Hay que poner == en vez de != pero tengo que arreglarlo
	if (null != LogManager.exists("FICHERO")) {

	    LOAD_ERROR = true;
	    LOAD_ERROR_MSG = "Error cargando logger";
	}
	// log.info("LOG cargado");

    }

    private void initModelRole() {
	// TODO Auto-generated method stub
	modelRole = new ModeloRol();
	ModeloRol.createTable();

    }

    /**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce) {
	loadLog4j(sce);

	/*
	 * log.trace("Nivel trace"); log.debug("Nivel debug");
	 * log.info("nivel info"); log.warn("Nivel Warning");
	 * log.error("Nivel Error"); log.fatal("Nivel fatal");
	 */
	if (!LOAD_ERROR) {

	    System.out.println("Log 4j Configurado");
	    // TODO: Conexion base de datos
	    System.out.println("Establecimiento de conexion con BBDD OK");
	    // TODO: Cargar modelo de datos

	    initModelPersona();
	    initModelRole();
	    System.out.println("Cargado modelo de datos");
	} else {
	    System.out.println("Error cargando log4j");
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
	System.out.println("Destruyendo contexto servlet");
	// TODO: Cerrar conexion BBDD
	System.out.println("Desconexion a BBDD OK");
	// TODO: Liberar memoria y poner variables a null
	modelPersona = null;
	modelRole = null;
	System.out.println("Memoria liberada");
    }

    private void initModelPersona() {
	modelPersona = new ModeloPersona();
	ModeloPersona.createTable();

    }

}
