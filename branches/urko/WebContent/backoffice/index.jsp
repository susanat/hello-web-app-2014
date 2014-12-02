<%@page import="com.ipartek.formacion.helloworld.bean.Persona"%>
<%@include file="includes/header.jsp" %>
<%@include file="includes/menu.jsp" %>

	<div>BackOffice  <%=persona.getUserName() %><a title="Cierra tu sesion" href="<%= Constante.SERVLET_LOGOUT %>">Logout[x]</a></div>
	
	<nav>
		<h2>Menu Administraci&oacute;n</h2>
		<ul>
			<li><a href="<%=Constante.CONTROLER_PERSONA %>" title="Gestionar Personas">USUARIOS</a> </li>
		</ul>

<%@include file="includes/footer.jsp" %>


