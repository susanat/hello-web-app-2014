<%@page import="com.ipartek.formacion.helloweb.Constantes"%>
<%@page import="com.ipartek.formacion.helloweb.bean.Persona"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Administracion</title>
</head>
<body>
	<%//recuperar el usuario de session
	Persona p=(Persona)request.getAttribute(Constantes.USER_SESSION);
	// Comprueba que exista la session
	if (p!=null){
		// Comprueba que el 
	}
	%>
	<h1>Bienvenido a la seccion de Administracion</h1>
</body>
</html>