<%@page import="ipt.fm.ipartek.test.util.Constantes"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>LinkedIn Search</title>
		
		<!-- Latest compiled and minified CSS -->
		<link rel="stylesheet" href="css/bootstrap.min.css">
		
		<!-- Optional theme -->
		<link rel="stylesheet" href="css/bootstrap-theme.min.css">
		
		<!-- Latest compiled and minified JavaScript -->
		<script src="js/bootstrap.min.js"></script>		
	</head>
	
	<body>
		<div class="container">
			<div class="row">
				<div class="col-md-4">	
					<h1>LinkedIn Search</h1>	
		
					${requestScope.personasLinkedIn}
		
					<form action="searchProfile" method="post">
					 	<div class="form-group">
							<input type="text" name="first" class="form-control col-md-4" placeholder="Nombre" required><br>
						</div>
						<div class="form-group">
							<input type="text" name="last" class="form-control col-md-4" placeholder="Apellidos" required><br><br>
						</div>
						<div class="form-group">
							<input type="submit" class="btn btn-info" value="Buscar">	
						</div>
					</form>
		
					${requestScope.resulthtml}
					
					<a href="<%=Constantes.CONTROLLER_PERSONA%>" class="btn btn-primary" title="listar personas">Listar Personas</a>
					<a href="<%=Constantes.JSP_FORM_PERSONA%>" class="btn btn-primary" title="crear persona">Crear Persona</a>
				</div>
			</div>
		</div>
	</body>
</html>