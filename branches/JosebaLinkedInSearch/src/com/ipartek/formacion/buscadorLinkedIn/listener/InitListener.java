package com.ipartek.formacion.buscadorLinkedIn.listener;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Application Lifecycle Listener implementation class InitListener
 *
 */
public class InitListener implements ServletContextListener {

    public static boolean LOAD_ERROR = false;
    public static String LOAD_ERROR_MSG = null;

    static final String DRIVER = "com.mysql.jdbc.Driver";
    static final String CON_URL = "jdbc:mysql://localhost/test";
    static final String USER = "root";
    static final String PASS = "";

    /**
     * Default constructor.
     */
    public InitListener() {
	// TODO Auto-generated constructor stub
    }

    /**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    @Override
    public void contextInitialized(ServletContextEvent sce) {
	// tenemos que mirar que la base de datos esta arrancada
	Connection conexion;
	try {
	    Class.forName(DRIVER);
	    conexion = DriverManager.getConnection(CON_URL, USER, PASS);
	} catch (Exception e) {
	    if (e instanceof SQLException) {

		// Error al tratar de conectarnos a la base de datos
		LOAD_ERROR = true;
		LOAD_ERROR_MSG = "Error conectando con la BBDD";

	    }
	    e.printStackTrace();
	} finally {
	    if (!LOAD_ERROR) {
		// cargado correcto de la BBDD
		System.out.println("Error al conectarnos a la BBDD");
	    } else {
		System.out.println("Error al conectarnos a la base de datos");
	    }
	}

    }

    /**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
	// TODO Auto-generated method stub
    }

}
