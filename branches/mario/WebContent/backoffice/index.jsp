


<%@page import="com.ipartek.formacion.helloweb.Rol"%>
<%@page import="com.ipartek.formacion.helloweb.bean.Persona"%>
<%@page import="com.ipartek.formacion.helloweb.Constantes"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
	<% 
		//recuperar usuario de session
		Persona p = (Persona) session.getAttribute(Constantes.USER_SESSION);
		if ((p == null) || (p.getRol() != Rol.ADMINISTRADOR)){
		    p = new Persona ("anonimo", 99, Rol.USUARIO);
		   
		    String root =  request.getContextPath();
		    response.sendRedirect( root + Constantes.JSP_LOGIN );   
		}
		
	%>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>BACKOFFICE</title>
</head>
<body>
	<%@include file="/includes/alerts.jsp" %>	
	<h1>Este es el backoffice del <%= p.getNombre() %></h1> <br><br>
	<a href="<%=Constantes.PATH_LOGOUT %>" title="Cierra tu sesión">[x] Cerrar Sesión</a>
	
	<nav>
		<h3>Menú Administración</h3>
		<ul>
			<li><a href="<%=Constantes.CONTROLLER_PERSONA %>" title="Gestionar Personas">Personas</a></li>
		</ul>	
	</nav>
</body>
</html>