package com.ipartek.formacion.helloworld.bean;

import com.ipartek.formacion.helloworld.util.Constante;

public class Rol {
    private String codigo;
    private String nombre;

    public Rol(final String codigo, final String nombre) {
	super();
	this.codigo = codigo;
	this.nombre = nombre;
    }

    public Rol() {
	super();
	this.codigo = Constante.ROL_USER_CODE;
	this.nombre = Constante.ROL_USER_NAME;
    }

    public String getCodigo() {
	return codigo;
    }

    public void setCodigo(final String codigo) {
	this.codigo = codigo;
    }

    public String getNombre() {
	return nombre;
    }

    public void setNombre(final String nombre) {
	this.nombre = nombre;
    }

}
