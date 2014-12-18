package com.ipartek.formacion.helloweb.controller;

import java.io.IOException;
import java.net.MalformedURLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.ipartek.formacion.helloweb.bean.Persona;
import com.ipartek.formacion.helloweb.listener.InitListener;
import com.ipartek.formacion.helloweb.model.ModeloPersona;
import com.ipartek.formacion.helloweb.model.interfaces.IModeloPersona.onModelPersonaError;
import com.ipartek.formacion.helloweb.temp.ShutdownExample;

public class CustomServlet extends HttpServlet {

	public Logger log = null;
	public Object nameClass = "";
	 
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8432805520586334696L;

	public CustomServlet() {
		super();
		
		//this.nameClass = obj.getClass();		
	}

	
	@Override
	public void init(ServletConfig config) throws ServletException {		
		super.init(config);
		
		loadLog4j(config);
	}
	



	/**
     * Carga la configuración de log4j
     */
    private void loadLog4j(ServletConfig config) {    	
    	//PropertyConfigurator.configure("C:\\desarrollo\\Web\\apache-tomcat-6.0.43\\webapps\\HelloWeb\\WEB-INF\\conf\\log4j.properties");
    	
    	//creamos el logger con el nombre de la clase pasado
    	log = Logger.getLogger(nameClass.getClass());
    	
    	ServletContext context = config.getServletContext();    	
    	
    	try {
    		
    		//System.setProperty("my.log", context.getRealPath("/") + "/trazas.log");
    		
    		//java.net.URL resourceUrl = context.getResource("/WEB-INF/conf/log4j.properties");
			//PropertyConfigurator.configure(resourceUrl);
    		
    		
    		//PropertyConfigurator.configure("C:\\desarrollo\\Web\\apache-tomcat-6.0.43\\webapps\\HelloWeb\\WEB-INF\\conf\\log4j.properties");
    		
    		
    		String path = context.getRealPath("/") + "WEB-INF\\conf\\log4j.properties";
    		PropertyConfigurator.configure(path);
    		
    		
    		
			log.info("Iniciado log servlet: " + nameClass);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	    	
    	
    	log.info("LOG cargado del customServlet");
    	InitListener.log.info("LOG cargado del customServlet");
    }
	
}
