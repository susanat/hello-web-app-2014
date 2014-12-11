package com.ipartek.formacion.helloweb.i18n;

import java.util.ArrayList;

public enum Idioma {

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

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public String getLenguaje() {
		return lenguaje;
	}

	public void setLenguaje(String lenguaje) {
		this.lenguaje = lenguaje;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public static ArrayList<String> getLocaleList() {

		ArrayList<String> resul = new ArrayList<String>();
		for (int i = 0; i < Idioma.values().length; i++) {
			resul.add(Idioma.values()[i].getLocale());
		}

		return resul;
	}

	public static ArrayList<String> getLenguajeList() {

		ArrayList<String> resul = new ArrayList<String>();
		for (int i = 0; i < Idioma.values().length; i++) {
			resul.add(Idioma.values()[i].getLenguaje());
		}

		return resul;
	}

	public static ArrayList<String> getTextosList() {

		ArrayList<String> resul = new ArrayList<String>();
		for (int i = 0; i < Idioma.values().length; i++) {
			resul.add(Idioma.values()[i].getTexto());
		}

		return resul;
	}
}
