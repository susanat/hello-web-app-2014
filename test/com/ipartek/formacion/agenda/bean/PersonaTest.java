package com.ipartek.formacion.agenda.bean;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class PersonaTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		Persona p = new Persona();
		String s = "22";
		int n = Integer.parseInt(s);
		// p.setCp(Integer.parseInt(s));
	}


	@Test
	/**
	 * Pruebas con el Nombre
	 * <ul>
	 * 	<li>Comprobar que no sea NULL</li>
	 * 	<li>Comprobar que no sea vacio</li>
	 * 	<li>Comprobar que empiece por una letra</li>
	 * 	<li>Comprobar que contenga letras y '.'</li>
	 *  <li>Otras...</li>
	 * </ul>
	 */
	public void testSetNombre() {
		Persona p=new Persona();
		String nombre=null;
		assertFalse("No vale un nombre 'NULL'", p.setNombre(nombre));
		nombre="";
		assertFalse("No vale un nombre ''", p.setNombre(nombre));

		char c;
		for (int i = 35; i < 256; i++) {
			c = (char) i;
			nombre = String.valueOf(c);
			System.out.println(nombre);
			if (Character.isLetter(c)) {
				assertTrue(nombre + ": Debe comenzar con una letra el nombre",
						p.setNombre(nombre));
			} else {
				assertFalse(nombre + ": Debe comenzar con una letra el nombre",
						p.setNombre(nombre));
			}
		}

		for (int i = 35; i < 256; i++) {
			c = (char) i;
			nombre = "a" + String.valueOf(c);
			System.out.println(nombre);
			if (Character.isLetter(c) || c == '.') {
				assertTrue(nombre + ": Puede contener letras y '.' el nombre",
						p.setNombre(nombre));
			} else {
				assertFalse(nombre + ": Puede contener letras y '.' el nombre",
						p.setNombre(nombre));
			}
		}

	}


}
