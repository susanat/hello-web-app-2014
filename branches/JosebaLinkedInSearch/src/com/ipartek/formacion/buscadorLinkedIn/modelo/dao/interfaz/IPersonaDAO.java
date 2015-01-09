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

    ArrayList<Persona> getAll();

    Persona getByID(Persona p);

    Persona insert(Persona p);

    boolean delete(Persona p);

    Persona update(Persona p);

}
