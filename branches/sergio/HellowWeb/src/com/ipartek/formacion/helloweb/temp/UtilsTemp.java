package com.ipartek.formacion.helloweb.temp;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
	
	public static String getComboRoles(HttpServletRequest request, Roles userRole) 
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
				if(userRole != null) {
					if(role.getId() == userRole.getId()) {
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
}
