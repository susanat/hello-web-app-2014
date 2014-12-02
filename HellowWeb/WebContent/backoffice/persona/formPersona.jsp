<%@page import="com.ipartek.formacion.helloweb.temp.UtilsTemp"%>
<%@page import="com.ipartek.formacion.helloweb.bean.Persona"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.ipartek.formacion.helloweb.bean.Roles"%>
<%@page import="com.ipartek.formacion.helloweb.comun.Constantes"%>
<%@page pageEncoding="UTF-8" %>

<%
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

  <title>Administracion: Formulario Persona</title>
  <meta name="description" content="">
  <meta name="author" content="">

  <link rel="stylesheet" href="<%=Constantes.SITE_PATH %>bootstrap/css/bootstrap.min.css">
  <link rel="stylesheet" href="<%=Constantes.SITE_PATH %>bootstrap/css/main.css">
  
	
	<style>
	body {
		padding-top: 50px;
		padding-bottom: 20px;
	}
	</style>
	<link rel="stylesheet" href="<%=Constantes.SITE_PATH %>bootstrap/css/bootstrap-theme.min.css">
	<link rel="stylesheet" href="<%=Constantes.SITE_PATH %>bootstrap/css/main.css">
	
	<script src="<%=Constantes.SITE_PATH %>bootstrap/js/vendor/modernizr-2.6.2-respond-1.1.0.min.js"></script>
	
	<!-- JQUERY -->
	<script src="<%=Constantes.SITE_PATH %>bootstrap/js/vendor/jquery-1.11.1.min.js"></script>
	<script>window.jQuery || document.write('<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"><\/script>')</script>

  <!--[if lt IE 9]>
  <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
  <![endif]-->
</head>

<body>

	<% 
	
	//default values
	String id = "-1";
	String nombre = "";
	String edad = "0";
	Roles role = null;
	
	//ORIGEN: nos ha llegado la persona por el servlet (en una lista)
	if (request.getAttribute(Constantes.ATTR_PERSONAS_LIST) != null) {
		
		List<Persona> personas = (List<Persona>)request.getAttribute(Constantes.ATTR_PERSONAS_LIST);
		if(personas != null && personas.size() > 0) {
			id = String.valueOf(personas.get(0).getId());
			nombre = personas.get(0).getNombre();
			edad = String.valueOf(personas.get(0).getEdad());
			role = personas.get(0).getRol();
		}
		
	} else	if (request.getParameter(Constantes.PARAM_PERSONAS_ID) != null) {
		//ORIGEN: nos ha llegado por post un parámetro de identificador
			//solicitamos al servlet que nos mande la información del usuario
			//llamamos para que nos cargue persona
			%>
				<form id="get_from_id" action="<%=Constantes.SITE_PATH +  Constantes.CONTROLLER_PERSONA %>" method="post">
						<input type='hidden' value='<%= request.getParameter(Constantes.PARAM_PERSONAS_ID) %>' name='<%= Constantes.PARAM_PERSONAS_ID %>' />						
				</form>
				<script>
				$( "#get_from_id" ).ready(function() {
					  $( "#get_from_id" ).submit();
				});
				</script>
			<%
		
	} else {
		//ORIGEN: ninguno. Para crear una nueva persona
	}




%>

	<nav>
		<!-- Insert breadcrumb -->
		<ol class="breadcrumb">
			<li><a href="<%= Constantes.JSP_BACK_ADMIN %>">Administracion</a></li>
			<li><a href="<%= Constantes.JSP_BACK_PERSONA_LIST %>">Listado Personas</a></li>
			<li>Formulario Persona</li>
		</ol>
	</nav>
	
	<div class="container row-centered">		
		<div class="col-xs-4 col-centered">
		
			<div class="row row-centered sombra" style="border: 1px solid; border-radius: 4px; margin-bottom: 20px; border-color: #428BCA; background-color: #428BCA; color: white;">				
					<h1>Nueva Persona</h1>	
					<p> <%= request.getRequestURL().toString() %> </p>			
			</div>
		
			<div class="row">
			<div class="panel panel-primary sombra ">
		    	<div class="panel-heading">
		      		<h3 class="panel-title">Crear nueva persona</h3>
		    	</div>
		    	<div class="panel-body">		
		    	
					<form class="" role="form" method="post" id="frm_personas" action="<%= Constantes.SITE_PATH +  Constantes.CONTROLLER_PERSONA %>">
						<div class="form-group form-group-install col-md-12">
							<label class="control-label" for="cont1">Id</label>
							<input class="form-control" type="text" name="<%=Constantes.PARAM_PERSONAS_ID%>" id="cont1" 
								value="<%= id %>" 
							 	placeholder="" disabled>
						</div>
					
					
						<div class="form-group form-group-install col-md-12">
							<label class="control-label" for="cont2">Nombre</label>
							<input class="form-control" type="text" name="<%=Constantes.PARAM_PERSONAS_NOMBRE%>" id="cont2" 
							value="<%=nombre %>" 
							required="required" placeholder="Enter the username">
						</div>
						
						<div class="form-group form-group-install col-md-12">
							<label class="control-label" for="cont3">Edad</label>
							<input class="form-control" type="numeric" name="<%=Constantes.PARAM_PERSONAS_EDAD%>" id="cont3"
							value="<%=edad %>"
							required="required" placeholder="">
						</div>
						
						<div class="form-group form-group-install col-md-12">
						
							<label class="control-label" for="cont4">Rol</label>
							<%= UtilsTemp.getComboRoles(request, role) %>
							
							
						</div>
						
						<!-- Path de referencia para redirigir -->
						<input type="hidden" name="<%=Constantes.PARAM_SESSION_LAST_URL%>" value="<%= path %>">
						
						<div class="col-xs-12 text-right">
								<input form="frm_personas" class="btn btn-success btn-lg" 
									type="submit" name="save" value="Guardar" 
									title="Guardar" />				  		
						</div>						
					</form>	
				</div> <!--  panel-body -->				
			</div>
			
			
			
		</div>
		</div>
	</div>
	
	
	
	

  	<!-- Añadimos los javascript -->
	
	
	<script src="<%=Constantes.SITE_PATH %>bootstrap/js/vendor/bootstrap.min.js"></script>
	<script src="<%=Constantes.SITE_PATH %>bootstrap/js/main.js"></script>
</body>
</html>