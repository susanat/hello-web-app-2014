package com.ipartek.formacion.helloweb.model.interfaces;

import java.util.List;

import com.ipartek.formacion.helloweb.bean.Languaje;

public interface IModeloIdioma {
    /**
     * Devuelve todas las personas de la base de datos ordenadas alfabeticamente
     *
     * @return listado de Idioma <code>Idioma</code>, si no existe null
     */
    List<Languaje> getAll();

    /**
     * Recuperar <code>Languaje</code> por su identificador
     *
     * @param el
     *            id <code>int</code> del Idioma
     * @return <code>Languaje</code> si no existe null
     */
    Languaje getById(int id);

    /**
     * dar de alta un Idioma
     *
     * @param i
     *            <code>Idioma</code> Idioma a insertar
     * @return identificador para la persona <code>int</code>, -1 si error
     */
    int insert(Languaje i);

    /**
     * modifica un Idioma
     *
     * @param p
     *            <code>Idioma</code> idioma a insertar
     * @return identificador para la Idioma <code>int</code>, -1 si error
     */
    int update(Languaje i);

    /**
     * Eliminamos fisicamente la <code>Idioma</code> por su identificador
     *
     * @param id
     *            identificador <code>Idioma</code>
     * @return true si elimando, false en caso contrario
     */
    boolean delete(int id);

    /**
     * Eliminamos logicamente la <code>Idioma</code> por su identificador
     *
     * @param id
     *            identificador <code>Idioma</code>
     * @return true si elimando, false en caso contrario
     */

    boolean deleteLog(int id);
}
