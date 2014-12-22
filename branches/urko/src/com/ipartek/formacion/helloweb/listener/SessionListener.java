package com.ipartek.formacion.helloweb.listener;

import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.log4j.Logger;

import com.ipartek.formacion.helloweb.bean.Persona;
import com.ipartek.formacion.helloweb.util.Constante;

/**
 * Application Lifecycle Listener implementation class SessionListener
 *
 */
public class SessionListener implements HttpSessionListener,
	HttpSessionAttributeListener {
    private final static Logger log = Logger.getLogger(SessionListener.class);

    private static int totalActiveSessions = 0;

    public static int getTotalActiveSession() {
	return totalActiveSessions;
    }

    /**
     * Default constructor.
     */
    public SessionListener() {
	// Logger logger = Logger.getAnonymousLogger();
	// logger.log(Level.INFO, "Session Listener Default constructor");
	log.trace("control de session");
    }

    /**
     * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
     */
    @Override
    public void attributeRemoved(final HttpSessionBindingEvent se) {
	// Logger logger = Logger.getAnonymousLogger();
	// logger.log(Level.INFO, "Atribute Deleted" + se.getName(), se);
	if (se.getName().equalsIgnoreCase(Constante.USER_SESSION)) {
	    Persona usuario = (Persona) se.getValue();
	    log.trace("usuario deslogueado: " + usuario.toString());
	}
    }

    /**
     * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
     */
    @Override
    public void attributeAdded(final HttpSessionBindingEvent se) {
	HttpSession session = se.getSession();
	ServletContext context = session.getServletContext();
	ArrayList<Persona> personas = null;
	Persona p = null;

	personas = (ArrayList<Persona>) context
		.getAttribute(Constante.ATT_REGISTERED_USERS);

	if (personas == null) {
	    personas = new ArrayList<Persona>();
	}
	p = (Persona) session.getAttribute(Constante.USER_SESSION);
	if (p != null) {
	    log.trace("Nuevo usuario registrado: " + p.toString());
	    personas.add(p);
	    context.setAttribute(Constante.ATT_REGISTERED_USERS, personas);
	}
    }

    /**
     * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
     */
    @Override
    public void attributeReplaced(final HttpSessionBindingEvent se) {
	// Logger logger = Logger.getAnonymousLogger();
	// logger.log(Level.INFO, "Atribute replaced" + se.getName(), se);
	if (se.getName().equals(Constante.USER_SESSION)) {
	    Persona usuario = (Persona) se.getValue();
	    log.trace("Nuevo usuario Registrado y modificado"
		    + usuario.toString());
	}
    }

    /**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    @Override
    public void sessionCreated(final HttpSessionEvent se) {
	// Logger logger = Logger.getAnonymousLogger();
	HttpSession session = se.getSession();
	log.trace(se + " fijado el tiempo maximo de la session");
	session.setMaxInactiveInterval(60 * 30);
	totalActiveSessions++;
    }

    /**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    @Override
    public void sessionDestroyed(final HttpSessionEvent se) {
	// Logger logger = Logger.getAnonymousLogger();
	// logger.log(Level.INFO, "Session destruida", se);
	// log.trace("El usuario"+);
	HttpSession session = se.getSession();
	ServletContext context = session.getServletContext();
	String motivo = "";
	ArrayList<Persona> personas = null;

	Persona p = null;

	totalActiveSessions--;

	if (destroySessionAsked(session)) {
	    motivo += "Deslogueado";
	} else {
	    motivo += "Destroyed";
	}

	if (null != session.getAttribute(Constante.USER_SESSION)) {
	    Persona usuario = (Persona) session
		    .getAttribute(Constante.USER_SESSION);
	    log.trace(usuario.toString() + " " + motivo);
	} else {
	    log.warn("Usuario anonimo " + motivo);
	}
	personas = (ArrayList<Persona>) context
		.getAttribute(Constante.ATT_REGISTERED_USERS);

	p = (Persona) session.getAttribute(Constante.USER_SESSION);

	personas.remove(p);
	context.setAttribute(Constante.ATT_REGISTERED_USERS, personas);
    }

    private boolean destroySessionAsked(final HttpSession session) {

	boolean asked = false;
	if (session.getAttribute(Constante.USER_LOGOUT_PETICION) != null
		&& (Boolean) session
			.getAttribute(Constante.USER_LOGOUT_PETICION)) {
	    asked = true;
	}

	return asked;
    }
}
