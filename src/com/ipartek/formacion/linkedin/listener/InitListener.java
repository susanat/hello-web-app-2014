package com.ipartek.formacion.linkedin.listener;

import java.sql.Connection;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.ipartek.formacion.linkedin.modelo.dao.ModelException;
import com.ipartek.formacion.linkedin.modelo.dao.MySqlDAOFactory;

/**
 * Application Lifecycle Listener implementation class InitListener
 *
 */
public class InitListener implements ServletContextListener {
    public static boolean LOAD_BD_ERROR = false;
    public static String LOAD_BD_ERROR_MSG = null;

    ServletContextEvent sce = null;

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
	this.sce = sce;
	Connection conexion = null;
	try {
	    conexion = MySqlDAOFactory.getInstance().conectar();
	    System.out.println("BD en marcha y funcionando");
	} catch (ModelException e) {
	    e.printStackTrace();
	    LOAD_BD_ERROR_MSG = "Error estableciendo la conexión a la BD";
	    System.out.println(LOAD_BD_ERROR_MSG);
	    LOAD_BD_ERROR = true;
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
