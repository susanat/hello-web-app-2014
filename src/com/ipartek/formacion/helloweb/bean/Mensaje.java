package com.ipartek.formacion.helloweb.bean;

/**
 * Mensaje de comunicación del servlet al usuario
 * 
 * @author Fran
 *
 */
public class Mensaje {
	private String msg;
	private MsgType type;
	private int code;

	public Mensaje(String msg, MsgType type, int code) {
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

	public MsgType getType() {
		return type;
	}

	public void setType(MsgType type) {
		this.type = type;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	/**
	 * Enumeración para los tipos de mensaje
	 * 
	 * @author Fran
	 *
	 */
	public enum MsgType {
		ERR, REG, LOG;
	}
}
