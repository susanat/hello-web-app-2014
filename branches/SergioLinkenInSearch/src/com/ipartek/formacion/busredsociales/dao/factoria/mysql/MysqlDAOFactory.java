package com.ipartek.formacion.busredsociales.dao.factoria.mysql;

import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.sql.DataSource;



import com.ipartek.formacion.busredsociales.dao.factoria.DAOException;
import com.ipartek.formacion.busredsociales.dao.factoria.DAOFactory;
import com.ipartek.formacion.busredsociales.dao.interfaz.IUsuarioDAO;


public class MysqlDAOFactory extends DAOFactory {
	
	//patrón singleton para esta clase @see: http://es.wikipedia.org/wiki/Singleton	
	private static MysqlDAOFactory INSTANCE = null;
	
	static {
		try {
			createInstance();
		} catch (Throwable ex) {
			// Log exception!
			throw new ExceptionInInitializerError(ex);
		}
	}

	/*
	 * Constructor privado para el patrón singleton.
	 */
	private MysqlDAOFactory() {
		
	}

	/**
	 * Crea una instancia de la clase si no existe.
	 */
	private static void createInstance() {
		if (INSTANCE == null) {
			// Sólo se accede a la zona sincronizada
			// cuando la instancia no está creada
			synchronized (MysqlDAOFactory.class) {
				// En la zona sincronizada sería necesario volver
				// a comprobar que no se ha creado la instancia
				if (INSTANCE == null) {
					INSTANCE = new MysqlDAOFactory();
				}
			}
		}
	}

	public static MysqlDAOFactory getInstance() {
		/*
		if (INSTANCE == null)
			createInstance();
		*/
		return INSTANCE;
	}
	
	
	
	//********************************** obtener conexion y desconectar	

	private static final String STR_LOOKUP = "java:comp/env/jdbc/MyConexion";

	private static Connection conexion = null;

	public  Connection conectar() throws Exception {		
		try {			
			if (conexion == null) {				
				InitialContext ctx = new InitialContext();
				// en el web.xml se configura el jdbc/MyConexion
				DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/MyConexion");
				conexion = ds.getConnection();				
			}
			
		} catch (SQLException ex) {
			throw new DAOException(ex);			
		} catch (Exception ex) {
			throw new DAOException(ex);			
		}
		
		if (conexion == null) {
			throw new DAOException("Error indeterminado. No se ha creado la conexión");
		}
		
		return conexion;

	}
	
	/**
	 * Desconecta de la base de datos
	 * @throws SQLException
	 */
	public void desconectar() throws SQLException {
		if (conexion != null) {
			if (!conexion.isClosed()) {
				conexion.close();
			}
			conexion = null;
		}
	}
	

	@Override
	public IUsuarioDAO getUsuarioDAO() throws DAOException, Exception {
		return new MySqlUsuarioDAO();
	}

	@Override
	public boolean checkConnection() throws DAOException, Exception {
		
		
		conectar();
		desconectar();		
		
		
		return true;
	}

}
