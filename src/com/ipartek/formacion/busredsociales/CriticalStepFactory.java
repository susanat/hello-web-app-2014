package com.ipartek.formacion.busredsociales;

import javax.servlet.ServletContext;

import com.ipartek.formacion.busredsociales.CriticalStepLogic.ETypeCriticalError;

/**
 * Esta clase abstracta contiene las funciones básica para el control de los pasos
 * críticos al inicio del programa.
 * 
 * @author Sergio Rubio Nieto
 *
 */
public abstract class CriticalStepFactory {

	private boolean status = false;
	
	public boolean getStatus() {
		return status;
	}
	
	public void setStatus(boolean setStatus) {
		status = setStatus;
	}
	
	public abstract ETypeCriticalError getTypeError();
			
	public abstract void setConfiguration(ServletContext context) throws Exception;
	
	public abstract boolean checkConfiguration(ServletContext context) throws Exception;
	
	
}
