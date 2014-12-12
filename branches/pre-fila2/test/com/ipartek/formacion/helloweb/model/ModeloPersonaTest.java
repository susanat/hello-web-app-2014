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
    public static final int TOTAL = 5;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {

    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {

    }

    @Before
    public void setUp() throws Exception {
	ModeloPersona modelo = new ModeloPersona();
	ModeloPersona.createTable();
    }

    @After
    public void tearDown() throws Exception {
	ModeloPersona.truncateTable();
	modelo = null;
    }

    @Test
    public void testGetAll() {
	assertEquals(TOTAL, modelo.getAll().size());
	ModeloPersona.truncateTable();
	assertNull(modelo.getAll());

    }

    @Test
    public void testGetByID() {

	Persona pGorriti = modelo.getByID(1);
	assertEquals("Gorriti", pGorriti.getNombre());
	assertNull(modelo.getByID(12));
    }

    @Test
    public void testInsert() {
	int todos = modelo.getAll().size();
	Persona p1 = new Persona("nuevo");
	assertTrue(Persona.ID_NULL < modelo.insert(p1));
	assertEquals(Persona.ID_NULL, modelo.insert(null));
	assertEquals("Debemos tener un registro nuevo", todos + 1, modelo
		.getAll().size());
    }

    @Test
    public void testDelete() {
	int todos = modelo.getAll().size();
	assertTrue(modelo.delete(1));
	assertFalse(modelo.delete(13));

	assertEquals("Debemos tener un registro menos", todos - 1, modelo
		.getAll().size());

    }

    @Test
    public void testDeleteAll() {
	Persona p = null;
	ArrayList<Persona> personas = modelo.getAll();
	for (Persona persona : personas) {
	    assertTrue(modelo.delete(persona.getId()));
	}
	assertNull(modelo.getAll());
    }

    /*
     * @Test public void testUpdate() { Persona pAntxon = modelo.getByID(2);
     * Persona pNuevo = new Persona("Nuevo"); assertEquals(2,
     * modelo.update(pAntxon)); assertEquals(-1, modelo.update(pNuevo));
     *
     * }
     */

}
