<%@page import="com.ipartek.formacion.helloweb.comun.Utils"%>
<%@page import="java.util.Locale"%>
<%@page import="com.ipartek.formacion.helloweb.bean.Message"%>
<%@page import="com.ipartek.formacion.helloweb.temp.UtilsTemp"%>
<%@page import="com.ipartek.formacion.helloweb.bean.Persona"%>
<%@page import="com.ipartek.formacion.helloweb.comun.Constantes"%>
<%@page pageEncoding="UTF-8" %>


<!-- https://jstl.java.net/ -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<!-- Lenguage -->
<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />


<!-- 
<c:choose>
  <c:when test="${sessionScope.locale_user != null}">
    <c:set var="language" value="${sessionScope.locale_user}"/>
  </c:when>
  <c:when test="${sessionScope.authenticated == false}">
    <c:set var="language" value="${pageContext.request.locale}"/>
  </c:when>  						  
</c:choose>	
 -->

<fmt:setLocale value="${language}" />
<fmt:setBundle basename="com.ipartek.formacion.helloweb.i18n.lang" />


<!-- Autentificado o no -->
<c:set var="isAuthenticated" scope="page" value="${sessionScope.authenticated == null ? false : true}"/>

<c:choose>
  <c:when test="${sessionScope.authenticated == null}">
    <c:set var="isAuthenticated" scope="page" value="${false}"/>
  </c:when>
  <c:when test="${sessionScope.authenticated == false}">
    <c:set var="isAuthenticated" scope="page" value="${false}"/>
  </c:when>
  <c:when test="${sessionScope.authenticated == true}">
    <c:set var="isAuthenticated" scope="page" value="${true}"/>
  </c:when>								  
</c:choose>	


<!-- url origen al login (vacía si ha entrado directamente -->
<c:set var="lastUrl" scope="page" value="${sessionScope.lasturl}"/>

<!doctype html>

<html lang="${language}">
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
				<h1><fmt:message key="login.login" /></h1>				
			</div>
		
			<div class="row">
				<div class="panel panel-primary sombra ">
			    	<div class="panel-heading">
			      		<h3 class="panel-title">
			      		
			      			<c:choose>
							  <c:when test="${isAuthenticated == false}">
							    <fmt:message key="login.help.insert" />
							  </c:when>
							  <c:when test="${isAuthenticated == true}">
							    <fmt:message key="login.help.wellcome" />
							  </c:when>							  
							</c:choose>			      					      		
			      		</h3>
			    	</div>			    	
			    	<div class="panel-body">
			    		<!-- Si no está autentificado, mostramos el formulario de login -->			    	
						<c:if test="${isAuthenticated == false}">
							<form class="" role="form" method="post" id="frm_login" action="login">
								<div class="form-group form-group-install col-md-12">
									<label class="control-label" for="cont1"><fmt:message key="login.label.username" /> * </label>
									<input class="form-control" type="text" name="<%=Constantes.PARAMETRO_USER%>" id="cont1" value="" required="required" 
									placeholder="<fmt:message key="login.placeholder.username" />">
								</div>
									
								<div class="form-group form-group-install col-md-12">
									<label class="control-label" for="cont2"><fmt:message key="login.label.password" /> * </label>
									<input class="form-control" type="password" name="<%=Constantes.PARAMETRO_PASSWORD%>" id="cont2" required="required" 
									placeholder="<fmt:message key="login.placeholder.password" />">
								</div>
								
								<!-- Path de referencia para redirigir -->
								<input type="hidden" name="<%=Constantes.PARAM_URL_TO%>" value="${lastUrl}">
								
								<div class="col-xs-12 text-right">
										<input form="frm_login" class="btn btn-success btn-lg" 
											type="submit" name="save" 
											title="Save" 
											value="<fmt:message key="login.button.login" />" />				  		
								</div>						
							</form>	
						</c:if>
						
						<!-- Si está autentificado, mostramos la ficha del usuario -->
						<c:if test="${isAuthenticated == true}">
							<div class="row">
								<ul>
									<li> Home Page </li>
									<li> Panel de usuario </li>										
									<c:if test="${isAuthenticated == true}">
										<c:if test="${sessionScope.user_session.idRol == 2}">
											<li>
												<a href='<%=Constantes.JSP_BACK_ADMIN %>' title='Administracion'>
													Administracion
												</a>
											</li>
										
										</c:if>	
									</c:if>																
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
												type="submit" name="save" 
												title="Logo out" 
												value="<fmt:message key="login.button.logout" />" />				  		
									</div>														
								</form>
							</div>
						</c:if>
										
						<!-- http://silviomoreto.github.io/bootstrap-select/ -->
						<div class="col-md-12">															
							<form role="form" method="post">
								<label class="control-label" for="language"><fmt:message key="login.label.combolang" /></label>							
								<select class="form-control" id="language" name="language" onchange="submit()">		                      			            		
			            			<option value="es_ES" ${language == 'es_ES' ? 'selected' : ''}>Español</option>             
			            			<option value="en_GB" ${language == 'en_GB' ? 'selected' : ''}>English</option>										
			            			<option value="es_EU" ${language == 'es_EU' ? 'selected' : ''}>Euskera</option>										
								</select>	
							</form>									
						</div>	<!-- http://silviomoreto.github.io/bootstrap-select/ -->	
						
					</div> <!--  panel-body -->				
				</div> <!-- fin panel primary -->
			
				<!-- Mostramos el error si hay  -->						
				<c:if test="${requestScope.isError.error == true}">
					<div class="alert alert-${requestScope.isError.type}" role="alert">
						Alerta: ${requestScope.isError.text}
					</div>			
				</c:if>
			
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
				toastr.info('<fmt:message key="login.button.logout" />');
									}
				</script>	
	<% 	
	} //fin condicion logout		
	%>
	

  	<!-- Añadimos los javascript -->
	<link href="<%=Constantes.PATH_SITE%>bootstrap/js/vendor/toastr/toastr.css" rel="stylesheet"/>
	<script src="<%=Constantes.PATH_SITE%>bootstrap/js/vendor/toastr/toastr.js"></script>
	
	<script src="bootstrap/js/vendor/bootstrap.min.js"></script>
	<script src="bootstrap/js/main.js"></script>
	
	<!--  Temporal, para visualizar los datos -->
	<div class="alert alert-success">
		Autentificado: ${isAuthenticated}
	<br>
		Pagina: ${lastUrl}
	<br>
		Rol: ${sessionScope.user_session.idRol}
	</div>
	
	<% 
		String userLocale = request.getHeader("Accept-Language");
	 	//Locale locale = request.getLocale();
	 	out.print("Header lang:" + userLocale + "<br>");
	 	
	 	//Returns the preferred Locale that the client will accept content in, based on the Accept-Language header. If the 
 		//client request doesn't provide an Accept-Language header, this method returns the default locale for the server. 
	 	out.print("Request lang:" + request.getLocale().toString() + "<br>");
	 		 	
  	%>
		${language}
		
		

	
	
</body>
</html>