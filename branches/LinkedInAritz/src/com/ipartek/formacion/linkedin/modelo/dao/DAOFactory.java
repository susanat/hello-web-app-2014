package com.ipartek.formacion.linkedin.modelo.dao;

public abstract class DAOFactory {

	// DAOs
	public abstract IPersonaDAO getPersonaDAO();

	// tipos bbdd
	public final static int ACCESS = 1;
	public final static int MYSQL = 2;

	public static DAOFactory getFactoriaDAO(int tipo) {
		switch (tipo) {
		case MYSQL:
			return MySqlDAOFactory.getInstance();
			// case ACCESS:
			// return new FactoriaACCESS();

		default:
			return null;
		}

	}

}
