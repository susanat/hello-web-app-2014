<%@page import="com.ipartek.formacion.helloweb.bean.Persona"%>
<%@page import="com.ipartek.formacion.helloweb.Constantes"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Editar Persona</title>
</head>
<body>
	<h1>Editar Persona</h1>
	<p><a href="<%= request.getContextPath()+"/"+ Constantes.CONTROLLER_PERSONA %>" title="volver">Volver</a></p>
	<%
		//Crear Persona nueva
		Persona p =(Persona) request.getAttribute(Constantes.ATT_PERSONA);
		if( p == null ){
		    p = new Persona("");
		}
	%>
	<form action="<%=request.getContextPath()+"/"+ Constantes.CONTROLLER_PERSONA %>" method="post">
		
		<input type="text" name="id" disabled value="<%= p.getId() %>">
		<br>
		<input type="text" name="nombre" value="<%= p.getNombre()%>">
		<br>
		<input type="number" name="edad" value="<%= p.getEdad()%>">
		<br>
		<input type="text" name="rol" value="<%= p.getRol()%>">
		<br>
		<input type="hidden" name="<%=Constantes.OP_KEY %>" value="<%=Constantes.OP_UPDATE%>">
		<input type="submit" value="crear">
	</form>
	
	<form action="<%=request.getContextPath()+"/"+ Constantes.CONTROLLER_PERSONA %>" method="post">
		
		<input type="hidden" name="id" disabled value="<%= p.getId() %>">
		<input type="hidden" name="<%=Constantes.OP_KEY %>" value="<%=Constantes.OP_DELETE%>">
		<input type="submit" value="Eliminar">
	</form>
</body>
</html>