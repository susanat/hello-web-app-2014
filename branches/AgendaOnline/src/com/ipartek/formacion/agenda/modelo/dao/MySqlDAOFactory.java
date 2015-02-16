package com.ipartek.formacion.agenda.modelo.dao;

import java.sql.Connection;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MySqlDAOFactory extends DAOFactory {
	// patron singleton para esta clase, @see:
	// http://es.wikipedia.org/wiki/Singleton#Java

	private static MySqlDAOFactory INSTANCE = null;
	private static Connection con = null;
	private static final String DATA_SOURCE = "java:comp/env/jdbc/TestAgenda";

	// constructor privado
	private MySqlDAOFactory() {
	}

	// creador sincronizado para protegerse de posibles problemas multi-hilo
	// otra prueba para evitar instanciación múltiple
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

	public Connection conectar() throws ModelException {

		if (con == null) {
			try {

				// Create initial context
				/*
				 * System.setProperty(Context.INITIAL_CONTEXT_FACTORY,
				 * "org.apache.naming.java.javaURLContextFactory");
				 * System.setProperty(Context.URL_PKG_PREFIXES,
				 * "org.apache.naming"); InitialContext ic = new
				 * InitialContext();
				 * 
				 * ic.createSubcontext("java:");
				 * ic.createSubcontext("java:/comp");
				 * ic.createSubcontext("java:/comp/env");
				 * ic.createSubcontext("java:/comp/env/jdbc");
				 * 
				 * // Construct DataSource MysqlDataSource ds = new
				 * MysqlDataSource();
				 * ds.setURL("jdbc:mysql://localhost:3306/agenda");
				 * ds.setUser("root"); ds.setPassword("");
				 * 
				 * ic.bind("java:/comp/env/jdbc/TestAgenda", ds);
				 */
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

	@Override
	public IPersonaDAO getPersonaDAO() {
		return new PersonaMySqlDAO();
	}

}