<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="UTF-8">

<title>LinkedIn Search</title>
<link rel="stylesheet" href="css/style.css"/>
</head>
<body>
<div class="registro">
<h1>LinkedIn Search</h1>

<h2>Personas</h2>




<form action="searchProfile" method="post">
	
	<input type="text" name="first" placeholder="Nombre" required>
	<br>
	<input type="text" name="last" placeholder="Apellidos" required>
	<br>
	<input type="submit" value="BUSCAR">	
</form>
</div>

<div class="resultados">
<h1>Resultados de la busqueda</h1>
<h2>Nº de resultados: ${requestScope.personas} </h2>
<div class="blanco">${requestScope.resulthtml}</div>
</div>


</body>
</html>