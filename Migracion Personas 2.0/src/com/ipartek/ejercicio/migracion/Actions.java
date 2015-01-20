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








import org.apache.log4j.Level;

import com.ipartek.ejercicio.migracion.Constantes.eErrorCause;
import com.ipartek.ejercicio.migracion.dao.factoria.DAOException;
import com.ipartek.ejercicio.migracion.dao.factoria.DAOFactory;
import com.ipartek.ejercicio.migracion.dao.interfaz.IPersonaDAO;
import com.ipartek.ejercicio.migracion.object.Persona;
import com.ipartek.ejercicio.migracion.utils.C_LOG;
import com.ipartek.ejercicio.migracion.utils.ClsUtilsConstantes;
import com.ipartek.ejercicio.migracion.utils.ClsUtilsFechas;
import com.ipartek.ejercicio.migracion.utils.ClsUtilsFicheros;
import com.ipartek.ejercicio.migracion.utils.ClsUtilsUI;


/**
 * Lígica del proceso de checkeo de datos.
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
     * Agrupa las lineas por tipo de error, una  lÃ­nea solo aparecerÃ© una vez y
     * solo con el primer tipo de error encontrado.
     */
    private HashMap<eErrorCause, List<String>> groupByFirstErr = null;

    /**
     * Agrupa las lineas por tipo de error, pero estas lÃ­neas pueden aparecer en
     * mÃ¡s de un error.
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
    public final List<Persona> getLstPersonas() {	
	return lstPersonas;
    }

    /**
     * Obtiene la lista de duplicados agrupados por dni.
     * 
     * @return HashMap<String, List<Persona>> con la lista de duplicados 
     * agrupados por DNI
     */
    public final HashMap<String, List<Persona>> getGroupDuplicated() {
	return new HashMap<String, List<Persona>>(groupDuplicated);
    }

    /**
     * Get the time of process.
     * 
     * @return Long with milliseconds
     */
    public final Long getTimeLapsedMiliseconds() {
	return miliseconds;
    }

    /**
     * Get the size of lines in file.
     * 
     * @return Integer number of lines or null if not yet read;
     */
    public final Integer getCountLines() {
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
    public final List<String> getLinesByFirstError(
	    final eErrorCause errorCause) {
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
    public final HashMap<eErrorCause, 
    List<String>> getAgrupedLinesByFirstError() {

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
    public final Integer getNumberOfLinesByFirstError(
	    final eErrorCause errorCause) {

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
    public final Integer getNumberOfLinesByAllError(
	    final eErrorCause errorCause) {

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
    public final Integer getCountLinesWithErrors() {
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
    public final void readFile(final String filePath) throws Exception {
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
    public final void startProcess() throws Exception {

	final Date fInicial = new Date();

	try {
	 // for each line
		for (final String line : strFile) {
		    // System.out.println(line + ClsUtilsConstantes.SALTO_DE_LINEA);
		    // Check each line for errors, if not, next line
		    if (isCorrectLine(line)) {
			createObject(line);
		    }
		}

		//creamos los duplicados si existen datos de persona
		if (lstPersonas != null) {
		    groupDuplicated = getListDuplicated(lstPersonas);
		}

		//System.out.println("final proceso");
		miliseconds = ClsUtilsFechas.diferenciaHoras(fInicial, new Date())
			.getDiffMilisegundos();

		
		//solo informamos en log
		C_LOG.setLOG("Lectura y clasificación de datos finalizada" , Level.TRACE);
		
	} catch (Exception ex) {
	    throw ex;
	}
		
    }

    /**
     * Check if is correct field.
     * 
     * @param line String Line to check
     * @return first false if not is correct, true if yes.
     */
    private boolean isCorrectLine(final String line) throws Exception {

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
     * Obtiene el modelo de persona de la factoria.
     * @return IPersonaDAO con el modelo de la persona
     * @throws Exception Excepción genÃ©rica por algÃºn fallo
     */
    public static IPersonaDAO getModelPersona() throws Exception {

	DAOFactory factoria = null;
	
	try {

	    // Obtenemos la factoria relativa al motor utilizado para el
	    // almacenamiento de datos.
	    factoria = DAOFactory
		    .getDaoFactoriaAbstracta(Globales.GLOBAL_MOTOR);

	    // obtenemos los modelos
	    IPersonaDAO modelUsuario = factoria.getPersonaDAO();

	    // testeamos la conexión de todos los modelos
	    if (factoria.checkConnection()) {
		return modelUsuario;
	    } else {
		throw new DAOException("Error en la devolución del modelo de persona");
	    }

	} catch (Exception e) {
	    throw e;
	}

    }
    
    

    /**
     * Crea un objeto con los datos de la linea y comprueba si ístos tienen
     * algín error.
     * 
     * (versiín utilizando reflection, como pruebas)
     * @see 
     * http://www.mkyong.com/java/how-to-use-reflection-to-call-java-method-at-runtime/
     * @param line String with line
     * 
     */
    private void createObject(final String line) throws Exception {

	String[] splitLine = line.split(Constantes.STR_SEPARATOR);	

	// String parameter para aíadir en caso que se pase valores tipo string
	Class[] paramString = new Class[1];
	paramString[0] = String.class;


	Class cls = null; //clase dinímica
	Object obj = null; //objeto que se crearí
	Method method = null; //contendrí el mítodo a invocar
	String functionName = null; //nombre de la funciín
	String parameter = ""; //parímetros a pasar en la funciín

	try {
	    // creamos el objeto por su nombre.
	    cls = Class.forName(Constantes.PATH_OBJECT_PERSONAS);
	    obj = cls.newInstance();
	    for (int i = 0; i < Constantes.NUM_EXPECTED_FIELDS; i++) {
		//obtenemos la funciín relativa al índice
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

	    //aíadimos el objeto a la lista
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
	    throw e;
	} catch (InstantiationException e) {
	    e.printStackTrace();
	    throw e;
	} catch (IllegalAccessException e) {
	    e.printStackTrace();
	    throw e;
	} catch (NoSuchMethodException e) {
	    e.printStackTrace();
	    throw e;
	} catch (SecurityException e) {
	    e.printStackTrace();
	    throw e;
	} catch (IllegalArgumentException e) {
	    e.printStackTrace();
	    throw e;
	} catch (InvocationTargetException e) {
	    e.printStackTrace();
	    throw e;
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
     * @param lstObjPersonas List<String> Listado con los objetos de persona 
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
	    //compruebo si tiene mís de un elementos en la lista
	    if (lst.getValue().size() > 1) {
		//aíado al mapa
		mapDuplicados.put(lst.getKey() , lst.getValue());
	    }

	}

	return mapDuplicados;
    }

    
    /**
     * Convierte un string en objeto persona.
     * (la fila ya ha sido verificada)
     * @param linea String con los datos de la persona
     * @return Objeto persona
     * @throws Exception 
     */
    private static Persona stringToPersona(final String linea) 
	    throws Exception {
	
	Persona obj = null;
   
	try {
	    String[] splitLine = linea.split(Constantes.STR_SEPARATOR);
	    
	    obj = new Persona();
	    
	    obj.setNombre(splitLine[0]);
	    obj.setApellido1(splitLine[1]);
	    obj.setPoblacion(splitLine[2]);
	    obj.setEdad(splitLine[3]);
	    obj.setEmail(splitLine[4]);
	    obj.setDni(splitLine[5]);
	    obj.setCargo(splitLine[6]);
	    
	} catch (Exception ex) {
	    ex.printStackTrace();
	    throw ex;
	}
	   
	return obj;
	
    }
    
    
    /**
     * Inicia el proceso de exportación de las personas correctas
     * a la base de datos.
     * @throws Exception 
     * @param objAction Object type action
     */
    public static void exportToDatabase(final Actions objAction) 
	    throws Exception {
	
	//Â¿que necesito?
	//Necesito el listado con los datos correctos
	List<String> aLines = new ArrayList<String>();
	
	//obtengo las correctas
	if (objAction.getAgrupedLinesByFirstError() != null) {
	    aLines = objAction.getAgrupedLinesByFirstError().get(eErrorCause.NONE);
	}
	
	//TODO: función a parte
	//V 2.0 Excepciones de aÃ±adir a correctas independiente de 
	//que tengan un tipo de error	
	//obtenemos aquellas que han dado error en EDAD
	if (objAction.getAgrupedLinesByFirstError() != null) {
	    
	    //obtenemos los fallos
	    List<String> aLinesExceptions = new ArrayList<String>();
	    aLinesExceptions = 
		    objAction.getAgrupedLinesByFirstError().get(eErrorCause.EDAD);
	    
	    //los aÃ±adimos si existen
	    if (aLinesExceptions != null && aLinesExceptions.size() > 1) {
		aLines.addAll(aLinesExceptions);
		
	    }	    
	}

	
	IPersonaDAO modelPersona = null;
	Persona obj = null;
	
	try {
        	//Necesito el modelo de la persona
        	modelPersona = getModelPersona();
        	
        	
        	//inicio transacción
        	modelPersona.conectarForTransaction();
        	
        	
        	//1, borrar tabla
        	modelPersona.dropTable();
        	//C_LOG.setLOG("Borrado de la tabla correcto.", Level.TRACE);
        	
        	//2, crear tabla
        	modelPersona.createTable();
        	//C_LOG.setLOG("Creación de la tabla correcto.", Level.TRACE);
        	
        	int i = 0;
        	//3, pasar datos
        	for (String linea : aLines) {
        	    i++;
        	    //crear objeto desde la lÃ­nea
        	    obj = null;
        	    obj = stringToPersona(linea);
        	    
        	    //insertar la linea
        	    modelPersona.insert(obj);        	    
        	    
        	}
        	//C_LOG.setLOG("AÃ±adidos a base de datos " + i + " personas.", Level.TRACE);
        	        	
        	//commit transacción
        	modelPersona.setCommit();
	
	} catch (Exception ex) {
	    if (modelPersona != null) {
		modelPersona.setRollback();		
	    }
	    
	    throw ex;
	}
	
    }
    
    
    /**
     * Initial main for actions.
     * 
     * @param args Argumentos de entrada
     * @throws Exception 
     */
    public static void main(final String[] args) {
		
	//construimos la ruta del fichero de entrada
	String filePath = ClsUtilsFicheros.combinarRutas(
			Constantes.PATH_SOURCE, Constantes.NAME_FILE_SOURCE);
		
	Actions objAction = null;
	Boolean continuar = false;

	
	try {
	    ClsUtilsUI.showNoModalInformation(
	    	"Activada migración. Pulse para continuar", "Migración");
	} catch (InterruptedException e3) {	    
	    e3.printStackTrace();
	}
	
	
	//Paso 1. instanciamos el objeto que contiene la lógica
	try {	    
	    //configuramos el log
	    ClsUtilsUI.showNoModalInformation(
		    	"Configuración del log.", "Migración");
	    //C_LOG.configureLog();
	    //C_LOG.setLOG("Llamada al ejecutable", Level.TRACE);
	    ClsUtilsUI.showNoModalInformation(
		    	"Fin configuracion del log.", "Migración");
	    //instanciamos el objeto actions	    
	    objAction = new Actions();
	    //Todo ok, seguimos para delante
	    continuar = true;
	} catch (Exception e2) {	    
	  //informamos del error
	  try {
	    ClsUtilsUI.showNoModalAlert(
	      			"ERROR CRITICO " + e2, "Migración");
        	} catch (InterruptedException e) {
        	    // TODO Auto-generated catch block
        	    e.printStackTrace();
        	}
	    C_LOG.showFail(e2, true);
	    //evitamos que continue el programa
	    continuar = false;
	}

	//Paso 2. Leer fichero
	if (objAction != null && continuar == true) {
	    try {
		//informamos
		ClsUtilsUI.showNoModalInformation(
			"Se abrirá el fichero: " + filePath, "Migración");

		//Abrimos el fichero		
		objAction.readFile(filePath);
		C_LOG.setLOG("Abierto el fichero: " + filePath, Level.INFO);
		
		//si no hay exception, continuamos con el proceso
		continuar = true;	
	    } catch (Exception e1) {	
		try {		   
		    ClsUtilsUI.showNoModalInformation(
			    "Error la lectura del fichero. " + e1 + ClsUtilsConstantes.SALTO_DE_LINEA, "Migración");
		    C_LOG.setLOG("Error en la lectura del fichero.", Level.ERROR);
		} catch (InterruptedException ex) {
		    // TODO Auto-generated catch block
		    ex.printStackTrace();
		}
	    }

	    //continuamos con el proceso de estructuracion de los datos	    
	    if (continuar) {
		try {		    
		    ClsUtilsUI.showNoModalInformation(
				"Se ha iniciado el procesado de datos", "Migración");		    
		    C_LOG.setLOG("Inicio proceso de lectura de los datos del fichero y su tratamiento.", Level.TRACE);
		    // iniciamos el proceso
		    objAction.startProcess();		    
		    C_LOG.setLOG("Fin proceso de estructuración y lectura de los datos del fichero.", Level.TRACE);
		    continuar = true;
		} catch (Exception ex) {	
		    try {		    
			ClsUtilsUI.showNoModalAlert(
				"Error en el procesado de datos. " + ex, "Migración");
			C_LOG.setLOG("Error la estructuración de los datos.", Level.ERROR);					
		    } catch (InterruptedException ex1) {			
			ex1.printStackTrace();				
		    }
		    continuar = false;
		}    
	    }
		    
	    //Exportamos los datos a los ficheros de salida
	    if (continuar) {
		try {	
		    
		    ClsUtilsUI.showNoModalInformation(
				"Salida de datos a ficheros.", "Migración");
		    
		    C_LOG.setLOG("Inicio creación de ficheros.", Level.TRACE);
   		    
		    //creamos el fichero de líneas Incorrectas
		    Output.createErrorsFile(objAction.getAgrupedLinesByFirstError());		  
		    
		    //creamos el fichero con las correctas
		    Output.createCorrectFile(objAction);
		    		    
		    //creamos el fichero de duplicados
		    Output.createDuplicatedFile(objAction);
		    
		    //Creamos el fichero de estadísticas
		    Output.createStadisticFile(objAction);

		    C_LOG.setLOG("Salida a ficheros fichero finalizada.", Level.INFO);
		    
		    String path = ClsUtilsFicheros.combinarRutas(
			    Constantes.PATH_OUTPUT, 
			    Constantes.NAME_FILE_ESTADISTICAS);
		    		    		    
		    C_LOG.setLOG(ClsUtilsFicheros.readFile2(path), Level.INFO);
		} catch (Exception e) {
		    try {
			    C_LOG.showFail(
					"Error en la escritura en fichero", 
					e, false);
			    ClsUtilsUI.showNoModalInformation(
				    "Error en la escritura del fichero", "Migración");
			} catch (InterruptedException ex) {
			    // TODO Auto-generated catch block
			    ex.printStackTrace();
			}
		   continuar = false;
		}

	    }
	}

	//exportamos a la base de datos		
	if (continuar) {
	    
	    try {
		ClsUtilsUI.showNoModalInformation(
			"Se cargarán los datos en Base de datos.", 
			"Carga en Base de datos");
		
		final Date fInicial = new Date();
		
		C_LOG.setLOG("Inicio proceso carga en Base de datos.", Level.INFO);
		exportToDatabase(objAction);
		C_LOG.setLOG("Fin proceso carga en Base de datos.", Level.INFO);
		long miliseconds = ClsUtilsFechas.diferenciaHoras(fInicial, new Date())
			.getDiffSegundos();
		C_LOG.setLOG("Tiempo destinado a BBDD: " + String.valueOf(miliseconds) + " segundos.", Level.INFO);
	    } catch (Exception ex) {
		try {
		    C_LOG.showFail("Error en la carga en base de datos", ex,
			    true);
		    ClsUtilsUI.showNoModalAlert("Error en la carga de base de datos. " + ex, "Migración");
		} catch (InterruptedException ex2) {
		    // TODO Auto-generated catch block
		    ex2.printStackTrace();
		}
		continuar = false;
	    }
	   
	}
	
	
	//informamos
	try {
	    if(continuar == true) {
		ClsUtilsUI.showNoModalInformation("Proceso completado", "Migración");
	    } else {
		ClsUtilsUI.showNoModalAlert("Proceso completado con errores.", "Migración");
	    }
	} catch (InterruptedException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	
    }
    
    
    
    
   
    
    
    
    


}
