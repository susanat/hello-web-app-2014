package com.ipartek.formacion.helloweb.i18n;

/**
 * Idiomas soportados.
 *
 * @author Curso
 *
 */
public enum Idioma {

	CASTELLANO("es_ES", "es", "ES"), EUSKERA("eu_ES", "eu", "ES"), INGLES("en_EN", "en", "EN");

	private String locale;
	private String idioma;
	private String pais;

	/**
	 * @param locale
	 * @param idioma
	 * @param pais
	 */
	private Idioma(final String locale, final String idioma, final String pais) {
		this.locale = locale;
		this.idioma = idioma;
		this.pais = pais;
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

}
