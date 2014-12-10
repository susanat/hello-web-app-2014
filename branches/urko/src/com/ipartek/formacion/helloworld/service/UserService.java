package com.ipartek.formacion.helloworld.service;

import com.ipartek.formacion.helloworld.bean.Persona;
import com.ipartek.formacion.helloworld.bean.Persona.Rol;
import com.ipartek.formacion.helloworld.util.Constante;

public class UserService {
    public static Persona find(final String userName, final String userPass) {
	Persona p = null;

	if (Constante.USER_ADMIN_NAME.equals(userName)
		&& Constante.USER_ADMIN_PASS.equals(userPass) ||

		Constante.USER_USER_NAME.equals(userName)
		&& Constante.USER_USER_PASS.equals(userPass)) {

	    if (Constante.USER_USER_NAME.equals(userName)) {
		p = new Persona(Integer.parseInt(Constante.USER_USER_CODE), "",
			userName, userPass, Rol.USUARIO);
	    } else {
		p = new Persona(Integer.parseInt(Constante.USER_ADMIN_CODE),
			"", userName, userPass, Rol.ADMINISTRADOR);
	    }
	}
	return p;
    }
}
