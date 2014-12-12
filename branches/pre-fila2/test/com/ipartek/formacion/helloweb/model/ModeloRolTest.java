package com.ipartek.formacion.helloweb.model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ModeloRolTest {

	//modelo
	ModeloRol model  = null;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		model = new ModeloRol();
		
		//creamos la tabla en cada test
		ModeloRol.createTable();
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCreate() {
		
	}

}
