package com.ipartek.formacion.helloweb.util;

import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.http.HttpSession;

import com.ipartek.formacion.helloweb.Constantes;

public class MensajesIdiomas {

	public static ResourceBundle loadMessages(final String idioma, final HttpSession session) {
		session.setAttribute(Constantes.PARAMETRO_LANG, idioma);
		return ResourceBundle.getBundle(Constantes.PROPERTY_I18N,
				new Locale(idioma.split("_")[0], idioma.split("_")[1]));
	}
}
