<%@include file="includes/head.jsp" %>
<%@include file="includes/nav.jsp" %>
       

  <h2>Usuarios Activos</h2>
  <ol>
  	<li><b>ADMINISTADORES:</b> <%= getServletContext().getAttribute(Constantes.USER_ADMIN_CONT) %></li>
  	<li><b>USUARIOS:</b> ${applicationScope.cont_user}</li>
  </ol>
            	
            	
            

<%@include file="includes/footer.jsp" %>   