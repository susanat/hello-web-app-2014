import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;


public class TestAccess {
	private static final String DRIVER = "sun.jdbc.odbc.JdbcOdbcDriver";
	private static final String CON_URL = "jdbc:odbc:dataSourceTest";

	@Test
	public void test() {
		try {
			// cargar Driver
			Class.forName(DRIVER);
			// obtener conexion con el DriverManager
			Connection conexion = DriverManager.getConnection(CON_URL);

			Statement st = conexion.createStatement();
			ResultSet rs = st.executeQuery("select * from persona");
			while (rs.next()) {
				System.out.println(rs.getString(1));
				System.out.println(rs.getString(2));
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
