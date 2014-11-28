package com.ipartek.formacion.helloweb.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ipartek.formacion.helloweb.bean.CargasTemporales;
import com.ipartek.formacion.helloweb.bean.Persona;
import com.ipartek.formacion.helloweb.model.interfaces.IModeloPersona.EBorrado;
import com.ipartek.formacion.helloweb.model.interfaces.IModeloPersona.onModelPersonaError;

public class ModeloPersonaTest {

	private ModeloPersona modeloPersona = new ModeloPersona();
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {		
			
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
	}

	@Before
	public void setUp() throws Exception {
		CargasTemporales.CargaTablaPersonas();	
		modeloPersona = new ModeloPersona();
		
		modeloPersona.setOnIError(new onModelPersonaError() {			
			public void onException(Persona obj, Exception ex) {	
				System.out.println(ex.getMessage());				
			}
		});
	}

	@After
	public void tearDown() throws Exception {
		CargasTemporales.truncateTablaPersonas();
		modeloPersona = null;
	}

	@Test
	public void testGetAll() {
		
		//inicialmente hay seis
		assertEquals(6, modeloPersona.getAll().size());
		
		CargasTemporales.truncateTablaPersonas();
		
		//null si no hay nada
		assertNull(modeloPersona.getAll());
		
	}

	@Test
	public void testGetById() {
		
		//el 1 es gorditti
		assertEquals("Gorriti", modeloPersona.getById(1).getNombre());
		
		assertNull(modeloPersona.getById(-236));
		
		
		CargasTemporales.truncateTablaPersonas();
		
		//null si no hay nada
		assertNull(modeloPersona.getById(125));
		
		
	}

	@Test
	public void testInsertPersona() {
		
		int todos = modeloPersona.getAll().size();
		int todoRes = modeloPersona.getAll().size();
		Persona prueba = new Persona("Gorriti2", 20, CargasTemporales.roles.get(0));
		
		//comprobamos que ha insertado correctamente
		assertTrue(Persona.ID_NULL < modeloPersona.Insert(prueba));
				
		//testeamos que al insertar mal nos devuelve -1
		assertEquals(Persona.ID_NULL, modeloPersona.Insert( null ));
		
		//comprobamos que hay un registro nuevo
		todoRes++;
		assertEquals(todoRes, modeloPersona.getAll().size());
		
	}
	

	@Test
	public void testDelete() {
		int todos = modeloPersona.getAll().size();
		//borrado lógico
		//assertTrue( modeloPersona.delete(1, EBorrado.LOGICA));		
		//assertEquals(todos, modeloPersona.getAll());
		
		//borrado Fisico
		assertTrue( modeloPersona.delete(1, EBorrado.FISICA));
		
		int todosRes = todos -1;
		
		assertEquals(todosRes, modeloPersona.getAll().size());
		
		
		modeloPersona.delete(-36, EBorrado.FISICA);
	}
	
	@Test
	public void testUpdate() {
		
		//borrado lógico
		//assertTrue( modeloPersona.delete(1, EBorrado.LOGICA));		
		//assertEquals(todos, modeloPersona.getAll());
		
		Persona prueba = new Persona(1,"Gorriti2", 20, CargasTemporales.roles.get(0));
		
		//borrado Fisico
		assertEquals(1, modeloPersona.update(1, prueba));
		
		
	}
	
	@Test
	public void testDeleteAll() {
		Persona p = null;
		List<Persona> personas = modeloPersona.getAll();
		for (Persona persona : personas) {
			assertTrue( modeloPersona.delete(persona.getId(), EBorrado.FISICA));
		}
		
	}

}
