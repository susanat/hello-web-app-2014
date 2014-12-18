package com.ipartek.formacion.helloweb.i18n;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import com.ipartek.formacion.helloweb.bean.Idioma;
import com.ipartek.formacion.helloweb.util.EIdioma;

/**
 * Clase con utilidades oara los idiomas. <h1>Lista de locales</h1>
 * <ol>
 * <li>es_ES</li>
 * <li>eu_ES</li>
 * <li>en_EN</li>
 * </ol>
 *
 * @author Curso
 *
 */
public class I18n {

	/**
	 * Obtener el locale del navegador para retornar el string de locale que
	 * necesitamos, si no se encuentra retorna "en_EN" por defecto.
	 *
	 * @return
	 */
	public static final String getBrowserLocale(final Locale localeBrowser) {
		// Por defecto inglés
		final Idioma idioma = new Idioma(EIdioma.INGLES.getLocale());
		String res = idioma.getLocale();

		// si no es nulo
		if (localeBrowser != null) {
			res = localeBrowser.getLanguage();
		}
		return res;
	}

	/**
	 * Utilidad para mostrar mensajes de properties con parámetros.
	 *
	 * @param cadenaMensaje
	 *            La cadena del mensaje con los parámetros a cambiar
	 * @param params
	 *            Número indeterminado de parámetros a sustituirse en la
	 *            cadenaMensaje
	 * @return cadenaMensaje con los parámetros cambiados, si
	 *         MissingResourceException return "! no existe mensaje !"
	 */
	public static String getStringParametros(final String cadenaMensaje, final Object... params) {
		try {
			return MessageFormat.format(cadenaMensaje, params);
		} catch (final MissingResourceException e) {
			return "! no existe mensaje !";
		}
	}

	/**
	 * Utilidad para mostrar mensajes de properties con parámetros.
	 *
	 * @param resource
	 *            ResourceBundle con los .properties
	 * @param key
	 *            clave a buscar en ResourceBundle
	 * @param params
	 *            Número indeterminado de parámetros a sustituirse en la
	 *            cadenaMensaje
	 * @return cadenaMensaje con los parámetros cambiados, si
	 *         MissingResourceException return "! no existe mensaje !"
	 */
	public static String getStringParametros(final ResourceBundle resource, final String key, final Object... params) {
		try {
			return MessageFormat.format(resource.getString(key), params);
		} catch (final MissingResourceException e) {
			return "! no existe mensaje !";
		}
	}

}
