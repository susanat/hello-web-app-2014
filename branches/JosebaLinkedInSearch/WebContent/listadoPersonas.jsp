<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listado personas</title>
</head>
<body>
	<h1>Listado Personas</h1>
	${requestScope.personas}
	
	<h2><a href="buscador.jsp">Volver al buscador</a></h2>
</body>
</html>