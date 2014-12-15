package com.ipartek.formacion.helloweb.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.ipartek.formacion.helloweb.model.ModeloCalificacion;
import com.ipartek.formacion.helloweb.model.ModeloPersona;
import com.ipartek.formacion.helloweb.model.ModeloRol;

/**
 * Application Lifecycle Listener implementation class InitListener
 *
 */
public class InitListener implements ServletContextListener,
		ServletContextAttributeListener {

	public static ModeloPersona modelPersona = null;
	public static ModeloCalificacion modelCalificacion = null;
	public static ModeloRol modelRole = null;

	/**
     * Default constructor.
     */
    public InitListener() {
			
		initModelPersona();
		initModelRole();
		System.out.println("Cargado modelo de datos");

    }
	
	/**
	 * @see ServletContextListener#contextInitialized(ServletContextEvent)
	 */
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("Incializar Contexto Servlet ");
		// TODO Log
		System.out.println("Log4j congigurado");
		// TODO conexion BBDD
		System.out.println("Establecer conexion BBDD OK");
		// TODO cargar modelos de datos
		initModelPersona();
		initModelCalificacion();
		System.out.println("Modelo Persona Cargardo");

	}
	
	 private void initModelRole() {
			// TODO Auto-generated method stub
			modelRole = new ModeloRol();
			ModeloRol.createTable();

	    }

	/**
	 * @see ServletContextListener#contextDestroyed(ServletContextEvent)
	 */
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("Destruyendo Contexto Servlet");
		// TODO cerrar conexion bbdd
		System.out.println("Desconexion BBDD OK");
		// TODO liberar memoria y poner a null varaibles
		System.out.println("Liberado memoria");
		modelPersona = null;

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
		modelCalificacion = new ModeloCalificacion();
		ModeloCalificacion.createTable();
	}

}
