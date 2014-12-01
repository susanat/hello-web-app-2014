<%@page import="com.ipartek.formacion.helloweb.comun.Utils"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="com.ipartek.formacion.helloweb.bean.Persona"%>
<%@page import="java.util.List"%>
<%@page import="com.ipartek.formacion.helloweb.comun.Constantes"%>

<%
	Persona persona = null;

	//obtenemos el actual path
	String path = request.getRequestURL().toString();
	
	//creamos una session anónima
	if(session == null) {
		session = request.getSession(true);
	}
	
	//añadimos el último path visitado
	session.setAttribute(Constantes.PARAM_SESSION_LAST_URL, path);
	
%>

<!doctype html>

<html lang="en">
<head>
  <meta charset="utf-8">

  <title>Administracion: personas</title>
  <meta name="description" content="">
  <meta name="author" content="">

  <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="bootstrap/css/main.css">
	
	<style>
	body {
		padding-top: 50px;
		padding-bottom: 20px;
	}
	</style>
	<link rel="stylesheet" href="bootstrap/css/bootstrap-theme.min.css">
	<link rel="stylesheet" href="bootstrap/css/main.css">
	
	<script src="bootstrap/js/vendor/modernizr-2.6.2-respond-1.1.0.min.js"></script>


	  <!--[if lt IE 9]>
	  <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
	  <![endif]-->
	<style>
	
	table {
		padding-left: 20px;
		padding-right: 20px;
	    border-collapse: separate;
	    border-spacing: 0 5px;
	}
	
	thead th {
	    background-color: #006DCC;
	    color: white;
	}
	
	tbody td {
	    background-color: #EEEEEE;
	}
	
	tr td:first-child,
	tr th:first-child {
	    border-top-left-radius: 6px;
	    border-bottom-left-radius: 6px;
	}
	
	tr td:last-child,
	tr th:last-child {
	    border-top-right-radius: 6px;
	    border-bottom-right-radius: 6px;
	}
	</style>


</head>

<body>

	<h1>Listado Personas</h1>
	
	<%
	
		List<Persona> personas = (List<Persona>) request.getAttribute(Constantes.ATTR_PERSONAS_LIST);
		if (personas == null) {
			%>
				<h2>No existe ningún registro relativo a la consulta </h2>
		
			<% 
		} else {

 
			
			%>
				<!-- html -->
				<table class="table">
				    <thead>
				        <tr>
				        	<th></th>
				            <th>Id</th>
				            <th>Nombre</th>
				            <th>Edad</th>
				            <th>Role</th>            
				        </tr>
				    </thead>
				    <tbody>
			<%
			
			
			for (Persona per : personas ) {
				
				out.println("<tr>");
				out.println("<td>" + "PNG" + "</td>");
				out.println("<td>" + per.getId() + "</td>");
				out.println("<td>" + per.getNombre() + "</td>");
				out.println("<td>" + per.getEdad() + "</td>");
				out.println("<td>" + per.getRol().toString() + "</td>");
				out.println("</tr>");
			}	
			
			
			%>
				<!-- html -->
				 	</tbody>
				</table>
				
				<div class="row">					
					<a href="<%= Constantes.JSP_BACK_PERSONA_FORM %>" type="button" class="btn btn-success btn-lg">
						Nueva Persona
					</a>
				</div>
			<%

		}
	
	%>
	
	
	<!-- Añadimos los javascript -->
	<script src="bootstrap/js/vendor/jquery-1.11.1.min.js"></script>
	<script>window.jQuery || document.write('<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"><\/script>')</script>
	
	<script src="bootstrap/js/vendor/bootstrap.min.js"></script>
	<script src="bootstrap/js/main.js"></script>
	
	
</body>
</html>