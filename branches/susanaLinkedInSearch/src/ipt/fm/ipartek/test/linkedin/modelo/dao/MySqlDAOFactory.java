package ipt.fm.ipartek.test.linkedin.modelo.dao;

import java.sql.Connection;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MySqlDAOFactory extends DAOFactory {

    	//Patron Singleton par esta clase, @see;http://es.wikipedia.org/wiki/Singleton#Java
    	private static MySqlDAOFactory INSTANCE= null;
    	
	private static Connection con = null;
	private static final String DATA_SOURCE = "java:comp/env/jdbc/TestDB";
	
	//constructor privado, nunca podremos hacer un new de esta clase
	private MySqlDAOFactory(){}
	
	// creador sincronizado para protegerse de posibles problemas  multi-hilo
	// otra prueba para evitar instanciación múltiple 
	private synchronized static void createInstance() {
	    if (INSTANCE == null) { 
	        INSTANCE = new MySqlDAOFactory();
	    }
	}
	 
	public static MySqlDAOFactory getInstance() {
	    if (INSTANCE == null) {
		createInstance();
	    }
	    return INSTANCE;
	    }
	
	public Connection conectar() {
		//patron singleton, si ya esta creada para que volver hacerlo ?
		if ( con == null ){
			try{
				InitialContext ctx = new InitialContext();
				DataSource ds = (DataSource) ctx.lookup(DATA_SOURCE);
				con = ds.getConnection();
			}catch ( Exception e){
				e.printStackTrace();
			}	
		} 
		return con;
	}
	
	public static void desconectar(){		
		if ( con  != null ){
			try{
				con.close();
				con = null;
			}catch( Exception e){
				e.printStackTrace();
			}	
		}
	}
	
	
	
	@Override
	public IPersonaDAO getPersonaDAO() {		
		return new PersonaMySqlDAO();
	}

	
	
}
