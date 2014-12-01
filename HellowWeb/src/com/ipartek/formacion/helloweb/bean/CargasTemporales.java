package com.ipartek.formacion.helloweb.bean;

import java.util.ArrayList;
import java.util.List;

public class CargasTemporales {

	public static List<Roles> roles = null;
	public static List<Permiso> permisos = null;
	public static List<Persona> personas = null;
	
	/**
	 * Empty constructor
	 */
	private CargasTemporales() {
		
	}
	
	static {
		
		CargaTablaRoles();
		CargaTablaPermisos();
		CargaTablaPersonas();
		
		
	}
	
	public static void CargaTablaRoles() {
		roles = new ArrayList<Roles>();
		roles.add(new Roles(1, "user"));
		roles.add(new Roles(2, "admin"));
	}
	
	public static void truncateTablaRoles() {
		roles = null;
	}
	
	public static void truncateTablaPermisos() {
		permisos = null;
	}
	
	public static void truncateTablaPersonas() {
		personas = null;
	}
	
	public static void CargaTablaPermisos(){
		permisos = new ArrayList<Permiso>();
		permisos.add(new Permiso(1, "SITE", "Permiso de acceso al sitio en caso de que sea privado"));
		permisos.add(new Permiso(2, "administracion.jsp", "Permiso de acceso fichero de administracion"));
	}
	
	public static void CargaTablaPersonas(){
		personas = new ArrayList<Persona>();
		personas.add(new Persona(1, "Gorriti", 20,roles.get(0)));
		personas.add(new Persona(2, "Antton", 20,roles.get(0)));
		personas.add(new Persona(3, "Pirulero", 20,roles.get(0)));
		personas.add(new Persona(4, "Duquesita", 20,roles.get(0)));
		personas.add(new Persona(5, "Manole", 20,roles.get(0)));
		personas.add(new Persona(6, "Sergio", 20,roles.get(1)));
	}
		
	
	public static boolean checkPermisoPagina(String file, Persona persona) {
		
		
		
		return false;
	}
	
		
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
