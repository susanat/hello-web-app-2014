
    <%@include file="includes/head.jsp" %>
		<%@include file="includes/nav.jsp" %>

		<% 
			//comprueba autentificacion y autorización
			Persona p = UtilsTemp.getAuthenticated(session);
			if ( p == null || ! UtilsTemp.havePermiso("ACCESO_ADMINISTRACION", p)) {
				UtilsTemp.goToLogin(response);
			} else {
		%>

        
	            <div class="row">
	                <div class="col-lg-12">
	                    <h1 class="page-header">Este es el index de <fmt:message key="adm.index.title" /></h1>
	                </div>
	                <!-- /.col-lg-12 -->
	            </div>
	        
	        	<!-- Titulo de la pagina -->
				<c:set var="title" value="lasdfasdf" />
				<!-- FIN Titulo de la pagina -->
	        	
	        	Contenido
	        	
        

		<% 
			}
		%>
		
		
  
 <!-- Include footer -->
 	<%@include file="includes/footer.jsp" %>