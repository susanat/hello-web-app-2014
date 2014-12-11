package com.ipartek.formacion.helloweb.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.ipartek.formacion.helloweb.model.ModeloCalificacion;
import com.ipartek.formacion.helloweb.model.ModeloPersona;

/**
 * Application Lifecycle Listener implementation class InitListener
 *
 */
public class InitListener implements ServletContextListener, ServletContextAttributeListener {

	public static ModeloPersona modeloPersona = null;
	public static ModeloCalificacion modeloCalificacion = null;

	/**
	 * @see ServletContextListener#contextInitialized(ServletContextEvent)
	 */
	public void contextInitialized(final ServletContextEvent se) {
		System.out.println("---- Llamada al método contextInitialized ----");
		System.out.println("Inicializar contexto del servlet");
		// TODO log
		System.out.println("Log4j configurado");
		// TODO conexión a la BBDD
		System.out.println("Establecer conexión con BBDD => OK");
		// TODO cargar modelos de datos
		initModeloPersona();
		System.out.println("Modelo Persona cargado");
	}

	/**
	 * @see ServletContextListener#contextDestroyed(ServletContextEvent)
	 */
	public void contextDestroyed(final ServletContextEvent se) {
		System.out.println("---- Llamada al método contextDestroyed ----");
		// TODO cerrar conexión con BBDD
		System.out.println("Destruyendo contexto del servlet");
		// TODO liberar memoria y poner a null las variables
		System.out.println("Liberando memoria");
		modeloPersona = null;
	}

	/**
	 * @see ServletContextAttributeListener#attributeAdded(ServletContextAttributeEvent)
	 */
	public void attributeAdded(final ServletContextAttributeEvent se) {
		System.out.println("---- Llamada al método attributeAdded ----");
	}

	/**
	 * @see ServletContextAttributeListener#attributeReplaced(ServletContextAttributeEvent)
	 */
	public void attributeReplaced(final ServletContextAttributeEvent se) {
		System.out.println("---- Llamada al método attributeReplaced ----");
	}

	/**
	 * @see ServletContextAttributeListener#attributeRemoved(ServletContextAttributeEvent)
	 */
	public void attributeRemoved(final ServletContextAttributeEvent se) {
		System.out.println("---- Llamada al método attributeRemoved ----");
	}

	private void initModeloPersona() {
		modeloPersona = new ModeloPersona();
		ModeloPersona.createTable();

		modeloCalificacion = new ModeloCalificacion();
		ModeloCalificacion.createTable();
	}

}
