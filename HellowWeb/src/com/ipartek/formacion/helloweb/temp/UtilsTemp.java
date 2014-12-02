package com.ipartek.formacion.helloweb.temp;

import javax.servlet.http.HttpServletRequest;

public class UtilsTemp {

	public static String getUriFromRequest(HttpServletRequest request){
		return request.getScheme() + "://" +
	             request.getServerName() + 
	             ("http".equals(request.getScheme()) && request.getServerPort() == 80 || "https".equals(request.getScheme()) && request.getServerPort() == 443 ? "" : ":" + request.getServerPort() ) +
	             request.getRequestURI() +
	            (request.getQueryString() != null ? "?" + request.getQueryString() : "");
	}
}
