<%@page import="ipt.fm.ipartek.test.linkedin.bean.PersonaLinkedin"%>
<%@page import="ipt.fm.ipartek.test.linkedin.bean.Persona"%>
<%@page import="java.util.ArrayList"%>

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
				<!-- <label class="sr-only" for="idNombre">Nombre</label> -->
				<input name="first" type="text" class="form-control" id="first"
					placeholder="Nombre" required>
			</div>
			<div class="form-group">
				<!-- <label class="sr-only" for="idApellidos">Apellidos</label>  -->
				<input name="last" type="text" class="form-control" id="last"
					placeholder="Apellidos" required>
			</div>
			<button type="submit" class="btn btn-default">Buscar</button>
		</form>
	</div>
	<br>
	<a href="PersonaServlet.do">Tabla Personas</a>
	<!-- 
		<input type="text" name="first" placeholder="Nombre" required>
		<br> <input type="text" name="last" placeholder="Apellidos"
			required> <br>
		<input type="SUBMIT" value="buscar" />
		
	</form>
	 -->
	<br>
	<br>
	<div id="idResultadoLinkedin">
		<%
			ArrayList<PersonaLinkedin> personas = (ArrayList<PersonaLinkedin>) request
					.getAttribute("resulthtml");
			if (personas == null) {
		%>
		No hay resultados
		<%
			} else {
				for (int i = 0; i < personas.size(); i++) {
		%>
		<div class='row col-md-offset-1 col-md-8 panel panel-default'>
			<div class="panel-heading">
				<h3 class="panel-title"><%=personas.get(i).getNombre() + " "
							+ personas.get(i).getApellidos()%></h3>
			</div>
			<div class="panel-body">
				<div class='row'>
					<div class="media col-md-2">
						<img class="media-left" alt='foto de perfil' name="foto"
							src='<%=personas.get(i).getFoto()%>'>

					</div>
					<div class="media-body">
						<%=personas.get(i).getBasic()%>
						<%=personas.get(i).getExpanded()%>
						<br>
						<form action='PersonaServlet
						' method='post'>
							<input type='hidden' name='nombre'
								value='<%=personas.get(i).getNombre()%>'> <input
								type='hidden' name='apellidos'
								value='<%=personas.get(i).getApellidos()%>'> <input
								type='hidden' name='foto' value='<%=personas.get(i).getFoto()%>'>
							<input type='hidden' name='action' value='crear'> <input
								type='submit' class="btn btn-primary" value='Guardar'>
						</form>
					</div>
				</div>
			</div>
		</div>
		<br>

		<%
			}
			}
		%>
	</div>
</body>
</html>