package com.ipartek.formacion.buscadorLinkedIn.modelo.dao;

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
	    return new MYSQLDAOFactory();
	default:
	    return null;

	}
    }
}
