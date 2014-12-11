package com.ipartek.formacion.helloweb.model.interfaces;

import java.util.ArrayList;

import com.ipartek.formacion.helloweb.bean.Calificacion;

public interface IModeloCalificacion {

    ArrayList<Calificacion> getAll();

    Calificacion getById();

    int insert(Calificacion c);

    int update(Calificacion c);

    boolean delete(int id);

}
