package com.ipartek.formacion.helloweb.i18n;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * Clase utilidades para los idiomas
 *
 * @author Mario Alvaro
 *
 */
public class I18n {

    /**
     * Obtener el locale(idioma) del navegador para retornar la cadena de locale
     * que nosotros necesitamos para nuestra app. Si no se encuentra devuelve el
     * valor "en_EN" por defecto. <h1>Lista de locales de la App</h1>
     * <ol>
     * <li>es_ES</li>
     * <li>eu_ES</li>
     * <li>en_EN</li>
     * </ol>
     *
     * @return cadena con el locale de nuestra App, por defecto en_EN
     *
     */
    public static final String getBrowserLocale(Locale localeBrowser) {
	// por defecto ingles
	String result = Idioma.INGLES.getLocale();
	// si no es nulo
	if (localeBrowser != null) {
	    // es euskera
	    if (Idioma.EUSKERA.getLenguaje().equalsIgnoreCase(
		    localeBrowser.getLanguage())) {
		result = Idioma.EUSKERA.getLocale();
		// es Castellano
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
     * @param resource
     *            - ResoruceBundle con los .properties
     * @param key
     *            - llave a buscar en ResoruceBundle
     * @param params
     *            - numero indeterminado de parametros a sustituir
     * @return - cadena mensaje con los parametros injectados, si Exception
     *         return "¡ no existe mensajes !"
     */
    public static Object getStringParametros(ResourceBundle resource,
	    String key, Object... params) {
	try {
	    return MessageFormat.format(resource.getString(key), params);
	} catch (MissingResourceException e) {
	    return '!' + key + '!';
	}

    }
}
