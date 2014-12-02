<%@page import="com.ipartek.formacion.helloweb.temp.UtilsTemp"%>
<%@page import="com.ipartek.formacion.helloweb.comun.Utils"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="com.ipartek.formacion.helloweb.bean.Persona"%>
<%@page import="java.util.List"%>
<%@page import="com.ipartek.formacion.helloweb.comun.Constantes"%>

<%
	//Persona persona = null;

	//obtenemos el actual path
	String path = request.getRequestURL().toString();
	
	//creamos una session anónima si no existe
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

  	<link rel="stylesheet" href="<%= Constantes.SITE_PATH%>bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="<%= Constantes.SITE_PATH%>bootstrap/css/main.css">
	
	<style>
	body {
		padding-top: 50px;
		padding-bottom: 20px;
	}
	</style>
	
	<script src="<%= Constantes.SITE_PATH%>bootstrap/js/vendor/jquery-1.11.1.min.js"></script>
	<script>window.jQuery || document.write('<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"><\/script>')</script>
	
	<link rel="stylesheet" href="<%= Constantes.SITE_PATH%>bootstrap/css/bootstrap-theme.min.css">
	
	
	<script src="<%= Constantes.SITE_PATH%>bootstrap/js/vendor/modernizr-2.6.2-respond-1.1.0.min.js"></script>


	

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
	
	
	
	
	<div class="container">
		<nav>
			<!-- Insert breadcrumb -->
			<ol class="breadcrumb">
				<li><a href="<%= Constantes.JSP_BACK_ADMIN %>">Administracion</a></li>
				<li>Listado Personas</li>
			</ol>
		</nav>
	
		<div class="row text-center">
			<h1>Listado Personas</h1>
		</div>
		<%
		
			//Si no existe el atributo, ha entrado directamente en el jsp, cargamos el listado
			if( request.getAttribute(Constantes.ATTR_PERSONAS_LIST) == null) {
				response.sendRedirect(Constantes.SITE_PATH + Constantes.CONTROLLER_PERSONA);
			} else {
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
						            <th>Editar</th>             
						            <th>Eliminar</th>
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
						out.println("<td>" + UtilsTemp.getNameFromRole(request, String.valueOf(per.getRol()) ) + "</td>");						
						out.println("<td>");
						%>						
							<form action="<%=Constantes.CONTROLLER_PERSONA %>" method="post">							
								<input type='hidden' value='<%= Constantes.EModeloAccion.GET.getValue() %>' name='<%= Constantes.PARAM_ACTION %>' />
							    <input type='hidden' value='<%= per.getId() %>' name='<%= Constantes.PARAM_PERSONAS_ID %>' />
							    <input type='hidden' value='<%= Constantes.JSP_BACK_PERSONA_FORM %>' name='<%= Constantes.PARAM_URL_TO %>' />
							    <input type='submit' name="submit" value='Editar' class='btn btn-success btn-lg'>
							</form>
						<%
						out.println("</td>");
						
						out.println("<td>");
						%>						
							<form action="<%=Constantes.CONTROLLER_PERSONA %>" method="post">							
								<input type='hidden' value='<%= Constantes.EModeloAccion.DELETE.getValue() %>' name='<%= Constantes.PARAM_ACTION %>' />
							    <input type='hidden' value='<%= per.getId() %>' name='<%= Constantes.PARAM_PERSONAS_ID %>' />							    
							    <input type='submit' name="submit" value='Eliminar' class='btn btn-success btn-lg'>
							</form>
						<%
						out.println("</td>");
						
						
						
						out.println("</tr>");
					}	
					
					
					%>
						<!-- html -->
						 	</tbody>
						</table>
						
						
					<%
		
				}
				
				%>
					<script>
					$(document).ready(function(){
						
						lanzarToast();
					
						function lanzarToast(){
							//http://codeseven.github.io/toastr/demo.html
							toastr.options = {
									  "closeButton": true,
									  "debug": false,
									  "progressBar": false,
									  "positionClass": "toast-bottom-right",
									  "onclick": null,
									  "showDuration": "200",
									  "hideDuration": "1000",
									  "timeOut": "3000",
									  "extendedTimeOut": "1000",
									  "showEasing": "swing",
									  "hideEasing": "linear",
									  "showMethod": "slideDown",
									  "hideMethod": "fadeOut"
									}
							
							// Display an info toast with no title
							toastr.success('Listado cargado correctamente.');
						}
						
							
					
					});	
					</script>
				<%
				
			}
		%>
			
		<div class="row">
			<div class="col-md-6">			
				<a href="<%= Constantes.JSP_BACK_PERSONA_FORM %>" type="button" class="btn btn-success btn-lg">
					Nueva Persona
				</a>
			</div>
			
			<div class="col-md-6 text-right" >					
				<a href="<%= Constantes.SITE_PATH + Constantes.CONTROLLER_PERSONA %>" type="button" class="btn btn-success btn-lg">
					Actualizar
				</a>
			</div>	
		</div>
	
	
	
	</div> <!-- fin content -->
	
	<!-- Añadimos los javascript -->
	
	
	<script src="<%= Constantes.SITE_PATH%>bootstrap/js/vendor/bootstrap.min.js"></script>
	<script src="<%= Constantes.SITE_PATH%>bootstrap/js/main.js"></script>
	
	<link href="<%= Constantes.SITE_PATH%>bootstrap/js/vendor/toastr/toastr.css" rel="stylesheet"/>
	<script src="<%= Constantes.SITE_PATH%>bootstrap/js/vendor/toastr/toastr.js"></script>
	
</body>
</html>