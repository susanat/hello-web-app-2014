package ipt.fm.ipartek.test.linkedin;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestAccess {

	private static final String DRIVER = "sun.jdbc.odbc.JdbcOdbcDriver";
	private static final String CON_URL = "jdbc:odbc:dataSourceTest";
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		//fail("Not yet implemented");
		
		try {
			Class.forName(DRIVER);
			Connection conexion = DriverManager.getConnection(CON_URL);
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
