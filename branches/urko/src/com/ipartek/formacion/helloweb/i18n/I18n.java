package com.ipartek.formacion.helloweb.i18n;

import java.util.Locale;

/**
 * Clase con utilidades para los idiomas
 *
 * @author Urko Villanueva
 *
 */
public class I18n {
    /**
     * Obtener el locale (idioma) del navegador para retornar la cadena de
     * locale. Si no se enceutra returna el valor "en_EN" por defecto locale <h1>
     * Lista de locales</h1>
     * <ol>
     * <li>es_ES</li>
     * <li>eu_ES</li>
     * <li>en_EN</li>
     * </ol>
     *
     * @return <code>String</code> de la cadena
     */
    public static final String getBrowserLocale(final Locale localeBrowser) {
	String result = Idioma.INGLES.getLocale();
	if (localeBrowser != null) {
	    // localeBrowser.getL
	    if (localeBrowser.getLanguage().equals(
		    new Locale(Idioma.EUSKERA.getLenguaje()).getLanguage())) {
		result = Idioma.EUSKERA.getLocale();
	    } else if (localeBrowser.getLanguage().equals(
		    new Locale(Idioma.CASTELLANO.getLenguaje()).getLanguage())) {
		result = Idioma.CASTELLANO.getLocale();
	    }
	    // if(Idioma.)
	}
	return result;
    }

    public static final Locale getStringLocale(final String lang) {
	Locale loc = new Locale(lang);
	return loc;

    }
}
