package ipt.fm.ipartek.test.linkedin;

/**
 * Manejar conexiones con el DataSource para la BBDD
 * @author ur00
 *
 */

import java.sql.Connection;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class FactoriaMySql {

	private static Connection con = null;
	private static final String DATA_SOURCE = "java:comp/env/jdbc/TestDB";

	public static Connection conectar() {
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
	};

	public static void desconectar() {

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
