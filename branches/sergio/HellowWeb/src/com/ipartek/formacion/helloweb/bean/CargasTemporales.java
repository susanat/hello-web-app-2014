package com.ipartek.formacion.helloweb.bean;

import java.util.ArrayList;
import java.util.List;

public class CargasTemporales {

	public static List<Roles> getListRoles(){
		List<Roles> roles = new ArrayList<Roles>();
		roles.add(new Roles(1,"Administrador"));
		roles.add(new Roles(2,"Usuario"));
		
		return roles;		
	}
	
	public static Persona getPersona(String name)
	{
		if("sergio".equals(name)) {
			return new Persona(name, 18, getListRoles().get(0));
		} else if("user".equals(name)) {
			return new Persona(name, 18, getListRoles().get(1));
		}
		
		return null;
	}
	
	
}
