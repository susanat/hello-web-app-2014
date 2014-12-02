package com.ipartek.formacion.helloweb.model;

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
		modelo = null;
		ModeloPersona.truncateTable();
	}

	@Test
	public void testGetAll() throws Exception {
		assertEquals("El tamaño de la lista de personas es incorrecto.", modelo.getAll().size(), 5);

		ModeloPersona.truncateTable();
		assertNull("La lista debería estar a null.", modelo.getAll());
	}

	@Test
	public void testGetById() throws Exception {
		final Persona p = modelo.getById(0);
		assertEquals("La persona recogida por id es incorrecta.", "Gorriti", p.getNombre());

		assertNull("La persona que se pide, y no existe, debería devolver null.", modelo.getById(13));
	}

	@Test
	public void testInsert() throws Exception {
		final int todos = modelo.getAll().size();

		final int idNuevaPersona = modelo.insert(new Persona("Nuevo"));
		assertTrue("Si se hace una insert debería retornar un valor mayor que -1.", Persona.ID_NULL < idNuevaPersona);
		// assertTrue("No se ha generado correctamente el ID.", condition);

		assertEquals("Si la persona está a null la insert debería retornar -1.", Persona.ID_NULL, modelo.insert(null));
		assertEquals("El registro nuevo debería haber aumentado el size() del ArrayList", todos + 1, modelo.getAll()
				.size());

		// Insertar cuando no existen registros
		ModeloPersona.truncateTable();
		final int idNuevaPersona2 = modelo.insert(new Persona("El nuevo2"));
		assertTrue("Debe poder insertar a pesar de no haber registros", Persona.ID_NULL < idNuevaPersona2);
	}

	@Test
	public void testDelete() throws Exception {
		final int todos = modelo.getAll().size();

		// Eliminar una persona
		assertTrue(modelo.delete(1));
		assertFalse(modelo.delete(13));

		assertEquals("El registro nuevo debería haber disminuido el size() del ArrayList", todos - 1, modelo.getAll()
				.size());
	}

	@Test
	public void testDeleteAll() throws Exception {
		final ArrayList<Persona> personas = modelo.getAll();

		for (final Persona persona : personas) {
			assertTrue(modelo.delete(persona.getId()));
		}
		assertNull(modelo.getAll());
	}

	@Test
	public void testUpdate() throws Exception {
		final Persona p = new Persona("nuevo");

	}

}
