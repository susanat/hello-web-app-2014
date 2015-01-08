package com.ipartek.formacion.busredsociales.comun;

public final class Constantes {
	
	static {
		//request.getSession().getServletContext().getRealPath("/");
	}

	/**
	 * Empty constructor to avoid instanciate class
	 */
	private Constantes() {

	}


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
