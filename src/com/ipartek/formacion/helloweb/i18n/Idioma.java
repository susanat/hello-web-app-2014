package com.ipartek.formacion.helloweb.i18n;

import java.util.ArrayList;

/**
 * Idiomas soportados por nuestra App
 * @author ur00
 *
 */
public enum Idioma {
	
	CASTELLANO("es_ES","es","ES"), 
	EUSKERA("eu_ES","eu","ES"), 
	INGLES("en_EN","en","EN");
	
	private String locale;
	private String lenguaje;
	private String pais;
	
	private Idioma(String locale, String lenguaje, String pais) {
		this.locale = locale;
		this.lenguaje = lenguaje;
		this.pais = pais;
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
	
	
	public static ArrayList<String> getLocalesList(){
		ArrayList<String>result = new ArrayList<String>();
			for ( int i=0; i < Idioma.values().length; i++){
				result.add((Idioma.values()[i]).getLocale());
			}
		return result;
	}
	
	public static ArrayList<String> getIdiomLenguageList(){
		ArrayList<String>result = new ArrayList<String>();
			for ( int i=0; i < Idioma.values().length; i++){
				result.add((Idioma.values()[i]).getLenguaje());
			}
		return result;
	}

		
	
	
	
	
	
}
