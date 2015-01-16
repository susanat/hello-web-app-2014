<%@page import="com.ipartek.formacion.linkedin.Constantes"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<base href="<%=request.getContextPath()+"/"%>">
  	<title>Linkedin search</title>
  	<link href="css/bootstrap.min.css" rel="stylesheet">
 	<link href="css/main.css" rel="stylesheet">
</head>
<body>

	<div id="search">
		<form name="searchForm" action="<%= Constantes.PATH_BUSCAR %>"
			method="post">
			<h3>Busqueda de LinkedIn</h3>

			<label for="first">Nombre</label>
			
			<input type="text" name="first" id="first" placeholder="Nombre"
				required /> <label for="last">Apellidos</label>
			
			<input type="text" name="last" id="last" placeholder="Apellidos"
				required />

			<p class="action">
				<input class="btn-secondary" type="submit" name="search"
					value="Buscar" />
			</p>
		</form>
	</div>
	
	<a  href="<%= Constantes.PATH_LISTADO_PERSONAS %>">ver Listado</a>

</body>
</html>