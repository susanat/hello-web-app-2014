<%@page import="ipt.fm.ipartek.test.util.Constantes"%>
<%@page import="ipt.fm.ipartek.test.bean.Persona"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Formulario Persona</title>
		
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
					<h1><%=buttonValue%> Persona</h1>
					<form action="<%=Constantes.CONTROLLER_PERSONA%>" method="post">
						<input type="hidden" name="id" value="<%=persona.getId()%>">
						<input type='hidden' name='op' value='<%=op%>'>
						<div class="form-group">
							<input type="text" class="form-control col-md-4" name="nombre" placeholder="Nombre" value="<%=persona.getNombre()%>" required><br>
						</div>
						<div class="form-group">
							<input type="text" class="form-control col-md-4" name="apellidos" placeholder="Apellidos" value="<%=persona.getApellidos()%>" required><br>
						</div>
						<div class="form-group">
							<input type="text" class="form-control col-md-4" name="foto" placeholder="Foto" value="<%=persona.getFoto()%>"><br><br>
						</div>
						<div class="form-group">
							<input type="submit" class="btn btn-success pull-left" value="<%=buttonValue%>">
						</div>
					</form>
					<a href="<%=Constantes.JSP_INDEX%>" class="btn btn-primary pull-left" title="volver">Volver</a>	
					
					<% if(!isNew) { %>
					<form action='<%=Constantes.CONTROLLER_PERSONA%>' method='post'>
						<div class="form-group">
							<input type="hidden" name="id" value="<%=persona.getId()%>">
						</div>
						<div class="form-group">
							<input type='hidden' name='op' value='<%=Constantes.CRUD_DELETE%>'>
						</div>
						<div class="form-group">
							<input type='submit' class="btn btn-danger pull-right" value='Eliminar'>
						</div>
					</form>
					<% } %>
				</div>		
			</div>
		</div>	

	</body>
</html>