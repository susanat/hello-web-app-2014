package com.ipartek.formacion.linkedin.modelo.dao;

import java.util.ArrayList;

import com.ipartek.formacion.linkedin.bean.Persona;

/**
 * Interfaz para definir las operaciones de CRUD contra la tabla Persona de la
 * BD, la cual luego deberemos implementar segun la BD que usemos
 *
 * @author Mario Alvaro
 *
 */
public interface IPersonaDAO {

    ArrayList<Persona> getAll();

    Persona getById(Persona p);

    int insert(Persona p);

    boolean delete(Persona p);

    boolean update(Persona p);

}
