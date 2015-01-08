package com.ipartek.ejercicio.migracion;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

import org.apache.log4j.Category;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.ipartek.ejercicio.migracion.Constantes.eErrorCause;
import com.ipartek.ejercicio.migracion.object.Persona;
import com.ipartek.ejercicio.migracion.utils.C_LOG;
import com.ipartek.ejercicio.migracion.utils.ClsUtilsConstantes;
import com.ipartek.ejercicio.migracion.utils.ClsUtilsFechas;
import com.ipartek.ejercicio.migracion.utils.ClsUtilsFicheros;
import com.ipartek.ejercicio.migracion.utils.ClsUtilsUI;


/**
 * Lógica del proceso de checkeo de datos.
 * 
 * 
 * @author baskito
 *
 */
public class Actions {

    /**
     * Save the objects of Persona.
     */
    private List<Persona> lstPersonas = null;

    /**
     * Save each line of file.
     */
    private List<String> strFile = null;

    /**
     * Agrupa las lineas por tiepo de error, una línea solo aparecerá una vez y
     * solo con el primer tipo de error encontrado.
     */
    private HashMap<eErrorCause, List<String>> groupByFirstErr = null;

    /**
     * Agrupa las lineas por tipo de error, pero estas líneas pueden aparecer en
     * más de un error.
     */
    private HashMap<eErrorCause, List<String>> groupByAllErr = null;

    /**
     * Agrupa los duplicados por DNI.
     */
    private HashMap<String, List<Persona>> groupDuplicated = null;

    /**
     * Guarda el tiempo del proceso.
     */
    private Long miliseconds = Constantes.INITIALIZE_LONG;

    /**
     * Constructor for object Actions.
     * @throws Exception 
     */
    public Actions() throws Exception {
	if (!checkFolders()) {
	    throw new Exception("No se ha podido crear la estructura del proyecto");
	}
    }



    /**
     * Get the list with objects of Persona.
     * @return List with Persona objects
     */    
    public List<Persona> getLstPersonas() {	
	return lstPersonas;
    }

    /**
     * Obtiene la lista de duplicados agrupados por dni.
     * 
     * @return HashMap<String, List<Persona>> con la lista de duplicados 
     * agrupados por DNI
     */
    public HashMap<String, List<Persona>> getGroupDuplicated() {
	return new HashMap<String, List<Persona>>(groupDuplicated);
    }

    /**
     * Get the time of process.
     * 
     * @return Long with milliseconds
     */
    public Long getTimeLapsedMiliseconds() {
	return miliseconds;
    }

    /**
     * Get the size of lines in file.
     * 
     * @return Integer number of lines or null if not yet read;
     */
    public Integer getCountLines() {
	int count = 0;		

	if (strFile != null) {
	    count =  strFile.size();
	}

	return count;
    }

    /**
     * Get List of lines with determinate error cause.
     * 
     * @param errorCause Error
     * @return List of lines
     */
    public List<String> getLinesByFirstError(final eErrorCause errorCause) {
	if (groupByFirstErr != null) {
	    return groupByFirstErr.get(errorCause);
	}

	return null;
    }

    /**
     * Get the hasmap with lines group by error cause.
     * 
     * @return hasmap with key enum ErrorCause and List of lines
     */
    public HashMap<eErrorCause, List<String>> getAgrupedLinesByFirstError() {

	if (groupByFirstErr != null) {
	    return groupByFirstErr;
	}

	return null;
    }

    /**
     * Get number of lines with determinate error cause.
     * 
     * @param errorCause Error
     * @return Integer count of lines with a type of error
     */
    public Integer getNumberOfLinesByFirstError(final eErrorCause errorCause) {

	if (groupByFirstErr != null) {
	    final List<String> lstTemp = groupByFirstErr.get(errorCause);
	    if (lstTemp == null) {
		return 0;
	    } else {
		return groupByFirstErr.get(errorCause).size();
	    }
	}

	return 0;
    }

    /**
     * Get count of lines processed.
     * 
     * @param errorCause Error
     * @return Integer with the number of lines processed
     */
    public Integer getNumberOfLinesByAllError(final eErrorCause errorCause) {

	if (groupByAllErr != null) {
	    List<String> lstTemp = groupByAllErr.get(errorCause);
	    if (lstTemp == null) {
		return 0;
	    } else {
		return groupByAllErr.get(errorCause).size();
	    }
	}

	return 0;
    }

    /**
     * Get count of lines with error.
     * 
     * @return Integer with lines with error
     */
    public Integer getCountLinesWithErrors() {
	HashMap<eErrorCause, List<String>> map = 
		new HashMap<eErrorCause, List<String>>(
			groupByFirstErr);

	// removemos las correctas:
	map.remove(eErrorCause.NONE);
	List<String> lstErrors = new ArrayList<String>();

	for (Entry<eErrorCause, List<String>> lst : map.entrySet()) {
	    lstErrors.addAll(lst.getValue());
	}

	return lstErrors.size();
    }

    /**
     * Read indicated file and save into list.
     * 
     * @throws Exception FileException
     * 
     * @param filePath path and name for file
     */
    public void readFile(final String filePath) throws Exception {
	try {	        
	    //strFile = ClsUtilsFicheros.readFile(filePath);
	    strFile = ClsUtilsFicheros.readWithScanerToList(filePath, 
		    Charset.forName("UTF-8"));
	} catch (Exception e) {	    
	    throw e;	      
	}

	//TODO: fichero de entrada tiene que estar codificado en UTF-8 no Bounds
	
    }

    /**
     * Start process to read list file.
     * @throws InterruptedException 
     */
    public void startProcess() throws InterruptedException {

	final Date fInicial = new Date();

	// for each line
	for (final String line : strFile) {
	    // System.out.println(line + ClsUtilsConstantes.SALTO_DE_LINEA);
	    // Check each line for errors, if not, next line
	    if (isCorrectLine(line)) {
		createObject(line);
	    }
	}

	//creamos los duplicados si existen datos de persona
	if(lstPersonas != null) {
	    groupDuplicated = getListDuplicated(lstPersonas);
	}

	//System.out.println("finanl proceso");
	miliseconds = ClsUtilsFechas.diferenciaHoras(fInicial, new Date())
		.getDiffMilisegundos();

	try {
	    ClsUtilsUI.showNoModalInformation(
		    "Migración finalizada", "Migración");
	} catch (InterruptedException e) {
	    ClsUtilsUI.showNoModalAlert(e.getMessage(), "Migración");		    
	} 
    }

    /**
     * Check if is correct field.
     * 
     * @param line String Line to check
     * @return first false if not is correct, true if yes.
     */
    private boolean isCorrectLine(final String line) {

	eErrorCause errorCause = null;

	// check max fields or min fields
	errorCause = Validations.isValidNumberFields(line,
		Constantes.NUM_EXPECTED_FIELDS);
	if (null != errorCause) {
	    // es incorrecta, guardamos en los dos maps
	    saveInAllErrorCause(errorCause, line);
	    saveInFirstErrorCause(errorCause, line);
	    return false;
	} else {
	    // es correcta
	    return true;
	}
    }

    /**
     * Crea un objeto con los datos de la linea y comprueba si éstos tienen
     * algún error.
     * 
     * (versión utilizando reflection, como pruebas)
     * @see 
     * http://www.mkyong.com/java/how-to-use-reflection-to-call-java-method-at-runtime/
     * @param line String with line
     * 
     */
    private void createObject(final String line) {

	String[] splitLine = line.split(Constantes.STR_SEPARATOR);	

	// String parameter para añadir en caso que se pase valores tipo string
	Class[] paramString = new Class[1];
	paramString[0] = String.class;


	Class cls = null; //clase dinámica
	Object obj = null; //objeto que se creará
	Method method = null; //contendrá el método a invocar
	String functionName = null; //nombre de la función
	String parameter = ""; //parámetros a pasar en la función

	try {
	    // creamos el objeto por su nombre.
	    cls = Class.forName(Constantes.PATH_OBJECT_PERSONAS);
	    obj = cls.newInstance();
	    for (int i = 0; i < Constantes.NUM_EXPECTED_FIELDS; i++) {
		//obtenemos la función relativa al índice
		functionName = Constantes.MAP_CAMPOS_POS.get(i + 1);
		parameter = splitLine[i];

		// call the printItString method, pass a String param
		method = cls.getDeclaredMethod(functionName, paramString);
		method.invoke(obj, parameter);
	    }


	    //Se ha creado el objeto
	    if (lstPersonas == null) {
		lstPersonas = new ArrayList<Persona>();
	    }

	    //añadimos el objeto a la lista
	    lstPersonas.add((Persona) obj);


	    // no paramater
	    Class[] noparams = {};

	    // System.out.println(obj.toString());
	    method = cls.getDeclaredMethod("getErrors", noparams);
	    final LinkedList<eErrorCause> errors = (LinkedList<eErrorCause>) method
		    .invoke(obj);
	    if (errors != null && errors.size() > 0) {
		// En all errors desglosamos los errores
		for (eErrorCause errorCause : errors) {
		    saveInAllErrorCause(errorCause, line);
		}

		// en first error, solo introducimos el primer error
		saveInFirstErrorCause(errors.getFirst(), line);
	    } else {
		// Sin errores
		saveInFirstErrorCause(eErrorCause.NONE, line);
		saveInAllErrorCause(eErrorCause.NONE, line);
	    }
	} catch (ClassNotFoundException e) {
	    e.printStackTrace();
	} catch (InstantiationException e) {
	    e.printStackTrace();
	} catch (IllegalAccessException e) {
	    e.printStackTrace();
	} catch (NoSuchMethodException e) {
	    e.printStackTrace();
	} catch (SecurityException e) {
	    e.printStackTrace();
	} catch (IllegalArgumentException e) {
	    e.printStackTrace();
	} catch (InvocationTargetException e) {
	    e.printStackTrace();
	}

    }

    /**
     * Guarda en los mapas la linea pasada agrupada por el error.
     * 
     * @param error
     *            Error que tiene la linea. (NONE si no hay error)
     * @param line
     *            Linea tratada
     */
    private void saveInFirstErrorCause(final eErrorCause error, 
	    final String line) {
	if (groupByFirstErr == null) {
	    groupByFirstErr = new HashMap<eErrorCause, List<String>>();
	}

	// Keep it first error cause
	eErrorCause key = error;
	if (groupByFirstErr.get(key) == null) {
	    groupByFirstErr.put(key, new ArrayList<String>());
	}
	groupByFirstErr.get(key).add(line);
    }

    /**
     * Guarda en los mapas la linea pasada agrupada por el error.
     * 
     * @param error
     *            Error que tiene la linea. (NONE si no hay error)
     * @param line
     *            Linea tratada
     */
    private void saveInAllErrorCause(final eErrorCause error, 
	    final String line) {
	if (groupByAllErr == null) {
	    groupByAllErr = new HashMap<eErrorCause, List<String>>();
	}

	eErrorCause key = error;
	if (groupByAllErr.get(key) == null) {
	    groupByAllErr.put(key, new ArrayList<String>());
	}
	groupByAllErr.get(key).add(line);
    }

    /**
     * Crea las carpetas necesarias para el programa.
     * @return false si ha habido error
     */
    private boolean checkFolders() {
	Boolean res = true;	

	//carpeta de entrada
	if (null == ClsUtilsFicheros.createFolder(ClsUtilsConstantes.PATH_PROJECT, 
		Constantes.NAME_FOLDER_SOURCE)) {
	    res = false;
	}

	//carpeta de salida
	if (null == ClsUtilsFicheros.createFolder(ClsUtilsConstantes.PATH_PROJECT, 
		Constantes.NAME_FOLDER_OUTPUT)) {
	    res = false;
	}

	return res;
    }

    /**
     * Crea una lista con los registros duplicados.
     * 
     * @param lstPersonas List<String> Listado con los objetos de persona
     * @return HashMap<String, List<String>> vacío si no hay duplicados
     */
    private HashMap<String, List<Persona>> getListDuplicated(
	    final List<Persona> lstObjPersonas) {

	HashMap<String, List<Persona>> mapDuplicados = 
		new HashMap<String, List<Persona>>();

	//agrupo por DNI
	HashMap<String, List<Persona>> map = new HashMap<String, List<Persona>>();	
	for (Persona persona : lstObjPersonas) {
	    String key = persona.getDni();
	    if (map.get(key) == null) {
		map.put(key, new ArrayList<Persona>());
	    }
	    map.get(key).add(persona);
	}

	//recorro encontrando duplicados
	for (Entry<String, List<Persona>> lst : map.entrySet()) {
	    //compruebo si tiene más de un elementos en la lista
	    if (lst.getValue().size() > 1) {
		//añado al mapa
		mapDuplicados.put(lst.getKey() , lst.getValue());
	    }

	}

	return mapDuplicados;
    }

    
    
    
    
    
    /**
     * Initial main for actions.
     * 
     * @param args Argumentos de entrada
     * @throws Exception 
     */
    public static void main(final String[] args) {
	
	
        
	
	Actions objAction = null;
	Boolean continuar = false;

	//instanciamos la lógica
	try {	    
	    objAction = new Actions();
	} catch (Exception e2) {
	    C_LOG.showFail(e2, true);
	}

	//construimos la ruta del fichero de entrada
	String filePath = ClsUtilsFicheros.combinarRutas(
		Constantes.PATH_SOURCE, Constantes.NAME_FILE_SOURCE);

	//Abrimos el fichero
	if (objAction != null) {
	    try {


		//informamos
		ClsUtilsUI.showNoModalInformation("Se procesará el fichero: " + filePath, "Migración");

		//actuamos		
		objAction.readFile(filePath);
		
		//si no hay exception, continuamos con el proceso
		continuar = true;

	    } catch (Exception e1) {
		C_LOG.showFail("No se ha podido cargar el fichero de entrada",e1, true);
	    }

	    //continuamos con el proceso
	    if (continuar) {
		try {
		    // iniciamos el proceso
		    objAction.startProcess();

		    // creamos el fichero de líneas Incorrectas
		    Output.createErrorsFile(objAction.getAgrupedLinesByFirstError());

		    // creamos el fichero con las correctas
		    Output.createCorrectFile(objAction);

		    // creamos el fichero de duplicados
		    Output.createDuplicatedFile(objAction);

		    // Creamos el fichero de estadísticas
		    Output.createStadisticFile(objAction);

		    C_LOG.SetLOG("Migración finalizada.", Level.INFO);
		    
		    String path = ClsUtilsFicheros.combinarRutas(Constantes.PATH_OUTPUT, Constantes.NAME_FILE_ESTADISTICAS);
		    
		    C_LOG.SetLOG(ClsUtilsFicheros.readFile2(path), Level.INFO);

		} catch (Exception e) {
		   C_LOG.showFail(e, true);
		}

	    }


	}

    }
    
    
    
    
   
    
    
    
    


}
