package com.ipartek.formacion.buscadorLinkedIn.modelo.dao;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.ipartek.formacion.buscadorLinkedIn.modelo.dao.interfaz.IPersonaDAO;

public class MYSQLDAOFactory extends DAOFactory {

    // Patron singleton para esta clase, @see:
    // http://es.wikipedia.org/wiki/Singleton#Java
    private static MYSQLDAOFactory INSTANCE = null;

    private static Connection con = null;
    private static final String DATA_SOURCE = "java:comp/env/jdbc/TestDB";

    // constructor privado (patron singleton)
    private MYSQLDAOFactory() {
    };

    private synchronized static void createInstance() {
	if (INSTANCE == null) {
	    INSTANCE = new MYSQLDAOFactory();
	}
    }

    public static MYSQLDAOFactory getInstance() {
	if (INSTANCE == null)
	    createInstance();
	return INSTANCE;
    }

    public static Connection conectar() {
	// patron singleton, si ya esta creada para que volver hacerlo ?
	if (con != null) {
	    try {
		InitialContext ctx = new InitialContext();
		DataSource ds = (DataSource) ctx.lookup(DATA_SOURCE);
		con = ds.getConnection();
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
	return con;
    }

    public Connection conectarDriver() {
	Connection conexion = null;
	try {
	    Class.forName("com.mysql.jdbc.Driver");

	    conexion = DriverManager.getConnection(
		    "jdbc:mysql://localhost/test", "root", "");
	} catch (Exception e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	return conexion;
    }

    public static void desconectar() {

	if (con != null) {
	    try {
		con.close();
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }

    @Override
    public IPersonaDAO getPersonaDAO() {

	return new PersonaMySqlDAO();
    }

}
