package com.ipartek.formacion.helloweb.listener;

import java.net.MalformedURLException;




import javax.print.DocFlavor.URL;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;





import com.ipartek.formacion.helloweb.comun.Constantes;

/**
 * Application Lifecycle Listener implementation class InitListener
 *
 */
public class InitListener implements ServletContextListener, ServletContextAttributeListener {

	 public final static Logger log = Logger.getLogger(InitListener.class);
	
	
    /**
     * Default constructor. 
     */
    public InitListener() {
        System.out.println("Constructor inicial del listener de Servlet Context");
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
         System.out.println("Iniciado el contexto de los servlet");
         
       //TODO: obtener y conectar los logs
         System.out.println("Iniciada la configuración del log4j de la aplicación");
         loadApplicationLog4j(sce);
                  
       //TODO: obtener y conectar a base de datos
         System.out.println("Iniciada la conexión a base de datos");
         
       //TODO: carga de tablas auxiliares no modificables
         System.out.println("Carga de tablas auxiliares no modificables (tabla de nombres de roles, por ejemplo)");
         
       //TODO: preparación de objetos de estadísticas
         System.out.println("Preparación objetos de estadísticas");
         
    }
    
    
    /**
     * Carga la configuración de log4j
     */
    private void loadApplicationLog4j(ServletContextEvent sce) {    	
    	//PropertyConfigurator.configure("C:\\desarrollo\\Web\\apache-tomcat-6.0.43\\webapps\\HelloWeb\\WEB-INF\\conf\\log4j.properties");
    	
    	ServletContext context = sce.getServletContext();    	
    	
    	try {
    		
    		System.setProperty("my.log", context.getRealPath("/") + "/HelloWeb/aplicacion.log");
    		
    		java.net.URL resourceUrl = context.getResource("/WEB-INF/conf/log4j.properties");
			PropertyConfigurator.configure(resourceUrl);
			
			
			if(! LogManager.getCurrentLoggers().hasMoreElements()) {
				//TODO: significa que no se han cargado los logs por alguna razón
				System.out.println("Error en la carga del log");
			}
					
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    	
    	log.info("LOG de aplicación en el InitListener cargado y configurado");
    }
    
    

	/**
     * @see ServletContextAttributeListener#attributeAdded(ServletContextAttributeEvent)
     */
    public void attributeAdded(ServletContextAttributeEvent scab)  {
    	ServletContext context = scab.getServletContext(); 
    	
    	
    	//System.out.println("Añadido atributo context: " + scab.getName() + context.getAttribute(scab.getName()));
    }

	/**
     * @see ServletContextAttributeListener#attributeReplaced(ServletContextAttributeEvent)
     */
    public void attributeReplaced(ServletContextAttributeEvent scab)  { 
    	ServletContext context = scab.getServletContext(); 
    	//System.out.println("Modificado atributo context: " + scab.getName() + context.getAttribute(scab.getName()));
    }

	/**
     * @see ServletContextAttributeListener#attributeRemoved(ServletContextAttributeEvent)
     */
    public void attributeRemoved(ServletContextAttributeEvent scab)  { 
    	ServletContext context = scab.getServletContext(); 
    	//System.out.println("Eliminado atributo context: " + scab.getName() + context.getAttribute(scab.getName()));
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
    	//System.out.println("Destruido el contexto de los servlet");
    	
    	//TODO cerrar conexión a base de datos
    	//System.out.println("Cerrada la conexión a base de datos");
    	
    	//TODO liberar memoria y cerrar 
    }
	
}
