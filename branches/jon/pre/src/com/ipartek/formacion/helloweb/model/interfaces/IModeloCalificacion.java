package com.ipartek.formacion.helloweb.model.interfaces;

import java.util.ArrayList;

import com.ipartek.formacion.helloweb.bean.Calificacion;

;

/**
 * Modelo para gestionar el bean de <code>Calificacion</code>.
 * 
 * @author Fran
 *
 */
public interface IModeloCalificacion {

	ArrayList<Calificacion> getAll();

	Calificacion getById(int id);

	int insert(Calificacion c);

	int update(Calificacion c);

	boolean delete(int i);
}
