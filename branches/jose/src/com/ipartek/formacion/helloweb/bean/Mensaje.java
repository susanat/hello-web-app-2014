package com.ipartek.formacion.helloweb.bean;

/**
 * Mensajes para el usuario
 * 
 * @author Curso
 *
 */
public class Mensaje {

	public static final String MSG_TYPE_SUCCESS = "success";
	public static final String MSG_TYPE_INFO = "info";
	public static final String MSG_TYPE_WARNING = "warning";
	public static final String MSG_TYPE_DANGER = "danger";

	// TODO constantes para los codigos HTTP

	String msg; // literal del mensaje
	String type; // tipo de mensaje [success, info, warning, danger]
	int code; // codigo http

	public Mensaje() {
		super();
		this.type = MSG_TYPE_SUCCESS;
	}

	public Mensaje(String msg) {
		super();
		this.msg = msg;
		this.type = MSG_TYPE_SUCCESS;

	}

	public Mensaje(String msg, String type) {
		super();
		this.msg = msg;
		this.type = type;
	}

	public Mensaje(String msg, String type, int code) {
		super();
		this.msg = msg;
		this.type = type;
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

}
