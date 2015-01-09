package com.ipartek.formacion.buscadorLinkedIn.modelo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.ipartek.formacion.buscadorLinkedIn.modelo.dao.interfaz.IPersonaDAO;

public class MYSQLDAOFactory extends DAOFactory {

    private static Connection con = null;
    private static final String DATA_SOURCE = "java:comp/env/jdbc/TestDB";

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

    public static Connection conectarDriver() {
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

    public static void cerrarConexion(Connection conexion, Statement st,
	    ResultSet rs) {
	if (rs != null) {
	    try {
		rs.close();
	    } catch (Exception e) {

		e.printStackTrace();
	    }
	}

	if (st != null) {
	    try {
		st.close();
	    } catch (Exception e) {

		e.printStackTrace();
	    }
	}

	if (conexion != null) {
	    try {
		conexion.close();
	    } catch (Exception e) {

		e.printStackTrace();
	    }
	}
    }

}
