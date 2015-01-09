package ipt.fm.ipartek.test.controller;

/**
 * Manejar conexiones con el DataSource para la BBDD
 * @author ur00
 *
 */

import java.sql.Connection;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class FactoriaMySql {

	private static Connection connection = null;
	private static final String DATA_SOURCE = "java:comp/env/jdbc/TestDB";

	public static Connection openConnection() {
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
	};

	public static void closeConnection() {

		if (connection != null) {
			try {
				connection.close();
			} catch (final Exception e) {
				e.printStackTrace();
			}
			;
		}
	};

}
