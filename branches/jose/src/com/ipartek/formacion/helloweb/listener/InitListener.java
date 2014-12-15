package com.ipartek.formacion.helloweb.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;

import com.ipartek.formacion.helloweb.model.ModeloPersona;

/**
 * Application Lifecycle Listener implementation class InitListener
 *
 */
public class InitListener implements ServletContextListener, ServletContextAttributeListener {

	public static ModeloPersona modelPersona = null;
	private final static Logger log = Logger.getLogger(InitListener.class);
	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0)  { 
		System.out.println("Inicializar Contexto Servlet");
		// TODO Log
		System.out.println("Log4j configurado");
		// TODO conexion BBDD
		System.out.println("Establecer conexion BBDD OK");
		// TODO cargar modelos de datos
		initModelPersona();
		System.out.println("Modelo Persona Cargado");
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
