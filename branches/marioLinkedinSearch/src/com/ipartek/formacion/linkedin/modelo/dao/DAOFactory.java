package com.ipartek.formacion.linkedin.modelo.dao;

/**
 * Factoria Abstracta
 *
 * @author Mario Alvaro
 *
 */
public abstract class DAOFactory {

    // DAOs
    public abstract IPersonaDAO getPersonaDAO();

    // Tipos de BBDD
    public final static int ACCESS = 1;
    public final static int MYSQL = 2;

    public static DAOFactory getDAOFactory(int tipo) {
	switch (tipo) {
	case MYSQL:
	    return new MySqlDAOFactory();
	    /*
	     * case ACCESS: return new FactoriaAccess();
	     */
	default:
	    return null;
	}

    }
}