package com.ipartek.formacion.helloweb.i18n;

import static org.junit.Assert.assertEquals;

import java.util.Locale;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class I18nTest {

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
	public void testGetBrowserLocale() {
		Locale l_es = new Locale("es");
		assertEquals(Idioma.CASTELLANO.getLocale(), I18n.getBrowserLocale(l_es));

		Locale l_es_ES = new Locale("es", "ES");
		assertEquals(Idioma.CASTELLANO.getLocale(),
				I18n.getBrowserLocale(l_es_ES));

		Locale l_eu = new Locale("eu");
		assertEquals(Idioma.EUSKERA.getLocale(), I18n.getBrowserLocale(l_eu));

		Locale l_eu_ES = new Locale("eu", "ES");
		assertEquals(Idioma.EUSKERA.getLocale(), I18n.getBrowserLocale(l_eu_ES));

		Locale l_en = new Locale("en");
		assertEquals(Idioma.INGLES.getLocale(), I18n.getBrowserLocale(l_en));

		Locale l_en_EN = new Locale("en", "EN");
		assertEquals(Idioma.INGLES.getLocale(), I18n.getBrowserLocale(l_en_EN));

		Locale l_no_soportado = new Locale("xx", "XX");
		assertEquals(Idioma.INGLES.getLocale(),
				I18n.getBrowserLocale(l_no_soportado));
	}

}
