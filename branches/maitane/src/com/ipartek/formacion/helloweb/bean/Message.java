package com.ipartek.formacion.helloweb.bean;

/**
 * Clase Message para crear objetos para las alertas
 * 
 * @author Maitane Casado
 *
 */

public class Message {

	// Atributos

	private String msg;
	private AlertType type;
	private int code;

	// Constructores

	public Message(String msg, AlertType type) {
		super();
		this.msg = msg;
		this.type = type;
	}

	public Message() {
		super();
	}

	// Getters and setters

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public AlertType getType() {
		return type;
	}

	public void setType(AlertType type) {
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
