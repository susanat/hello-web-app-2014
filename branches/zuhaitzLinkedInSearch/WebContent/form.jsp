<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Crear Persona</title>
	</head>
	
	<body>
	
		<h1>Crear Persona</h1>
		<form action="persona" method="post">
			<input type="text" name="nombre" placeholder="Nombre" required>
			<br>
			<input type="text" name="apellidos" placeholder="Apellidos" required>
			<br>
			<input type="number" name="edad" placeholder="Edad" required>
			<br>
			<input type="submit" value="Crear">	
		</form>
	
	</body>
</html>