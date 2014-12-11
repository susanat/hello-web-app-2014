package com.ipartek.formacion.helloweb.i18n;

import java.util.ArrayList;

/**
 * Idiomas soportados por nuestra App
 * 
 * @author Curso
 *
 */
public enum Idioma {

	CASTELLANO("es_ES", "es", "ES", "Español"), EUSKERA("eu_ES", "eu", "ES",
			"Euskera"), INGLES("en_EN", "en", "EN", "Ingles");

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

	public ArrayList<String> getLenguajesArrays() {
		ArrayList<String> lista = new ArrayList<String>();
		for (Idioma idioma : Idioma.values()) {
			lista.add(idioma.lenguaje);
		}
		return lista;
	}

	public ArrayList<String> getLocaleArrays() {
		ArrayList<String> lista = new ArrayList<String>();
		for (Idioma idioma : Idioma.values()) {
			lista.add(idioma.locale);
		}
		return lista;
	}

	public ArrayList<String> getTextoArrays() {
		ArrayList<String> lista = new ArrayList<String>();
		for (Idioma idioma : Idioma.values()) {
			lista.add(idioma.texto);
		}
		return lista;
	}

}
