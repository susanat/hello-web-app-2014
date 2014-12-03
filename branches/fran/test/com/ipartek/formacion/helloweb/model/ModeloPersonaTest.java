package com.ipartek.formacion.helloweb.model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ipartek.formacion.helloweb.bean.Persona;

public class ModeloPersonaTest {
	ModeloPersona personas;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		personas = new ModeloPersona();
		ModeloPersona.createTable();
	}

	@After
	public void tearDown() throws Exception {
		ModeloPersona.truncateTable();
		personas = null;
	}

	@Test
	public void testGetAll() {
		// Prueba que devuelve el número de elementos
		assertEquals(4, personas.getAll().size());
	}

	@Test
	public void testGetById() {
		assertEquals("Gorriti", personas.getById(1).getNombre());
		assertEquals("Antxon", personas.getById(2).getNombre());
		assertEquals("Pili", personas.getById(3).getNombre());
		assertEquals("Mili", personas.getById(4).getNombre());
		assertNull(personas.getById(12));
	}

	@Test
	public void testInsert() {
		int todos = personas.getAll().size();
		// Comprobar que la inserción funcione
		assertTrue(Persona.ID_NULL < personas
				.insert(new Persona("PersonaNueva")));
		// Comprobar que la inserción de null funciona (no debe insertar)
		assertEquals(Persona.ID_NULL, personas.insert(null));
		// Comprobar que tras las inserciones solo se ha incrementado en 1 el
		// número de personas
		assertEquals("Debería haber una persona mas", todos + 1, personas
				.getAll().size());
	}

	@Test
	public void testDelete() {
		int todos = personas.getAll().size();
		assertTrue(personas.delete(1)); // Comprobar que esta borrada
		assertNull(personas.getById(1));
		assertFalse(personas.delete(10));
		assertEquals("Debería haber una persona menos", todos - 1, personas
				.getAll().size());
	}

	@Test
	public void testUpdate() {
		int todos = personas.getAll().size();
		Persona p = personas.getById(1);
		Persona p2 = new Persona("");
		p2.setNombre(p.getNombre());
		p2.setEdad(p.getEdad());
		p2.setId(p.getId());
		p2.setNombre("X");
		assertTrue(Persona.ID_NULL < personas.update(p2));
		assertEquals("X", personas.getById(1).getNombre());
		Persona pInexistente = new Persona("");
		pInexistente.setId(14);
		assertEquals(Persona.ID_NULL, personas.update(null));
		assertEquals(Persona.ID_NULL, personas.update(pInexistente));
		assertEquals("Debería ser las mismas personas", todos, personas
				.getAll().size());
	}

}
