package com.ipartek.formacion.helloweb.model;

import java.util.ArrayList;

import com.ipartek.formacion.helloweb.bean.Persona;
import com.ipartek.formacion.helloweb.model.interfaces.IModeloPersona;

/**
 * Implementacion para la persistencia
 *
 * @author Urko Villanueva
 *
 */
public class ModeloPersona implements IModeloPersona {
    // TODO implementnar BBDD
    public static ArrayList<Persona> personas = null;
    private static int pos;

    public static void init() {
	Persona p = new Persona(1, "Gorriti");
	personas = new ArrayList<Persona>();
	personas.add(p);

	p = new Persona(2, "Antxon");
	personas.add(p);

	p = new Persona(3, "Pirulero");
	personas.add(p);

	p = new Persona(4, "Duquesita");
	personas.add(p);

	p = new Persona(5, "Manoli");
	personas.add(p);

	pos = 6;
    }

    public static void destroy() {
	personas = null;
    }

    @Override
    public ArrayList<Persona> getAll() {
	// TODO Auto-generated method stub
	return personas;
    }

    @Override
    public Persona getById(final int id) {
	// TODO Auto-generated method stub
	Persona p = null;
	int len = personas.size();
	int i = 0;

	while (p == null && i < len) {
	    // System.out.println(personas.get(i).getCodigo() + "-" + id);
	    if (null != personas.get(i) && personas.get(i).getCodigo() == id) {
		p = personas.get(i);
	    }
	    i++;
	}
	return p;
    }

    @Override
    public int insert(final Persona p) {
	// TODO Auto-generated method stub
	int cod = Persona.ID_NULL;
	if (personas == null) {
	    personas = new ArrayList<Persona>();
	    pos = 1;
	}
	if (p != null) {
	    Persona paux = p;
	    paux.setCodigo(pos);
	    if (personas.add(paux)) {
		cod = pos;
	    }
	    pos++;
	}
	return cod;
    }

    @Override
    public int update(final Persona p) {
	// TODO Auto-generated method stub
	int cod = Persona.ID_NULL;
	if (p.getCodigo() > Persona.ID_NULL) {
	    Persona pAux = getById(p.getCodigo());
	    int i = personas.indexOf(pAux);
	    cod = personas.set(i, p).getCodigo();
	}
	return cod;
    }

    @Override
    public boolean delete(final int id) {
	// TODO Auto-generated method stub
	boolean exito = false;
	if (id > Persona.ID_NULL) {
	    Persona p = getById(id);
	    int i = personas.indexOf(p);
	    if (p != null) {
		personas.remove(i);
		exito = true;
	    }
	} else {
	    // TODO Excepcion de dato mal enviado

	}
	return exito;
    }

    @Override
    public boolean deleteLog(final int id) {
	// TODO Auto-generated method stub
	boolean exito = false;
	if (id > Persona.ID_NULL) {
	    Persona p = getById(id);
	    int i = personas.indexOf(p);

	    if (p != null) {
		personas.set(i, null);
		exito = true;
	    }
	} else {
	    // TODO Excepcion de dato mal enviado

	}
	return exito;
    }
}
