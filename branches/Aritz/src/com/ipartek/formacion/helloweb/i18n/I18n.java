package com.ipartek.formacion.helloweb.i18n;

import java.util.Locale;

/**
 * clase con utilidades para los idiomas
 *
 * @author Aritz Tellaeche
 *
 */
public class I18n {

	/**
	 * obtener el locale(idioma) del navegador para retornar la cadena de locale
	 * q nosotros tenemos. Si no se encuentra retorna "en_EN" por defecto
	 *
	 * <ul>
	 * <li>Ingles</li>
	 * <li>Euskera</li>
	 * <li>Castellano</li>
	 * </ul>
	 *
	 * @return cadena con el locale de nuestra app, por defecto en_EN
	 */
	public static final String getBrowserLocale(Locale localeBrowser) {

		// por defecto ingles
		String result = Idioma.INGLES.getLocale();

		// si no es nulo
		if (localeBrowser != null) {
			// en euskera
			if (Idioma.EUSKERA.getLenguaje().equalsIgnoreCase(
					localeBrowser.getLanguage())) {
				result = Idioma.EUSKERA.getLocale();

				// en castellano
			} else if (Idioma.CASTELLANO.getLenguaje().equalsIgnoreCase(
					localeBrowser.getLanguage())) {
				result = Idioma.CASTELLANO.getLocale();
			}
		}

		return result;

	}

}
