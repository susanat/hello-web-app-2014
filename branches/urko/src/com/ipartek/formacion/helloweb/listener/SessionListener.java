package com.ipartek.formacion.helloweb.listener;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.ipartek.formacion.helloworld.bean.Persona;
import com.ipartek.formacion.helloworld.util.Constante;

/**
 * Application Lifecycle Listener implementation class SessionListener
 *
 */
public class SessionListener implements HttpSessionListener,
	HttpSessionAttributeListener {

    /**
     * Default constructor.
     */
    public SessionListener() {
	Logger logger = Logger.getAnonymousLogger();
	logger.log(Level.SEVERE, "Session Listener Default constructor");
    }

    /**
     * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
     */
    @Override
    public void attributeRemoved(final HttpSessionBindingEvent se) {
	Logger logger = Logger.getAnonymousLogger();
	logger.log(Level.SEVERE, "Atribute Deleted" + se.getName(), se);
	if (se.getName().equals(Constante.USER_SESSION)) {
	    Persona usuario = (Persona) se.getValue();
	    System.out.println("usuario borrado: " + usuario.toString());
	}
    }

    /**
     * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
     */
    @Override
    public void attributeAdded(final HttpSessionBindingEvent se) {
	Logger logger = Logger.getAnonymousLogger();
	logger.log(Level.SEVERE, "Atribute Added" + se.getName(), se);
	if (se.getName().equals(Constante.USER_SESSION)) {
	    Persona usuario = (Persona) se.getValue();
	    System.out.println("Nuevo usuario registrado: "
		    + usuario.toString());
	}
    }

    /**
     * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
     */
    @Override
    public void attributeReplaced(final HttpSessionBindingEvent se) {
	Logger logger = Logger.getAnonymousLogger();
	logger.log(Level.SEVERE, "Atribute replaced" + se.getName(), se);
	if (se.getName().equals(Constante.USER_SESSION)) {
	    Persona usuario = (Persona) se.getValue();
	    System.out.println("Nuevo usuario Registrado y modificado"
		    + usuario.toString());
	}
    }

    /**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    @Override
    public void sessionCreated(final HttpSessionEvent se) {
	Logger logger = Logger.getAnonymousLogger();
	logger.log(Level.SEVERE, "Session creada", se);
    }

    /**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    @Override
    public void sessionDestroyed(final HttpSessionEvent se) {
	Logger logger = Logger.getAnonymousLogger();
	logger.log(Level.SEVERE, "Session destruida", se);
    }

}
