package com.ipartek.formacion.helloweb.util;

import java.util.ArrayList;

/**
 * Idiomas soportados por nuestra App
 *
 * @author ur00
 *
 */
public enum EIdioma {

	CASTELLANO("es_ES", "es", "ES", "Castellano"), EUSKERA("eu_ES", "eu", "ES", "Euskara"), INGLES("en_EN", "en", "EN",
			"English");

	private String locale;
	private String lenguaje;
	private String pais;
	private String texto;

	private EIdioma(final String locale, final String lenguaje, final String pais, final String texto) {
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

	public static ArrayList<String> getLocalesList() {
		final ArrayList<String> result = new ArrayList<String>();
		for (int i = 0; i < EIdioma.values().length; i++) {
			result.add((EIdioma.values()[i]).getLocale());
		}
		return result;
	}

	public static ArrayList<String> getIdiomLenguageList() {
		final ArrayList<String> result = new ArrayList<String>();
		for (int i = 0; i < EIdioma.values().length; i++) {
			result.add((EIdioma.values()[i]).getLenguaje());
		}
		return result;
	}

	public static ArrayList<String> getTextosList() {
		final ArrayList<String> resul = new ArrayList<String>();
		for (int i = 0; i < EIdioma.values().length; i++) {
			resul.add(EIdioma.values()[i].getTexto());
		}
		return resul;
	}

}
