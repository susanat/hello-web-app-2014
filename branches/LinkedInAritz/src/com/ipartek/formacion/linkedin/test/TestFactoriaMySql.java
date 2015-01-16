package com.ipartek.formacion.linkedin.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ipartek.formacion.linkedin.bean.Persona;
import com.ipartek.formacion.linkedin.modelo.dao.DAOFactory;
import com.ipartek.formacion.linkedin.modelo.dao.IPersonaDAO;

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

		DAOFactory factoria = DAOFactory.getFactoriaDAO(DAOFactory.MYSQL);

		IPersonaDAO daoPersona = factoria.getPersonaDAO();

		Persona p = new Persona(-1, "pepe", "Gorriti", -1, "");
		
		int id = daoPersona.insert(p);
		
		assertTrue(" ID inserccion negativo ", id > 0 );

		p = daoPersona.getById(p);

		assertEquals("ddd", p.getNombre());
		assertEquals("ddd", p.getApellido());

	}

}
