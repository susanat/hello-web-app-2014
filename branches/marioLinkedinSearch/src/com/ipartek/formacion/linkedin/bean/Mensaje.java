package com.ipartek.formacion.linkedin.bean;

/**
 * Clase para mostrar los mensajes o alertas durante la apliación.
 *
 * @author Mario Alvaro
 *
 */

public class Mensaje {

    public static final String MSG_TYPE_SUCCESS = "success";
    public static final String MSG_TYPE_INFO = "info";
    public static final String MSG_TYPE_WARNING = "warning";
    public static final String MSG_TYPE_DANGER = "danger";
    /**
     * Descripción del mensaje
     */
    private String msg;
    /**
     * Tipo del mensaje: Success, Info, Warning, Danger
     */
    private String type;
    /**
     * Código http
     */
    int code;

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
	setMsg(msg);
	setType(type);
	setCode(code);
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
