<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>LinkedIn Search</title>
<!-- Bootstrap Core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/styleLinkedin.css" rel="stylesheet">

</head>
<body>
		<h1>LinkedIn Search</h1>


	<div class="container">

		${requestScope.personas}

		<form class="form-inline" action="searchProfile" method="post">
			<div class="form-group">
				<label class="sr-only" for="idNombre">Nombre</label> <input
					type="text" class="form-control" id="idNombre" placeholder="Nombre"
					required>
			</div>
			<div class="form-group">
				<label class="sr-only" for="idApellidos">Apellidos</label> <input
					type="text" class="form-control" id="idApellidos"
					placeholder="Apellidos" required>
			</div>
			<button type="submit" class="btn btn-default">Buscar</button>
		</form>
	</div>
	<!-- 
		<input type="text" name="first" placeholder="Nombre" required>
		<br> <input type="text" name="last" placeholder="Apellidos"
			required> <br>
		<input type="SUBMIT" value="buscar" />
		
	</form>
	 -->
<div id="idResultadoLinkedin">
	${requestScope.resulthtml}
</div>

</body>
</html>