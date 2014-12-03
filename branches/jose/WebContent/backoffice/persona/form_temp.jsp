<%@page import="com.ipartek.formacion.helloweb.bean.Persona"%>
<%@page import="com.ipartek.formacion.helloweb.Constantes"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	//crear persona nueva
	Persona p = (Persona) request.getAttribute(Constantes.ATT_PERSONA);
	String cabecera = "Crear nueva Persona";
	String buttonValue = "Crear";
	String op=Constantes.OP_CREATE;
	boolean isNew = true;
	if (p == null) {
		p = new Persona("");
	} else {
		cabecera = "Modificar " + p.getNombre();
		buttonValue = "Modificar";
		isNew = false;
		op=Constantes.OP_UPDATE;
	}
%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Editar Persona</title>
</head>
<body>
	<h1><%=cabecera%></h1>
	<h2>
		<a
			href="<%=request.getContextPath() + "/"
					+ Constantes.CONTROLLER_PERSONA%>">volver</a>
	</h2>
	<form
		action="<%=request.getContextPath() + "/"
					+ Constantes.CONTROLLER_PERSONA%>"
		method="post">
		<input type="text" name="id" readonly value="<%=p.getId()%>">
		<br> <input type="text" name="name" value="<%=p.getNombre()%>">
		<br> <input type="numeric" name="edad" value="<%=p.getEdad()%>">
		<br> <input type="text" name="rol" disabled
			value="<%=p.getRol()%>"> <br> <input type="hidden"
			name="<%=Constantes.OP_KEY%>" value="<%=op%>">
		<input type="submit" value="<%=buttonValue%>">
	</form>

	<%
		if (!isNew) {
	%>
	<form
		action="<%=request.getContextPath() + "/"
						+ Constantes.CONTROLLER_PERSONA%>"
		method="post">
		<input type="hidden" name="id" disabled value="<%=p.getId()%>">
		<input type="hidden" name="<%=Constantes.OP_KEY%>"
			value="<%=Constantes.OP_DELETE%>"> <input type="submit"
			value="eliminar">
	</form>
	<%
		}
	%>
</body>
</html>