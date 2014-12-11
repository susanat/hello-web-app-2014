<%@page import="com.ipartek.formacion.helloweb.bean.Message"%>
<%@page import="com.ipartek.formacion.helloweb.temp.UtilsTemp"%>
<%@page import="com.ipartek.formacion.helloweb.bean.Persona"%>
<%@page import="com.ipartek.formacion.helloweb.comun.Constantes"%>
<%@page pageEncoding="UTF-8" %>

<!-- https://jstl.java.net/ -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%//*************************** Autentificación usuario

	//Obtenemos la persona autentificada
	Persona persona = UtilsTemp.getAuthenticated(session);
		
	boolean autentificado = false;
	//Comprobamos si está autentificado
	if( persona != null) {
		//está ya autentificado		
		autentificado = true;		
	}
%>

<%//*************************** CASO ESPECIAL: obtenemos el path desde el que se nos ha redirigido al login, para poder redirigir desde el servlet login	
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
											<input type="hidden" name="<%=Constantes.PARAM_URL_TO%>" value="<%= fromPath %>">
											
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
											</ul>
										</div>
										<div class="row">
											<form class="" role="form" method="post" id="frm_login" action="logout">
												<!-- Path de referencia para redirigir (actualmente decidimos index) -->
												<input type="hidden" name="<%=Constantes.PARAM_URL_TO%>" value="<%= Constantes.JSP_INDEX %>">
												
												<!-- Invalidamos la sesión, no borramos los datos nada más -->
												<input type="hidden" name="<%=Constantes.PARAM_SESSION_INVALIDATE%>" value="true">
												
												<div class="col-xs-12 text-right">
														<input form="frm_login" class="btn btn-active btn-lg" 
															type="submit" name="save" value="Logo out" 
															title="Logo out" />				  		
												</div>						
											</form>	
										</div>
						
						<% 
							}//fin condicion de autentificado
						%>				
						
					</div> <!--  panel-body -->				
				</div> <!-- fin panel primary -->
			
			<!-- Mostramos el error si hay  -->
			<%			
				Message msg = UtilsTemp.getMessage(request);
				if(msg != null && msg.isError()){
					out.print(msg.getShowDivAlert());
				}
			
			%>
			
			
			
						
			<c:if test="${requestScope.isError.error != false}">
				<div class="alert alert-${requestScope.isError.type} " role="alert">
					Alerta: ${requestScope.isError.text}
				</div>			
			</c:if>
			
			
			<c:out value="<% msg.getText(); %>"/> 
			
			</div>
		</div>
	</div>
	
	<% 
	if (request.getAttribute(Constantes.ATTR_LOGOUT_ACTION) != null) {
			
	%>		
				<script>
				$(document).ready(function(){						
					lanzarToast();					
				
				});	
				</script>	
	<% 	
	} //fin condicion logout		
	%>
	

  	<!-- Añadimos los javascript -->
	<link href="<%=Constantes.PATH_SITE%>bootstrap/js/vendor/toastr/toastr.css" rel="stylesheet"/>
	<script src="<%=Constantes.PATH_SITE%>bootstrap/js/vendor/toastr/toastr.js"></script>
	
	<script src="bootstrap/js/vendor/bootstrap.min.js"></script>
	<script src="bootstrap/js/main.js"></script>
</body>
</html>