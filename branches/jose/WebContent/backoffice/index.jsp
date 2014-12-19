<%@include file="includes/head.jsp" %>
<%@include file="includes/nav.jsp" %>
       
 <h2>Usuarios Activos</h2>
<ol>
<li><b>ADMINISTADORES:</b><%=getServletContext().getAttribute("numAdministradores") %></li>
<li><b>USUARIOS:</b><%=getServletContext().getAttribute("numUsuarios") %></li>
</ol>

<%@include file="includes/footer.jsp" %>   