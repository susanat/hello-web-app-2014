package com.ipartek.formacion;

import java.io.PrintWriter;
import java.io.StringWriter;

public class JsonGenericResponse {

	private boolean error = false;
	private String typeError = "";	
	private String msg = "No Error";	
	private String stackTrace = "";
	
	private Object objeto = null;
		
	public boolean isError() {
		return error;
	}

	public void setError(boolean error) {
		this.error = error;
	}

	public String getTypeError() {
		return typeError;
	}

	public void setTypeError(String typeError) {
		this.typeError = typeError;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getStackTrace() {
		return stackTrace;
	}

	public void setStackTrace(String stackTrace) {
		this.stackTrace = stackTrace;
	}

	public Object getObjeto() {
		return objeto;
	}

	public void setObjeto(Object objeto) {
		this.objeto = objeto;
	}

	public JsonGenericResponse () {}
	
	public JsonGenericResponse(Exception ex) {
		
	}	
	
	public void setException(Exception ex) {
		desgloseEx(ex);				
	}
	
	
	private void desgloseEx(Exception ex) 
	{
		this.error = true;
		this.typeError = ex.getClass().toString();
		this.stackTrace = stackTraceToString(ex);
		this.msg = ex.getMessage();
		
	}
	
	private String stackTraceToString(Exception ex) {		
		StringWriter errors = new StringWriter();
		ex.printStackTrace(new PrintWriter(errors));
		return errors.toString();
	}

}
