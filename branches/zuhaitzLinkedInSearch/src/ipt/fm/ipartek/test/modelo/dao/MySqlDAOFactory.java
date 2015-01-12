package ipt.fm.ipartek.test.modelo.dao;

import java.sql.Connection;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MySqlDAOFactory extends DAOFactory {

	// Patrón singleton para esta clase, @see:
	// http://es.wikipedia.org/wiki/Singleton#Java
	private static MySqlDAOFactory INSTANCE = null;
	private static Connection connection = null;
	private static final String DATA_SOURCE = "java:comp/env/jdbc/TestDB";

	private MySqlDAOFactory() {
	}

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

	public Connection openConnection() {
		// patrón singleton
		if (connection == null) {
			try {
				final InitialContext ctx = new InitialContext();
				final DataSource ds = (DataSource) ctx.lookup(DATA_SOURCE);
				connection = ds.getConnection();
			} catch (final Exception e) {
				e.printStackTrace();
			}
		}
		return connection;
	}

	public void closeConnection() {
		if (connection != null) {
			try {
				connection.close();
				connection = null;
			} catch (final Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public IPersonaDAO getIPersonaDAO() {
		return new PersonaMySqlDAO();
	}

}
