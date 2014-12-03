package com.ipartek.formacion.helloweb.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

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
		modelo = null;
	}

	@Test
	public void testGetAll() {
		assertEquals(6, modelo.getAll().size());
		ModeloPersona.truncateTable();
		assertNull(modelo.getAll());

	}

	@Test
	public void testGetById() {

		String nombre = "Gorriti2";
		int idNuevo = modelo.insert(new Persona(nombre));

		Persona pGorriti = modelo.getById(idNuevo);
		assertEquals(nombre, pGorriti.getNombre());
		assertNull(modelo.getById(13));

	}

	@Test
	public void testInsert() {

		int todos = modelo.getAll().size();
		int idNuevaPersona = modelo.insert(new Persona("El nuevo"));
		assertTrue(Persona.ID_NULL < idNuevaPersona);
		assertEquals("no se ha generado bien el id", todos, modelo.insert(null));

		assertEquals("no deberia insertarse", Persona.ID_NULL,
				modelo.insert(null));

		assertEquals("debemos tener un registro nuevo", (todos + 1), modelo
				.getAll().size());

		// insertar cuando no existen registros
		ModeloPersona.truncateTable();
		int idNuevaPersona2 = modelo.insert(new Persona("El nuevo2"));
		assertTrue(Persona.ID_NULL < idNuevaPersona2);
		assertEquals("debe poder insertar aunq no haya registros",
				Persona.ID_NULL, modelo.insert(null));

	}

	@Test
	public void testDelete() {

		int todos = modelo.getAll().size();

		assertTrue(modelo.delete(1));
		assertFalse(modelo.delete(13));

		assertEquals("debemos tener un registro menos", (todos - 1), modelo
				.getAll().size());

	}

	@Test
	public void testDeleteAll() throws Exception {
		// eliminar todas las personas
		// Persona p = null;
		ArrayList<Persona> personas = modelo.getAll();
		for (Persona persona : personas) {
			assertTrue(modelo.delete(persona.getId()));
		}
		assertNull(modelo.getAll());
	}

	@Test
	public void testUpdate() {

		// Persona pGorriti = modelo.getById();
		// assertTrue(modelo.update(pGorriti));

	}
}
