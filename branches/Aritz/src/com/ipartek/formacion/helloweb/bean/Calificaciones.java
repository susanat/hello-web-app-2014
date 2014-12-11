package com.ipartek.formacion.helloweb.bean;

public class Calificaciones {

	private int idNota;
	private int nota;
	private Calificacion calificacion;

	public static final int ID_NULL = -1;
	public static final int NOTA_NULL = 0;

	public Calificaciones(int nota, Calificacion calificacion) {
		super();
		this.idNota = ID_NULL;
		this.nota = NOTA_NULL;
		this.calificacion = calificacion;
	}

	public int getIdNota() {
		return idNota;
	}

	public void setIdNota(int idNota) {
		this.idNota = idNota;
	}

	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}

	public Calificacion getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(Calificacion calificacion) {
		this.calificacion = calificacion;
	}

	/**
	 * Enumeracion para las calificaciones de las notas
	 * 
	 * @author Aritz Tellaeche
	 *
	 */
	public enum Calificacion {
		MUY_DEFICIENTE, INSUFICIENTE, SUFICIENTE, BIEN, NOTABLE, SOBRESALIENTE, MATRICULA_HONOR

	}

	@Override
	public String toString() {
		return "Calificaciones [idNota=" + idNota + ", nota=" + nota
				+ ", calificacion=" + calificacion + "]";
	}

}
