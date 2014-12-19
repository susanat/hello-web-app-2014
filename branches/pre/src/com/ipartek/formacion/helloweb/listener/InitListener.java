package com.ipartek.formacion.helloweb.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;




import com.ipartek.formacion.helloweb.Constantes;
import com.ipartek.formacion.helloweb.model.ModeloCalificacion;
import com.ipartek.formacion.helloweb.model.ModeloPersona;
import com.ipartek.formacion.helloweb.model.ModeloRol;

/**
 * Application Lifecycle Listener implementation class InitListener
 *
 */
public class InitListener implements ServletContextListener,
		ServletContextAttributeListener {

	private final static Logger log = Logger.getLogger(InitListener.class);
	
	public static boolean LOAD_ERROR = false;
	public static String  LOAD_ERROR_MSG = null;
	
	public static final String PATH_LOG4J = "WEB-INF/conf/log4j.properties";
	
	public static ModeloPersona modelPersona = null;
	public static ModeloRol modelRole = null;
	public static ModeloCalificacion modelCalificacion = null;
	

	/**
	 * @see ServletContextListener#contextInitialized(ServletContextEvent)
	 */
	public void contextInitialized(ServletContextEvent sce) {
		
			
		loadLog4j( sce );
		
		if ( !LOAD_ERROR ){
			
						
			//TODO establecer conexion
			log.info("Establecer conexion BBDD OK");
			// TODO cargar modelos de datos
			initModelPersona();
			initModelCalificacion();
			initModelRole();
			log.info("Mode lo Persona Cargardo");
			
			initContadoresSessionesUsuarios(sce);
			
			
		}else{
			System.out.println("Error cargando LOG4J");
		}		

		
		
	} 

	
	 private void initContadoresSessionesUsuarios(ServletContextEvent sce) {
		sce.getServletContext().setAttribute(Constantes.USER_ADMIN_CONT, 0);
		sce.getServletContext().setAttribute(Constantes.USER_USER_CONT, 0);		
	}


	private void initModelRole() {
			// TODO Auto-generated method stub
			modelRole = new ModeloRol();
			ModeloRol.createTable();

	    }
	
	
	/**
	 * Cargar la configuracion de Log4J
	 * @param sce 
	 */
	private void loadLog4j(ServletContextEvent sce) {
		
		try{
			String pathReal = sce.getServletContext().getRealPath("/");
			PropertyConfigurator.configure(pathReal + PATH_LOG4J );
			//check configration, si apender == null ha fallado la carga de cofiguración			
			if ( null == LogManager.exists("ACCESOS") ){
				LOAD_ERROR = true;
				LOAD_ERROR_MSG = Constantes.MSG_ERR_LOAD_LOG4J + " path: " + pathReal + PATH_LOG4J;
			}			
			log.debug("LOG cargado");
		}catch( Exception e ){
			e.printStackTrace();			
		}	
		
	}

	/**
	 * @see ServletContextListener#contextDestroyed(ServletContextEvent)
	 */
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("Destruyendo Contexto Servlet");
		// TODO cerrar conexion bbdd
		System.out.println("Desconexion BBDD OK");
		// TODO liberar memoria y poner a null varaibles
		System.out.println("Liberado memoria");
		modelPersona = null;
		
		initContadoresSessionesUsuarios(sce);

	}

	/**
	 * @see ServletContextAttributeListener#attributeAdded(ServletContextAttributeEvent)
	 */
	public void attributeAdded(ServletContextAttributeEvent scab) {
		// TODO attributeAdded
	}

	/**
	 * @see ServletContextAttributeListener#attributeReplaced(ServletContextAttributeEvent)
	 */
	public void attributeReplaced(ServletContextAttributeEvent scab) {
		// TODO attributeReplaced
	}

	/**
	 * @see ServletContextAttributeListener#attributeRemoved(ServletContextAttributeEvent)
	 */
	public void attributeRemoved(ServletContextAttributeEvent scab) {
		// TODO attributeRemoved
	}

	private void initModelPersona() {
		modelPersona = new ModeloPersona();
		ModeloPersona.createTable();
	}

	private void initModelCalificacion() {
		modelCalificacion = new ModeloCalificacion();
		ModeloCalificacion.createTable();
	}

}
