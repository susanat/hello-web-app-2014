<%@page import="com.ipartek.formacion.helloweb.comun.Constantes"%>
<%@page pageEncoding="UTF-8" %>
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


  <!--[if lt IE 9]>
  <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
  <![endif]-->
</head>

<body>

	<div class="container row-centered">
				
		
		<div class="col-xs-4 col-centered">
		
			<div class="row row-centered sombra" style="border: 1px solid; border-radius: 4px; margin-bottom: 20px; border-color: #428BCA; background-color: #428BCA; color: white;">				
					<h1>Login</h1>				
			</div>
		
			<div class="row">
			<div class="panel panel-primary sombra ">
		    	<div class="panel-heading">
		      		<h3 class="panel-title">Please, insert username and password.</h3>
		    	</div>
		    	<div class="panel-body">		
		    	
					<form class="" role="form" method="post" id="frm_install_database" action="login">
						<div class="form-group form-group-install col-md-12">
							<label class="control-label" for="cont1">Username * </label>
							<input class="form-control" type="text" name="<%= Constantes.PARAMETRO_USER %>" id="cont1" value="" required="required" placeholder="Enter the username">
						</div>
						
						<div class="form-group form-group-install col-md-12">
							<label class="control-label" for="cont2">Password * </label>
							<input class="form-control" type="password" name="<%= Constantes.PARAMETRO_PASSWORD %>" id="cont2" required="required" placeholder="Enter password">
						</div>
						
						<div class="col-xs-12 text-right">
								<input form="frm_install_database" class="btn btn-success btn-lg" 
									type="submit" name="save" value="Sign In" 
									title="Save" />				  		
						</div>
					</form>	
				</div> <!--  panel-body -->				
			</div>
			
			<%  
					Object result = request.getAttribute(Constantes.PARAMETRO_REQUEST_RESULT);  
					if(result != null){
						
						%>
						
						<div class="alert alert-danger sombra" role="alert"><%= String.valueOf(result) %></div>
						
						<%						
						
					}				
			%>
		</div>
		</div>
	</div>
	
	<% 
		if( session != null && session.getAttribute(Constantes.SESSION_LAST_URL) != null ) {
			out.print(session.getAttribute(Constantes.SESSION_LAST_URL));
		}
	
	%>
	
	

  	<!-- Añadimos los javascript -->
	<script src="bootstrap/js/vendor/jquery-1.11.1.min.js"></script>
	<script>window.jQuery || document.write('<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"><\/script>')</script>
	
	<script src="bootstrap/js/vendor/bootstrap.min.js"></script>
	<script src="bootstrap/js/main.js"></script>
</body>
</html>