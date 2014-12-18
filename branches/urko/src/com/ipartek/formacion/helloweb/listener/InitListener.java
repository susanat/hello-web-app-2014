package com.ipartek.formacion.helloweb.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.ipartek.formacion.helloweb.model.ModeloPersona;

//import com.ipartek.formacion.helloweb.Constantes;

/**
 * Application Lifecycle Listener implementation class InitListener
 *
 */
public class InitListener implements ServletContextListener,
	ServletContextAttributeListener {
    private final static Logger log = Logger.getLogger(InitListener.class);

    public static boolean LOAD_ERROR = false;
    public static String LOAD_ERROR_MSG = null;

    public static final String PATH_LOG4J = "WEB-INF/conf/log4j.properties";

    public static ModeloPersona modelPersona = null;

    // public static ModeloRol modelRole = null;
    // public static ModeloCalificacion modelCalificacion = null;

    /**
     * Default constructor.
     */
    public InitListener() {
	// Logger logger = Logger.getAnonymousLogger();
	// logger.log(Level.SEVERE, "Se ha inicializado el servidor");

    }

    /**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    @Override
    public void contextInitialized(final ServletContextEvent sce) {
	// Logger logger = Logger.getAnonymousLogger();
	// logger.log(Level.INFO, "Inicializar contexto servlet", sce);

	// logger.log(Level.INFO, "Modelo persona cargado", sce);
	loadLog4j(sce);
	initModeloPersona();
    }

    /**
     * Cargar la configuracion de Log4J
     *
     * @param sce
     */
    private void loadLog4j(final ServletContextEvent sce) {

	try {
	    String pathReal = sce.getServletContext().getRealPath("/");
	    PropertyConfigurator.configure(pathReal + PATH_LOG4J);
	    // check configration, si no hay apender es que ha fallado
	    if (null == LogManager.exists("ACCESOS")) {
		LOAD_ERROR = true;
		// LOAD_ERROR_MSG = Constante.MSG_ERR_LOAD_LOG4J;
	    }
	    log.debug("LOG cargado");
	} catch (Exception e) {
	    e.printStackTrace();
	}

    }

    /**
     * @see ServletContextAttributeListener#attributeAdded(ServletContextAttributeEvent)
     */
    @Override
    public void attributeAdded(final ServletContextAttributeEvent scab) {
	// sce

    }

    /**
     * @see ServletContextAttributeListener#attributeReplaced(ServletContextAttributeEvent)
     */
    @Override
    public void attributeReplaced(final ServletContextAttributeEvent scab) {
	// TODO Auto-generated method stub
    }

    /**
     * @see ServletContextAttributeListener#attributeRemoved(ServletContextAttributeEvent)
     */
    @Override
    public void attributeRemoved(final ServletContextAttributeEvent scab) {
	// TODO Auto-generated method stub
    }

    /**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    @Override
    public void contextDestroyed(final ServletContextEvent sce) {
	// TODO Auto-generated method stub
	// Logger logger = Logger.getAnonymousLogger();
	// logger.log(Level.INFO, "Destruyendo persona cargado", sce);
	// TODO cerrar conexion BBDD
	// TODO liberar memeoria y poner a null variables

    }

    private void initModeloPersona() {
	ModeloPersona.init();
	modelPersona = new ModeloPersona();
    }
}
