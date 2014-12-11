package com.ipartek.formacion.helloweb.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.ipartek.formacion.helloweb.model.ModeloPersona;

/**
 * Application Lifecycle Listener implementation class InitListener
 *
 */
public class InitListener implements ServletContextListener,
	ServletContextAttributeListener {

    public static ModeloPersona modelPersona = null;

    /**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce) {
	System.out.println("Inicializar Contexto Servet");
	// TODO log
	System.out.println("Log4j Configurado");
	// TODO conexion BBDD
	System.out.println("Establecer conexion BBDD Ok");
	// TODO cargar modelos de datos
	initModelPersona();
	System.out.println("Modelo Persona cargado");

    }

    private void initModelPersona() {
	modelPersona = new ModeloPersona();
	ModeloPersona.createTable();

    }

    /**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce) {
	System.out.println("Destruyendo Contexto del Servlet");
	// TODO cerrar conexion BBDD
	System.out.println("Desconexion BBDD Ok");
	// TODO liberar memoria y poner a null variables
	System.out.println("Liberada memoria");

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

}
