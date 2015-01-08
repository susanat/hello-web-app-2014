package com.ipartek.ejercicio.migracion;

import java.nio.charset.Charset;
import java.util.HashMap;

import com.ipartek.ejercicio.migracion.utils.ClsUtilsConstantes;
import com.ipartek.ejercicio.migracion.utils.ClsUtilsFicheros;

/**
 * Storage class constants. 
 * @author baskito
 *
 */
public final class Constantes {
	
    /**
     * Empty constructor.
     */
    private Constantes() {
	
    };

    /**
     * Show each type of error.
     * @author baskito     
     */
    public enum eErrorCause{
	/**
	 * Ningún error.
	 */
	NONE,
	/**
	 * Error relativo a la edad.
	 */
	EDAD,
	/**
	 * Error mal formato de email.
	 */
	EMAIL,
	/**
	 * Error mail formato de DNI.
	 */
	DNI,
	/**
	 * Error caracteres extraños a UTF8.
	 */
	UTF8,
	/**
	 * Error mas campos de los esperados.
	 */
	MAX_FIELDS,
	/**
	 * Error menos campos de los esperados.
	 */
	MIN_FIELDS
    }
    
    
    /**
     * Name for source folder.
     */
    public static final String NAME_FOLDER_SOURCE = "source";
    
    
    /**
     * Path source of files.
     */
    public static final String PATH_SOURCE = 
	    ClsUtilsFicheros.combinarRutas(
		    ClsUtilsConstantes.PATH_PROJECT, NAME_FOLDER_SOURCE);    
   
    
    /**
     * Path name of source file.
     */
    public static final String NAME_FILE_SOURCE = "personas.txt";
    
    
    /**
     * Name for output folder.
     */
    public static final String NAME_FOLDER_OUTPUT = "output";
    
    /**
     * Path output for files.
     */
    public static final String PATH_OUTPUT = 
	    ClsUtilsFicheros.combinarRutas(
		    ClsUtilsConstantes.PATH_PROJECT, NAME_FOLDER_OUTPUT);
    
   
    
    /**
     * Name for file for statistics.
     */
    public static final String NAME_FILE_ESTADISTICAS = "estadisticas.txt";
    
    /**
     * Name for file for correct register.
     */
    public static final String NAME_FILE_CORRECTAS = "personas_correctas.txt";
    
    /**
     * Name for file for wrong register.
     */
    public static final String NAME_FILE_ERRONEAS = "personas_error.txt";
    
    /**
     * Name for file for duplicated registers.
     */
    public static final String NAME_FILE_REPETIDAS = "personas_repetidas.txt";
	
    /**
     * Separator for fields in line.
     */
    public static final String STR_SEPARATOR = ",";
	
    /**
     * Num of expected fields.
     */
    public static final int NUM_EXPECTED_FIELDS = 7;
    
    /**
     * Min edad allowed.
     */
    public static final int MIN_EDAD = 18;
    
    /**
     * Max edad allowed.
     */
    public static final int MAX_EDAD = 99;
      
	 
    /**
     * Map with the relation field - function of set in object persona.
     * TODO: 2.0 carga desde xml
     */
    public static final HashMap<Integer, String> MAP_CAMPOS_POS;
    static
    {
	MAP_CAMPOS_POS = new HashMap<Integer, String>();
	MAP_CAMPOS_POS.put(1, "setNombre");
	MAP_CAMPOS_POS.put(2, "setApellido1");
	MAP_CAMPOS_POS.put(3, "setPoblacion");
	MAP_CAMPOS_POS.put(4, "setEdad");
	MAP_CAMPOS_POS.put(5, "setEmail");
	MAP_CAMPOS_POS.put(6, "setDni");
	MAP_CAMPOS_POS.put(7, "setCargo");
    }
    
    /**
     * Const for object persona.
     */
    public static final String PATH_OBJECT_PERSONAS = 
	    "com.ipartek.ejercicio.migracion.object.Persona";
    
    /**
     * Const for charset default for files.
     */
    public static final Charset CHARSET_OUTPUT = Charset.forName("UTF-8");
    
    /**
     * Const to initialize logs.
     */
    public static final Long INITIALIZE_LONG = 0L;
    
    /**
     * String para cumplimentar el tamaño del dni.
     */
    public static final String DNI_CARACTER = "0";
    
    /**
     * Tamaño mínimo del DNI (se rellenará con DNI_CARACTER).
     */
    public static final int DNI_MIN_SIZE = 9;
	
}
