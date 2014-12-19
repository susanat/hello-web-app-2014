package com.ipartek.formacion.helloweb.util;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.ipartek.formacion.helloweb.bean.Persona;

public class Util {
    private Util() {
    }

    public static String obtenerRutaPersona(final Persona p) {
	String ruta = null;
	int rol = -1;
	if (p.getRol() != null) {
	    rol = Integer.parseInt(p.getRol().getCodigo());
	}
	switch (rol) {
	case 0: {
	    ruta = Constante.JSP_BACKOFFICE_INDEX;
	    break;
	}
	case 1: {
	    ruta = Constante.JSP_SALUDO;
	    break;
	}
	default:
	    ruta = Constante.JSP_LOGIN;
	}
	return ruta;
    }

    public static HashMap<String, String> getRequestInfo(
	    final HttpServletRequest request) {
	HashMap<String, String> requestInfo = null;
	requestInfo = new HashMap<String, String>();
	requestInfo.put("metodo", request.getMethod());
	requestInfo.put("URI", request.getRequestURI());
	requestInfo.put("Protoco", request.getProtocol());
	requestInfo.put("Path", request.getPathInfo());
	return requestInfo;
    }

    public HashMap<String, String> getRequestHeader(
	    final HttpServletRequest request) {
	HashMap<String, String> requestInfo = null;

	return requestInfo;
    }
}
