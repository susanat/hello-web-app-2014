package com.ipartek.formacion.helloweb.comun;

import java.util.Date;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.RollingFileAppender;

public class C_LOG {
    
    public enum EDestinoLog {
    	SERVER,
    	SITE	
    }
        
    private EDestinoLog destino;
    private Level level;
        
    public static final String LOG_PROPERTIES_PATH = "";
    public static final String LOG_PROPERTIES_NAME = "\\log4j.properties";
    public static final String LOG_PROPERTIES_FILE = LOG_PROPERTIES_PATH + LOG_PROPERTIES_NAME;
    
    
    private static Logger LOG = null;
    
    static {
        
        LOG = Logger.getLogger(C_LOG.class);			
	
	
	//añadimos el fichero
	System.setProperty("my.log", "\\migracion.log");
	
	System.out.println(System.getProperty("my.log"));
	
	PropertyConfigurator.configure(LOG_PROPERTIES_FILE);
	
	LOG.info("Inicio LOG: " + new Date());
	
	
    }
    
    public static void SetLOG(String message, Level level ){	
	if (level == Level.DEBUG) {
	    if (LOG.isDebugEnabled()){
		LOG.log(level, message);
	    }
	}else{
	    LOG.log(level, message);
	}
    }
    
    public static void SetLOG(String message, Exception ex){	
		
	
	message += Constantes.SALTO_DE_LINEA;		    
	message += "Mensaje: " + ex.getMessage().toString();
	message += Constantes.SALTO_DE_LINEA;
	message += "StackTrace: " + ex;
	
	
	LOG.error(message);
	
	
    }
    
    public static void showFail(String mensaje, Exception ex){
	
    	C_LOG.SetLOG(mensaje, ex);
	
    }
    
    public static void showFail(Exception ex){
	
	
    }
    

}
