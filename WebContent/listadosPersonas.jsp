<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>LinkedIn Search</title>
</head>
<body>

<h1>LinkedIn Search</h1>

<a href="http://localhost:8080/LinkenInSearch/index.jsp">Volver</a>
<br>
<%
	String personas = (String)request.getAttribute("personas");
	if (personas.length() > 0) {
		String[] persona = personas.split(";");
		String[] datos;
		for (int i=0; i<persona.length; i++) {
			datos = persona[i].split(",");
%>
			<form action="persona" method="post">
				<input type="text" name="id" value="<%=datos[2]%>" readonly>
				<input type="text" name="nombre" value="<%=datos[0]%>">
				<input type="text" name="apellidos" value="<%=datos[1]%>">
				<input type="hidden" name="operacion" value="0">
				<input type="submit" value="Actualizar">
			</form>
			<form action="persona" method="post">
				<input type="hidden" name="id" value="<%=datos[2]%>">
				<input type="hidden" name="operacion" value="1">
				<input type="submit" value="Eliminar">
			</form>
<%
		}
	}

%>

</body>
</html>