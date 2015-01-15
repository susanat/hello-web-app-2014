<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Buscador LinkedIn</title>
<link rel="stylesheet" type="text/css" href="css/styles.css"/>
</head>
<body>
	<h1>LinkedIn Search</h1>
	
	
	<form action="searchProfile" method="post">
		<div class="form-group">
		 <label for="first">Nombre</label>
		<input type="text" name="first" id="first" required class="form-control" placeholder="Nombre">
		</div>
		<div class="form-group">
		<label for="last">Apellido</label>
		<input type="text" name="last" id="last" required class="form-control" placeholder="Apellido">
		</div>
		
		<input type="submit" value="buscar" class="btn btn-default">
	</form>
	<h2><a href="PersonaServlet">Ver todos</a></h2>
</body>
</html>