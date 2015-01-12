<%@page import="ipt.fm.ipartek.test.util.Constantes"%>
<%@page import="ipt.fm.ipartek.test.bean.Persona"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Formulario Persona</title>
	</head>
	
	<body>
		<%
			Persona persona = (Persona) request.getAttribute(Constantes.ATT_PERSONA);
			String buttonValue ="Crear";
			int op = Constantes.CRUD_UPDATE;
			boolean isNew = false;
			
			// Nueva Persona
			if (persona == null) {
				persona = new Persona();
				isNew = true;
				op = Constantes.CRUD_INSERT;
			// Modificar Persona
			} else {
				buttonValue = "Modificar";
			}
		%>
	
		<h1><%=buttonValue%> Persona</h1>
		<form action="<%=Constantes.CONTROLLER_PERSONA%>" method="post">
			<input type="hidden" name="id" value="<%=persona.getId()%>">
			<input type='hidden' name='op' value='<%=op%>'>
			<input type="text" name="nombre" placeholder="Nombre" value="<%=persona.getNombre()%>" required>
			<br>
			<input type="text" name="apellidos" placeholder="Apellidos" value="<%=persona.getApellidos()%>" required>
			<br>
			<input type="text" name="foto" placeholder="Foto" value="<%=persona.getFoto()%>">
			<br>
			<input type="submit" value="<%=buttonValue%>">	
		</form>
		
		<% if(!isNew) { %>
		<form action='<%=Constantes.CONTROLLER_PERSONA%>' method='post'>
			<input type="hidden" name="id" value="<%=persona.getId()%>">
			<input type='hidden' name='op' value='<%=Constantes.CRUD_DELETE%>'>
			<input type='submit' class="btn btn-danger pull-right" value='Eliminar'>
		</form>
		<% } %>
		
		<a href="<%=Constantes.JSP_INDEX%>" title="volver">Volver</a>	
	</body>
</html>