package com.ipartek.formacion.helloweb.service;

import com.ipartek.formacion.helloweb.bean.Persona;
import com.ipartek.formacion.helloweb.bean.Persona.Rol;
import com.ipartek.formacion.helloweb.util.Constante;

public class UserService {
    public static Persona find(final String userName, final String userPass) {
	Persona p = null;
	// System.out.println(userName + " - " + userPass);
	if (Constante.USER_ADMIN_NAME.equals(userName)
		&& Constante.USER_ADMIN_PASS.equals(userPass) ||

		Constante.USER_USER_NAME.equals(userName)
		&& Constante.USER_USER_PASS.equals(userPass)) {

	    if (Constante.USER_USER_NAME.equals(userName)) {
		p = new Persona(Integer.parseInt(Constante.USER_USER_CODE),
			Constante.USER_USER_NAME, userName, userPass,
			Rol.USUARIO);
	    } else {
		p = new Persona(Integer.parseInt(Constante.USER_ADMIN_CODE),
			Constante.USER_ADMIN_NAME, userName, userPass,
			Rol.ADMINISTRADOR);
	    }
	}
	return p;
    }
}
