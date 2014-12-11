package com.ipartek.formacion.helloweb.util;

import java.util.ArrayList;

/**
 * Enumeración para los roles de usuario
 *
 * @author Curso
 *
 */
public enum Rol {

	ADMINISTRADOR, USUARIO, INVITADO;

	public static ArrayList<String> getTextoRolList() {
		final ArrayList<String> res = new ArrayList<String>();

		for (final Rol rol : Rol.values()) {
			res.add(String.valueOf(rol));
		}

		return res;
	}
}
