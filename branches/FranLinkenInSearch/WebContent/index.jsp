<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html">
<title>LinkedIn Search</title>
</head>
<body>

<h1>LinkedIn Search</h1>

<a href="http://localhost:8080/LinkenInSearch/persona">Listado</a>

<form action="searchProfile" method="post">
	
	<input type="text" name="first" placeholder="Nombre" required>
	<br>
	<input type="text" name="last" placeholder="Apellidos" required>
	<br>
	<input type="submit" value="buscar">	
</form>

${requestScope.resulthtml}


</body>
</html>