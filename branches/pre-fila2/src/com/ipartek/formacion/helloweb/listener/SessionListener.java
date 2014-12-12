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
public class SessionListener implements HttpSessionAttributeListener,
HttpSessionListener {

    /**
     * Default constructor.
     */
    public SessionListener() {
	System.out.println("SessionListener default Constructor");
    }

    /**
     * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
     */
    public void attributeRemoved(HttpSessionBindingEvent se) {
	System.out.println("Sesion attributeRemoved");
	if (se.getName().equals(Constantes.USER_SESSION)) {
	    System.out.println("Usuario finalizo sesion");
	}
    }

    /**
     * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
     */
    public void attributeAdded(HttpSessionBindingEvent se) {
	System.out.println("Session attributeAdded");
	if (se.getName().equals(Constantes.USER_SESSION)) {
	    Persona usuario = (Persona) se.getValue();
	    System.out.println("Nuevo usuario registrado: "
		    + usuario.toString());
	}
    }

    /**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent se) {
	System.out.println("Session Created");
    }

    /**
     * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
     */
    public void attributeReplaced(HttpSessionBindingEvent se) {
	System.out.println("Session attribute Replaced " + se.getName());
	if (se.getName().equals(Constantes.USER_SESSION)) {
	    Persona usuario = (Persona) se.getValue();
	    System.out.println("Nuevo usuario registrado y modificado: "
		    + usuario.toString());
	}

    }

    /**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent se) {
	System.out.println("Session Destroyed");
    }

}
