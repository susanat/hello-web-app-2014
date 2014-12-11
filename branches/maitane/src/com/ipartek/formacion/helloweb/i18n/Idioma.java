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

	CASTELLANO("es_ES", "es", "ES", "Castellano"), EUSKERA("eu_ES", "eu", "ES",
			"Euskera"), INGLES("en_EN", "en", "EN", "English");

	private String locale;
	private String lenguaje;
	private String pais;
	private String texto;

	private Idioma(String _locale, String _language, String _pais, String _text) {
		this.locale = _locale;
		this.lenguaje = _language;
		this.pais = _pais;
		this.texto = _text;
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

	public static ArrayList<String> devuelveListaIdioma() {
		ArrayList<String> rdo = new ArrayList<String>();
		for (Idioma idioma : Idioma.values()) {
			rdo.add(idioma.getTexto());
		}
		return rdo;
	}

	public static ArrayList<String> devuelvelistaLocale() {
		ArrayList<String> rdo = new ArrayList<String>();
		for (Idioma idioma : Idioma.values()) {
			rdo.add(idioma.getLocale());
		}
		return rdo;
	}
	
	public static ArrayList<String> devuelvelistaLenguaje() {
		ArrayList<String> rdo = new ArrayList<String>();
		for (Idioma idioma : Idioma.values()) {
			rdo.add(idioma.getLenguaje());
		}
		return rdo;
	}


}
