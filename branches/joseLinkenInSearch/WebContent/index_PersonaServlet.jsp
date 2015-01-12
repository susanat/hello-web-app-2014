<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>LinkedIn Search</title>
</head>
<body>

	<h1>LinkedIn Search</h1>


	${requestScope.personas}

	<form action="PersonaServlet" method="post">

		<input type="text" name="nombre" placeholder="Nombre" required>
		<br> <input type="text" name="apellidos" placeholder="Apellidos"
			required> <br> Action
		<table>
			<tr>
				<td>
					<!--  <input type="radio" name="Action" value="Actualizar" /> Actualizar --> 
					<!--  <input type="radio" name="Action" value="Eliminar" /> Eliminar -->
					<input type="radio" name="Action" value="Crear" checked /> Crear 
					<input type="radio" name="Action" value="Buscar" /> Buscar
				</td>
			</tr>
		</table>
		<input type="SUBMIT" value="Submit" />
	</form>

	${requestScope.resulthtml}


</body>
</html>