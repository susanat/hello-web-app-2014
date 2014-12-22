package com.ipartek.formacion.helloweb.listener;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.log4j.Logger;

import com.ipartek.formacion.helloweb.Constantes;
import com.ipartek.formacion.helloweb.bean.Persona;
import com.ipartek.formacion.helloweb.util.ERole;

/**
 * Application Lifecycle Listener implementation class SessionListener
 *
 */
public class SessionListener implements HttpSessionAttributeListener, HttpSessionListener {

	private final static Logger log = Logger.getLogger("ACCESOS");

	private static ArrayList<HttpSession> sessions = new ArrayList<HttpSession>();

	/**
	 * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
	 */
	public void sessionCreated(final HttpSessionEvent se) {
		System.out.println("---- Llamada al método sessionCreated ----");
		// Marcar tiempo de expiración
		final HttpSession session = se.getSession();
		session.setMaxInactiveInterval(60 * 30);
		log.trace("Nueva session " + session.getId() + " - " + session.getMaxInactiveInterval() + " seg");

		sessions.add(session);
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

		sessions.remove(session);
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

	public synchronized static int getCount() {
		return ((sessions != null) && (sessions.size() > 0)) ? sessions.size() : 0;
	}

	public synchronized static ArrayList<HttpSession> getSessions() {
		return sessions;
	}

	public synchronized static ArrayList<Persona> getSessionsByRole(final ERole role) {
		final ArrayList<Persona> usuarios = new ArrayList<Persona>();
		int index = 0;

		if ((sessions != null) && (sessions.size() > 0)) {
			for (final HttpSession session : sessions) {
				final Persona usuario = (Persona) session.getAttribute(Constantes.USER_SESSION);

				if (usuario != null) {
					if (usuario.getRole().getNombre().equalsIgnoreCase(role.toString())) {
						usuarios.add(index++, usuario);
					}
				}
			}
		}
		return usuarios;
	}

}
