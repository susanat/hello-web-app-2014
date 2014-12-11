package com.ipartek.formacion.helloweb.model.interfaces;

import java.util.List;

import com.ipartek.formacion.helloweb.bean.Persona;

/**
 * Interfaz para gestionar el bean de <code>Persona</code> de cara a su gestión
 * a base de datos
 *
 * @author Urko Villanueva
 *
 */
public interface IModeloPersona {

    /**
     * Devuelve todas las personas de la base de datos ordenadas alfabeticamente
     *
     * @return listado de persona <code>Persona</code>, si no existe null
     */
    List<Persona> getAll();

    /**
     * Recuperar <code>Persona</code> por su identificador
     *
     * @param el
     *            id <code>int</code> de la persona
     * @return <code>Persona</code> si no existe null
     */
    Persona getById(int id);

    /**
     * dar de alta una Persona
     *
     * @param p
     *            <code>Persona</code> persona a insertar
     * @return identificador para la persona <code>int</code>, -1 si error
     */
    int insert(Persona p);

    /**
     * modifica una Persona
     *
     * @param p
     *            <code>Persona</code> persona a insertar
     * @return identificador para la persona <code>int</code>, -1 si error
     */
    int update(Persona p);

    /**
     * Eliminamos fisicamente la <code>Persona</code> por su identificador
     *
     * @param id
     *            identificador <code>Persona</code>
     * @return true si elimando, false en caso contrario
     */
    boolean delete(int id);

    /**
     * Eliminamos logicamente la <code>Persona</code> por su identificador
     *
     * @param id
     *            identificador <code>Persona</code>
     * @return true si elimando, false en caso contrario
     */

    boolean deleteLog(int id);

}
