package com.ipartek.formacion.helloweb.util;

import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.http.HttpSession;

import com.ipartek.formacion.helloweb.Constantes;

public class MensajesIdiomas {

	public static ResourceBundle loadMessages(String idioma, final HttpSession session) {
		if (idioma == null) {
			idioma = Constantes.DEFAULT_LANG;
		}

		session.setAttribute(Constantes.PARAMETRO_LANG, idioma);

		Locale locale = null;
		if (idioma.length() > 2) {
			locale = new Locale(idioma.split("_")[0], idioma.split("_")[1]);
		} else {
			locale = new Locale(idioma);
		}
		return ResourceBundle.getBundle(Constantes.PROPERTY_I18N, locale);
	}
}
