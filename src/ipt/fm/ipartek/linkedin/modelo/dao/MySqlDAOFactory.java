package ipt.fm.ipartek.linkedin.modelo.dao;

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

	public Connection conectar() throws ModelException {
		// patron singleton, si ya esta creada para que volver hacerlo ?
		if (con == null) {
			try {
				InitialContext ctx = new InitialContext();
				DataSource ds = (DataSource) ctx.lookup(DATA_SOURCE);
				con = ds.getConnection();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("LA CONEXIÓN A LA BD, HA FALLADO");
				throw new ModelException("LA CONEXIÓN A LA BD, HA FALLADO");
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

}
