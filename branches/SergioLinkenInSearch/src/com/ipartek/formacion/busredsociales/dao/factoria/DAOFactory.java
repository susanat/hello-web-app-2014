package com.ipartek.formacion.busredsociales.dao.factoria;

import com.ipartek.formacion.busredsociales.dao.factoria.mysql.MysqlDAOFactory;
import com.ipartek.formacion.busredsociales.dao.interfaz.IUsuarioDAO;

/**
 * Clase abstracta para la obtención 
 * del tipo de conexión de almacenamiento de datos.
 * @author baskito
 *
 */
public abstract class DAOFactory 
{
	//Listado de DAOs	
	/**
	 * Dao para el interfaz de usuario.
	 * @return IUsuarioDAO del usuario
	 * @throws DAOException Excepción personalizada
	 * @throws Exception Excepción genérica
	 */
    public abstract IUsuarioDAO getUsuarioDAO() throws DAOException, Exception;
	
	
	/**
	 * Función para la comprobación de la conexión.
	 * @return Boolean True si la conexión se ha relizado.
	 * @throws DAOException Excepción personalizada.
	 * @throws Exception Excepción comun.
	 */
    public abstract boolean checkConnection() throws DAOException, Exception;
    
    /**
     * Almacenamiento en access.
     */
	public final static int ACCESS = 1;
	
	/**
	 * Almacenamiento en mysql
	 */
	public final static int MYSQL = 2;
	
	/**
	 * Obtiene la instancia del tipo de conexión escogida.
	 * @param tipo
	 * @return
	 */
	public static DAOFactory getDaoFactoriaAbstracta (int tipo) {
		switch (tipo) {			
			case MYSQL:
				return MysqlDAOFactory.getInstance();
		}
		
		return null;
	}
}
