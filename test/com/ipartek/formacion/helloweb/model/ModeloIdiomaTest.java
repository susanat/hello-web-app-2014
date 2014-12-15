package com.ipartek.formacion.helloweb.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ipartek.formacion.helloweb.bean.Idioma;
import com.ipartek.formacion.helloweb.bean.Persona;

public class ModeloIdiomaTest {
    ModeloIdioma model = null;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {

	model = new ModeloIdioma();
	ModeloIdioma.createTable();
    }

    @After
    public void tearDown() throws Exception {
	ModeloIdioma.truncateTable();
	model = null;
    }

    @Test
    public void testCreateTable() {

    }

    @Test
    public void testTruncateTable() {

    }

    @Test
    public void testGetAll() {
	assertEquals(5, model.getAll().size());
	ModeloIdioma.truncateTable();
	assertNull(model.getAll());
    }

    @Test
    public void testGetById() {
	Idioma i = new Idioma("");
	i.setLocale("it_IT");
	int idNuevo = model.insert(i);
	Idioma iaux = model.getById(idNuevo);
	assertEquals(i.getLocale(), iaux.getLocale());

	assertNull(model.getById(13));
    }

    @Test
    public void testInsert() {
	int todos = model.getAll().size();

	int idNuevoIdioma = model.insert(new Idioma("it_IT"));
	assertTrue(Persona.ID_NULL < idNuevoIdioma);
	assertEquals("No se ha generado bien el ID", todos, idNuevoIdioma);

	assertEquals("No deberia insertarse", Idioma.ID_NULL,
		model.insert(null));

	assertEquals("debemos tener un registro nuevo ", todos + 1, model
		.getAll().size());

	// insertar cuando no existen registros
	ModeloIdioma.truncateTable();
	int idNuevoIdioma2 = model.insert(new Idioma("fi_FI"));
	assertTrue("Debe poder insertar a pesar de no haber registros",
		Idioma.ID_NULL < idNuevoIdioma2);

    }

    @Test
    public void testUpdate() {
	// fail("Not yet implemented");
	Idioma i = model.getById(3);
	i.setLocale("it_IT");
	model.update(i);
	Idioma iaux = model.getById(3);
	assertEquals(i, iaux);
    }

    @Test
    public void testDelete() {
	// comprobar eliminar 1 idioma
	int todos = model.getAll().size();

	assertTrue(model.delete(1));
	// comprobar que este borrado
	assertNull(model.getById(1));

	assertFalse(model.delete(13));
	assertNull(model.getById(13));

	assertEquals("debemos tener un registro menos ", todos - 1, model
		.getAll().size());
    }

}
