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
	public void testSetNombre() {
		Persona p=new Persona();
		String nombre=null;
		assertFalse("No vale un nombre 'NULL'", p.setNombre(nombre));
		nombre="";
		assertFalse("No vale un nombre ''", p.setNombre(nombre));

		nombre = "a";
		assertFalse("No vale un nombre de un solo caracter'" + nombre + "'",
				p.setNombre(nombre));

		nombre = "aa15aa";
		assertFalse("No vale el nombre:" + nombre, p.setNombre(nombre));

		nombre = "aa";
		assertTrue("Nombre valido: " + nombre, p.setNombre(nombre));

		nombre = "aa aa";
		assertTrue("Nombre validos: " + nombre, p.setNombre(nombre));

		nombre = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		assertFalse("Nombre demasiado largo: " + nombre, p.setNombre(nombre));
	}

	@Test
	public void testSetApellidos() {
		Persona p = new Persona();
		String apellidos = null;
		assertFalse("No vale un apellido 'NULL'", p.setApellidos(apellidos));

		apellidos = "";
		assertFalse("Vale un apellido ''", p.setApellidos(apellidos));

		apellidos = "aa15aa";
		assertFalse("No vale los apellidos:" + apellidos,
				p.setApellidos(apellidos));

		apellidos = "a";
		assertTrue("Apellidos validos: " + apellidos, p.setApellidos(apellidos));

		apellidos = "aa aa";
		assertTrue("Apellido validos: " + apellidos, p.setApellidos(apellidos));

		apellidos = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		assertFalse("Apellidos demasiado largo: " + apellidos,
				p.setApellidos(apellidos));
	}

	@Test
	public void testTelFijo() {
		Persona p = new Persona();

		int telFijo = 0;
		assertFalse("No vale el Telefono Fijo: " + telFijo,
				p.setTelFijo(telFijo));

		telFijo = -123456789;
		assertFalse("No vale el Telefono Fijo: " + telFijo,
				p.setTelFijo(telFijo));

		telFijo = -12345678;
		assertFalse("No vale el Telefono Fijo: " + telFijo,
				p.setTelFijo(telFijo));

		telFijo = 1234567890;
		assertFalse("No vale el Telefono Fijo: " + telFijo,
				p.setTelFijo(telFijo));

		telFijo = 123456789;
		assertTrue("Vale el Telefono Fijo:" + telFijo, p.setTelFijo(telFijo));

	}

	@Test
	public void testTelMovil() {
		Persona p = new Persona();

		int telMovil = 0;
		assertFalse("No vale el Telefono Fijo: " + telMovil,
				p.setTelMovil(telMovil));

		telMovil = -123456789;
		assertFalse("No vale el Telefono Fijo: " + telMovil,
				p.setTelMovil(telMovil));

		telMovil = -12345678;
		assertFalse("No vale el Telefono Fijo: " + telMovil,
				p.setTelMovil(telMovil));

		telMovil = 1234567890;
		assertFalse("No vale el Telefono Fijo: " + telMovil,
				p.setTelMovil(telMovil));

		telMovil = 123456789;
		assertTrue("Vale el Telefono Fijo:" + telMovil, p.setTelMovil(telMovil));

	}

	@Test
	public void testDireccion() {
		Persona p=new Persona();
		
		String direccion=null;
		assertFalse("No vale una direccion 'NULL'", p.setDireccion(direccion));
		
		direccion="";
		assertTrue("Vale una direccion ''", p.setDireccion(direccion));
		
		direccion = "a";
		assertTrue("Vale la direccion: " + direccion, p.setDireccion(direccion));

		direccion = "c\\ aa";
		assertTrue("Vale la direccion: " + direccion, p.setDireccion(direccion));

		direccion = "c\\ aa, 12";
		assertTrue("Vale la direccion: " + direccion, p.setDireccion(direccion));

		direccion = "c\\\\ aa, 12";
		assertFalse("No vale la direccion: " + direccion,
				p.setDireccion(direccion));

		direccion = "c\\ aa, nº 12";
		assertTrue("Vale la direccion: " + direccion, p.setDireccion(direccion));

		direccion = "c\\ aa, nº 12, 5";
		assertTrue("Vale la direccion: " + direccion, p.setDireccion(direccion));

		direccion = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		assertFalse("Direccion demasiado larga: " + direccion,
				p.setDireccion(direccion));

	}

	@Test
	public void testPoblacion() {

	}

	@Test
	public void testProvincia() {

	}

	@Test
	public void testCP() {

	}
}
