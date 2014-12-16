package com.ipartek.formacion.helloweb.i18n;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.MissingResourceException;

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
	Locale loc = new Locale(Idioma.INGLES.getLenguaje(),
		Idioma.INGLES.getPais());
	if (lang != null) {
	    if (lang.equalsIgnoreCase(Idioma.CASTELLANO.getLenguaje())) {
		loc = new Locale(Idioma.CASTELLANO.getLenguaje(),
			Idioma.CASTELLANO.getPais());
	    } else {
		loc = new Locale(Idioma.EUSKERA.getLenguaje(),
			Idioma.EUSKERA.getPais());
	    }
	}
	return loc;

    }

    /**
     * Utilidad para mostrar mensajes de properties con parametros
     *
     * @param cadenaMensaje
     *            <code>String</code> del mensaje con los parametro a cambiar
     * @param params
     *            numero indeterminado de parametro a susustituirse en la
     *            cadenaMensaje
     * @return cade mensaje con los parametro injectados, si
     *         <code>MissingResourceException</code>
     */
    public static String getStringParametros(final String cadenaMensaje,
	    final Object... params) {
	try {
	    return MessageFormat.format(cadenaMensaje, params);
	} catch (MissingResourceException e) {
	    return '!' + "no existe mensaje" + '!';
	}

    }
}
