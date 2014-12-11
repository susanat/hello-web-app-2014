package com.ipartek.formacion.helloweb.i18n;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Idiomas soportados por nuesta App
 *
 * @author Urko Villanueva
 *
 */
public enum Idioma {
    CASTELLANO("es_ES", "es", "ES", "castellano"), EUSKERA("eu_ES", "eu", "EU",
	    "euskera"), INGLES("en_EN", "en", "EN", "english");
    private String locale;
    private String lenguaje;
    private String pais;
    private String iName;

    private Idioma(final String locale, final String lenguaje,
	    final String pais, final String piName) {
	this.locale = locale;
	this.lenguaje = lenguaje;
	this.pais = pais;
	this.iName = piName;
    }

    public String getLocale() {
	return locale;
    }

    public void setLocale(final String locale) {
	this.locale = locale;
    }

    public String getLenguaje() {
	return lenguaje;
    }

    public void setLenguaje(final String lenguaje) {
	this.lenguaje = lenguaje;
    }

    public String getPais() {
	return pais;
    }

    public void setPais(final String pais) {
	this.pais = pais;
    }

    public String getiName() {
	return iName;
    }

    public void setiName(final String iName) {
	this.iName = iName;
    }

    public static HashMap<String, String> getNames() {
	HashMap<String, String> idiomas = new HashMap<String, String>();
	idiomas.put(CASTELLANO.locale, CASTELLANO.getiName());
	idiomas.put(INGLES.locale, INGLES.getiName());
	idiomas.put(EUSKERA.locale, EUSKERA.getiName());
	return idiomas;
    }

    public static ArrayList<String> getValores() {
	ArrayList<String> lista = new ArrayList<String>();
	Idioma[] array = Idioma.values();
	int len = array.length;

	for (int i = 0; i < len; i++) {
	    lista.add(i, array[i].getiName());
	}
	return lista;
    }

    public static ArrayList<String> getIndices() {
	ArrayList<String> lista = new ArrayList<String>();
	Idioma[] array = Idioma.values();
	int len = array.length;

	for (int i = 0; i < len; i++) {
	    lista.add(i, array[i].getLocale());
	}
	return lista;
    }
}
