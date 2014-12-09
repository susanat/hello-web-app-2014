package com.ipartek.formacion.helloweb.i18n;

/**
 * Idiomas soportados por nuesta App
 *
 * @author Urko Villanueva
 *
 */
public enum Idioma {
    CASTELLANO("es_ES", "es", "ES"), EUSKERA("eu_ES", "eu", "EU"), INGLES(
	    "en_EN", "en", "EN");
    private String locale;
    private String lenguaje;
    private String pais;

    private Idioma(final String locale, final String lenguaje, final String pais) {
	this.locale = locale;
	this.lenguaje = lenguaje;
	this.pais = pais;
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

}
