package com.ipartek.formacion.helloweb.util;

import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.ipartek.formacion.helloweb.Constantes;

public class MensajesIdiomas {

	private final static Logger log = Logger.getLogger("ACCESOS");

	public static ResourceBundle loadMessages(String idioma, final HttpSession session) {
		if (idioma == null) {
			idioma = EIdioma.INGLES.getLocale();
		}

		Locale locale = null;
		if (idioma.length() > 2) {
			locale = new Locale(idioma.split("_")[0], idioma.split("_")[1]);
		} else {
			locale = new Locale(idioma);
		}
		log.debug("cargados mensajes de properties " + Constantes.PROPERTY_I18N + " " + locale);
		return ResourceBundle.getBundle(Constantes.PROPERTY_I18N, locale);
	}
}
