package com.ipartek.formacion.helloweb.listener;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.ipartek.formacion.helloweb.comun.Constantes;

/**
 * Application Lifecycle Listener implementation class SessionListener
 *
 */
public class SessionListener implements HttpSessionListener, HttpSessionAttributeListener {

    /**
     * Default constructor. 
     */
    public SessionListener() {
    	//System.out.println("Constructor creado del listener session listener");
    }

	/**
     * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
     */
    public void attributeRemoved(HttpSessionBindingEvent se)  { 
         //System.out.println("attribute removed: " + se.getName());
    }

	/**
     * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
     */
    public void attributeAdded(HttpSessionBindingEvent se)  { 
    	
    	HttpSession session = se.getSession();
    	
    	//System.out.println("attribute added: " + se.getName() + " " + session.getAttribute(se.getName()));
    }

	/**
     * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
     */
    public void attributeReplaced(HttpSessionBindingEvent se)  { 
    	HttpSession session = se.getSession();
    	
    	//System.out.println("attribute replaced: " + se.getName() + " " + session.getAttribute(se.getName()));
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent se)  { 
    	
    	HttpSession session = se.getSession();
    	//System.out.println("session created: " + session.getId() + " " + session.getCreationTime());
    	if(session.getAttribute(Constantes.PARAM_SESSION_AUTHENTICATED) != null) {
    		//System.out.println(session.getAttribute(Constantes.PARAM_SESSION_AUTHENTICATED));
    	}
    		
    		
    		
    	
    	
    	//añadimos timeout, un minuto para pruebas
    	session.setMaxInactiveInterval(30*60);
    	
    	
         
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent se)  { 
    	HttpSession session = se.getSession();
    	//System.out.println("session removed: " + session.getId() + " Creado el: " + session.getCreationTime() + "Causa?: " + se.getSource().toString());
    }
	
}
