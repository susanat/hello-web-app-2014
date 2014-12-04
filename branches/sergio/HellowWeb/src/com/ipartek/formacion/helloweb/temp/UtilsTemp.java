package com.ipartek.formacion.helloweb.temp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.helloweb.bean.CargasTemporales;
import com.ipartek.formacion.helloweb.bean.Message;
import com.ipartek.formacion.helloweb.bean.Persona;
import com.ipartek.formacion.helloweb.bean.Roles;
import com.ipartek.formacion.helloweb.comun.Constantes;

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

	public static void cargaHistorial(HttpServletRequest request, HttpSession session) 
	{
		//obtenemos el actual path
		String path = request.getRequestURL().toString();
		
		//creamos una session anónima si no existe
		if(session == null) {
			session = request.getSession(true);
		}
		
		//añadimos el último path visitado
		session.setAttribute(Constantes.PARAM_SESSION_LAST_URL, path);		
		
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
	
	
	public static Persona getAuthenticated(HttpSession session) {
		
		Persona p = null;		
		
		if(session != null) {
			if( session.getAttribute(Constantes.PARAM_SESSION_AUTHENTICATED) != null) {				
				p = (Persona) session.getAttribute(Constantes.PARAM_SESSION_USER);			
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

}
