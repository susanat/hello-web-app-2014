package com.ipartek.formacion.helloweb.temp;

import javax.servlet.http.HttpServlet;

public class ShutdownExample extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6984558964989142994L;
	
	private int serviceCounter = 0;    
	
	//Access methods for serviceCounter   
	public synchronized void enteringServiceMethod() {		serviceCounter++;    }    
	public synchronized void leavingServiceMethod() {		serviceCounter--;    }    
	protected synchronized int numServices() {		return serviceCounter;} 
	

}
