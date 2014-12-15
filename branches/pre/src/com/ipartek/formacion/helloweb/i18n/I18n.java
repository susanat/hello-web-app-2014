package com.ipartek.formacion.helloweb.i18n;

import java.util.Locale;

/**
 * Clase con utilidades para los idiomas
 * @author ur00
 *
 */
public class I18n {

	/**
	 * Obtener el locale(idioma) del navegador para retornar la cadena de locale que nosotros necesitamos para nuestra app
	 * Si no se encuentra retorna valor "en_EN" por defecto
	 * <h1>lista de locales de la App</h1>
	 * <ol>
	 * <li>es_ES</li>
	 * <li>eu_ES</li>
	 * <li>en_EN</li>
	 * </ol>
	 * 
	 * @return cadena con el locale de nuestra App, por defecto en_EN
	 */
	public static final String getBrowserLocale( Locale localeBrowser ){
		//por defecto ingles
		String result = Idioma.INGLES.getLocale();
		//si no es nulo
		if ( localeBrowser != null ){
			//es euskera
			if( Idioma.EUSKERA.getLenguaje().equalsIgnoreCase(localeBrowser.getLanguage())){
				result = Idioma.EUSKERA.getLocale();
			//es Castellano	
			}else if (Idioma.CASTELLANO.getLenguaje().equalsIgnoreCase(localeBrowser.getLanguage())){
				result = Idioma.CASTELLANO.getLocale();
			}
		}
		return result;		
	}
	
}
