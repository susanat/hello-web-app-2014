package com.ipartek.formacion.helloweb.bean;

public class Calificaciones {

    // Atributos
    private int id;
    private int nota;
    private String descripcionNota;

    public static final int ID_NULL = -1;

    // Constructores

    public Calificaciones(int nota, String descripcionNota) {
	super();
	this.nota = nota;
	this.descripcionNota = descripcionNota;
	this.id = ID_NULL;
    }

    public Calificaciones(String string) {
	// TODO Auto-generated constructor stub
    }

    // Getter y Setter
    public int getId() {
	return id;
    }

    public int getNota() {
	return nota;
    }

    public String getDescripcionNota() {
	return descripcionNota;
    }

    public void setId(int id) {
	this.id = id;
    }

    public void setNota(int nota) {
	this.nota = nota;
    }

    public void setDescripcionNota(String descripcionNota) {
	this.descripcionNota = descripcionNota;
    }

    @Override
    public String toString() {
	return "Calificaciones [id=" + id + ", nota=" + nota
		+ ", descripcionNota=" + descripcionNota + "]";
    }

}
