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

    ModeloPersona model = new ModeloPersona();

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
    public void testGellAll() throws Exception {

	// Comprobamos si el array es de 5
	assertEquals(5, model.getAll().size());
	// Si no exite nada nos devuelve un nulo
	ModeloPersona.truncateTable();
	assertNull(model.getAll());

    }

    @Test
    public void testGetByID() throws Exception {

	// comprobamos que el id coincide y si el id=13 es null
	Persona pGorriti = model.getByID(1);
	assertEquals("Gorriti", pGorriti.getNombre());
	assertNull(model.getByID(13));

    }

    @Test
    public void testInsert() throws Exception {

	int todos = model.getAll().size();
	// Insertamos una persona nueva para comprobar si se inserta

	int idNueavaPersona = model.insert(new Persona("nuevo"));
	assertTrue(Persona.ID_NULL < idNueavaPersona);

	// Para comprobar que nos devuelve -1 si le insertamos un null
	assertEquals("No deberia insertarse", Persona.ID_NULL,
		model.insert(null));

	// comprobamos que si hemos insertado uno sea los que teniamos mas uno
	assertEquals("debemos tener un registro nuevo", (todos + 1), model
		.getAll().size());

	// insertar cuando no existen registros
	ModeloPersona.truncateTable();
	int idNueavaPersona2 = model.insert(new Persona("nuevo2"));
	assertTrue("debemos poder insertar a paesar de no haber registros",
		Persona.ID_NULL < idNueavaPersona);

    }

    @Test
    public void testDelete() throws Exception {

	// Comprobar eliminar una personas
	int todos = model.getAll().size();

	assertTrue(model.delete(1));
	assertFalse(model.delete(13));

	// comprobamos que si hemos insertado uno sea los que teniamos mas uno
	assertEquals("debemos tener un registro nuevo", (todos - 1), model
		.getAll().size());
    }

    @Test
    public void testDeleteAll() throws Exception {

	// eliminar todas las personas
	Persona p = null;
	ArrayList<Persona> personas = model.getAll();

	// Cojo todas las personas del modelo y las recorro
	for (Persona persona : personas) {
	    assertTrue(model.delete(persona.getId()));
	}
	assertNull(model.getAll());

    }

    @Test
    public void testUpdate() throws Exception {

    }

}
