package com.ipartek.formacion.helloweb.model.interfaces;

import java.util.ArrayList;

import com.ipartek.formacion.helloweb.bean.Persona;

/**
 * Modelo para getionar el bean de <code>persona</code>
 * 
 * @author Curso
 */

public interface IModeloPersona {

    /**
     * Retorna todas las personas de la BBDD alfabeticamente
     * 
     * @return Listado <code>persona</code>, sino existe null
     */

    ArrayList<Persona> getAll();

    /**
     * Recuperar <code>persona</code> por su identificador
     * 
     * @param id
     *            identificador de <code>persona</code>
     * @return <code>persona</code>, si no existe null
     */
    Persona getByID(int id);

    /**
     * Operaciones Basicas CRUD CREATE
     * 
     * Insertamos nueva <code>persona</code>
     * 
     * @param p
     *            <code>persona</code> a insertar
     * @return identificador de la <code>persona</code>, -1 si error
     */
    int insert(Persona p);

    /**
     * UPDATE
     * 
     * Modifica una <code>persona</code>
     * 
     * @param p
     *            <code>persona</code> a insertar
     * @return identificador de la <code>persona</code>, -1 si error
     */
    int update(Persona p);

    /**
     * Eliminamos logicamente <code>persona</code> por su identificador
     * 
     * @param id
     *            identificador <code>persona</code>
     * @return true si eliminado, false en caso contrario
     */
    boolean delete(int id);

}
