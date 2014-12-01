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
</head>

<body>

	<div class="container row-centered">
				
		
		<div class="col-xs-4 col-centered">
		
			<div class="row row-centered sombra" style="border: 1px solid; border-radius: 4px; margin-bottom: 20px; border-color: #428BCA; background-color: #428BCA; color: white;">				
					<h1>Nueva Persona</h1>				
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
							<input class="form-control" type="text" name="<%=Constantes.PARAM_PERSONAS_ID%>" id="cont1" value="" 
							 placeholder="" disabled>
						</div>
					
					
						<div class="form-group form-group-install col-md-12">
							<label class="control-label" for="cont2">Nombre</label>
							<input class="form-control" type="text" name="<%=Constantes.PARAM_PERSONAS_NOMBRE%>" id="cont2" value="" 
							required="required" placeholder="Enter the username">
						</div>
						
						<div class="form-group form-group-install col-md-12">
							<label class="control-label" for="cont3">Edad</label>
							<input class="form-control" type="numeric" name="<%=Constantes.PARAM_PERSONAS_EDAD%>" id="cont3" value=""
							required="required" placeholder="">
						</div>
						
						<div class="form-group form-group-install col-md-12">
							<label class="control-label" for="cont4">Role</label>
							<input class="form-control" type="password" name="<%=Constantes.PARAM_PERSONAS_ROLE%>" id="cont4"  value=""
							required="required" placeholder="" disabled>
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
			
			<%  
					String result = (String) request.getAttribute(Constantes.PARAM_SESSION_MSJ);  
					if(result != null){
						
						%>
						
						<div class="alert alert-danger sombra" role="alert"><%= String.valueOf(result) %></div>
						
						<%						
						
					}				
			%>
		</div>
		</div>
	</div>
	
	
	
	

  	<!-- Añadimos los javascript -->
	<script src="bootstrap/js/vendor/jquery-1.11.1.min.js"></script>
	<script>window.jQuery || document.write('<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"><\/script>')</script>
	
	<script src="bootstrap/js/vendor/bootstrap.min.js"></script>
	<script src="bootstrap/js/main.js"></script>
</body>
</html>