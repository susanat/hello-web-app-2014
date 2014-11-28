<%@page import="java.util.Enumeration"%>
<%@page import="com.ipartek.formacion.helloweb.util.Rol"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.ipartek.formacion.helloweb.bean.Persona"%>
<%@page import="com.ipartek.formacion.helloweb.Constantes"%>

<!doctype html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Saludo</title>
</head>

<body>

	<%
		//Recuperar usuario de session
		Persona p = (Persona) session.getAttribute(Constantes.USER_SESSION);
		if (p == null) {
			p = new Persona("anónimo", 99, Rol.INVITADO);
			response.sendRedirect(Constantes.JSP_LOGIN);
		}
	%>

	<h1>
		Ongi Etorri
		<%=p.getNombre()%></h1>
	<a href="<%=Constantes.PATH_LOGOUT%>" title="Cierra tu sesión">[x] Logout</a>
	
	<h2>Request Info</h2>
	<ol>
		<li>Method: <b><%=request.getMethod()%></b></li>
		<li>Request URI: <b><%=request.getRequestURI()%></b></li>
		<li>Request URL: <b><%=request.getRequestURL()%></b></li>
		<li>Context Path: <b><%=request.getContextPath()%></b></li>
		<li>Protocol: <b><%=request.getProtocol()%></b></li>
		<li>PathInfo: <b><%=request.getPathInfo()%></b></li>
		<li>Remote Address: <b><%=request.getRemoteAddr()%></b></li>
	</ol>
	
	<h2>Request Header</h2>
	<ol>
	<% 
		response.setContentType("text/html");
	    Enumeration e = request.getHeaderNames();
	    while (e.hasMoreElements()) {
	    	String key = (String)e.nextElement();
	        String value = request.getHeader(key);
	        out.println("<li>" + key + ": <b>" + value + "</b></li>");
	    }
 	%>
 	</ol>
 	
 	<h2>Request Parameters</h2>
	<ol>
	<% 
		response.setContentType("text/html");
	    Enumeration par = request.getParameterNames();
	    while (par.hasMoreElements()) {
	    	String key = (String)par.nextElement();
	        String value = request.getHeader(key);
	        out.println("<li>" + key + ": <b>" + value + "</b></li>");
	    }
 	%>
 	</ol>
 	
 	<h2>Request Attributes</h2>
	<ol>
	<% 
		response.setContentType("text/html");
	    Enumeration attr = request.getAttributeNames();
	    while (attr.hasMoreElements()) {
	    	String key = (String)attr.nextElement();
	        String value = request.getHeader(key);
	        out.println("<li>" + key + ": <b>" + value + "</b></li>");
	    }
 	%>
 	</ol>
 
</body>

</html>







