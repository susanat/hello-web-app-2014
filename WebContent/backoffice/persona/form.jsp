<%@page import="com.ipartek.formacion.helloweb.bean.Persona"%>
<%@page import="com.ipartek.formacion.helloweb.constantes.Constantes"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="../includes/head.jsp"%>
<%@include file="../includes/nav.jsp"%>
	<%
		String cabecera = "";
		String submitLabel = "";
		String op = "";
		boolean isNew = false;
		//recoger atributo de persona
		Persona p = (Persona)request.getAttribute(Constantes.ATT_PERSONA);
		if (p==null) {
			//La persona es vacia, vamos a crear una nueva
			p = new Persona("");
			cabecera = "Crear persona nueva";
			submitLabel = "Crear";
			op = Constantes.OP_INSERT;
			isNew = true;
		} else {
			//La persona viene cargada, se puede actualizar
			cabecera = "Modificar " + p.getNombre();
			submitLabel = "Modificar";
			op = Constantes.OP_UPDATE;
		}
	%>
	<h1><%=cabecera%></h1>
	<%@include file="/includes/alerts.jsp" %>
	<a href="<%=Constantes.CONTROLLER_PERSONA%>" title="Listado de personas">Listar personas</a>
	
	<form action="<%=Constantes.CONTROLLER_PERSONA %>" method="post">
		<input type="text" name="id" value="<%=p.getId()%>" readonly>
		<br>
		<input type="text" name="nombre" value="<%=p.getNombre()%>">
		<br>
		<input type="numeric" name="edad" value="<%=p.getEdad()%>">
		<br>
		<input type="radio" name="rol" value="0"
		<%
			if (Persona.Rol.ADMINISTRADOR.equals(p.getRole())) {
		%>
			checked
		<%
			}
		%>><%=Persona.Rol.ADMINISTRADOR%>
		<input type="radio" name="rol" value="1"
		<%
			if (Persona.Rol.USER.equals(p.getRole())) {
		%>
			checked
		<%
			}
		%>><%=Persona.Rol.USER%>
		<br>
		<input type="hidden" name="<%=Constantes.OP_KEY %>" value="<%=op%>">
		<input type="submit" value="<%=submitLabel%>">
	</form>
	
	<% 
	if (!isNew) {
	%>
	<form action="<%=Constantes.CONTROLLER_PERSONA %>" method="post">
		<input type="hidden" name="id" value="<%=p.getId()%>">
		<input type="hidden" name="<%=Constantes.OP_KEY %>" value="<%=Constantes.OP_DELETE%>">
		<input type="submit" value="Eliminar">
	</form>
	<%
	}
	%>
<%@include file="../includes/footer.jsp"%>