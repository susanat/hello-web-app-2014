package com.ipartek.formacion.agenda.bean;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
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

	@Ignore
	@Test
	public void test() throws NumberFormatException, PersonaException {
		Persona p = new Persona();
		String s = null;
		int n = Integer.parseInt(s);
		p.setCp(Integer.parseInt(s));
	}

	@Test
	public void testSetNombre() {
		Persona p = new Persona();
		String nombre;

		nombre = null;
		try {
			p.setNombre(nombre);
			fail("Deberia producir un error");
		} catch (PersonaException e) {
			assertEquals(e.getMessage(), PersonaException.NOMBRE_EMPTY);
		}

		nombre = "";
		try {
			p.setNombre(nombre);
			fail("Deberia producir un error");
		} catch (PersonaException e) {
			assertEquals(e.getMessage(), PersonaException.NOMBRE_EMPTY);
		}

		nombre = "a";
		try {
			p.setNombre(nombre);
			fail("Deberia producir un error");
		} catch (PersonaException e) {
			assertEquals(e.getMessage(), PersonaException.NOMBRE_INVALID_CHAR);
		}

		nombre = "aa15aa";
		try {
			p.setNombre(nombre);
			fail("Deberia producir un error");
		} catch (PersonaException e) {
			assertEquals(e.getMessage(), PersonaException.NOMBRE_INVALID_CHAR);
		}

		nombre = "aa";
		try {
			p.setNombre(nombre);
			assertEquals(nombre, p.getNombre());
		} catch (PersonaException e) {
			fail("No deberia producir un error");
		}

		nombre = "aa aa";
		try {
			p.setNombre(nombre);
			assertEquals(nombre, p.getNombre());
		} catch (PersonaException e) {
			fail("No deberia producir un error");
		}

		nombre = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		try {
			p.setNombre(nombre);
			fail("Deberia producir un error");
		} catch (PersonaException e) {
			assertEquals(e.getMessage(), PersonaException.NOMBRE_INVALID_CHAR);
		}

	}

	@Test
	public void testSetApellidos() {
		Persona p = new Persona();

		String apellidos = null;
		try {
			p.setApellidos(apellidos);
			assertTrue("Todo OK", true);
		} catch (PersonaException e) {
			fail("No deberia producir un error");
		}

		apellidos = "";
		try {
			p.setApellidos(apellidos);
			assertEquals(apellidos, p.getApellidos());
		} catch (PersonaException e) {
			fail("No deberia producir un error");
		}

		apellidos = "aa15aa";
		try {
			p.setApellidos(apellidos);
			fail("Deberia producir un error");
		} catch (PersonaException e) {
			assertEquals(e.getMessage(), PersonaException.APELLIDO_INVALID_CHAR);
		}

		apellidos = "a";
		try {
			p.setApellidos(apellidos);
			assertEquals(apellidos, p.getApellidos());
		} catch (PersonaException e) {
			fail("No deberia producir un error");
		}

		apellidos = "aa aa";
		try {
			p.setApellidos(apellidos);
			assertEquals(apellidos, p.getApellidos());
		} catch (PersonaException e) {
			fail("No deberia producir un error");
		}

		apellidos = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		try {
			p.setApellidos(apellidos);
			fail("Deberia producir un error");
		} catch (PersonaException e) {
			assertEquals(e.getMessage(), PersonaException.APELLIDO_INVALID_CHAR);
		}
	}

	@Test
	public void testTelFijo() {
		Persona p = new Persona();

		int telFijo = 0;
		try {
			p.setTelFijo(telFijo);
			assertEquals(telFijo, p.getTelFijo());
		} catch (PersonaException e) {
			fail("No deberia producir un error");
		}

		telFijo = -123456789;
		try {
			p.setTelFijo(telFijo);
			fail("Deberia producir un error");
		} catch (PersonaException e) {
			assertEquals(e.getMessage(), PersonaException.TEL_INVALID_FORMAT);
		}

		telFijo = -12345678;
		try {
			p.setTelFijo(telFijo);
			fail("Deberia producir un error");
		} catch (PersonaException e) {
			assertEquals(e.getMessage(), PersonaException.TEL_INVALID_FORMAT);
		}

		telFijo = 1234567890;
		try {
			p.setTelFijo(telFijo);
			fail("Deberia producir un error");
		} catch (PersonaException e) {
			assertEquals(e.getMessage(), PersonaException.TEL_INVALID_FORMAT);
		}

		telFijo = 123456789;
		try {
			p.setTelFijo(telFijo);
			assertEquals(telFijo, p.getTelFijo());
		} catch (PersonaException e) {
			fail("No deberia producir un error");
		}

	}

	@Test
	public void testTelMovil() {
		Persona p = new Persona();

		int telMovil = 0;
		try {
			p.setTelMovil(telMovil);
			fail("Deberia producir un error");
		} catch (PersonaException e) {
			assertEquals(e.getMessage(), PersonaException.TEL_INVALID_FORMAT);
		}

		telMovil = -123456789;
		try {
			p.setTelMovil(telMovil);
			fail("Deberia producir un error");
		} catch (PersonaException e) {
			assertEquals(e.getMessage(), PersonaException.TEL_INVALID_FORMAT);
		}

		telMovil = -12345678;
		try {
			p.setTelMovil(telMovil);
			fail("Deberia producir un error");
		} catch (PersonaException e) {
			assertEquals(e.getMessage(), PersonaException.TEL_INVALID_FORMAT);
		}

		telMovil = 1234567890;
		try {
			p.setTelMovil(telMovil);
			fail("Deberia producir un error");
		} catch (PersonaException e) {
			assertEquals(e.getMessage(), PersonaException.TEL_INVALID_FORMAT);
		}

		telMovil = 123456789;
		try {
			p.setTelMovil(telMovil);
			assertEquals(telMovil, p.getTelMovil());
		} catch (PersonaException e) {
			fail("No deberia producir un error");
		}

	}

	@Test
	public void testDireccion() {
		Persona p = new Persona();

		String direccion = null;
		try {
			p.setDireccion(direccion);
			assertTrue("Todo OK", true);
		} catch (PersonaException e) {
			fail("NULL - No deberia producir un error");
		}

		direccion = "";
		try {
			p.setDireccion(direccion);
			assertEquals(direccion, p.getDireccion());
		} catch (PersonaException e) {
			fail("No deberia producir un error");
		}

		direccion = "a";
		try {
			p.setDireccion(direccion);
			assertEquals(direccion, p.getDireccion());
		} catch (PersonaException e) {
			fail("La direccion está incompleta");
		}

		direccion = "c/ aa";
		try {
			p.setDireccion(direccion);
			assertEquals(direccion, p.getDireccion());
		} catch (PersonaException e) {
			fail("La direccion está mal cumplimentada");
		}

		direccion = "c// aa, 12";
		try {
			p.setDireccion(direccion);
			assertEquals(direccion, p.getDireccion());
		} catch (PersonaException e) {
			fail("La direccion está mal cumplimentada");
		}

		direccion = "c\\\\ aa, 12";
		try {
			p.setDireccion(direccion);
			assertEquals(direccion, p.getDireccion());
		} catch (PersonaException e) {
			fail("La direccion está mal cumplimentada");
		}
		direccion = "c\\ aa, nº 12";
		try {
			p.setDireccion(direccion);
			assertEquals(direccion, p.getDireccion());
		} catch (PersonaException e) {
			fail("La direccion está mal cumplimentada");
		}

		direccion = "c\\ aa, nº12, 5";
		try {
			p.setDireccion(direccion);
			assertEquals(direccion, p.getDireccion());
		} catch (PersonaException e) {
			fail("La direccion está mal cumplimentada");
		}

		direccion = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		try {
			p.setDireccion(direccion);
			assertEquals(direccion, p.getDireccion());
		} catch (PersonaException e) {
			fail("La direccion es demasiado larga");
		}
	}

	@Test
	public void testPoblacion() {
		Persona p = new Persona();

		String poblacion = null;
		try {
			p.setProvincia(poblacion);
			assertTrue("Todo OK", true);
		} catch (PersonaException e) {
			fail("NULL - No deberia producir un error");
		}

		poblacion = "";
		try {
			p.setProvincia(poblacion);
			assertEquals(poblacion, p.getPoblacion());
		} catch (PersonaException e) {
			fail("'' - No deberia producir un error");
		}

		poblacion = "aa15aa";
		try {
			p.setPoblacion(poblacion);
			fail("Deberia producir un error");
		} catch (PersonaException e) {
			assertEquals(e.getMessage(),
					PersonaException.POBLACION_INVALID_CHAR);
		}

		poblacion = "a";
		try {
			p.setPoblacion(poblacion);
			assertEquals(poblacion, p.getPoblacion());
		} catch (PersonaException e) {
			fail(poblacion + " - No deberia producir un error");
		}

		poblacion = "aa aa";
		try {
			p.setPoblacion(poblacion);
			assertEquals(poblacion, p.getPoblacion());
		} catch (PersonaException e) {
			fail(poblacion + " - No deberia producir un error");
		}

		poblacion = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		try {
			p.setPoblacion(poblacion);
			fail("Deberia producir un error");
		} catch (PersonaException e) {
			assertEquals(e.getMessage(),
					PersonaException.POBLACION_INVALID_CHAR);
		}
	}

	@Test
	public void testProvincia() {
		Persona p = new Persona();

		String provincia = null;
		try {
			p.setProvincia(provincia);
			assertTrue("Todo OK", true);
		} catch (PersonaException e) {
			fail("NULL - No deberia producir un error");
		}

		provincia = "";
		try {
			p.setProvincia(provincia);
			assertEquals(provincia, p.getProvincia());
		} catch (PersonaException e) {
			fail("'' - No deberia producir un error");
		}

		provincia = "aa15aa";
		try {
			p.setProvincia(provincia);
			fail("Deberia producir un error");
		} catch (PersonaException e) {
			assertEquals(e.getMessage(),
					PersonaException.PROVINCIA_INVALID_CHAR);
		}

		provincia = "a";
		try {
			p.setProvincia(provincia);
			assertEquals(provincia, p.getProvincia());
		} catch (PersonaException e) {
			fail(provincia + " - No deberia producir un error");
		}

		provincia = "aa aa";
		try {
			p.setProvincia(provincia);
			assertEquals(provincia, p.getProvincia());
		} catch (PersonaException e) {
			fail(provincia + " - No deberia producir un error");
		}

		provincia = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		try {
			p.setProvincia(provincia);
			fail("Deberia producir un error");
		} catch (PersonaException e) {
			assertEquals(e.getMessage(),
					PersonaException.PROVINCIA_INVALID_CHAR);
		}
	}

	@Test
	public void testCP() {
		Persona p = new Persona();

		int cp = 0;
		try {
			p.setCp(cp);
			assertEquals(cp, p.getCp());
		} catch (PersonaException e) {
			fail("El CP " + cp + " es correcto");
		}

		cp = -15;
		try {
			p.setCp(cp);
			fail("El CP " + cp + " no es correcto");
		} catch (PersonaException e) {
			assertEquals(e.getMessage(), PersonaException.CP_INVALID_FORMAT);
		}

		cp = -1234;
		try {
			p.setCp(cp);
			fail("El CP " + cp + " no es correcto");
		} catch (PersonaException e) {
			assertEquals(e.getMessage(), PersonaException.CP_INVALID_FORMAT);
		}

		cp = 12345;
		try {
			p.setCp(cp);
			assertEquals(cp, p.getCp());
		} catch (PersonaException e) {
			fail("El CP " + cp + " es correcto");
		}

		cp = 123456;
		try {
			p.setCp(cp);
			fail("El CP " + cp + " no es correcto");
		} catch (PersonaException e) {
			assertEquals(e.getMessage(), PersonaException.CP_INVALID_FORMAT);
		}
	}
}
