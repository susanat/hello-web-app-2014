package com.ipartek.formacion.helloweb.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ipartek.formacion.helloweb.bean.Persona;
import com.ipartek.formacion.helloweb.model.ModeloPersona;

public class ModeloPersonaTest {

	ModeloPersona modelo = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {

		modelo = new ModeloPersona();
		ModeloPersona.createTable();
	}

	@After
	public void tearDown() throws Exception {
		ModeloPersona.truncateTable();
	}

	@Test
	public void testGetAll() {
		assertEquals(5, modelo.getAll().size());
		ModeloPersona.truncateTable();
		assertNull(modelo.getAll());

	}

	@Test
	public void testGetById() {
		Persona pGorriti = modelo.getById();
		assertEquals("Gorriti", pGorriti.getNombre());
		assertNull(modelo.getById(13));

	}

	@Test
	public void testInsert() {

		int todos = modelo.getAll().size();
		int idNuevaPersona = modelo.insert(new Persona("El nuevo"));
		assertTrue(Persona.ID_NULL < idNuevaPersona);
		assertEquals(Persona.ID_NULL, modelo.insert(null));

		assertEquals("debemos tener un registro nuevo", todos + 1, modelo
				.getAll().size());

	}

	@Test
	public void testDelete() {

		int todos = modelo.getAll().size();
		// int idNuevaPersona = modelo.insert(new Persona("El nuevo"));
		assertTrue(modelo.delete(1));
		assertFalse(modelo.delete(13));

		assertEquals("debemos tener un registro menos", todos - 1, modelo
				.getAll().size());

		// eliminar todas las personas

	}

}
