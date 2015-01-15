package com.ipartek.ejercicio.migracion;

import com.ipartek.ejercicio.migracion.Constantes.eErrorCause;

/**
 * Funciones reutilizadas relativas al programa.
 * 
 * @author Sergio Rubio Nieto
 *
 */
public final class UtilsPrograma {

    
    /**
     * Empty constructor.
     */
    private UtilsPrograma() {
	
    }
    
    /**
     * Convierte el enum de error en String.
     * @param eError eErrorCause código de error
     * @return String con el nombre del error
     */
    public static String enumToString(final eErrorCause eError) {
	/*
	Datos Incompletos -> linea
	Edad -> linea
	Email no valido -> linea
	DNI no valido -> linea
	UTF8 -> linea
	*/
	//TODO: con tiempo quitar esto y ponerlo dentro del enum	
	String texto = "";
	
	if (eErrorCause.MAX_FIELDS.equals(eError)) {
	    return "Datos incompletos";
	} else if (eErrorCause.MIN_FIELDS.equals(eError)) {
	    return "Datos incompletos";
	} else if (eErrorCause.DNI.equals(eError)) {
	    return "DNI no válido";
	} else if (eErrorCause.EDAD.equals(eError)) {
	    return "Edad no válida";
	} else if (eErrorCause.EMAIL.equals(eError)) {
	    return "Email no valido";
	} else if (eErrorCause.UTF8.equals(eError)) {
	    return "UTF8";
	}
	
	return texto;
	
	
    }
}
