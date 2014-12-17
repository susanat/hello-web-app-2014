package com.ipartek.formacion.helloweb.listener;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

//NO IMPLEMENTADA
//Lo siguiente es lo que se pondría en cada servlet
//SessionCounter counter = SessionCounter.getInstance(getServletContext());
//int count = counter.getCount("127.0.0.1");
/**
 * Application Lifecycle Listener implementation class SessionCounter
 *
 */
public class SessionCounter implements HttpSessionListener, ServletContextListener, ServletRequestListener {

	private static final String ATTR_SESSION_COUNT = "sessionCount";

	private Map<HttpSession, String> sessions = new ConcurrentHashMap<HttpSession, String>();

	public void contextInitialized(final ServletContextEvent event) {
		event.getServletContext().setAttribute(ATTR_SESSION_COUNT, this);
	}

	public void requestInitialized(final ServletRequestEvent event) {
		final HttpServletRequest request = (HttpServletRequest) event.getServletRequest();
		final HttpSession session = request.getSession();
		if (session.isNew()) {
			sessions.put(session, request.getRemoteAddr());
		}
	}

	public void sessionDestroyed(final HttpSessionEvent event) {
		sessions.remove(event.getSession());
	}

	public void sessionCreated(final HttpSessionEvent event) {
		// NOOP. Useless since we can't obtain IP here.
	}

	public void requestDestroyed(final ServletRequestEvent event) {
		// NOOP. No logic needed.
	}

	public void contextDestroyed(final ServletContextEvent event) {
		// NOOP. No logic needed. Maybe some future cleanup?
	}

	public static SessionCounter getInstance(final ServletContext context) {
		return (SessionCounter) context.getAttribute(ATTR_SESSION_COUNT);
	}

	public int getCount(final String remoteAddr) {
		return Collections.frequency(sessions.values(), remoteAddr);
	}

}
