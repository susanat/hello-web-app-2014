package com.ipartek.formacion.agenda.modelo.dao;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MySqlDAOFactoryTest {

	private MySqlDAOFactory f = null;

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
	public void test() throws Exception {

		f = (MySqlDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		try {
			f.conectar();
		} catch (Exception e) {
			e.printStackTrace();
		}
		f.desconectar();
		// fail("Not yet implemented");
	}

}
