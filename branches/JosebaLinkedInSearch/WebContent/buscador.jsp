<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>LinkedIn Search</h1>
	
	
	<form action="searchProfile" method="post">
		Nombre:
		<input type="text" name="first" id="first" required><br>
		Apellido:
		<input type="text" name="last" id="last" required><br>
		<input type="submit" value="buscar">
	</form>
	<h2><a href="PersonaServlet">Ver todos</a></h2>
</body>
</html>