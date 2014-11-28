<%@page import="com.ipartek.formacion.helloweb.Constantes"%>
<%@page import="com.ipartek.formacion.helloweb.bean.Persona"%>

<%
	//recuperar el usuario de session
	Persona p = (Persona) request.getAttribute(Constantes.USER_SESSION);
	// variable para saber si el usuario es administrador
	boolean esAdministrador = true;
	// Comprueba que exista la session
	if (p == null) {
		esAdministrador = false;
	} else {
		// Comprueba que el usuario sea administrador
		esAdministrador = Persona.Rol.ADMINISTRADOR.equals(p.getRol());
	}

	//en caso de que no sea administrador
	if (!esAdministrador) {
		response.setStatus(response.SC_UNAUTHORIZED);
		//String root = request.getSession().getServletContext().getRealPath("/");
		//String root = request.getContextPath();
		String root = request.getHeader("referer");
		response.sendRedirect(root + Constantes.JSP_LOGIN);
	}
%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Administracion</title>
</head>
<body>
	<h1>Bienvenido a la seccion de Administracion</h1>
	<a href="<%=Constantes.PATH_LOGOUT%>" title="Cierra tu session">[x]
		Cerrar Session</a>
</body>
</html>