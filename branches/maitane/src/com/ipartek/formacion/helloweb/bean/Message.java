package com.ipartek.formacion.helloweb.bean;

/**
 * Clase Message para crear objetos para las alertas
 * 
 * @author Maitane Casado
 *
 */

public class Message {

	// Atributos

	public static final String MSG_TYPE_SUCCESS = "success";
	public static final String MSG_TYPE_INFO = "info";
	public static final String MSG_TYPE_WARNING = "warning";
	public static final String MSG_TYPE_DANGER = "danger";

	private String msg;
	private String type;
	private int code;

	// Constructores

	public Message(String msg, String type) {
		super();
		this.msg = msg;
		this.type = type;
	}

	public Message() {
		super();
		this.type = MSG_TYPE_SUCCESS;
	}

	public Message(String msg, String type, int code) {
		super();
		this.msg = msg;
		this.type = type;
		this.code = code;
	}

	public Message(String msg) {
		super();
		this.msg = msg;
		this.type = MSG_TYPE_SUCCESS;
	}

	// Getters and setters

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

	/**
	 * Enumeracion para los tipos de errores
	 * 
	 * @author Maitane Casado
	 *
	 */
	public enum AlertType {
		SUCCESS, INFO, WARNING, DANGER;
	}

}
