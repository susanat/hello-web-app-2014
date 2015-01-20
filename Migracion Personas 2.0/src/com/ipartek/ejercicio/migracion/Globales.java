package com.ipartek.ejercicio.migracion;

import com.ipartek.ejercicio.migracion.dao.factoria.DAOFactory;

public class Globales {
	
	static {
		
	}
	
	
	
	
	/**
	 * url ROOT del sitio
	 */	
	public static int GLOBAL_MOTOR = DAOFactory.MYSQL;
	
	
	public static String DATABASE_NAME = "migracion"; 
	

}
