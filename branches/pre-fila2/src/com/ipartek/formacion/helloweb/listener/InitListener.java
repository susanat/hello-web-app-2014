package com.ipartek.formacion.helloweb.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.ipartek.formacion.helloweb.model.ModeloPersona;
import com.ipartek.formacion.helloweb.model.ModeloRol;

/**
 * Application Lifecycle Listener implementation class InitListener
 *
 */
public class InitListener implements ServletContextListener,
	ServletContextAttributeListener {

    public static ModeloPersona modelPersona = null;
    public static ModeloRol modelRole = null;

    /**
     * Default constructor.
     */
    public InitListener() {
	System.out.println("Inicializar Contexto Servlet");
	// TODO: Log
	System.out.println("Log 4j Configurado");
	// TODO: Conexion base de datos
	System.out.println("Establecimiento de conexion con BBDD OK");
	// TODO: Cargar modelo de datos

	initModelPersona();
	initModelRole();
	System.out.println("Cargado modelo de datos");

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
	// TODO Auto-generated method stub
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
