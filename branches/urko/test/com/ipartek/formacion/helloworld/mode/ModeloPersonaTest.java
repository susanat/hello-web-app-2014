package com.ipartek.formacion.helloworld.mode;

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
    private static ModeloPersona modelo;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {

    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {

    }

    @Before
    public void setUp() throws Exception {
	ModeloPersona.init();
	modelo = new ModeloPersona();
    }

    @After
    public void tearDown() throws Exception {
	ModeloPersona.destroy();
    }

    @Test
    public void testGetAll() {
	// fail("Not yet implemented");
	assertEquals(ModeloPersona.personas, modelo.getAll());
	ModeloPersona.destroy();
	assertNull(modelo.getAll());
    }

    @Test
    public void testGetById() {
	// fail("Not yet implemented");
	/*
	 * Persona pGorriti = modelo.getById(1); assertEquals("Gorriti",
	 * pGorriti.getNombre()); assertNull(modelo.getById(13));
	 */
    }

    @Test
    public void testInsert() {
	// fail("Not yet implemented");
	Persona p = new Persona(6, "Kepa");
	int size = modelo.getAll().size();

	assertTrue(Persona.ID_NULL < modelo.insert(p));
	assertEquals(Persona.ID_NULL, modelo.insert(null));
	assertEquals("", size + 1, modelo.getAll().size());
    }

    @Test
    public void testUpdate() {
	Persona p = modelo.getById(1);
	p.setNombre("Patxi");
	modelo.update(p);
	assertEquals(p, modelo.getById(1));
    }

    @Test
    public void testDelete() {
	int size = modelo.getAll().size();

	assertTrue("No se ha borrado la persona con id 1", modelo.delete(1));
	assertFalse(modelo.delete(13));
	assertEquals("", size - 1, modelo.getAll().size());
    }

    @Test
    public void testDeleteAll() {
	ArrayList<Persona> ps = (ArrayList<Persona>) ModeloPersona.personas
		.clone();
	for (Persona p : ps) {
	    assertTrue("no borra todo", modelo.delete(p.getCodigo()));
	}
	// assertNull(modelo.getAll());
    }

    @Test
    public void testDeleteLog() {
	int size = modelo.getAll().size();

	assertTrue("No se ha borrado la persona con id 1", modelo.deleteLog(1));
	assertFalse("Borra una que no existe", modelo.deleteLog(13));
	assertEquals("", size - 1, modelo.getAll().size());
    }

}
