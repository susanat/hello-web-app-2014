<%@include file="../includes/head.jsp" %>
<%@include file="../includes/nav.jsp" %>

<%@page import="com.ipartek.formacion.helloweb.util.Rol"%>
<%@page import="com.ipartek.formacion.helloweb.bean.Persona"%>
<%@page import="com.ipartek.formacion.helloweb.Constantes"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%
	Persona p = (Persona) request.getAttribute(Constantes.ATTR_PERSONA);
	String cabecera = "Crear nueva Persona";
	String buttonValue ="Crear";
	int op = Constantes.OP_UPDATE;
	boolean isNew = false;
	
	// Nueva Persona
	if (p == null) {
		p = new Persona("");
		isNew = true;
		op = Constantes.OP_INSERT;
	// Modificar Persona
	} else {
		cabecera = "Modificar " + p.getNombre();
		buttonValue = "Modificar";
	}
%>


	<h1><%=cabecera%></h1>
	<a href="<%=request.getContextPath() + "/" + Constantes.CONTROLLER_PERSONA%>" 
	   title="ir a la lista de personas">Lista Personas</a>
	<%@include file="/includes/alert.jsp"%>

	<form action="<%=request.getContextPath() + "/" + Constantes.CONTROLLER_PERSONA%>" method="post">
		<input type='hidden' name='op' value=<%=op%>>
		<input type='text' name='id' readonly value='<%=p.getId()%>'>
		<br> 
		<input type='text' name='name' value="<%=p.getNombre()%>">
		<br> 
		<input type='number' name='edad' value="<%=p.getEdad()%>">
		<br> 
		<input type='radio' name='rol' value='<%=Rol.ADMINISTRADOR%>'/>Administrador
		<input type='radio' name='rol' checked value='<%=Rol.USUARIO%>'/>Usuario
		<br>
		<input type='submit' value='<%=buttonValue%>'>
		
	</form>
	
	<% if(!isNew) { %>
		<form action='<%=request.getContextPath() + "/" + Constantes.CONTROLLER_PERSONA%>' method='post'>
			<input type='hidden' name='op' value=<%=Constantes.OP_DELETE %>>
			<input type='submit' value='Eliminar'>
		</form>
	<% } %>

<%@include file="../includes/footer.jsp" %> 