package com.ipartek.formacion.helloweb.i18n;

import java.util.Locale;

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
}
