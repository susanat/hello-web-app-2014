/**
 *
 */
package com.ipartek.formacion.helloweb.model;

import java.util.ArrayList;

import com.ipartek.formacion.helloweb.bean.Idioma;
import com.ipartek.formacion.helloweb.model.interfaces.IModeloIdioma;

/**
 * Implementacion para la Persistencia de los Idiomas
 *
 * @author ur00
 *
 */
public class ModeloIdioma implements IModeloIdioma {

	// TODO implementar base BBDD
	static ArrayList<Idioma> idiomas = null;

	public static void createTable() {
		idiomas = new ArrayList<Idioma>();
		Idioma i = new Idioma("");
		i.setLocale("es_ES");
		i.setId(0);
		i.setLenguaje("es");
		i.setPais("ES");
		i.setTexto("Castellano");
		idiomas.add(i);

		i = new Idioma("");
		i.setLocale("en_EN");
		i.setId(1);
		i.setLenguaje("en");
		i.setPais("EN");
		i.setTexto("English");
		idiomas.add(i);

		i = new Idioma("");
		i.setLocale("eu_ES");
		i.setId(2);
		i.setLenguaje("eu");
		i.setPais("ES");
		i.setTexto("Euskera");
		idiomas.add(i);

		i = new Idioma("");
		i.setLocale("fr_FR");
		i.setId(3);
		i.setLenguaje("fr");
		i.setPais("FR");
		i.setTexto("Français");
		idiomas.add(i);

		i = new Idioma("");
		i.setLocale("de_DE");
		i.setId(4);
		i.setLenguaje("de");
		i.setPais("DE");
		i.setTexto("Deutsch");
		idiomas.add(i);

	}

	static void truncateTable() {
		idiomas = null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ipartek.formacion.helloweb.model.interfaces.IModeloIdioma#getAll()
	 */
	public ArrayList<Idioma> getAll() {
		ArrayList<Idioma> idiomasLogicos = null;
		if (idiomas != null) {
			idiomasLogicos = new ArrayList<Idioma>();
			for (final Idioma i : idiomas) {
				if (i != null) {
					idiomasLogicos.add(i);
				}
			}

			// Si todos están borrados lógicamente
			if (idiomasLogicos.isEmpty()) {
				idiomasLogicos = null;
			}
		}
		return idiomasLogicos;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ipartek.formacion.helloweb.model.interfaces.IModeloIdioma#getById()
	 */
	public Idioma getById(final int id) {
		Idioma res = null;
		if (idiomas != null) {
			for (final Idioma i : idiomas) {
				if (i != null) {
					if (i.getId() == id) {
						res = i;
						break;
					}
				}
			}
		}
		return res;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.ipartek.formacion.helloweb.model.interfaces.IModeloIdioma#insert
	 * (com.ipartek.formacion.helloweb.bean.Idioma)
	 */
	public int insert(final Idioma p) {
		int res = Idioma.ID_NULL;

		if (idiomas == null) {
			idiomas = new ArrayList<Idioma>();
		}

		if (p != null) {
			idiomas.add(p);
			p.setId((idiomas.size() - 1));
			res = (idiomas.size() - 1);
		}

		return res;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ipartek.formacion.helloweb.model.interfaces.IModeloIdioma#update
	 * (com.ipartek.formacion.helloweb.bean.Idioma)
	 */
	public int update(final Idioma i) {
		int res = Idioma.ID_NULL;
		if (idiomas != null) {
			idiomas.set(i.getId(), i);
			res = i.getId();
		}
		return res;

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.ipartek.formacion.helloweb.model.interfaces.IModeloIdioma#delete
	 * (int)
	 */
	public boolean delete(final int id) {
		boolean res = false;
		try {
			if (idiomas != null) {
				if (getById(id) != null) {
					idiomas.set(id, null);
					res = true;
				}
			}
		} catch (final Exception e) {
			// TODO traza de Log
			System.out.print("No existe el ID [" + id + "] que queremos eliminar");
		}
		return res;
	}

}
