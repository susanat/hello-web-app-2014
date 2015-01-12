package ipt.fm.ipartek.test.linkedin.modelo.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import ipt.fm.ipartek.test.linkedin.bean.Persona;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

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
	public void testInsertar() {

		DAOFactory factoria = DAOFactory.getFactoryDAO(DAOFactory.MYSQL);
		IPersonaDAO daoPersona = factoria.getPersonaDAO();

		Persona p = new Persona("insertado", "insertado");
		p = daoPersona.insert(p);

		assertEquals("insertado", p.getNombre());
		assertEquals("insertado", p.getApellidos());

	}

	@Test
	public void testActualizar() {
		DAOFactory factoria = DAOFactory.getFactoryDAO(DAOFactory.MYSQL);
		IPersonaDAO daoPersona = factoria.getPersonaDAO();

		Persona p = new Persona("insertado", "insertado");
		p = daoPersona.insert(p);

		p.setNombre("actualizado");
		p.setApellidos("actualizado");
		p = daoPersona.update(p);
		assertEquals("actualizado", p.getNombre());
		assertEquals("actualizado", p.getApellidos());

	}

	@Test
	public void testBorrado() {
		DAOFactory factoria = DAOFactory.getFactoryDAO(DAOFactory.MYSQL);
		IPersonaDAO daoPersona = factoria.getPersonaDAO();

		Persona p = new Persona("insertado", "insertado");
		p = daoPersona.insert(p);

		assertEquals("insertado", p.getNombre());
		assertEquals("insertado", p.getApellidos());

		boolean res = daoPersona.delete(p);
		assertTrue(res);

	}

}
