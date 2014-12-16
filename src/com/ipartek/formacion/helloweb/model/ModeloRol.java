package com.ipartek.formacion.helloweb.model;

import java.util.ArrayList;

import com.ipartek.formacion.helloweb.bean.Role;
import com.ipartek.formacion.helloweb.model.interfaces.IModeloRol;

public class ModeloRol implements IModeloRol {

    static ArrayList<Role> roles = null;

    public static void createTable() {
	roles = new ArrayList<Role>();
	Role r = new Role("");
	r.setNombre("Usuario");
	r.setDescripcion("Usuarios normales");
	r.setId(1);
	roles.add(r);

	r = new Role("");
	r.setNombre("Administrador");
	r.setDescripcion("Administradores del sitio");
	r.setId(2);
	roles.add(r);
    }

    static void truncateTable() {
	roles = null;
    }

    public ArrayList<Role> getAll() {
	ArrayList<Role> rolesLogicos = null;
	if (roles != null) {
	    rolesLogicos = new ArrayList<Role>();
	    for (Role r : roles) {
		if (r != null) {
		    rolesLogicos.add(r);
		}
	    }

	    // Si todos estan borrados logicamente
	    if (rolesLogicos.isEmpty()) {
		rolesLogicos = null;
	    }
	}
	return rolesLogicos;
    }

    public Role getByID(int id) {
	Role resul = null;
	if (roles != null) {
	    for (Role r : roles) {
		if (r != null) {
		    if (r.getId() == id) {
			resul = r;
			break;
		    }
		}
	    }
	}
	return resul;
    }

    public int insert(Role r) {
	int resul = Role.ID_NULL;

	if (roles == null) {
	    roles = new ArrayList<Role>();
	}

	if (r != null) {
	    roles.add(r);
	    r.setId(roles.size() - 1);
	    resul = (roles.size() - 1);
	}

	return resul;
    }

    public int update(Role r) {
	int resul = Role.ID_NULL;
	if (roles != null) {
	    roles.set(r.getId(), r);
	    resul = r.getId();
	}
	return resul;
    }

    public boolean delete(int id) {
	boolean resul = false;
	try {
	    if (roles != null) {
		if (getByID(id) != null) {
		    roles.set((id), null);
		    resul = true;
		}
	    }
	} catch (Exception e) {
	    // TODO traza de Log
	    System.out.print("No existe el ID[" + id + "] queremos eliminar");
	}
	return resul;
    }

}
