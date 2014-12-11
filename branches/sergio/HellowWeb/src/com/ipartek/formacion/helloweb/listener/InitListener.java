package com.ipartek.formacion.helloweb.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Application Lifecycle Listener implementation class InitListener
 *
 */
public class InitListener implements ServletContextListener, ServletContextAttributeListener {

    /**
     * Default constructor. 
     */
    public InitListener() {
        System.out.println("Constructor inicial del listener de Servlet Context");
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
         System.out.println("Iniciado el contexto de los servlet");
         
       //TODO: obtener y conectar los logs
         System.out.println("Iniciada la configuración del log4j");
                  
       //TODO: obtener y conectar a base de datos
         System.out.println("Iniciada la conexión a base de datos");
         
       //TODO: carga de tablas auxiliares no modificables
         System.out.println("Carga de tablas auxiliares no modificables (tabla de nombres de roles, por ejemplo)");
    }

	/**
     * @see ServletContextAttributeListener#attributeAdded(ServletContextAttributeEvent)
     */
    public void attributeAdded(ServletContextAttributeEvent scab)  {
    	ServletContext context = scab.getServletContext(); 
    	
    	
    	System.out.println("Añadido atributo context: " + scab.getName() + context.getAttribute(scab.getName()));
    }

	/**
     * @see ServletContextAttributeListener#attributeReplaced(ServletContextAttributeEvent)
     */
    public void attributeReplaced(ServletContextAttributeEvent scab)  { 
    	ServletContext context = scab.getServletContext(); 
    	System.out.println("Modificado atributo context: " + scab.getName() + context.getAttribute(scab.getName()));
    }

	/**
     * @see ServletContextAttributeListener#attributeRemoved(ServletContextAttributeEvent)
     */
    public void attributeRemoved(ServletContextAttributeEvent scab)  { 
    	ServletContext context = scab.getServletContext(); 
    	System.out.println("Eliminado atributo context: " + scab.getName() + context.getAttribute(scab.getName()));
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
    	System.out.println("Destruido el contexto de los servlet");
    	
    	//TODO cerrar conexión a base de datos
    	System.out.println("Cerrada la conexión a base de datos");
    	
    	//TODO liberar memoria y cerrar 
    }
	
}
