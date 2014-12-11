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

		System.out.println("Inicializar cotexto servlet");

		// TODO log
		System.out.println("log4j configurado");

		// TODO conexion bbdd y recuperar modelos
		System.out.println("establecer conexion bbdd ok");

		// TODO cargar modelos y datos
		initModelPersona();
		System.out.println("modelo persona cargado");
	}

	/**
	 * @see ServletContextListener#contextDestroyed(ServletContextEvent)
	 */
	public void contextDestroyed(ServletContextEvent sce) {

		System.out.println("Destruyendo contexto del servlet");

		// TODO cerrar conexion bbdd
		System.out.println("Desconexion bbdd ok");

		// TODO liberar memoria y poner a null variables
		System.out.println("liberado memoria");

	}

	/**
	 * @see ServletContextAttributeListener#attributeAdded(ServletContextAttributeEvent)
	 */
	public void attributeAdded(ServletContextAttributeEvent scab) {
		// TODO liberar memoria y poner a null variables
	}

	/**
	 * @see ServletContextAttributeListener#attributeReplaced(ServletContextAttributeEvent)
	 */
	public void attributeReplaced(ServletContextAttributeEvent scab) {
		// TODO liberar memoria y poner a null variables
	}

	/**
	 * @see ServletContextAttributeListener#attributeRemoved(ServletContextAttributeEvent)
	 */
	public void attributeRemoved(ServletContextAttributeEvent scab) {
		// TODO liberar memoria y poner a null variables
	}

	private void initModelPersona() {
		modelPersona = new ModeloPersona();

		ModeloPersona.createTable();

	}

}
