<%@page import="ipt.fm.ipartek.test.util.Constantes"%>
<%@page import="java.util.ArrayList"%>
<%@page import="ipt.fm.ipartek.test.bean.Persona"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Lista de Personas</title>
				
		<!-- Latest compiled and minified CSS -->
		<link rel="stylesheet" href="css/bootstrap.min.css">
		
		<!-- Optional theme -->
		<link rel="stylesheet" href="css/bootstrap-theme.min.css">
		
		<!-- Latest compiled and minified JavaScript -->
		<script src="js/bootstrap.min.js"></script>		
	</head>
	
	<body>
		<div class="container">
			<%
				ArrayList<Persona> personas = (ArrayList<Persona>)request.getAttribute("personas");
			
				out.print("<table class='table table-striped'>");
				out.print("<thead>");
				out.print("<tr>");
				out.print("<th>ID</th>");
				out.print("<th>Nombre completo</th>");
				out.print("</tr>");
				out.print("</thead>");
				out.print("<tbody>");
				for(Persona persona : personas) {
					out.print("<tr>");
					out.print("<td>" + persona.getId() + "</td>");
					out.print("<td><a href='" + Constantes.CONTROLLER_PERSONA + "?idList=" + persona.getId() + "'>" 
						+ persona.getNombre() + " " + persona.getApellidos() + "</a></td>");
					out.print("</tr>");
				}
				out.print("</tbody>");
				out.print("</table>");
			%>
			<a href="<%=Constantes.JSP_INDEX%>" class="btn btn-primary" class="btn btn-primary"title="volver">Volver</a>
		</div>
	</body>
	
</html>