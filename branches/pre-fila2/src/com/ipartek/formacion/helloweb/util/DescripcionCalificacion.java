package com.ipartek.formacion.helloweb.util;

public enum DescripcionCalificacion {

    MUY_DEFICIENTE("Muy Deficiente"), INSUFICIENTE("Insuficiente"), SUFICIENTE(
	    "Suficiente"), BIEN("Bien"), NOTABLE("Notable"), SOBRESALIENTE(
		    "Sobresaliente"), M_HONOR("Matricula de honor");

    private String descripcion;

    private DescripcionCalificacion(String descripcion) {
	this.descripcion = descripcion;
    }

    public String getDescripcion() {
	return descripcion;
    }

}
