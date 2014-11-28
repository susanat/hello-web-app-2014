<%@page import="com.ipartek.formacion.helloweb.util.Rol"%>
<%@page import="com.ipartek.formacion.helloweb.bean.Persona"%>
<%@page import="com.ipartek.formacion.helloweb.Constantes"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Backoffice</title>
</head>

<body>
	<h1>Backoffice</h1>
	
	<%
		String root = request.getContextPath() + "/";
		Persona p = (Persona) session.getAttribute(Constantes.USER_SESSION);
		
		if (p == null || p.getRol() != Rol.ADMINISTRADOR) {
			request.setAttribute(Constantes.MSG_KEY, Constantes.MSG_NO_AUTORIZADO);
			response.sendRedirect(root + Constantes.PATH_LOGIN);
		} else {
			out.println("<h2>Ongi etorri administrador</h2>");
			out.println("<a href='" + root + Constantes.PATH_LOGOUT + "' title='Cierra tu sesión'>[x] Logout</a>");
		}
	%>
	
</body>

</html>