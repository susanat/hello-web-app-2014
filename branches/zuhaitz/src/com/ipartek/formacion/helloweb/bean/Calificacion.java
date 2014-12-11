package com.ipartek.formacion.helloweb.bean;

public class Calificacion {

	public static final int ID_NULL = -1;

	private int id;
	private int valor;
	private String texto;

	/**
	 * @param id
	 * @param valor
	 * @param texto
	 */
	public Calificacion(final int valor, final String texto) {
		super();
		setValor(valor);
		setTexto(texto);
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(final int id) {
		this.id = id;
	}

	/**
	 * @return the valor
	 */
	public int getValor() {
		return valor;
	}

	/**
	 * @param valor
	 *            the valor to set
	 */
	public void setValor(final int valor) {
		this.valor = valor;
	}

	/**
	 * @return the texto
	 */
	public String getTexto() {
		return texto;
	}

	/**
	 * @param texto
	 *            the texto to set
	 */
	public void setTexto(final String texto) {
		this.texto = texto;
	}

	@Override
	public String toString() {
		return getValor() + " " + getTexto();
	}

}
