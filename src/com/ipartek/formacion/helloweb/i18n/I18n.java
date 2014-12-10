package com.ipartek.formacion.helloweb.i18n;

import java.util.Locale;

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
		String res = Idioma.INGLES.getLocale();

		if (localeBrowser != null) {
			if (Idioma.EUSKERA.getIdioma() == localeBrowser.getLanguage()) {
				res = Idioma.EUSKERA.getLocale();
			} else if (Idioma.CASTELLANO.getIdioma() == localeBrowser.getLanguage()) {
				res = Idioma.CASTELLANO.getLocale();
			}
		}

		return res;
	}

}
