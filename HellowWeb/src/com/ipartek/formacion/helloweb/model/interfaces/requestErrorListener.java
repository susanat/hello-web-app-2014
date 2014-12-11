package com.ipartek.formacion.helloweb.model.interfaces;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

import com.ipartek.formacion.helloweb.bean.Message;
import com.ipartek.formacion.helloweb.comun.Constantes;

/**
 * Application Lifecycle Listener implementation class requestErrorListener
 *
 */
public class requestErrorListener implements ServletRequestListener, ServletRequestAttributeListener {

    /**
     * Default constructor. 
     */
    public requestErrorListener() {
        
    }

	/**
     * @see ServletRequestListener#requestDestroyed(ServletRequestEvent)
     */
    public void requestDestroyed(ServletRequestEvent sre)  { 
         
    }

	/**
     * @see ServletRequestAttributeListener#attributeAdded(ServletRequestAttributeEvent)
     */
    public void attributeAdded(ServletRequestAttributeEvent srae)  { 
    	
    	if(srae.getName().equals(Constantes.ATTR_ERROR)) {
    		
    		Message msj = (Message) srae.getServletRequest().getAttribute(srae.getName());    		
    		
    		
    		if(msj.isError()) {
    			System.out.println("Error: " + msj.getText());
    		} else {
    			System.out.println("Petición sin error");
    		}
    		
    		
    	}
    }

	/**
     * @see ServletRequestAttributeListener#attributeRemoved(ServletRequestAttributeEvent)
     */
    public void attributeRemoved(ServletRequestAttributeEvent srae)  { 
        
    }

	/**
     * @see ServletRequestAttributeListener#attributeReplaced(ServletRequestAttributeEvent)
     */
    public void attributeReplaced(ServletRequestAttributeEvent srae)  { 
    	
    }

	/**
     * @see ServletRequestListener#requestInitialized(ServletRequestEvent)
     */
    public void requestInitialized(ServletRequestEvent sre)  { 
         
    }
	
}
