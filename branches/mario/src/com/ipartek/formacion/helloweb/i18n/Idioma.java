package com.ipartek.formacion.helloweb.i18n;

/**
 * Idiomas soportados por nuestra App
 *
 * @author Mario Alvaro
 *
 */
public enum Idioma {

    CASTELLANO("es_ES", "es", "ES"), EUSKERA("eu_ES", "eu", "ES"), INGLES(
	    "en_EN", "en", "EN");

    private String locale;
    private String lenguage;
    private String pais;

    private Idioma(String locale, String lenguage, String pais) {
	this.locale = locale;
	this.lenguage = lenguage;
	this.pais = pais;
    }

    public String getLocale() {
	return locale;
    }

    public String getLenguage() {
	return lenguage;
    }

    public String getPais() {
	return pais;
    }

}
