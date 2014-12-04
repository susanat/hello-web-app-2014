<% 
	//carga la última página visitada en session dentro del parámetro PARAM_SESSION_LAST_URL
	UtilsTemp.cargaHistorial(request, session);
%>


<% 
	//comprueba autentificacion y autorización
	Persona p = UtilsTemp.getAuthenticated(session);
	if ( p == null || ! UtilsTemp.havePermiso("ACCESO_ADMINISTRACION", p)) {
		UtilsTemp.goToLogin(response);
	} else {
%>

<%@include file="includes/head.jsp" %>       
		<%@include file="includes/nav.jsp" %>
        
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Dashboard</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
        
        	
        	Contenido
        
        
        <% 
        	String myVariable = "includes/footer.jsp";
        %>
        
 <jsp:include page="<%= myVariable %>" flush="true" />

<% 
	}
%>
 