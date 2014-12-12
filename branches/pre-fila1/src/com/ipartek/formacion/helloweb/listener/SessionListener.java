package com.ipartek.formacion.helloweb.listener;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.ipartek.formacion.helloweb.Constantes;
import com.ipartek.formacion.helloweb.bean.Persona;

/**
 * Application Lifecycle Listener implementation class SessionListener
 *
 */
public class SessionListener implements HttpSessionAttributeListener, HttpSessionListener {

	static final String charset = "javax.servlet.jsp.jstl.fmt.request.charset";	
	
    /**
     * Default constructor. 
     */
    public SessionListener() {
       System.out.println("SessionListener Default Constructor");
    }

/* Eventos sobre los atributos de HttpSession */      
    
	/**
     * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
     */
    public void attributeRemoved(HttpSessionBindingEvent se)  { 
    	System.out.println("Session attributeRemoved");    	
    	//cambiando usuario en sesion
    	if ( se.getName().equals(Constantes.USER_SESSION)){    		
    		System.out.println("Usuario Deslogado");
    	}
    }

	/**
     * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
     */
    public void attributeAdded(HttpSessionBindingEvent se)  { 
    	System.out.println("Session attributeAdded");
    	if ( se.getName().equals(Constantes.USER_SESSION)){
    		Persona usuario = (Persona)se.getValue();
    		System.out.println("Nuevo usario registrado: " + usuario.toString() );
    	}
    }

	

	/**
     * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
     */
    public void attributeReplaced(HttpSessionBindingEvent se)  { 
    	System.out.println("Session attributeReplaced " + se.getName() );
    	//cambiando usuario en sesion
    	if ( se.getName().equals(Constantes.USER_SESSION)){
    		Persona usuario = (Persona)se.getValue();
    		System.out.println("Nuevo usario registrado y modificado: " + usuario.toString() );
    	}
    	
    	
    	
    	
    }

/* Ciclo de Vida de HttpSession */  
    
    /**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent se)  { 
    	System.out.println("Session sessionCreated");
    }
    
	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent se)  { 
    	System.out.println("Session sessionDestroyed");
    }
	
}
