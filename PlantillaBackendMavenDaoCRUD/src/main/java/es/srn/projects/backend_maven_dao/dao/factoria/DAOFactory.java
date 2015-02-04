package es.srn.projects.backend_maven_dao.dao.factoria;

import java.sql.SQLException;

import es.srn.projects.backend_maven_dao.dao.factoria.interfaz.IUsuarioDAO;


/**
 * Clase abstracta para la obtenci�n 
 * del tipo de conexi�n de almacenamiento de datos.
 * @author baskito
 *
 */
public abstract class DAOFactory 
{
	//Listado de DAOs	
	/**
	 * Dao para el interfaz de usuario.
	 * @return IUsuarioDAO del usuario
	 * @throws DAOException Excepci�n personalizada
	 * @throws Exception Excepci�n gen�rica
	 */
    public abstract IUsuarioDAO getUsuarioDAO() throws Exception;
	
	
	/**
	 * Funci�n para la comprobaci�n de la conexi�n.
	 * @return Boolean True si la conexi�n se ha relizado.
	 * @throws DAOException Excepci�n personalizada.
	 * @throws Exception Excepci�n comun.
	 */
    public abstract boolean checkConnection() throws Exception;
    public abstract boolean createDataBase() throws ClassNotFoundException, SQLException;
    public abstract void commit() throws SQLException;
    public abstract void rollback() throws SQLException;
    
    /**
     * Almacenamiento en access.
     */
	public final static int ACCESS = 1;
	
	/**
	 * Almacenamiento en mysql
	 */
	public final static int MYSQL = 2;
	
	/**
	 * Obtiene la instancia del tipo de conexi�n escogida.
	 * @param tipo
	 * @return
	 */
	public static DAOFactory getDaoFactoriaAbstracta (int tipo) {
		switch (tipo) {			
			case MYSQL:
				//return MysqlDAOFactory.getInstance();
		}
		
		return null;
	}
}
