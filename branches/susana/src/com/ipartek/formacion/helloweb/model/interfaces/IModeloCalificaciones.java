package com.ipartek.formacion.helloweb.model.interfaces;

import java.util.ArrayList;

import com.ipartek.formacion.helloweb.bean.Calificaciones;

public interface IModeloCalificaciones {

    /**
     * Retorna todas las calificaciones de la BBDD alfabeticamente
     * 
     * @return listado <code>Calificaciones</code>, si no existen null
     */
    ArrayList<Calificaciones> getAll();

    // Recojo las calificaciones por ID
    Calificaciones getById(int id);

    // Inserto una nueva calificacion sino hay ningun ID ninguna nota
    int insertCalificacion(Calificaciones c);

}
