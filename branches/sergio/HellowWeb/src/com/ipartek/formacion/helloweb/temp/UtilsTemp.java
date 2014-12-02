package com.ipartek.formacion.helloweb.temp;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
	
	public static String getComboRoles(HttpServletRequest request, String idRole) 
	{
		StringBuilder str = new StringBuilder();
		List<Roles> roles = null;
		
			
		if (request.getAttribute(Constantes.ATTR_ROLES_LIST) != null) 
		{
			roles = (List<Roles>) request.getAttribute(Constantes.ATTR_ROLES_LIST);
			
		}
		
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
				if(!idRole.equals(String.valueOf(Persona.ROL_NULL))) {
					if(String.valueOf(role.getId()) == idRole) {
						str.append("selected");
					}
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

	/**
	 * Obtiene un string con el rol indicado por id
	 * 
	 * @param roles Listado de roles
	 * @param idRole int identificador del rol
	 * @return String con el texto del rol o vacío si no lo encuentra
	 */
	public static String getNameFromRole(List<Roles> roles, int idRole) {
		String res  = "";
		
		if(roles != null) {
			for(Roles role : roles) {
				if(role.getId() == idRole) {
					
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
	 * @return String con el texto del rol o vacío si no lo encuentra
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
			if (request.getAttribute(Constantes.ATTR_ROLES_LIST) != null) 
			{
				roles = (List<Roles>) request.getAttribute(Constantes.ATTR_ROLES_LIST);				
			}
			intIdRole = Integer.parseInt(idRole);
		} catch (Exception ex) {
			//TODO: logger con el error
		}
		
		return getNameFromRole(roles, intIdRole); 
	}
}
