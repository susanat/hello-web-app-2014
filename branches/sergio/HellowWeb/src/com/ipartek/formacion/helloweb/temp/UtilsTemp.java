package com.ipartek.formacion.helloweb.temp;

import java.io.IOException;
import java.net.URL;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.helloweb.bean.CargasTemporales;
import com.ipartek.formacion.helloweb.bean.Message;
import com.ipartek.formacion.helloweb.bean.Persona;
import com.ipartek.formacion.helloweb.bean.Roles;
import com.ipartek.formacion.helloweb.comun.Constantes;
import com.ipartek.formacion.helloweb.comun.Globales;

public class UtilsTemp {

	public static String getUriFromRequest(HttpServletRequest request){
		return request.getScheme() + "://" +
	             request.getServerName() + 
	             ("http".equals(request.getScheme()) && request.getServerPort() == 80 || "https".equals(request.getScheme()) && request.getServerPort() == 443 ? "" : ":" + request.getServerPort() ) +
	             request.getRequestURI() +
	            (request.getQueryString() != null ? "?" + request.getQueryString() : "");
	}
	
	public static String getComboRoles(List<Roles> lstRoles, String idRole) {		
		
		StringBuilder str = new StringBuilder();
		List<Roles> roles = new ArrayList<Roles>(lstRoles);
		
		//abrimos el combo
		str.append("<select class='form-control' id='roles' name='");
		str.append(Constantes.PARAM_PERSONAS_ROLE);
		str.append("'>");
		
		//si no es null, mostramos
		if(roles != null) 
		{
			for(Roles role : roles) {
				str.append("<option value='");
				str.append(role.getId());
				str.append("'");
				
				//si coincide con el pasado, selected				
				if (idRole.equals(String.valueOf(role.getId()))) {
					str.append("selected");
				}				
				
				str.append(">"); //cierre de la apertura del option
				str.append(role.getNombre());
				str.append("</option>"); //cierre del option
			}			
			
		}		
					
		//cerramos el combo
		str.append("</select>");	
		
		return str.toString();		
	}
	
	
	public static String getComboRoles(HttpServletRequest request, String idRole) 
	{		
		List<Roles> roles = null;
			
		/**
		if (request.getAttribute(Constantes.ATTR_ROLES_LIST) != null) 
		{
			roles = (List<Roles>) request.getAttribute(Constantes.ATTR_ROLES_LIST);
			
		}
		*/
		
		//TODO: hardcodeado
		roles = CargasTemporales.getListRoles();
		
		return getComboRoles(roles, idRole);
	}

	/**
	 * Obtiene un string con el rol indicado por id
	 * 
	 * @param roles Listado de roles
	 * @param idRole int identificador del rol
	 * @return String con el texto del rol o vac�o si no lo encuentra
	 */
	public static String getNameFromRole(List<Roles> roles, int idRole) {
		String res  = "";
		
		if(roles != null) {
			for(Roles role : roles) {
				if(role.getId() == idRole) {
					res = role.getNombre();
				}
			}
		}			
		return res;
	}
	
	/**
	 * Obtiene un string con el rol indicado por id
	 * 
	 * @param roles Listado de roles
	 * @param idRole String identificador del rol
	 * @return String con el texto del rol o vac�o si no lo encuentra
	 */
	public static String getNameFromRole(List<Roles> roles, String idRole) {
		
		int intIdRole = 0;
		
		try {
			intIdRole = Integer.parseInt(idRole);
		} catch (Exception ex) {
			//TODO: logger con el error
		}
		
		return getNameFromRole(roles, intIdRole); 
	}
	
	public static String getNameFromRole(HttpServletRequest request, String idRole) {
		
		int intIdRole = 0;
		
		List<Roles> roles = null;		
				
		try {
				//TODO: hardcodeado
				roles = CargasTemporales.getListRoles();
				//paso a int
				intIdRole = Integer.parseInt(idRole);
				//llamo a la versión list, int
				return getNameFromRole(roles, idRole);
		} catch (Exception ex) {
			//TODO: logger con el error
		}
		
		return getNameFromRole(roles, intIdRole); 
	}

	
	/**
	 * Guarda la última url visitada
	 * @param request peticion
	 * @param session session actual
	 * @return
	 */
	public static String cargaHistorial(HttpServletRequest request, HttpSession session) 
	{
		//creamos una session anónima si no existe
		if(session == null) {
			session = request.getSession(true);
		}		
				
		//obtenemos el actual path
		String path = request.getRequestURL().toString();
		
		//paths descartadas para almacenar en historial TODO: Dinamizar o poner en otro sitio
		if(! "http://localhost:8080/HelloWeb/login_jstl.jsp".equals(path)) {
			
			//añadimos el último path visitado
			session.setAttribute(Constantes.ATTR_SESSION_LAST_URL, path);
			
		} else {
			//obtenemos el path que habí, si no vacío
			if(session != null) {
				Object lastUrl = session.getAttribute(Constantes.ATTR_SESSION_LAST_URL);
				
				if(lastUrl != null) {
					path = (String) lastUrl;
				}				
			}			
		}
		
		return path;
		
	}
	
	/**
	 * 
	 * @param request
	 * @return String con la alerta o vacío si no hay error
	 */
	/*
	public static String showError(HttpServletRequest request) {
		StringBuilder res = new StringBuilder();
		
		//existe error (si no, malo)
		if(request.getAttribute(Constantes.ATTR_ERROR) != null)	{
			
			//obtenemos el objeto error
			Message msg = (Message) request.getAttribute(Constantes.ATTR_ERROR);
						  
			if(msg != null){
				 res.append("<div class='alert alert-danger sombra' role='alert'>" + msg.getText() + "</div>");			
			}
		}	
		
		return res.toString();
	}
	*/
	
	/**
	 * Obtiene del request el objeto message
	 * @param request HttpServletRequest del jsp
	 * @return Message El objeto o null si no existe
	 */
	public static Message getMessage (HttpServletRequest request) {
		Message msg = null;		
		//existe error (si no, malo)
		if(request.getAttribute(Constantes.ATTR_ERROR) != null)	{					
			//obtenemos el objeto error
			msg = (Message) request.getAttribute(Constantes.ATTR_ERROR);
		}		
		return msg;
	}
	
	
	/**
	 * Obtiene el objeto del usuario autentificado
	 * 
	 * @param session Sesión actual
	 * @return null si no existe usuario o Objeto de tipo usuario
	 */
	public static Persona getAuthenticated(HttpSession session) {
		
		Persona p = null;		
		
		if(session != null) {
			if( session.getAttribute(Constantes.ATTR_SESSION_AUTHENTICATED) != null) {				
				p = (Persona) session.getAttribute(Constantes.ATTR_SESSION_USER);			
			}
		}
		
		return p;
		
	}
	
	/**
	 * Comprueba si un usuario tiene permiso el nombre indicado
	 * 
	 * @param nombrePermiso
	 * @param p
	 * @return true si dispone de permiso, false si no
	 */
	public static boolean havePermiso(String nombrePermiso, Persona p) 
	{
		//TODO hardcodeado
		if(p == null) {
			return false;
		}
		
		if( p.getRol() == 2) {
			return true;
		}
		
		
		
		return false;		
	}
	
	/**
	 * Redirige a la página de login
	 * 
	 * @param response
	 * @throws IOException
	 */
	public static void goToLogin(HttpServletResponse response) throws IOException {
		
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
   		response.sendRedirect(Constantes.JSP_LOGIN);
   		
	}
	
	/**
	 * Dada la propiedad y el locale de la sesión obtiene el texto traducido al idioma indicado del objeto Role. 
	 * @param obj Roles
	 * @param propiedad String con el nombre de la propiedad (ejemplo, role.alias.desc) 
	 * @param sesion HttpSession actual
	 * @return String con el texto en el idioma o en blanco si no lo encuentra
	 */
	public static String getTextLang(Roles obj, String propiedad, HttpSession sesion) {	
		
		String res = propiedad;
		String resTemp = "";
		
		//construimos la propiedad
		if( propiedad.trim().toLowerCase().equals(Roles.ROLE_DESC_NULL.toLowerCase()) 
				|| propiedad.trim().toLowerCase().equals(Roles.ROLE_NAME_NULL.toLowerCase())) {
			
			
			//construimos la propiedad, sustituyo alias por el alias
			propiedad = propiedad.replace("alias", obj.getAlias().toLowerCase().trim()); 
			
				
			resTemp = getStringLang(propiedad, sesion, Globales.SITE_DEFAULT_LANG);
			if("".equals(res.trim())) {
				resTemp = propiedad; 
			} else {
				res = resTemp;
			}			
		}
		
		
		return res;
	}
	
	
	/**
	 * Dada la propiedad y el locale de la sesión obtiene el texto traducido al idioma indicado. 
	 * @param propiedad Propiedad a buscar
	 * @param sesion sesion
	 * @return
	 */
	public static String getStringLang (String propiedad, HttpSession sesion, String langDefault) {
		String res = "";
		String language = langDefault;
		String[] langSplit = null;
		Locale locale = null;
		
		try {			
			//Locale por defecto
			langSplit = language.split("_");				
			locale = new Locale(langSplit[0], langSplit[1].toUpperCase());

			//obtener lenguaje de la session del usuario
			if(sesion.getAttribute(Constantes.ATTR_SESSION_LOCALE) != null) {
				language = sesion.getAttribute(Constantes.ATTR_SESSION_LOCALE).toString();
			}
			
			if(language != null) {				
				langSplit = language.split("_");				
				locale = new Locale(langSplit[0], langSplit[1].toUpperCase());
				//locale = new Locale(language);
			}
			
			//Cargar resourceBundle o properties dependiente del idioma
			// Debemos indicara el package donde se encuentra y el nombre del /properties sin la extension del locale
			ResourceBundle men = ResourceBundle.getBundle("com.ipartek.formacion.helloweb.i18n.lang", locale );
			
			//obtenemos el texto del mensaje
			res = men.getString(propiedad);			
		} catch (Exception ex) {
			ex.printStackTrace();
		}		
		return res;
	}
	
	/**
	 * Dada la propiedad y el locale de la sesión obtiene el texto traducido al idioma indicado. 
	 * @param propiedad Propiedad a buscar
	 * @param sesion sesion
	 * @return
	 */
	public static String getStringLang (String propiedad, Locale locale, String langDefault) {
		String res = "";
		String language = langDefault;
			
		try {			
			//Locale por defecto
			Locale localLocale = new Locale(language);

			//obtener lenguaje de la session del usuario
			if(locale != null) {
				localLocale = locale;
			}
			
			//Cargar resourceBundle o properties dependiente del idioma
			// Debemos indicara el package donde se encuentra y el nombre del /properties sin la extension del locale
			ResourceBundle messages = ResourceBundle.getBundle(Constantes.PACKAGE_LANG, locale );
						
			
			//obtenemos el texto del mensaje
			res = messages.getString(propiedad);			
		} catch (Exception ex) {
			ex.printStackTrace();
		}		
		return res;
	}
	
	public static String getStringLangParams(String propiedad, HttpSession sesion, String langDefault, Object...params) 
	{
		
		String lang = UtilsTemp.getStringLang(propiedad, sesion, langDefault);		
		lang = MessageFormat.format(lang, params); 
		
		return lang;
		
		
		
	}

}
