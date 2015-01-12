package ipt.fm.ipartek.test.linkedin.modelo.dao;

import java.sql.Connection;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MySqlDAOFactory extends DAOFactory {

	// Patron Singleton para esta clase, @see:
	// http://es.wikipedia.org/wiki/Singleton#Java
	private static MySqlDAOFactory INSTANCE = null;

	private static Connection con = null;
	private static final String DATA_SOURCE = "java:comp/env/jdbc/TestDB";

	// Constructor privado
	private MySqlDAOFactory() {
	}

	// Metodo para que devuelva la instancia UNICA de la clase

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

	@Override
	public IPersonaDAO getPersonaDAO() {

		return new PersonaMySqlDAO();
	}

	public Connection conectar() {
		// patron singleton, si ya esta creada para que volver hacerlo ?
		if (con == null) {
			try {
				InitialContext ctx = new InitialContext();
				DataSource ds = (DataSource) ctx.lookup(DATA_SOURCE);
				con = ds.getConnection();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return con;
	}

	public void desconectar() {

		if (con != null) {
			try {
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			;
		}
	};
}
