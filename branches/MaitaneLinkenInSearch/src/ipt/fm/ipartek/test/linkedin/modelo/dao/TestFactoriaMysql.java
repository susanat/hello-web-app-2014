package ipt.fm.ipartek.test.linkedin.modelo.dao;

import static org.junit.Assert.assertEquals;
import ipt.fm.ipartek.test.linkedin.bean.Persona;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestFactoriaMysql {
	static Connection conexion = null;
	static PreparedStatement pst = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		conexion = MySqlDAOFactory.conectar();
		String createTableSQL = "CREATE TABLE personaPrueba("
				+ "id NUMBER(5) NOT NULL, " + "nombre VARCHAR(20) NOT NULL, "
				+ "apellido1 VARCHAR(20) NOT NULL" + ")";
		pst = conexion.prepareStatement(createTableSQL);
		pst.executeUpdate();

	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {

		MySqlDAOFactory.desconectar();
	}

	@Before
	public void setUp() throws Exception {

	}

	@After
	public void tearDown() throws Exception {

	}

	@Test
	public void testGetById() {
		DAOFactory factoria = DAOFactory.getFactoriaDAO(DAOFactory.MYSQL);

		IPersonaDAO daoPersona = factoria.getPersonaDAO();

		Persona p = new Persona("", "");

		Persona pAux = daoPersona.getbyId(p);

		assertEquals("pepe", pAux.getNombre());
		assertEquals("gorriti", pAux.getApellido1());

	}

}
