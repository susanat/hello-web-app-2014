package com.ipartek.formacion.helloweb.bean;

public class Calificacion {

    private int id;
    private int valor;
    private String descripcion;

    public static final int ID_CALI_NULL = -1;

    public Calificacion(int valor, String descripcion) {
	super();
	this.valor = valor;
	this.descripcion = descripcion;
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

    @Override
    public String toString() {
	return "Calificacion [id=" + id + ", valor=" + valor + ", descripcion="
		+ descripcion + "]";
    }

}
