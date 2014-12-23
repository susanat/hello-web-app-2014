<%@page import="com.ipartek.formacion.helloweb.listener.InitListener"%>
<%@include file="includes/head.jsp" %>
<%@include file="includes/nav.jsp" %>
  
       
       
  	<h1>Bienvenido/a.</h1>    
  	<br>   
  	<h1>Usuarios Conectados:</h1>
    <ul>
    	<li>
    		<i class="glyphicon glyphicon-user"></i>Admin: <%= getServletContext().getAttribute(Constantes.USER_ADMIN_CONT)%>
  		</li>
    	<li>
    		<i class="glyphicon glyphicon-user"></i>Users: ${applicationScope.cont_user} 
    	</li>
    </ul>   	
    
    

<%@include file="includes/footer.jsp" %>   




      

