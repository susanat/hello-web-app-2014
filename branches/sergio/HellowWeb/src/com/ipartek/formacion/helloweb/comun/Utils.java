package com.ipartek.formacion.helloweb.comun;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.ipartek.formacion.helloweb.bean.Persona;
import com.ipartek.formacion.helloweb.bean.Roles;




/**
 * Clase de recopilaci�n de funciones utiles * 
 * 
 * @author baskito
 * @version 27.11.2014
 */
public class Utils {

	
	public static boolean inArrayRolles(int[] rolesAllowed, Persona persona) {

		for (int lRol : rolesAllowed) {
			if (lRol == persona.getRol())
				return true;
		}
		return false;
	}
	
	public static void logOff (HttpSession session) {
		session.invalidate();
		
		/*session = null;*/		
	}
	
	public static String getUriFile(String url) {
		//return url.substring( url.lastIndexOf('/')+1, url.length() );
		return url.substring(Constantes.SITE_PATH.length(), url.length());
	}
}
