package com.ipartek.formacion.helloweb.listener;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.log4j.Logger;

import com.ipartek.formacion.helloweb.Constantes;
import com.ipartek.formacion.helloweb.bean.Persona;

/**
 * Application Lifecycle Listener implementation class SessionListener
 *
 */
public class SessionListener implements HttpSessionAttributeListener, HttpSessionListener {

	private final static Logger log = Logger.getLogger("ACCESOS");

	/**
	 * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
	 */
	public void sessionCreated(final HttpSessionEvent se) {
		System.out.println("---- Llamada al método sessionCreated ----");
		// Marcar tiempo de expiración
		final HttpSession session = se.getSession();
		session.setMaxInactiveInterval(60 * 30);
		log.trace("Nueva session " + session.getId() + " - " + session.getMaxInactiveInterval() + " seg");
	}

	/**
	 * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
	 */
	public void sessionDestroyed(final HttpSessionEvent se) {
		final HttpSession session = se.getSession();
		String msg = "";

		if (session.getAttribute(Constantes.USER_LOGOUT_PETICION) != null) {
			msg = "Logout voluntario";
		} else {
			msg = "Logout expiración";
		}

		if (null != session.getAttribute(Constantes.USER_SESSION)) {
			final Persona usuario = (Persona) session.getAttribute(Constantes.USER_SESSION);
			msg += " usuario " + usuario.toString();
		} else {
			msg += " usuario nulo";
		}

		log.info(msg);
	}

	public void attributeAdded(final HttpSessionBindingEvent se) {
		if (Constantes.USER_SESSION.equalsIgnoreCase(se.getName())) {
			log.trace("attributeAdded");
		}
	}

	public void attributeRemoved(final HttpSessionBindingEvent se) {
		if (Constantes.USER_SESSION.equalsIgnoreCase(se.getName())) {
			log.trace("attributeRemoved");
		}
	}

	public void attributeReplaced(final HttpSessionBindingEvent se) {
		if (Constantes.USER_SESSION.equalsIgnoreCase(se.getName())) {
			log.trace("attributeReplaced");
		}
	}

}
