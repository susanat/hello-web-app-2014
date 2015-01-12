package ipt.fm.ipartek.test.linkedin.modelo.dao;

import java.sql.Connection;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MySqlDAOFactory extends DAOFactory {

	// patrón singleton
	private static MySqlDAOFactory INSTANCE = null;

	private static Connection con = null;
	private static final String DATA_SOURCE = "java:comp/env/jdbc/TestDB";

	// constructor privado
	private MySqlDAOFactory() {

	}

	private synchronized static void createInstance() {
		if (INSTANCE == null) {
			INSTANCE = new MySqlDAOFactory();
		}
	}

	public static MySqlDAOFactory getInstance() {
		if (INSTANCE == null)
			createInstance();
		return INSTANCE;
	}

	public Connection conectar() {
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
				con = null;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public IPersonaDAO getPersonaDAO() {
		return new PersonaMySqlDAO();
	}

}
