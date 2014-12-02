<%@page import="com.ipartek.formacion.helloweb.bean.Persona"%>
<%@page import="com.ipartek.formacion.helloweb.comun.Constantes"%>
<%@page pageEncoding="UTF-8" %>


<%

	boolean autentificado = false;
	Persona persona = null;

	//si existe sessión, avisamos
	//Existe una sessión, si quiere entrar con otra cuenta deslogueate o vete al panel de usuarios
	if( session.getAttribute(Constantes.PARAM_SESSION_AUTHENTICATED) != null &&
			(Boolean)session.getAttribute(Constantes.PARAM_SESSION_AUTHENTICATED) != false) {
		
		//está ya autentificado		
		autentificado = true;
		
		persona = (Persona) session.getAttribute(Constantes.PARAM_SESSION_USER);
		
	}


	//obtenemos el path desde el que se nos ha redirigido al login, para poder volver luego
	//despues de authentificarnos
	String fromPath = "";
	if( session != null && session.getAttribute(Constantes.PARAM_SESSION_LAST_URL) != null ) {
		fromPath = session.getAttribute(Constantes.PARAM_SESSION_LAST_URL).toString();
	} else {
		//si no, ha entrado directamente
		fromPath = request.getRequestURL().toString(); 
	}
%>

<!doctype html>

<html lang="en">
<head>
  <meta charset="utf-8">

  <title>Login</title>
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
	
	<script src="bootstrap/js/vendor/jquery-1.11.1.min.js"></script>
	<script>window.jQuery || document.write('<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"><\/script>')</script>


  <!--[if lt IE 9]>
  <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
  <![endif]-->
</head>

<body>

	<div class="container row-centered">
				
		
		<div class="col-xs-4 col-centered">
		
			<div class="row row-centered sombra" style="border: 1px solid; border-radius: 4px; margin-bottom: 20px; border-color: #428BCA; background-color: #428BCA; color: white;">				
				<h1><%=Constantes.general_login %></h1>				
			</div>
		
			<div class="row">
			<div class="panel panel-primary sombra ">
		    	<div class="panel-heading">
		      		<h3 class="panel-title">
		      			<% 
		      			if (! autentificado) {
		      				out.print(Constantes.general_login_insert);	
		      			} else {
		      				out.print( String.format(Constantes.general_login_wellcome, persona.getNombre()));
		      			}		      			
		      			%>		      		
		      		</h3>
		    	</div>
		    	<div class="panel-body">		
		    	
					
	<% 
		if (! autentificado) {
	%>
					<form class="" role="form" method="post" id="frm_login" action="login">
						<div class="form-group form-group-install col-md-12">
							<label class="control-label" for="cont1"><%=Constantes.general_login_username %> * </label>
							<input class="form-control" type="text" name="<%=Constantes.PARAMETRO_USER%>" id="cont1" value="" required="required" placeholder="Enter the username">
						</div>
						
						<div class="form-group form-group-install col-md-12">
							<label class="control-label" for="cont2"><%=Constantes.general_login_password %> * </label>
							<input class="form-control" type="password" name="<%=Constantes.PARAMETRO_PASSWORD%>" id="cont2" required="required" placeholder="Enter password">
						</div>
						
						<!-- Path de referencia para redirigir -->
						<input type="hidden" name="<%=Constantes.PARAM_SESSION_LAST_URL%>" value="<%= fromPath %>">
						
						<div class="col-xs-12 text-right">
								<input form="frm_login" class="btn btn-success btn-lg" 
									type="submit" name="save" value="Sign In" 
									title="Save" />				  		
						</div>						
					</form>	
	<% 
		} else {		
	%>	
	
					<div class="row">
					<ul>
						<li> Home Page </li>
						<li> Panel de usuario </li>					
						<% 
							//TODO: ver como hacer lo de los permisos						
							if ( persona.getRol() == 2) {
								out.print("<li>");
								out.print("<a href='" + Constantes.JSP_BACK_ADMIN + "' title=' "+ "Administracion" +" '>");	
								out.print("Administración");
								out.print("</a>");
								out.print("</li>");
							}						
						%>
					</div>
					<form class="" role="form" method="post" id="frm_login" action="logout">
						<!-- Path de referencia para redirigir -->
						<input type="hidden" name="<%=Constantes.PARAM_SESSION_LAST_URL%>" value="<%= fromPath %>">
						
						<!-- Invalidamos la sesión, no borramos los datos nada más -->
						<input type="hidden" name="<%=Constantes.PARAM_SESSION_INVALIDATE%>" value="true">
						
						<div class="col-xs-12 text-right">
								<input form="frm_login" class="btn btn-active btn-lg" 
									type="submit" name="save" value="Logo out" 
									title="Logo out" />				  		
						</div>						
					</form>	
	
	<% 
		}//fin condicion de autentificado
	%>				
					
				</div> <!--  panel-body -->				
			</div>
			
			<%  
					if(request.getAttribute(Constantes.ATTR_ERROR) != null && 
							(Boolean)request.getAttribute(Constantes.ATTR_ERROR) == true) 
					{
						String result = (String) request.getAttribute(Constantes.ATTR_ERROR_MSJ);  
						if(result != null){
							
							%>
							
							<div class="alert alert-danger sombra" role="alert"><%= String.valueOf(result) %></div>
							
							<%						
							
						}
					}		
			%>
		</div>
		</div>
	</div>
	
	<% 
			if (request.getAttribute(Constantes.ATTR_LOGOUT_ACTION) != null && 
			(Boolean)request.getAttribute(Constantes.ATTR_LOGOUT_ACTION) == true) {
			
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
							toastr.info('<%=Constantes.general_login_desconect_msj%>');
						}
					
					});	
					</script>	
	<% 
	
	}
		
	%>
	
	

  	<!-- Añadimos los javascript -->
	<link href="<%= Constantes.SITE_PATH%>bootstrap/js/vendor/toastr/toastr.css" rel="stylesheet"/>
	<script src="<%= Constantes.SITE_PATH%>bootstrap/js/vendor/toastr/toastr.js"></script>
	
	<script src="bootstrap/js/vendor/bootstrap.min.js"></script>
	<script src="bootstrap/js/main.js"></script>
</body>
</html>