package com.ipartek.formacion.helloweb.bean;

public class Calificacion {

    private int id;
    private int valor;
    private String descripcion;

    public static final int ID_NULL = -1;
    public static final int VALOR_NULL = 0;
    public static final String DESCRIPCION_NULL = "Muy deficiente";

    public Calificacion(int valor) {
	super();
	this.valor = valor;
	this.descripcion = DESCRIPCION_NULL;
	this.id = ID_NULL;
    }

    public Calificacion(int valor, String descripcion) {
	super();
	this.valor = valor;
	this.descripcion = descripcion;
	this.id = ID_NULL;
    }

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public int getValor() {
	return valor;
    }

    public void setValor(int valor) {
	this.valor = valor;
    }

    public String getDescripcion() {
	return descripcion;
    }

    public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
    }
}
