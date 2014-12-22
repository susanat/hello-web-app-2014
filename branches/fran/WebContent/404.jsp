<%@page isErrorPage="true"%>

<!DOCTYPE html">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Página no encontrada</title>
	</head>
	<body>
		<div class="row">
			<div class="col-lg-12">
				<h1>Esta página no existe!!</h1>
				<h1>JA, JA!</h1>
				<img src="<%=request.getContextPath()%>/assests/nelson.png" alt="Nelson"> 
				<br><br>
				<a href="http://localhost:8080/HelloWeb">Volver a intentarlo</a>
			</div>
		</div>
	</body>
</html>