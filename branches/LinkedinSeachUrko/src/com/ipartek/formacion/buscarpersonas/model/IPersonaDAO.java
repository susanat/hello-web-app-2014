package com.ipartek.formacion.buscarpersonas.model;

import java.util.ArrayList;

import com.ipartek.formacion.buscarpersonas.bean.Persona;
import com.ipartek.formacion.buscarpersonas.exception.ModelException;

public interface IPersonaDAO {
    static final String TABLA = "persona";
    static final String[] CAMPOS = { "codPersona", "nombre", "apellidos",
	    "foto" };

    public ArrayList<Persona> getAll() throws ModelException;

    public Persona getById(Persona p) throws ModelException;

    public int insert(Persona p) throws ModelException;

    public int delete(Persona p) throws ModelException;

    public int update(Persona p) throws ModelException;
}
