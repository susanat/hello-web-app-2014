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

 