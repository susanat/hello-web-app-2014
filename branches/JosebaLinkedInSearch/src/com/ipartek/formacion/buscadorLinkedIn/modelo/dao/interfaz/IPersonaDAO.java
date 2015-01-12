package com.ipartek.formacion.buscadorLinkedIn.modelo.dao.interfaz;

import java.util.ArrayList;

import com.ipartek.formacion.buscadorLinkedIn.bean.Persona;

/**
 * Interfaz para definir las operaciones de CRUD contra la tabla Persona de la
 * BBDD. La cual deberemos implementar segun las BBDD que usemos
 *
 * @author Joseba Carrión Blanco
 *
 */

public interface IPersonaDAO {

    static final String TABLA = "persona";
    static final String COL_ID = "id";
    static final String NOMBRE = "nombre";
    static final String APELLIDOS = "apellidos";
    static final String LINK_FOTO = "URLImagen";

    ArrayList<Persona> getAll();

    Persona getByID(int id);

    int insert(Persona p);

    boolean delete(Persona p);

    Persona update(Persona p);

}
