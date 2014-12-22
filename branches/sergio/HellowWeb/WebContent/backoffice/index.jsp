
<%@page import="com.ipartek.formacion.helloweb.bean.Persona"%>
<%@page import="com.ipartek.formacion.helloweb.bean.estadisticas.UserSession"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map.Entry"%>
<%@page import="com.ipartek.formacion.helloweb.bean.CargasTemporales"%>


<%@include file="/backoffice/includes/head.jsp" %>
		<%@include file="/backoffice/includes/nav.jsp" %>

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
	        	
	        	<h1>Usuarios con sesiones activas</h1>
	        	<% 
	        		if(CargasTemporales.activeUsers != null ) {
	        			for(Entry<String, UserSession> entry : CargasTemporales.activeUsers.entrySet()) {
	        			    String key = entry.getKey();
	        			    UserSession value = entry.getValue();

	        			    out.print("********************" + "<br>");
	        			    out.print("Id session: " + key + "<br>");
	        			    
	        			    if(value.getUsuario() != null) {
	        			    	out.print("Usuario: " + value.getUsuario().getNombre() + "<br>");
	        			    } else {
	        			    	out.print("Usuario: " + "Anonimo" + "<br>");	
	        			    }
	        			    
	        			    
	        			    
	        			    out.print("********************" + "<br>");	        			    
	        			}	        			
	        		}	        	
	        	%>
        
        	<form action="<%=Constantes.CONTROLLER_LOG_OUT%>" method="post">        		        	
        		<input type="hidden" name="" value="">
	        	<input 
	        		type='submit' 
	        		name='login' 
	        		class='login login-submit' 
	           		value='<fmt:message key='admin.button.session.out' />'
     			/>
     		</form>        	

		<% 
			}
		%>
		
		
		
		
  
 <!-- Include footer -->
 	
 	
 	<%@include file="/backoffice/includes/footer.jsp" %>
 	