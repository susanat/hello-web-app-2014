<%@page import="java.util.Enumeration"%>
<%@page import="com.ipartek.formacion.helloweb.bean.Persona"%>
<%@page import="com.ipartek.formacion.helloweb.constantes.Constantes"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:set var="language" value="<%=session.getAttribute(Constantes.USER_SESSION_IDIOMA)%>" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="com.ipartek.formacion.helloweb.i18n.i18nmesages" /> 

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Saludo</title>
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

	<h1><fmt:message key="index.saludo"></fmt:message><%=" " + p.getNombre()%></h1>

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
	
	<h1>Ejemplo getParameterValues</h1>
	<form action="ejemploParameterValueServlet.do" method="post">
		<input type="checkbox" name="pasa" value="tv">TV<br>
		<input type="checkbox" name="pasa" value="libros">Libros<br>
		<input type="checkbox" name="pasa" value="musica">Música<br>
		<input type="checkbox" name="pasa" value="otros">Otros<br>
		
		<span>Selecciona el tipo de respone</span>
		<select name="tipoRespuesta">
			<option value="text/html">HTML</option>
			<option value="application/json">JSON</option>			
		</select>
		<br>
		
		<input type="submit" value="Enviar">
	</form>
</body>
</html>