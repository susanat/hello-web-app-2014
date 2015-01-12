package com.ipartek.formacion.buscarpersonas.model;

import java.util.ArrayList;

import com.ipartek.formacion.buscarpersonas.bean.Persona;

public interface IPersonaDAO {
    static final String TABLA = "persona";
    static final String[] CAMPOS = { "codPersona", "nombre", "apellidos",
	    "foto" };

    public ArrayList<Persona> getAll();

    public Persona getById(Persona p);

    public int insert(Persona p);

    public int delete(Persona p);

    public int update(Persona p);
}
