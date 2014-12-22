<%@include file="includes/head.jsp" %>
<%@include file="includes/nav.jsp" %>

       
<div>
       
        <h1><fmt:message key="page.content"></fmt:message></h1> 
        <h1>Numero de usuarios logeados</h1>
        <ul>
        	<li>Administradores: <%=session.getAttribute("adminUsers") %> </li>
        	<li>Usuarios: 	<%=session.getAttribute("userUsers") %></li>
        </ul>
        
</div>
      

<%@include file="includes/footer.jsp" %>