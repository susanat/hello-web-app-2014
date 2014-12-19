package com.ipartek.formacion.helloweb.i18n;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * Clase con utilidades para i18n
 * 
 * @author Maitane Casado
 *
 */

public class I18n {

	/**
	 * Obtener el locale(idioma) del navegador para retornar la cadena de locale
	 * que nosotros necesitamos para nuestra App. Si no se encuentra retorna
	 * valor "en_EN" por defecto
	 * 
	 * <h1>Lista de locales de la App</h1>
	 * <ol>
	 * <li>es_ES</li>
	 * <li>eu_ES</li>
	 * <li>en_EN</li>
	 * </ol>
	 * 
	 * @return cadena con el locale de nuestra App, por defecto en_EN
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
	 * Esta es una utilidad para mostrar mensajes de properties con parametros
	 * 
	 * @param cadenaMesnaje
	 *            cadena del mesnaje con los parametros a cambiar
	 * @param params
	 *            numero indeterminado de parametros (por eso lleva 3 puntos) a
	 *            sustituirse en la cadenaMensaje
	 * @return cadena mensajes con los parametros inyectados, Exception return
	 *         "! no existe mensaje !"
	 */

	public static String getStringParametros(String cadenaMesnaje,
			Object... params) {
		try {
			return MessageFormat.format(cadenaMesnaje, params);
		} catch (Exception e) {
			return "! no existe mensaje !";
		}
	}

	/**
	 * Esta es una utilidad para mostrar mensajes de properties con parametros
	 * 
	 * @param resource
	 *            ResourceBundle en los .properties
	 * @param key
	 *            llave a buscar en ResourceBundle
	 * @param params
	 *            numero indeterminado de parametros a sustituir
	 * @return cadena mensajes con los parametros inyectados,
	 *         MissingResourceException return "!" + key + " !"
	 */

	public static Object getStringParametros(ResourceBundle resource,
			String key, Object... params) {
		try {
			return MessageFormat.format(resource.getString(key), params);
		} catch (MissingResourceException e) {
			return "!" + key + " !";
		}
	}
}
