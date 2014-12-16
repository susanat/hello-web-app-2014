package com.ipartek.formacion.helloweb.model.interfaces;

import java.util.ArrayList;

import com.ipartek.formacion.helloweb.bean.Calificacion;

/**
 * Modelo para gestionar el bean de <code>Persona</code>
 *
 * @author ur00
 *
 */
public interface IModeloCalifiacion {

    /**
     * Retorna todas las perosnas de la BBDD alfabeticamente
     *
     * @return listado <code>Persona</code>, si no existen null
     */
    ArrayList<Calificacion> getAll();

    /**
     * Recuperar <code>Persona</code> por su identificador
     *
     * @param id
     *            identificador <code>Persona</code>
     * @return <code>Persona</code>, si no existe null
     */
    Calificacion getById(int id);

    /**
     * Insertar nueva <code>Persona</code>
     *
     * @param p
     *            <code>Persona</code> a insertar
     * @return identificador de la <code>Persona</code>, -1 si error
     */
    int insert(Calificacion p);

    /**
     * Modifica una <code>Persona</code>
     *
     * @param p
     *            <code>Persona</code> a insertar
     * @return identificador de la <code>Persona</code>, -1 si error
     */
    int update(Calificacion p);

    /**
     * Eliminamos logicamente <code>Persona</code> por su identificador
     *
     * @param id
     *            identificador <code>Persona</code>
     * @return true si eliminado, false en caso contrario
     */
    boolean delete(int id);

}
