<%@include file="../includes/head.jsp" %>
<%@include file="../includes/nav.jsp" %>

<%@page import="com.ipartek.formacion.helloweb.util.Rol"%>
<%@page import="com.ipartek.formacion.helloweb.bean.Persona"%>
<%@page import="com.ipartek.formacion.helloweb.Constantes"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%
	Persona persona = (Persona) request.getAttribute(Constantes.ATTR_PERSONA);
	String cabecera = "Crear nueva Persona";
	String buttonValue ="Crear";
	int op = Constantes.OP_UPDATE;
	boolean isNew = false;
	
	// Nueva Persona
	if (persona == null) {
		persona = new Persona("");
		isNew = true;
		op = Constantes.OP_INSERT;
	// Modificar Persona
	} else {
		cabecera = "Modificar " + persona.getNombre();
		buttonValue = "Modificar";
	}
%>

	<!-- <h1><%=cabecera%></h1> -->
	<a href="<%=request.getContextPath() + "/" + Constantes.CONTROLLER_PERSONA%>" 
	   title="ir a la lista de personas">Lista Personas</a>
	<%@include file="/includes/alert.jsp"%>

	<form action="<%=request.getContextPath() + "/" + Constantes.CONTROLLER_PERSONA%>" method="post">
		<input type='hidden' name='op' value=<%=op%>>
		<input type='text' name='id' readonly value='<%=persona.getId()%>'>
		<br> 
		<input type='text' name='nombre' value="<%=persona.getNombre()%>">
		<br> 
		<input type='number' name='edad' value="<%=persona.getEdad()%>">
		<br> 
		<input type='radio' name='rol' value='<%=Rol.ADMINISTRADOR%>'/>Administrador
		<input type='radio' name='rol' checked value='<%=Rol.USUARIO%>'/>Usuario
	
	  	<%if(persona.getRol() == Rol.ADMINISTRADOR){%>

		<%} else if(persona.getRol() == Rol.USUARIO){%>
		
		<%}%>
	
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