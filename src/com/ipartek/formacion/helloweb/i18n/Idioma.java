package com.ipartek.formacion.helloweb.i18n;

import java.util.ArrayList;

/**
 * Idiomas soportados por nuestra App
 * 
 * @author ur00
 *
 */
public enum Idioma {

    // (locales,,,texto)
    CASTELLANO("es_ES", "es", "ES", "Castellano"), EUSKERA("eu_ES", "eu", "ES",
	    "Euskara"), INGLES("en_EN", "en", "EN", "English");

    private String locale;
    private String lenguaje;
    private String pais;
    private String texto;

    private Idioma(String locale, String lenguaje, String pais, String texto) {
	this.locale = locale;
	this.lenguaje = lenguaje;
	this.pais = pais;
	this.texto = texto;
    }

    public String getLocale() {
	return locale;
    }

    public String getLenguaje() {
	return lenguaje;
    }

    public String getPais() {
	return pais;
    }

    public String getTexto() {
	return texto;
    }

    // Me devuelve locale en un array
    public static ArrayList<String> getLocalesList() {
	ArrayList<String> result = new ArrayList<String>();
	for (int i = 0; i < Idioma.values().length; i++) {
	    result.add((Idioma.values()[i]).getLocale());
	}
	return result;
    }

    // Me devuelve lenguaje en un array
    public static ArrayList<String> getIdiomLenguageList() {
	ArrayList<String> result = new ArrayList<String>();
	for (int i = 0; i < Idioma.values().length; i++) {
	    result.add((Idioma.values()[i]).getLenguaje());
	}
	return result;
    }

    // Me devuelve el texto en un array
    public static ArrayList<String> getTextosList() {
	ArrayList<String> resul = new ArrayList<String>();
	for (int i = 0; i < Idioma.values().length; i++) {
	    resul.add(Idioma.values()[i].getTexto());
	}
	return resul;

    }

}
