package com.ipartek.formacion.helloweb.bean;

import com.ipartek.formacion.helloweb.TipoMensaje;

public class Mensaje {

    private String msg;
    private TipoMensaje type;
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
