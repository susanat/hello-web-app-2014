package com.ipartek.formacion.helloweb.listener;

import javax.servlet.http.HttpSession;
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
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent se) {

	// marcar el tiempo de expiracion 30 minutos
	HttpSession session = se.getSession();
	session.setMaxInactiveInterval(3);
	System.out.println("Nueva sesion ID:" + session.getId()
		+ " Intervalo expiracion: " + session.getMaxInactiveInterval());

    }

    /**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent se) {
	HttpSession session = se.getSession();
	String motivo = "";
	if (session.getAttribute(Constantes.LOGOUT_CAUSE) != null) {
	    motivo = "Logout a peticion del usuario";

	} else {
	    motivo = "Expiracion de la sesion";
	}

	if (session.getAttribute(Constantes.USER_SESSION) != null) {
	    Persona usuario = (Persona) (session
		    .getAttribute(Constantes.USER_SESSION));
	    System.out.println(motivo + " " + usuario.toString());
	} else {
	    System.out.println(motivo + " usuario nulo");
	}

    }

    public void attributeAdded(HttpSessionBindingEvent se) {
	if (Constantes.USER_SESSION.equalsIgnoreCase(se.getName())) {
	    System.out.println("Atributo añadido");
	}
    }

    public void attributeRemoved(HttpSessionBindingEvent se) {
	if (Constantes.USER_SESSION.equalsIgnoreCase(se.getName())) {
	    System.out.println("Atributo removido");
	}
    }

    public void attributeReplaced(HttpSessionBindingEvent se) {
	if (Constantes.USER_SESSION.equalsIgnoreCase(se.getName())) {
	    System.out.println("Atributo reemplazado");
	}
    }

}
