package com.ipartek.formacion.agenda.modelo.dao;


/**
 * Creacion de la factoria abstracta (este archivo es para determinar el tipo de
 * base de datos con el que vamos a trabajar
 * 
 * @author Susana COstoya y Kepa Escudero
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
			return MySqlDAOFactory.getInstance();
			/*
			 * case ACCESS: return new FactoriaAccess();
			 */
		default:
			return null;
		}

	}
}
