package com.ipartek.formacion.helloweb.bean;

import java.util.ArrayList;

/**
 * Clase de los Idiomas.
 *
 * @author Curso
 *
 */
public class Idioma {

	/**
	 * id del Idioma.
	 */
	private int id;
	/**
	 * locale del Idioma => "es_ES".
	 */
	private String locale;
	/**
	 * lenguaje del Idioma => "es".
	 */
	private String lenguaje;
	/**
	 * pais del Idioma => "ES".
	 */
	private String pais;
	/**
	 * texto del Idioma => "Castellano".
	 */
	private String texto;

	/**
	 * Constante para poner un ID inicial por defecto al Idioma.
	 */
	public static final int ID_NULL = -1;

	/**
	 * @param pLocale
	 *            locale
	 * @param pLenguaje
	 *            lenguaje
	 * @param pPais
	 *            pais
	 * @param pTexto
	 *            texto
	 */
	public Idioma(final String pLocale, final String pLenguaje, final String pPais, final String pTexto) {
		super();
		setLocale(pLocale);
		setLenguaje(pLenguaje);
		setPais(pPais);
		setTexto(pTexto);
	}

	/**
	 * @param pLocale
	 *            locale
	 */
	public Idioma(final String pLocale) {
		super();
		this.locale = pLocale;
	}

	/**
	 * @return the id
	 */
	public final int getId() {
		return id;
	}

	/**
	 * @param pId
	 *            the id to set
	 */
	public final void setId(final int pId) {
		this.id = pId;
	}

	/**
	 * @return the locale
	 */
	public final String getLocale() {
		return locale;
	}

	/**
	 * @param pLocale
	 *            the locale to set
	 */
	public final void setLocale(final String pLocale) {
		this.locale = pLocale;
	}

	/**
	 * @return the lenguaje
	 */
	public final String getLenguaje() {
		return lenguaje;
	}

	/**
	 * @param pLenguaje
	 *            the lenguaje to set
	 */
	public final void setLenguaje(final String pLenguaje) {
		this.lenguaje = pLenguaje;
	}

	/**
	 * @return the pPais
	 */
	public final String getPais() {
		return pais;
	}

	/**
	 * @param pPais
	 *            the pais to set
	 */
	public final void setPais(final String pPais) {
		this.pais = pPais;
	}

	/**
	 * @return the texto
	 */
	public final String getTexto() {
		return texto;
	}

	/**
	 * @param pTexto
	 *            the texto to set
	 */
	public final void setTexto(final String pTexto) {
		this.texto = pTexto;
	}

	/**
	 * Devuelve un array de String con los textos de los idiomas.
	 *
	 * @param idiomas
	 *            ArrayList de Idiomas
	 * @return array de String
	 */
	public static ArrayList<String> getIdiomaTextoList(final ArrayList<Idioma> idiomas) {
		final ArrayList<String> res = new ArrayList<String>();
		for (final Idioma idioma : idiomas) {
			res.add(idioma.getTexto());
		}
		return res;
	}

	/**
	 * Devuelve un array de String con los locales de los idiomas.
	 *
	 * @param aIdiomas
	 *            ArrayList de idiomas
	 * @return array de String
	 */
	public static ArrayList<String> getLocalesList(final ArrayList<Idioma> aIdiomas) {
		final ArrayList<String> res = new ArrayList<String>();
		for (final Idioma idioma : aIdiomas) {
			res.add(idioma.getLocale());
		}
		return res;
	}

	/**
	 * Devuelve un array de String con los lenguajes de los idiomas.
	 *
	 * @param aIdiomas
	 *            ArrayList de Idiomas
	 * @return array de String
	 */
	public static ArrayList<String> getIdiomaList(final ArrayList<Idioma> aIdiomas) {
		final ArrayList<String> result = new ArrayList<String>();
		for (final Idioma idioma : aIdiomas) {
			result.add(idioma.getLenguaje());
		}
		return result;
	}

}
