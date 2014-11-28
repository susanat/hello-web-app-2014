package com.ipartek.fomacion.helloweb.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.ipartek.formacion.helloweb.bean.Persona;
import com.ipartek.formacion.helloweb.model.ModeloPersona;


public class ModeloPersonaTest {

	ModeloPersona model = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		model = new ModeloPersona();
		ModeloPersona.createTable();
	}

	@After
	public void tearDown() throws Exception {
		ModeloPersona.truncateTable();
		model = null;
	}

	@Test
	public void testGetAll() throws Exception {
		assertEquals(5, model.getAll().size());
		ModeloPersona.truncateTable();

		// comprobacion de que es igual a NULL
		assertNull(model.getAll());

	}

	@Test
	public void testGetById() throws Exception {

		// Comprobacion de una persona que existe
		Persona pGorriti = model.getByd(1);
		assertEquals("Gorriti", pGorriti.getNombre());

		// Comprobacion de una persona que no existe - en ese caso devuelve Null
		assertNull(model.getByd(15));
	}

	@Test
	public void testInsert() throws Exception {

		// Comprobacion de que se anadio un registro correcto
		int todos = model.getAll().size();
		int idNuevaPersona = model.insert(new Persona("nuevo"));
		assertTrue(Persona.ID_NULL < idNuevaPersona);
		assertEquals("debemos tener un registro nuevo", (todos + 1), model
				.getAll().size());

		// Comprobacion al anadir un registro Null
		todos = model.getAll().size();
		assertEquals(Persona.ID_NULL, model.insert(null));
		assertEquals("NO debemos tener un registro nuevo", todos, model
				.getAll().size());
	}

	@Test
	public void testDelete() throws Exception {
		// Comprobar eliminar una persona
		int todos = model.getAll().size();

		// Eliminar una persona valida
		assertTrue(model.delete(1));
		// Eliminar una persona incorrecta
		assertTrue(model.delete(13));

		assertEquals("debemos tener un registro menos", (todos - 1), model
				.getAll().size());
	}

	@Test
	public void testDeleteAll() throws Exception{
		//eliminar todas las personas
		ArrayList<Persona> personas = model.getAll();
		for (Persona persona:personas){
			assertTrue(model.delete(persona.getId()));
		}
		assertNull(model.getAll());
	}

	@Ignore
	@Test
	public void testUpdate() throws Exception {

		Persona p = model.getByd(1);
	}
}
