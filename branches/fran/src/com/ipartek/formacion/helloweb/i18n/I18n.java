package com.ipartek.formacion.helloweb.i18n;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class I18n {

	/**
	 * Formatear el locale del navegador para que lleve siempre el formato,
	 * lenguaje_PAIS.
	 * 
	 * @param localeBrowser
	 * @return String con el formato lenguaje_PAIS
	 */
	public static final String getBrowserLocale(Locale localeBrowser) {
		String resul = Idioma.INGLES.getLocale();
		if (localeBrowser != null) {
			if (Idioma.EUSKERA.getLenguaje().equalsIgnoreCase(
					localeBrowser.getLanguage())) {
				resul = Idioma.EUSKERA.getLocale();
			} else if (Idioma.CASTELLANO.getLenguaje().equalsIgnoreCase(
					localeBrowser.getLanguage())) {
				resul = Idioma.CASTELLANO.getLocale();
			}
		}
		return resul;
	}

	/**
	 * Función para mostrar mensajes con parámetros.
	 * 
	 * @param resource
	 *            fichero de mensajes.
	 * @param key
	 *            clave del mensaje en el fichero de mensajes.
	 * @param params
	 *            valores de los parámetros a incrustar en el mensaje.
	 * @return mensaje con los valores incrustados en el mensaje.
	 */
	public static String getStringParametros(ResourceBundle resource,
			String key, Object... params) {
		try {
			return MessageFormat.format(resource.getString(key), params);
		} catch (MissingResourceException e) {
			return "| no existe mensaje |";
		}

	}
}
