package com.ipartek.ejercicio.migracion.utils;

import java.util.Date;
import java.util.Enumeration;

import org.apache.log4j.Appender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.RollingFileAppender;

public final class C_LOG {
    
    private C_LOG(){
	
    }
    
    public static enum EDestinoLog {
	SERVER,
	SITE	
    }
    
    
    private static EDestinoLog destino;
    private static Level level;
        
    public static final String LOG_PROPERTIES_PATH = ClsUtilsConstantes.PATH_PROJECT;
    public static final String LOG_PROPERTIES_NAME = "\\log4j.properties";
    public static final String LOG_PROPERTIES_FILE = LOG_PROPERTIES_PATH + LOG_PROPERTIES_NAME;
        
    private static Logger LOG = null;

    public static void configureLog() throws Exception {

	try {
    
	    /*
	    ClsUtilsUI.showNoModalInformation(
			"Configuraci�n del log: "
				+ ClsUtilsConstantes.SALTO_DE_LINEA
				+ ClsUtilsConstantes.PATH_PROJECT + "\\migracion.log" 
				+ ClsUtilsConstantes.SALTO_DE_LINEA 
				+ LOG_PROPERTIES_FILE, "Migraci�n");
	     */
	    
	    LOG = Logger.getLogger(C_LOG.class);
	    
	    // a�adimos el fichero
	    System.setProperty("my.log", 
		    ClsUtilsConstantes.PATH_PROJECT
		    + "\\migracion.log");

	    //ClsUtilsUI.showNoModalInformation("Modificado el archivo properties","migracion");
	    //System.out.println(System.getProperty("my.log"));

	    PropertyConfigurator.configure(LOG_PROPERTIES_FILE);

	    //ClsUtilsUI.showNoModalInformation("Configurado el archivo properties","migracion");
	    
	    Logger rootLogger = Logger.getRootLogger();	    
	    Enumeration appenders = rootLogger.getAllAppenders();
	    if (!appenders.hasMoreElements()) {
	        System.out.println("LOG4J config file is missing");
	        throw new Exception("Error en la configuraci�n del log");
	    } else {
	        System.out.println("appender found "
	        + ((Appender) appenders.nextElement()).getName());
	    }
	    
	    //ClsUtilsUI.showNoModalInformation("Comprobado el archivo properties","migracion");
	    
	    if(LOG == null) {
		ClsUtilsUI.showNoModalAlert("Error al crear el log.", "Migraci�n");
	    } else {
		LOG.info("Inicio LOG: " + new Date());
	    }
	    
	} catch (Exception ex) {
	    throw ex;
	}

    }
    
    public static void setLOG(final String message, final Level level) {	
	if (level == Level.DEBUG) {
	    if (LOG.isDebugEnabled()){
		LOG.log(level, message);
	    }
	} else {
	    LOG.log(level, message);
	}
    }
    
    public static void setLOG(String message, Exception ex){	
		
	if(ex != null) {
	    message += ClsUtilsConstantes.SALTO_DE_LINEA;		    
	    message += "Mensaje: " + ex.getMessage();
	    message += ClsUtilsConstantes.SALTO_DE_LINEA;
	    message += "StackTrace: " + ex;
	} else {
	    message += ClsUtilsConstantes.SALTO_DE_LINEA;		    
	    message += "Mensaje: " + "Error indeterminado. Excepci�n a null.";
	}
	
	LOG.error(message);
	
	
    }
    
    public static void showFail(String mensaje, Exception ex, boolean showPanel){
	
	C_LOG.setLOG(mensaje, ex);
	
	if (showPanel) {
	    try {
		ClsUtilsUI.showNoModalAlert(mensaje, "Migraci�n");
	    } catch (InterruptedException e) {
		
	    }
	}	
    }
    
    public static void showFail(Exception ex, boolean showPanel){
	showFail(ex.getMessage(), ex, showPanel);
	
    }
    

}
