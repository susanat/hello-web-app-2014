<%@page import="com.ipartek.formacion.helloweb.bean.Persona"%>
<%@page import="com.ipartek.formacion.helloweb.Constantes"%>

<%
		//recuperar usuario de session
		Persona p = (Persona)session.getAttribute(Constantes.USER_SESSION);
		if ( (p == null) || ( p.getRol() != Persona.Rol.ADMINISTRADOR ) ){			
			p = new Persona("anonimo", 99 );			
			
			String root = request.getContextPath();			
			System.out.println ( root + "/" + Constantes.JSP_LOGIN );
			
			response.sendRedirect( root + "/" + Constantes.JSP_LOGIN );
		}
		
	%>



<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>BAKOFFICE</title>
</head>
<body>

	<%@include file="/includes/alerts.jsp" %>

	<h1>BAKOFFICE</h1>
	<h2>Ongi Etorri Cheriff</h2>
	
	<a href="<%=Constantes.PATH_LOGOUT%>" title="Cierra tu seccion" > [x] Cerrar Session </a>

	
	<nav>
		<h3>Menu Administracion</h3>
		<ul>
			<li><a href="<%=Constantes.CONTROLLER_PERSONA%>" title="Gestionar Personas"> Personas</a></li>
		</ul>
		
	</nav>

</body>
</html>