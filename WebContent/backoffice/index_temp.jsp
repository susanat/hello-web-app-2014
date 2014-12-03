<%@page import="com.ipartek.formacion.helloweb.constantes.Constantes"%>
<%@page import="com.ipartek.formacion.helloweb.bean.Persona"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Backoffice</title>
</head>
<body>
	<%
		Persona p = (Persona) session.getAttribute(Constantes.USER_SESSION);
		if (p == null || Persona.Rol.ADMINISTRADOR != p.getRole()) {
			p = new Persona("anonimo", 99);
			String root = request.getContextPath();
			response.sendRedirect(root + Constantes.JSP_LOGIN);
		}
	%>

	<h1>Backoffice</h1>
	<%@include file="/includes/alerts.jsp" %>
	<nav>
		<h2>Menú administración</h2>
		<ul>
			<li><a href="<%=request.getContextPath()+"/"+Constantes.CONTROLLER_PERSONA%>" title="Gestionar personas">Personas</a></li>
		</ul>
	</nav>
	
	<form action="<%=request.getContextPath()+"/"+Constantes.PATH_LOGOUT%>" method="post">
		<button>Logout</button>
	</form>
</body>
</html>