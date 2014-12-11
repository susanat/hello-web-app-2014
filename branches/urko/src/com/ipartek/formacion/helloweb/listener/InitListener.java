package com.ipartek.formacion.helloweb.listener;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.ipartek.formacion.helloworld.model.ModeloPersona;

/**
 * Application Lifecycle Listener implementation class InitListener
 *
 */
public class InitListener implements ServletContextListener,
	ServletContextAttributeListener {
    public static ModeloPersona mPersona;

    /**
     * Default constructor.
     */
    public InitListener() {
	Logger logger = Logger.getAnonymousLogger();
	logger.log(Level.SEVERE, "Se ha inicializado el servidor");
    }

    /**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    @Override
    public void contextInitialized(final ServletContextEvent sce) {
	Logger logger = Logger.getAnonymousLogger();
	logger.log(Level.INFO, "Inicializar contexto servlet", sce);

	// TODO Log
	// TODO conexion BBDD y recuperar datos
	logger.log(Level.INFO, "Modelo persona cargado", sce);
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
	Logger logger = Logger.getAnonymousLogger();
	logger.log(Level.INFO, "Destruyendo persona cargado", sce);
	// TODO cerrar conexion BBDD
	// TODO liberar memeoria y poner a null variables

    }

    private void initModeloPersona() {
	ModeloPersona.init();
	mPersona = new ModeloPersona();
    }
}
