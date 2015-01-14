package com.ipartek.formacion.busredsociales;

import javax.servlet.ServletContext;

public abstract class CriticalStep {

	private boolean status = false;
	
	public boolean getStatus() {
		return status;
	}
	
	public void setStatus(boolean setStatus) {
		status = setStatus;
	}
			
	public abstract void setConfiguration(ServletContext context) throws Exception;
	
	public abstract boolean checkConfiguration(ServletContext context) throws Exception;
	
	
}
