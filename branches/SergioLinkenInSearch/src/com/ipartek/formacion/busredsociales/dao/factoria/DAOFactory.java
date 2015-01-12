package com.ipartek.formacion.busredsociales.dao.factoria;

import com.ipartek.formacion.busredsociales.dao.factoria.mysql.MysqlDAOFactory;
import com.ipartek.formacion.busredsociales.dao.interfaz.IUsuarioDAO;

public abstract class DAOFactory 
{
	//DAOs
	public abstract IUsuarioDAO getUsuarioDAO() throws DAOException, Exception;
	
	
	public final static int ACCESS = 1;
	public final static int MYSQL = 2;
	
	
	public static DAOFactory getDaoFactoriaAbstracta (int tipo) {
		switch (tipo) {			
			case MYSQL:
				return MysqlDAOFactory.getInstance();
				
			
		}
		
		return null;
	}
}
