package com.ipartek.formacion.helloweb.bean;

import com.ipartek.formacion.helloweb.TipoMensaje;

/**
 * Clase para mostrar los mensajes o alertas durante la apliación.
 *
 * @author Mario Alvaro
 *
 */
public class Mensaje {

    /**
     * Descripción del mensaje
     */
    private String msg;
    /**
     * Tipo del mensaje: Success, Info, Warning, Danger
     */
    private TipoMensaje type;
    /**
     * Código http
     */
    int code;

    public Mensaje(String msg, TipoMensaje type, int code) {
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

    public TipoMensaje getType() {
	return type;
    }

    public void setType(TipoMensaje type) {
	this.type = type;
    }

    public int getCode() {
	return code;
    }

    public void setCode(int code) {
	this.code = code;
    }

}
