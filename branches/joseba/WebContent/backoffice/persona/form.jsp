<%@page import="com.ipartek.formacion.helloweb.bean.Persona"%>
<%@page import="com.ipartek.formacion.helloweb.Constantes"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Editar persona</title>
</head>
<body>
<%
			Persona p = (Persona)request.getAttribute(Constantes.ATT_PERSONA);
			String cabecera = "Crear nueva persona";
			String buttonValue = "Crear";
			String op= Constantes.OP_UPDATE;
			boolean isNew = false;
			
			//nueva persona
			if(p == null){
			    p = new Persona("");
			    isNew = true;
			    op = Constantes.OP_CREATE;
			  
			}
			//modificar persona
			else{
			    cabecera = "Modificar " + p.getNombre();
			    buttonValue = "Modificar";
			}
		%>
		<h1><%=cabecera %> <%=p.getNombre() %></h1>
		<%@include file="/include/alerts.jsp" %>
		<h2><a href="<%=request.getContextPath() + "/" + Constantes.CONTROLLER_PERSONA %>">Volver</a></h2>
		
		<form action="<%=request.getContextPath() + "/" + Constantes.CONTROLLER_PERSONA %>" method="post">
			<input type="text" name="id" readonly="readonly" value="<%=p.getId()%>">
			<br>
			<input type="text" name="name" value="<%=p.getNombre()%>">
			<br>
			<input type="number" name="edad" value="<%=p.getEdad()%>">
			<br>
			<input type="radio" name="rol" value=<%=Persona.Rol.ADMINISTRADOR %>>Administrador<br>
			<input type="radio" name="rol" value=<%=Persona.Rol.USER %>>Usuario
			<br>
			<input type="hidden" name="op" value=<%= op %>>
			<input type="submit" value=<%=buttonValue %>>
		</form>
		<!-- TODO: Formulario eliminar -->
		
		<%
			if(!isNew){
		%>
		<form action="<%=request.getContextPath() + "/" + Constantes.CONTROLLER_PERSONA %>" method="post">
			<input type="hidden" name="id" value="<%=p.getId() %>">
			<input type="hidden" name=<%=Constantes.OP_KEY %> value=<%=Constantes.OP_DELETE %>>
			<input type="submit" value="Eliminar">
		</form>
		<%} %>
		
</body>
</html>