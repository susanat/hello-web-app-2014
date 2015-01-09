package ipt.fm.ipartek.test.linkedin.modelo.dao;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ipartek.formacion.linkedin.bean.Persona;

public class TestFactoriaMySql {

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
	public void testGetById() {
		DAOFactory factoria = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		IPersonaDAO daoPersona = factoria.getPersonaDAO();
		Persona p = new Persona(-1,"","","");
		p = daoPersona.getById(p);
		assertEquals("pepe", p.getNombre());
		assertEquals("gorriti", p.getApellido());
	}

}
