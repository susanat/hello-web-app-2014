package com.ipartek.formacion.helloweb.i18n;

import java.util.Locale;

/**
 * Clase con utilidades para los idiomas
 *
 * @author Joseba Carrión Blanco
 *
 */
public class I18n {

    /**
     * Obtener el locale(idioma) del navegador para retornar la cadena de locale
     * que nosotros necesitamos <h1>Lista de locales de la app</h1>
     * <ol>
     * <li>es_ES</li>
     * <li>eu_ES</li>
     * <li>en_EN</li>
     * </ol>
     *
     * @return cadena con el locale de nuestra app, por defecto eu_ES
     */
    public static final String getBrowserLocale(Locale localeBrowser) {

	// por defecto ingles
	String result = Idioma.INGLES.getLocale();
	// comprobamos que no es nulo
	if (localeBrowser != null) {
	    // comprobamos si es euskera
	    if (Idioma.EUSKERA.getLenguaje().equalsIgnoreCase(
		    localeBrowser.getLanguage())) {
		result = Idioma.EUSKERA.getLocale();

		// comprobamos si es castellano
	    } else if (Idioma.CASTELLANO.getLenguaje().equalsIgnoreCase(
		    localeBrowser.getLanguage())) {
		result = Idioma.CASTELLANO.getLocale();
	    }
	}
	return result;

    }
}
