package com.ipartek.ejercicio.migracion.dao.factoria.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.sql.DataSource;











import com.ipartek.ejercicio.migracion.Globales;
import com.ipartek.ejercicio.migracion.dao.factoria.DAOException;
import com.ipartek.ejercicio.migracion.dao.factoria.DAOFactory;
import com.ipartek.ejercicio.migracion.dao.interfaz.IPersonaDAO;


public class MysqlDAOFactory extends DAOFactory {
	
	//patrón singleton para esta clase @see: http://es.wikipedia.org/wiki/Singleton
	private static MysqlDAOFactory INSTANCE = null;
	
	/**
	 * Cadena para la carga del driver de conexión.
	 */
	public final static String CLASS_NAME = "com.mysql.jdbc.Driver";
	
	/**
	 * Cadena de conexión para la BBDD
	 */
	public final static String CONNECTION_CHAIN = "jdbc:mysql://localhost:3306/" + Globales.DATABASE_NAME;
	
	//public static final String STR_LOOKUP = "java:comp/env/jdbc/MyConexion";
	

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
		if (INSTANCE == null)
			createInstance();
		return INSTANCE;
	}
	

	private static Connection conexion = null;

	public  Connection conectar() throws Exception {
		
		try {
			if (conexion == null) {			
			   
			    Class.forName(CLASS_NAME);
			    Connection conexion = DriverManager.getConnection 
				    (CONNECTION_CHAIN,"root", "");
			    return conexion;
			}
			
		} catch (SQLException ex) {
			throw ex;			
		} catch (Exception ex) {
			throw ex;			
		}
		
		if (conexion == null) {
			throw new Exception(
				"Error indeterminado. No se ha creado la conexión");
		}
		
		return conexion;

	}

	
	/**
	 * Desconecta de la base de datos.
	 * @throws SQLException Excepción en caso de error
	 */
	public  void desconectar() throws SQLException {
		if (conexion != null) {
			if (!conexion.isClosed()) {
				conexion.close();
			}
			conexion = null;
		}
	}
	

	@Override
	public IPersonaDAO getPersonaDAO() throws Exception {
		return new MySqlPersonaDAO();
	}

    @Override
    public boolean checkConnection() throws Exception {

	conectar();
	desconectar();

	return true;
    }

}
