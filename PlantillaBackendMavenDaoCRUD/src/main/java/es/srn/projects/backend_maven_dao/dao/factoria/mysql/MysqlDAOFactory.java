package es.srn.projects.backend_maven_dao.dao.factoria.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import es.srn.projects.backend_maven_dao.dao.factoria.DAOFactory;
import es.srn.projects.backend_maven_dao.dao.factoria.interfaz.IUsuarioDAO;

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
	
	//********* variables para la conexión directa
	private static final String BD_URL_CONEXION = "jdbc:mysql://localhost:3306/";
	private static final String BD_NAME= "testPlantilla";
	private static final String BD_USER = "root";
	private static final String BD_PASSWORD = "";
	private static final String CLASS_NAME = "com.mysql.jdbc.Driver";
	
	
	//********* variables para la conexión con datasource
    /**
	 * Cadena de conexión para dataSource.
	 */
	private static final String STR_LOOKUP = "java:comp/env/jdbc/";
	
	/**
	 * Identificador del dataSource.
	 */
	private static final String STR_ID_DATASOURCE = "MyConexion";

	/**
	 * Session de la conexión.
	 */
	private static Connection session = null;
	
	private boolean isTrans = false;

	private Connection establecerConexionDataSource () throws NamingException, SQLException {
		
		InitialContext ctx = new InitialContext();
		// en el web.xml se configura el jdbc/MyConexion
		DataSource ds = (DataSource) ctx.lookup(STR_LOOKUP + STR_ID_DATASOURCE);
		return ds.getConnection();
	}
		
	  
	/**
	 * Establece la conexión con la base de datos.
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	private final Connection establecerConexion() throws SQLException,
			ClassNotFoundException {

		// This will load the MySQL driver, each DB has its own driver
		// Step 1: Load the JDBC driver.
		Class.forName(CLASS_NAME);

		// Step 2: Establish the connection to the database.
		String url = BD_URL_CONEXION + BD_NAME;
		return DriverManager.getConnection(url, BD_USER, BD_PASSWORD);
	}
	
	
	public  Connection conectar() throws Exception {		
		try {			
			if (session == null) {				
				session = establecerConexion();			
			}			
			
			//autocommitable en cada transacción
			session.setAutoCommit(true);
			isTrans = false;
			
		} catch (SQLException ex) {
			if(1049 == ex.getErrorCode()) {
				//TODO: controlar
				System.out.println("Base de datos no existente");
			}
			
			throw ex;				
		} catch (Exception ex) {
			throw ex;			
		}
		
		if (session == null) {
			throw new Exception("Error indeterminado. No se ha creado la conexión");
		}
		
		return session;
	}
	
	/**
	 * Obtiene la conexión con el parametro autocomit a false o, si existe, 
	 * lo inicia a false. Iniciando así una transacción.
	 * @return
	 * @throws Exception
	 */
	public Connection beginTrans() throws Exception {		
		try {			
			if (session == null) {				
				session = establecerConexion();			
			}			
			//cancelamos el autocommit e indicamos que es transacción.
			session.setAutoCommit(false);
			isTrans = true;
			
		} catch (SQLException ex) {
			
			if(1049 == ex.getErrorCode()) {
				//TODO: controlar, o mejor devolver y olvidar desde aquí
				System.out.println("Base de datos no existente");
			}
			
			throw ex;			
		} catch (Exception ex) {
			throw ex;			
		}
		
		//si ha llegado null aquí es que hay algún problema
		if (session == null) {
			throw new Exception("Error indeterminado. No se ha creado la conexión");
		}
		
		return session;
	}
		
	
	/**
	 * Desconecta de la base de datos 
	 * si no se encuentra en una transacción.
	 * @throws SQLException
	 */
	public void desconectar() throws SQLException {
		
		
		if(! isTrans) {
			try {
				if (session != null) {
					if (!session.isClosed()) {
						session.setAutoCommit(true);
						session.close();
						
					}
					session = null;
				}	
			} catch(SQLException ex) {
				throw ex;
			} finally {
				isTrans = false;
			}
		}
			
	}
	

	@Override
	public boolean checkConnection() throws Exception {
		
		
		conectar();
		desconectar();		
		
		
		return true;
	}

	/**
	 * Realiza el commit de una transacción en mysql.
	 * @throws SQLException
	 */
	@Override
	public void commit() throws SQLException {
		try {
			session.commit();
		} catch (SQLException e) {			
			throw e;
		} finally {
			this.desconectar();
		}
	}
	
	/**
	 * Realiza el rollback de una transacción en mysql.
	 * @throws SQLException
	 */
	@Override
	public void rollback() throws SQLException {
		try {
			session.rollback();
		} catch (SQLException e) {			
			throw e;
		} finally {
			this.desconectar();
		}
	}
	
	
	@Override
	public IUsuarioDAO getUsuarioDAO() throws Exception {
		return new MySqlUsuarioDAO();
	}
	
	/**
	 * Crea una base de datos en el servidor de base de datos indicado
	 * @return true si la ha creado
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	@Override
	public boolean createDataBase() throws ClassNotFoundException, SQLException {
		Class.forName(CLASS_NAME);
	    Connection conn = DriverManager.getConnection(BD_URL_CONEXION, BD_USER, BD_PASSWORD);
	    Statement s = conn.createStatement();
	    return s.executeUpdate("CREATE DATABASE " + BD_NAME) > 0; 		
	}
}
