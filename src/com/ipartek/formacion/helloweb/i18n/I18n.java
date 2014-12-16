package com.ipartek.formacion.helloweb.i18n;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

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

    /**
     * Utilidad para mostrar mensajes de properties con parametros
     *
     * @param cadenaMensaje
     *            cadena del mensaje con los parametros a cambiar
     * @param params
     *            numero indeterminado de parametros a sustituirse en la
     *            cadenaMensaje
     * @return cadena mensaje los parametros inyectados, si hay Exception return
     *         "no existe mensaje"
     */
    public static String getStringParametros(String cadenaMensaje,
	    Object... params) {
	try {
	    return MessageFormat.format(cadenaMensaje, params);
	} catch (Exception e) {
	    return "! no existe mensaje !";
	}
    }

    /**
     * Utilidad para mostrar mensajes de properties con parametros
     * 
     * @param resource
     *            ResourceBundle con los .properties
     * @param key
     *            llave a buscar en ResourceBundle
     * @param params
     *            numero indeterminado de parametros a sustituir
     * @return cadena mensajes con los parametros inyectados, si
     *         MissingResourceException devuelve un aviso
     */
    public static Object getStringParametros(ResourceBundle resource,
	    String key, Object... params) {
	try {
	    return MessageFormat.format(resource.getString(key), params);
	} catch (MissingResourceException e) {
	    return "! No existe el mensaje!";
	}
    }
}
