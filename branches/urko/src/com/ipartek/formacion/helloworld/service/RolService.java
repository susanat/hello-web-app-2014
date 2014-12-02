package com.ipartek.formacion.helloworld.service;

import com.ipartek.formacion.helloworld.bean.Persona;
import com.ipartek.formacion.helloworld.bean.Rol;
import com.ipartek.formacion.helloworld.util.Constante;

public class RolService {
    public static Rol find(final Persona persona) {
	Rol rol = null;
	int codigo = persona.getCodigo();
	switch (codigo) {
	case 0: {
	    rol = new Rol(Constante.ROL_ADMIN_CODE, Constante.ROL_ADMIN_NAME);
	    break;
	}
	case 1: {
	    rol = new Rol(Constante.ROL_USER_CODE, Constante.ROL_USER_NAME);
	    break;
	}
	}
	return rol;
    }
}
