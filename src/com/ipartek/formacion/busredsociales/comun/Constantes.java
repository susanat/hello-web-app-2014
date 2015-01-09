package com.ipartek.formacion.busredsociales.comun;

import com.ipartek.formacion.busredsociales.dao.factoria.DAOFactory;

public final class Constantes {
	
	static {
		
	}

	/**
	 * Empty constructor to avoid instanciate class
	 */
	private Constantes() {

	}
	
	public static DAOFactory factoria = DAOFactory.getDaoFactoriaAbstracta(DAOFactory.MYSQL);


	//********************** GENERAL
	/**
     * Salto de línea genérico independiente del S.O. 
     * (uso de System.getProperty).
     */
    public static final String SALTO_DE_LINEA = 
	    System.getProperty("line.separator");


    public static final String PATH_ABS_THEME = Globales.SITE_ROOT_PATH + "theme/default/";

    
    
    public static final String ATTR_LISTADO = "listado";
	
		
}
