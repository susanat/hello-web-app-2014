<%@page import="com.ipartek.formacion.helloweb.bean.Persona"%>
<%@page import="com.ipartek.formacion.helloweb.Constantes"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>saludo</title>
</head>
<body>
<%
	Persona p = (Persona)session.getAttribute(Constantes.USER_SESSION);
	if(p==null){
		p = new Persona("anonimo", 99);
		response.setStatus(response.SC_UNAUTHORIZED);
		

		response.sendRedirect(Constantes.JSP_LOGIN);
		//response.setHeader("Location", Constantes.JSP_LOGIN);
		//p = new Persona("anonimo", 99);
	}
%>

<h1>Hola <%=p.getNombre()%></h1>
</body>
</html>