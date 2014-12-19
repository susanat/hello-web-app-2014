package com.ipartek.formacion.helloweb.i18n;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

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
	
	
	

	/**
	 * Utilidad para mostrar mensajes de properties con parametros
	 * @param resource ResourceBundle con los .properties 
	 * @param key llave a buscar en ResourceBundle
	 * @param params numero indeterminado de paramatros a sustituir
	 * @return cadena mensajes con los parametros injectados, si MissingResourceException return: '!' + key + '!'
	 */
	public static String getStringParametros(
			ResourceBundle resource, String key, Object... params ) 
	{		
		 try {
	            return MessageFormat.format(resource.getString(key), params);
	        } catch (MissingResourceException e) {
	            return '!' + key + '!';
	        }
	}
	
	
}
