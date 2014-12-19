package com.ipartek.formacion.helloweb.listener;

import java.util.Enumeration;
import java.util.HashMap;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.ipartek.formacion.helloweb.bean.CargasTemporales;
import com.ipartek.formacion.helloweb.bean.estadisticas.UserSession;
import com.ipartek.formacion.helloweb.bean.estadisticas.UserSession.ECauseSessionOff;
import com.ipartek.formacion.helloweb.comun.Constantes;
import com.ipartek.formacion.helloweb.comun.Globales;
import com.ipartek.formacion.helloweb.temp.UtilsTemp;

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
    	
    	//añadimos timeout, tiempo en segundos a la sessión
    	session.setMaxInactiveInterval(Globales.SESSION_MAX_MINUTES * 60);
    	
    	//añadimos a la sesión el flag de no estar autentificado
    	session.setAttribute(Constantes.ATTR_SESSION_AUTHENTICATED, false);
    	    	
    	writeDataSessionCreated(session);
    	
    	
    	//Añadimos la sessión a las estadísticas
    	UtilsTemp.setStadistics(session);
    	
    	         
    }

    
	
	

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent se)  { 
    	HttpSession session = se.getSession();    	    	    	
	
    	ECauseSessionOff eCause = writeDataSessionRemoved(session);
    	
    	
    	//Eliminamos la sesión a las estadísticas
    	UtilsTemp.delStadistics(session);
    	
    	
    	//¿Esto se podrá hacer aquí?
    	//si queremos mantener la sessión por expiración
    	if (eCause != null && eCause == ECauseSessionOff.EXPIRED) {
    		//1- comprobamos si existe coockie
    		
    		//2- si existe y tiene lo de recordar creamos nueva sesión para el usuario
    		
    		
    		//3- copiamos los parámetros de la vieja sesión a la nueva
    		
    	} else if(eCause != null && eCause == ECauseSessionOff.LOGOUT) {
    		
    		
    		
    	}
    	
    }
    
    private void writeDataSessionCreated(HttpSession session) {
    	
    	System.out.println();
    	System.out.println("****Session created*******************************************************");
    	System.out.println("* Session id: " + session.getId());
    	System.out.println("* Creation: " + session.getCreationTime());
    	System.out.println("* TimeOut: " + session.getMaxInactiveInterval());
    	System.out.println("* Parameters: ");        		
    	//TODO: añadir modelo para userSession (eliminar fisicamente o no la sesión y  el motivo), en el logout, poner motivo. Si existe un motivo, no sobrescribir
    	Enumeration e = session.getAttributeNames();
    	while (e.hasMoreElements()) {
    		String key = (String)e.nextElement();
    		String value = session.getAttribute(key).toString();
    		System.out.println("* - " + key + " = " + value);
    	}    	
    	System.out.println("**************************************************************************");
    }
    
    private ECauseSessionOff writeDataSessionRemoved(HttpSession session) {
    	
    	UserSession.ECauseSessionOff eCause = null;    	
    	String textCause = "";    	
    	//obtenemos la causa del fin de la sesión
    	if(session.getAttribute(Constantes.ATTR_SESSION_OFF_CAUSE) != null) {
    		eCause = (ECauseSessionOff) session.getAttribute(Constantes.ATTR_SESSION_OFF_CAUSE);
    	}
    	if(eCause != null) {
    		switch (eCause) {
			case EXPIRED:
				textCause = "Sesión expirada";
				break;

			case LOGOUT:
				textCause = "Logout manual";
				break;
			}    		
    	} else {
    		textCause = "Ninguna de las otras opciones (Expirada)";
    	}
    	
    	System.out.println();
    	System.out.println("****Session Removed*******************************************************");
    	System.out.println("* Session id: " + session.getId());
    	System.out.println("* Creation: " + session.getCreationTime());
    	System.out.println("* TimeOut: " + session.getMaxInactiveInterval());
    	System.out.println("* Parameters: ");        		
    	//TODO: añadir modelo para userSession (eliminar fisicamente o no la sesión y  el motivo), en el logout, poner motivo. Si existe un motivo, no sobrescribir
    	Enumeration e = session.getAttributeNames();
    	while (e.hasMoreElements()) {
    		String key = (String)e.nextElement();
    		String value = session.getAttribute(key).toString();
    		System.out.println("* - " + key + " = " + value);
    	}        	
    	
    	System.out.println("* Cause session destroyed: " + textCause);
    	System.out.println("**************************************************************************");
    	
    	return eCause;
    }
    
    
	
}
