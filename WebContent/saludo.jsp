<%@page import="java.util.Enumeration"%>
<%@page import="com.ipartek.formacion.helloweb.bean.Persona"%>
<%@page import="com.ipartek.formacion.helloweb.constantes.Constantes"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
		Persona p = (Persona) session.getAttribute(Constantes.USER_SESSION);
		if (p == null) {
			p = new Persona("anonimo", 99);
			String root =  request.getContextPath();
			response.sendRedirect(root + Constantes.JSP_LOGIN);
		}
	%>

	<h1>Ongi Etorri <%=p.getNombre()%></h1>

	<form action="<%=Constantes.PATH_LOGOUT%>" method="post">
		<button>Logout</button>
	</form>
	
	<h2>Request Info</h2>
	<ul>
		<li>Method: <%=request.getMethod()%></li>
		<li>Request URI: <%=request.getRequestURI()%></li>
		<li>Request URL: <%=request.getRequestURL()%></li>
		<li>Protocolo: <%=request.getProtocol()%></li>
		<li>Protocolo: <%=request.getServerName()%></li>
		<li>Puerto: <%=request.getServerPort()%></li>
	</ul>
	
	<h2>Request Header</h2>
	<ul>
		<%  
		 	Enumeration e = request.getHeaderNames();
	        while (e.hasMoreElements()) {
	            String name = (String)e.nextElement();
	            String value = request.getHeader(name);
	            out.println("<li>" + name + " = " + value + "</li>");
	        } 
		%>
	</ul>
	
	<h2>Request Parameters</h2>
	<ul>
		<%  
		 	Enumeration ep = request.getParameterNames();
	        while (ep.hasMoreElements()) {
	            String name = (String)ep.nextElement();
	            String value = request.getParameter(name);
	            out.println("<li>" + name + " = " + value + "</li>");
	        } 
		%>
	</ul>
</body>
</html>