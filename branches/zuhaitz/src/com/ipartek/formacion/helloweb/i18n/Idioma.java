package com.ipartek.formacion.helloweb.i18n;

import java.util.ArrayList;

/**
 * Idiomas soportados.
 *
 * @author Curso
 *
 */
public enum Idioma {

	CASTELLANO("es_ES", "es", "ES", "Castellano"), EUSKERA("eu_ES", "eu", "ES", "Euskera"), INGLES("en_EN", "en", "EN",
			"English");

	private String locale;
	private String idioma;
	private String pais;
	private String texto;

	/**
	 * @param locale
	 * @param idioma
	 * @param pais
	 */
	private Idioma(final String locale, final String idioma, final String pais, final String texto) {
		this.locale = locale;
		this.idioma = idioma;
		this.pais = pais;
		this.texto = texto;
	}

	/**
	 * @return the locale
	 */
	public String getLocale() {
		return locale;
	}

	/**
	 * @return the language
	 */
	public String getIdioma() {
		return idioma;
	}

	/**
	 * @return the country
	 */
	public String getPais() {
		return pais;
	}

	/**
	 * @param texto
	 *            the texto to set
	 * @return
	 */
	public String getTexto() {
		return texto;
	}

	public static ArrayList<String> getIdiomaTextoList() {
		final ArrayList<String> res = new ArrayList<String>();
		for (int i = 0; i < Idioma.values().length; i++) {
			res.add(Idioma.values()[i].getTexto());
		}
		return res;
	}

	public static ArrayList<String> getLocalesList() {
		final ArrayList<String> result = new ArrayList<String>();
		for (int i = 0; i < Idioma.values().length; i++) {
			result.add((Idioma.values()[i]).getLocale());
		}
		return result;
	}

	public static ArrayList<String> getIdiomaList() {
		final ArrayList<String> result = new ArrayList<String>();
		for (int i = 0; i < Idioma.values().length; i++) {
			result.add((Idioma.values()[i]).getIdioma());
		}
		return result;
	}

}
