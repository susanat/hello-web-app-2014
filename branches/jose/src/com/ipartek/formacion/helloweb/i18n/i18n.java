package com.ipartek.formacion.helloweb.i18n;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

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

	/**
	 * Utilidad para mostrar mensajes de properties con parametros
	 * 
	 * @param cadenaMensaje
	 *            cadena del mensaje con los parametros a cambiar
	 * @param params
	 *            numero indeterminado (...) de parametros a sustituirse en la
	 *            cadenaMensaje
	 * @return cadena mensaje con los parametros injectados, si Exception
	 *         devuelve "! no existe mensaje !"
	 */
	public static String getStringParametros(String cadenaMensaje,
			Object... params) {
		try {
			return MessageFormat.format(cadenaMensaje, params);
		} catch (Exception e) {
			return "! no existe mensaje !";
		}
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

	/**
	 * Utilidad para mostrar mensajes de properties con parametros
	 * 
	 * @param resource
	 *            ResourceBundle con los .properties
	 * @param key
	 *            llave para buscar en ResourceBundle
	 * @param params
	 *            numero indeterminado de parametros a sustituir
	 * @return cadena de mensajes con los parametros injectados, si
	 *         MissingResourceException devuelve "!key!"
	 */
	public static Object getStringParametros(ResourceBundle resource,
			String key, Object... params) {
		try {
			return MessageFormat.format(resource.getString(key), params);
		} catch (MissingResourceException e) {
			return "!" + key + "!";
		}

	}
}
