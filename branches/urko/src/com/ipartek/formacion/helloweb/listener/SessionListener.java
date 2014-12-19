package com.ipartek.formacion.helloweb.listener;

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
	// Logger logger = Logger.getAnonymousLogger();
	// logger.log(Level.INFO, "Atribute Added" + se.getName(), se);
	if (se.getName().equals(Constante.USER_SESSION)) {
	    Persona usuario = (Persona) se.getValue();
	    log.trace("Nuevo usuario registrado: " + usuario.toString());
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
	log.trace(se + " fijado el tiempo maximo de la session");
	HttpSession session = se.getSession();
	session.setMaxInactiveInterval(60 * 30);
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
	String motivo = "";

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
