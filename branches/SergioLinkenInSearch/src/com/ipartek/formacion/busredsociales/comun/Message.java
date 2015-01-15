package com.ipartek.formacion.busredsociales.comun;




public class Message 
{
	public enum ETypeAlert {
		SUCCESS,
		INFO,
		WARNING,
		DANGER
	}
	
	
	public final static String DEFAULT_TEXT = "";
	public final static ETypeAlert DEFAULT_TYPE = ETypeAlert.INFO;
	public final static Boolean DEFAULT_ERROR = false;
	public final static Exception DEFAULT_EXCEPTION = null;
	public final static int DEFAULT_CODE = 0;
	public final static String DEFAULT_URI_ORIGIN = "";
	
	private Boolean error = Message.DEFAULT_ERROR;
	private String text = Message.DEFAULT_TEXT;
	private ETypeAlert type = Message.DEFAULT_TYPE;
	private Exception exception = Message.DEFAULT_EXCEPTION;
	private int code = Message.DEFAULT_CODE;
	private String urlOrigin = Message.DEFAULT_URI_ORIGIN;
	
	public Boolean isError() {
		return error;
	}
	
	public Boolean getError() {
		return error;
	}
	
	public void setError(Boolean error) {
		this.error = error;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public ETypeAlert getType() {
		return type;
	}
	public void setType(ETypeAlert type) {
		this.type = type;
	}
	public Exception getException() {
		return exception;
	}
	public void setException(Exception exception) {
		this.exception = exception;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
		
	public String getUrlOrigin() {
		return urlOrigin;
	}
	public void setUrlOrigin(String urlOrigin) {
		this.urlOrigin = urlOrigin;
	}
	public void clear() {
		error = Message.DEFAULT_ERROR;
		text = Message.DEFAULT_TEXT;
		type = Message.DEFAULT_TYPE;
		exception = Message.DEFAULT_EXCEPTION;
		code = Message.DEFAULT_CODE;
	}
	

	public String getShowDivAlert() 
	{
		StringBuilder res = new StringBuilder();		
		String classs = "alert-info";

		//obtenemos el tipo 
		switch (this.getType()) {
		case DANGER:
			classs = "alert-danger";
			break;

		case INFO:
			classs = "alert-info";
			break;

		case SUCCESS:
			classs = "alert-success";
			break;

		case WARNING:
			classs = "alert-warning";
			break;
		default:
			break;
		}

		res.append("<div class='alert ");
		res.append(classs);
		res.append(" sombra'");
		res.append("role='alert'>");
		res.append(this.getText());
		res.append("</div>");

		return res.toString();
	}
}

/*

<div class="alert alert-success" role="alert">...</div>
<div class="alert alert-info" role="alert">...</div>
<div class="alert alert-warning" role="alert">...</div>
<div class="alert alert-danger" role="alert">...</div>
*/