package com.ipartek.formacion.buscadorLinkedIn.modelo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.ipartek.formacion.buscadorLinkedIn.modelo.dao.interfaz.IPersonaDAO;

public abstract class DAOFactory {

    public abstract IPersonaDAO getPersonaDAO();

    public final static int ACCESS = 1;
    public final static int MYSQL = 2;

    // TODO Añadir Excepcion
    public static DAOFactory getFactoriaDAO(int tipo) {
	switch (tipo) {
	/*
	 * case ACCESS: return new AccessDAOFactoria(); break;
	 */
	case MYSQL:
	    return MYSQLDAOFactory.getInstance();

	case ACCESS:
	    return AccessDAOFactory.getInstance();
	default:
	    return null;

	}
    }

    public void cerrarConexion(Connection conexion, Statement st, ResultSet rs) {
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
