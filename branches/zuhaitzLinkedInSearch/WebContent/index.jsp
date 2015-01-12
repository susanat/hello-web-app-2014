<%@page import="ipt.fm.ipartek.test.util.Constantes"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>LinkedIn Search</title>
	</head>
	
	<body>	
		<h1>LinkedIn Search</h1>	
		
		${requestScope.personasLinkedIn}
		
		<form action="searchProfile" method="post">
			<input type="text" name="first" placeholder="Nombre" required>
			<br>
			<input type="text" name="last" placeholder="Apellidos" required>
			<br>
			<input type="submit" value="Buscar">	
		</form>
		
		${requestScope.resulthtml}
		
		<a href="<%=Constantes.CONTROLLER_PERSONA%>" title="listar personas">Listar Personas</a>
		<a href="<%=Constantes.JSP_FORM_PERSONA%>" title="crear persona">Crear Persona</a>
	
	</body>
</html>