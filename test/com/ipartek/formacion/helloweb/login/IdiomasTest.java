package com.ipartek.formacion.helloweb.login;

import static org.junit.Assert.assertEquals;

import java.util.Locale;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ipartek.formacion.helloweb.i18n.I18n;
import com.ipartek.formacion.helloweb.i18n.Idioma;

public class IdiomasTest {

    private Locale Locale;
    String languageBrowser = I18n.getBrowserLocale(Locale);
    Idioma idioma;

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
    public void testIdiomas() {

	// Comprobar que coge el idioma del navegador
	assertEquals(idioma, languageBrowser);

	// Comprobar que recoge el idioma con la session

    }

}
