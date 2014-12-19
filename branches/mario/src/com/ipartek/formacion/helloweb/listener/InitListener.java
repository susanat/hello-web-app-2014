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
import com.ipartek.formacion.helloweb.model.ModeloPersona;

/**
 * Application Lifecycle Listener implementation class InitListener
 *
 */
public class InitListener implements ServletContextListener,
	ServletContextAttributeListener {
    public static boolean LOAD_ERROR = false;
    public static String LOAD_ERROR_MSG = null;
    public final static String LOG4J_PATH = "WEB-INF/conf/log4j.properties";
    public static ModeloPersona modelPersona = null;
    public static ModeloCalificacion modeloCalificacion = null;
    private final static Logger log = Logger.getLogger(InitListener.class);
    ServletContextEvent sce = null;

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
	this.sce = sce;
	loadLog4j(sce);
	if (!LOAD_ERROR) {
	    // TODO conexion BBDD y recuperar modelos
	    log.info("Establecer conexion BBDD OK");

	    // TODO cargar modelos de datos
	    initModelPersona();
	    initModelCalificacion();
	    log.info("Modelo Persona Cargado");
	    System.out.println("Modelo Calificacion Cargado");
	    initContadoresSessionesUsuarios(sce);
	} else {
	    System.out.println("Error cargando LOG4J");
	}

    }

    private void initContadoresSessionesUsuarios(ServletContextEvent sce2) {
	sce.getServletContext().setAttribute(Constantes.USER_USER_CONT, 0);
	sce.getServletContext().setAttribute(Constantes.USER_ADMIN_CONT, 0);

    }

    /**
     * Cargar la configuracion de Log4j
     */
    private void loadLog4j(ServletContextEvent sce) {
	try {
	    String prefix = sce.getServletContext().getRealPath("/");
	    PropertyConfigurator.configure(prefix + LOG4J_PATH);
	    // check configuration, si appender = null, ha fallado la carga de
	    // configuracion
	    if (null == LogManager.exists("ACCESOS")) {
		LOAD_ERROR = true;
		LOAD_ERROR_MSG = Constantes.MSG_ERR_LOAD_LOG4J + " path: "
			+ prefix + LOG4J_PATH;
	    }

	    log.info("LOG cargado");

	} catch (Exception e) {
	    // TODO: handle exception
	}

    }

    /**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce) {
	System.out.println("Destruyendo Contexto Servlet ");

	// TODO cerrar conexion BBDD
	System.out.println("Desconexion BBDD OK");

	// TODO liberar memoria y poner a null variables
	System.out.println("Liberado memoria");
	modelPersona = null;
	initContadoresSessionesUsuarios(sce);
    }

    /**
     * @see ServletContextAttributeListener#attributeAdded(ServletContextAttributeEvent)
     */
    public void attributeAdded(ServletContextAttributeEvent scab) {
	// TODO attributeAdded
    }

    /**
     * @see ServletContextAttributeListener#attributeReplaced(ServletContextAttributeEvent)
     */
    public void attributeReplaced(ServletContextAttributeEvent scab) {
	// TODO attributeReplaced
    }

    /**
     * @see ServletContextAttributeListener#attributeRemoved(ServletContextAttributeEvent)
     */
    public void attributeRemoved(ServletContextAttributeEvent scab) {
	// TODO attributeRemoved
    }

    private void initModelPersona() {
	modelPersona = new ModeloPersona();
	ModeloPersona.createTable();

    }

    private void initModelCalificacion() {
	modeloCalificacion = new ModeloCalificacion();
	ModeloCalificacion.createTable();

    }
}
