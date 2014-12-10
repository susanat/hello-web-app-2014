package com.ipartek.formacion.helloweb.i18n;

import java.util.ArrayList;

/**
 * Idiomas soportados por nuestra App
 * 
 * @author Maitane Casado
 *
 */
public enum Idioma {

	// Enumeracion compleja

	CASTELLANO("es_ES", "es", "ES"), EUSKERA("eu_ES", "eu", "ES"), INGLES(
			"en_EN", "en", "EN");

	private String locale;
	private String lenguaje;
	private String pais;

	private Idioma(String _locale, String _language, String _pais) {
		this.locale = _locale;
		this.lenguaje = _language;
		this.pais = _pais;
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

	public Idioma[] devuelveListaIdioma() {
		Idioma[] rdo = Idioma.values();

		return rdo;
	}

	public ArrayList<String> devuelvelistaLocale() {
		ArrayList<String> rdo = new ArrayList<String>();
		for (Idioma idioma : Idioma.values()) {
			rdo.add(idioma.getLocale());
		}
		return rdo;
	}

}
