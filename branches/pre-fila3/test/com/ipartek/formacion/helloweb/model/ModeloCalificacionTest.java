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

import com.ipartek.formacion.helloweb.bean.Calificacion;

public class ModeloCalificacionTest {

	ModeloCalificacion modelo = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {

		modelo = new ModeloCalificacion();
		ModeloCalificacion.createTable();
	}

	@After
	public void tearDown() throws Exception {
		ModeloCalificacion.truncateTable();
		modelo = null;
	}

	@Test
	public void testGetAll() {
		assertEquals(11, modelo.getAll().size());
		ModeloCalificacion.truncateTable();
		assertNull(modelo.getAll());

	}

	@Test
	public void testGetById() {

		int notaNueva = 12;
		String descripcion = "CumLaude";
		int idNuevo = modelo.insert(new Calificacion(notaNueva, descripcion));

		Calificacion cNueva = modelo.getById(idNuevo);
		assertEquals(notaNueva, cNueva.getClave());
		assertNull(modelo.getById(13));

	}

	@Test
	public void testInsert() {

		int todos = modelo.getAll().size();

		// insertar una calificacion nueva
		int idNuevaNota = modelo.insert(new Calificacion(12, "CumLaude"));
		assertTrue(Calificacion.ID_NULL < idNuevaNota);
		assertEquals("no deberia insertarse", Calificacion.ID_NULL,
				modelo.insert(null));

		assertEquals("debemos tener un registro nuevo", (todos + 1), modelo
				.getAll().size());

		// insertar cuando no existen registros
		ModeloCalificacion.truncateTable();
		int idNuevaNota2 = modelo.insert(new Calificacion(4, "penco"));
		assertTrue(Calificacion.ID_NULL < idNuevaNota2);
		assertEquals("debe poder insertar aunq no haya registros",
				Calificacion.ID_NULL, modelo.insert(null));

	}

	@Test
	public void testDelete() {

		// comprobar eliminar 1 calificacion
		int todos = modelo.getAll().size();

		assertTrue(modelo.delete(1));

		// comprobar que este borrado
		assertNull(modelo.getById(1));

		// borrar un registro que no existe
		assertFalse(modelo.delete(13));
		assertNull(modelo.getById(13));

		assertEquals("debemos tener un registro menos", (todos - 1), modelo
				.getAll().size());

	}

	@Test
	public void testDeleteAll() throws Exception {

		// eliminar todas las calificaciones
		ArrayList<Calificacion> calificaciones = modelo.getAll();
		for (Calificacion calificacion : calificaciones) {
			assertTrue(modelo.delete(calificacion.getId()));
		}
		assertNull(modelo.getAll());
	}

	@Test
	public void testUpdate() {

		// update de registros que ya existen
		int todos = modelo.getAll().size();
		Calificacion c = modelo.getById(1);
		Calificacion c2 = new Calificacion(7, "Notable");
		c2.setClave(c.getClave());
		c2.setDescripcion(c.getDescripcion());
		c2.setId(c.getId());
		c2.setClave(5);
		assertTrue(Calificacion.ID_NULL < modelo.update(c2));
		assertEquals(5, modelo.getById(1).getClave());

		// update de un registro null
		assertEquals(Calificacion.ID_NULL, modelo.update(null));

		// update de un registro que no existe
		Calificacion cInexistente = new Calificacion(0, "nulo");
		cInexistente.setId(14);
		assertEquals(Calificacion.ID_NULL, modelo.update(cInexistente));
		assertEquals("Debería ser las mismas calificaciones", todos, modelo
				.getAll().size());

	}
}
