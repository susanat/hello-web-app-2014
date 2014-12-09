package com.ipartek.formacion.helloweb.i18n;

import java.util.Locale;

/**
 * Clase con utilidades para los idiomas
 * 
 * @author Curso
 *
 */
public class i18n {
	/**
	 * Obtener el locale(idioma) del navegador para retornar la cadena de locale
	 * que no Si no se encuentra retorna valor "en_EN" por defecto <h1>lista de
	 * locales de la App</h1>
	 * <ol>
	 * <li>es_ES</li>
	 * <li>eu_ES</li>
	 * <li>en_EN</li>
	 * </ol>
	 */
	public static final String getBrowserLocale(Locale localeBrowser){
		// por defecto Ingles
		String result =Idioma.INGLES.getLocale();
		// Si no es NULL
		if (localeBrowser!=null){
			// es Euskera
			if (Idioma.EUSKERA.getLenguaje().equalsIgnoreCase(
					localeBrowser.getLanguage())) {
				result = Idioma.EUSKERA.getLocale();
			} // es Castellano
			else if (Idioma.CASTELLANO.getLenguaje().equalsIgnoreCase(
					localeBrowser.getLanguage())) {
				result = Idioma.CASTELLANO.getLocale();
			}
		}
		return result;
	}

	/*
	 * public static final String getSession(HttpSession sesion) { // por
	 * defecto Ingles String result = Idioma.INGLES.getLenguaje(); // Si no es
	 * NULL if (sesion.getAttribute(Constantes.IDIOMA_KEY) != null) { // es
	 * Euskera if (Idioma.EUSKERA.getLenguaje().equalsIgnoreCase( (String)
	 * sesion.getAttribute(Constantes.IDIOMA_KEY))) { result =
	 * Idioma.EUSKERA.getLocale(); } // es Castellano else if
	 * (Idioma.CASTELLANO.getLenguaje().equalsIgnoreCase( (String)
	 * sesion.getAttribute(Constantes.IDIOMA_KEY))) { result =
	 * Idioma.CASTELLANO.getLocale(); } } return result; }
	 */

}
