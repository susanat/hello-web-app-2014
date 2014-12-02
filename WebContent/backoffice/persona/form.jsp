<%@page import="com.ipartek.formacion.helloweb.Rol"%>
<%@page import="com.ipartek.formacion.helloweb.bean.Persona"%>
<%@page import="com.ipartek.formacion.helloweb.Constantes"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//Crear Persona nueva
	Persona p =(Persona) request.getAttribute(Constantes.ATT_PERSONA);
	//inicializar variables para el formulario
	String cabecera= "Crear nueva Persona";
	String buttonValue = "Crear";
	boolean isNew = false;
	String op = Constantes.OP_UPDATE;
	
	//nueva persona
	if( p == null ){
	    p = new Persona("");
	    isNew= true;
	    op=Constantes.OP_CREATE;
	//modificar persona
	}else{
	    cabecera = "Modificar " + p.getNombre();
	    buttonValue = "Modificar";
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Editar Persona</title>
</head>
<body>
	
	<%@include file="/includes/alerts.jsp" %>
	<h1><%=cabecera %></h1>
	
	<p><a href="<%= request.getContextPath()+"/"+ Constantes.CONTROLLER_PERSONA %>" title="volver">Volver</a></p>
	<form action="<%=request.getContextPath()+"/"+ Constantes.CONTROLLER_PERSONA %>" method="post">
		
		<input type="text" name="id" readonly value="<%= p.getId() %>">
		<br>
		<input type="text" name="nombre" value="<%= p.getNombre()%>">
		<br>
		<input type="number" name="edad" value="<%= p.getEdad()%>">
		<br>
		<input type="radio" name="rol" value="<%= Rol.ADMINISTRADOR %>" <%= (p.getRol()==Rol.ADMINISTRADOR)?"checked":"false"%> ><%= Rol.ADMINISTRADOR %>
		<input type="radio" name="rol" value="<%= Rol.USUARIO %>"  <%= (p.getRol()==Rol.USUARIO)?"checked":"false"%> ><%= Rol.USUARIO %>
		<br>
		<input type="hidden" name="<%=Constantes.OP_KEY %>" value="<%= op %>">
		
		<input type="submit" value="<%=buttonValue %>">
	</form>
	
	<% if (!isNew){ %>
	    <form action="<%=request.getContextPath()+"/"+ Constantes.CONTROLLER_PERSONA %>" method="post">
		
		<input type="hidden" name="id" value="<%= p.getId() %>">
		<input type="hidden" name="<%=Constantes.OP_KEY %>" value="<%=Constantes.OP_DELETE%>">
		<input type="submit" value="Eliminar">
	</form>
	<%} %>	 
	
	
	
</body>
</html>