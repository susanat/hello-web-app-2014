package com.ipartek.formacion.helloweb.model;

import java.util.ArrayList;

import com.ipartek.formacion.helloweb.bean.Calificacion;
import com.ipartek.formacion.helloweb.model.interfaces.IModeloCalificacion;
import com.ipartek.formacion.helloweb.util.DescripcionCalificacion;

public class ModeloCalificacion implements IModeloCalificacion {

    static ArrayList<Calificacion> calificaciones = null;

    public static void createTable() {
	calificaciones = new ArrayList<Calificacion>();

	Calificacion c = new Calificacion(0, "");
	c.setValor(0);
	c.setDescripcion(DescripcionCalificacion.MUY_DEFICIENTE
		.getDescripcion());
	calificaciones.add(c);

    }

    public ArrayList<Calificacion> getAll() {
	// TODO Auto-generated method stub
	return null;
    }

    public Calificacion getById() {
	// TODO Auto-generated method stub
	return null;
    }

    public int insert(Calificacion c) {
	// TODO Auto-generated method stub
	return 0;
    }

    public int update(Calificacion c) {
	// TODO Auto-generated method stub
	return 0;
    }

    public boolean delete(int id) {
	// TODO Auto-generated method stub
	return false;
    }

}
