package com.ipartek.ejercicio.migracion.dao.factoria;

import com.ipartek.ejercicio.migracion.dao.factoria.mysql.MysqlDAOFactory;
import com.ipartek.ejercicio.migracion.dao.interfaz.IPersonaDAO;

public abstract class DAOFactory 
{
	//DAOs
    
    	/**
    	 * Dao relativo a la tabla de usuario.
    	 * @return IPersonaDAO
    	 * @throws DAOException Excepcion en caso de error
    	 * @throws Exception Excepcion en caso de error
    	 */
	public abstract IPersonaDAO getPersonaDAO() throws Exception;
	
	public abstract boolean checkConnection() throws Exception;
	
	
	/**
	 * Tipo de motor
	 */	
	public final static int MYSQL = 2;
	
	
	public static DAOFactory getDaoFactoriaAbstracta (int tipo) {
		switch (tipo) {			
			case MYSQL:
				return MysqlDAOFactory.getInstance();
				
			
		}
		
		return null;
	}
}
