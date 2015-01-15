package com.ipartek.formacion.buscadorLinkedIn.modelo.dao;

import java.sql.Connection;
import java.sql.DriverManager;

import com.ipartek.formacion.buscadorLinkedIn.modelo.dao.interfaz.IPersonaDAO;

public class AccessDAOFactory extends DAOFactory {

    private static AccessDAOFactory INSTANCE = null;

    // constructor privado (patron singleton)
    private AccessDAOFactory() {
    };

    private synchronized static void createInstance() {
	if (INSTANCE == null) {
	    INSTANCE = new AccessDAOFactory();
	}
    }

    public static AccessDAOFactory getInstance() {
	if (INSTANCE == null)
	    createInstance();
	return INSTANCE;
    }

    @Override
    public IPersonaDAO getPersonaDAO() {

	return new PersonaAccessDAO();
    }

    public Connection conectarDriver() {
	Connection conexion = null;
	try {
	    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

	    conexion = DriverManager.getConnection("jdbc:odbc:dataSourceTest");
	} catch (Exception e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	return conexion;
    }

}
