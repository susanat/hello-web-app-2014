package com.ipartek.formacion.helloweb.model.interfaces;

import java.util.ArrayList;

import com.ipartek.formacion.helloweb.bean.Persona;

/**
 * Modelo para gestionar el bean {@code Persona}
 *
 * @author Joseba Carrión Blanco
 *
 */
public interface IModeloPersona {
    /**
     * Retorna todas las personas
     *
     * @return {@code ArrayList<Persona>}, o null si no existen
     */
    ArrayList<Persona> getAll();

    /**
     * Recuperara {@code Persona} por su identificador
     *
     * @param id
     *            identificador de la {@code Persona}
     * @return {@code Persona} o null si no existe
     */
    Persona getByID(int id);

    /**
     * Inserta nueva {@code Persona}
     *
     * @param p
     *            {@code Persona} a insertar
     * @return identificador de la {@code Persona}, -1 si no ha insertado, -2
     *         existe
     */
    int insert(Persona p);

    /**
     * Modifica una {@code Persona}
     *
     * @param p
     *            {@code Persona} a actualizar
     * @return identificador de la {@code Persona}, -1 si error
     */
    int update(Persona p);

    /**
     * Eliminar la {@code Persona} logicamente por su identificador
     *
     * @param id
     *            identificador {@code Persona}
     * @return {@code True} si eliminado, {@code False} si error o no eliminado
     */
    boolean delete(int id);
}
