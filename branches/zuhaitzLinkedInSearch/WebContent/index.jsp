<%@page import="ipt.fm.ipartek.test.bean.Persona"%>
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
	
		<%
			Persona persona = (Persona) request.getAttribute(Constantes.ATT_PERSONA);
			String buttonValue ="Crear";
			int op = Constantes.CRUD_UPDATE;
			boolean isNew = false;
			
			// Nueva Persona
			if (persona == null) {
				persona = new Persona();
				isNew = true;
				op = Constantes.CRUD_INSERT;
			// Modificar Persona
			} else {
				buttonValue = "Modificar";
			}
		%>
	
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
					
					<a href="<%=Constantes.CONTROLLER_PERSONA%>" class="btn btn-primary pull-left" title="listar personas">Listar Personas</a>
					
					<% if(request.getAttribute("resulthtml") != null) {%>
						<form action="<%=Constantes.CONTROLLER_PERSONA%>" method="post">
							<input type='hidden' name='op' value='<%=Constantes.CRUD_INSERT%>'>
							<input type="hidden" name="id" value="<%=persona.getId()%>">
							<input type="hidden" name="nombre" value='<%=request.getParameter("first")%>'>
							<input type="hidden" name="apellidos" value='<%=request.getParameter("last")%>'>
							<input type="hidden" name="foto" value='<%=request.getAttribute("foto")%>'>
							<input type="submit" class='btn btn-primary pull-right' value='Crear'>
						</form>
					<%}%>
				</div>
			</div>
		</div>
	</body>
</html>