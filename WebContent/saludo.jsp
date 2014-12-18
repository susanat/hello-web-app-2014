<%@page import="java.util.Enumeration"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="com.ipartek.formacion.helloweb.util.Rol"%>
<%@page import="com.ipartek.formacion.helloweb.bean.Persona"%>
<%@page import="com.ipartek.formacion.helloweb.Constantes"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Index Usuario</title>
</head>
<body>
	<%
		//recuperar usuario de sesion
		Persona p = (Persona)session.getAttribute(Constantes.USER_SESSION);
		if(p == null){
		   p = new Persona("anonimo");
		   response.setStatus(response.SC_UNAUTHORIZED);
		   response.sendRedirect(Constantes.JSP_LOGIN);
		}
	%>
	<h1>Ongi Etorri <%= p.getNombre() %> </h1>
	<br>
	<h2>Request info</h2>
	<ol>
		
		<li>Method: <b><%=request.getMethod() %></b></li>
		<li>Request URI: <b> <%= request.getRequestURI()%></b></li>
		<li>Request URL: <b> <%= request.getRequestURL()%></b></li>
		<li>Protocol: <b> <%= request.getProtocol()%></b></li>
		<li>PathInfo: <b> <%= request.getPathInfo()%></b></li>
		<li>Remote Address: <b> <%= request.getRemoteAddr()%></b></li>
        <li>ServerName: <b> <%= request.getServerName() %></b></li>
	</ol>
	<h2>Request Headers</h2>
	<ol>
		<%
	        Enumeration e = request.getHeaderNames();
	        while (e.hasMoreElements()) {
	            String key = (String)e.nextElement();
	            String value = request.getHeader(key);
	            out.println("<li>" + key + "<b>: " + value + "</b></li>");
	            
	        } %>
		
       
	</ol>
	<h2>Request parameters</h2>
	<ol>
		<%
	        Enumeration ep = request.getParameterNames();
	        while (ep.hasMoreElements()) {
	            String key = (String)ep.nextElement();
	            String value = request.getParameter(key);
	            out.println("<li>" + key + "<b>: " + value + "</b></li>");
	            
	        } %>
		
		
	</ol>
	
	<h2>Request parameters</h2>
	<ol>
		<%
	        Enumeration et = request.getAttributeNames();
	        while (et.hasMoreElements()) {
	            String key = (String)et.nextElement();
	            String value = (String)request.getAttribute(key);
	            out.println("<li>" + key + "<b>: " + value + "</b></li>");
	            
	        } %>
		
		
	</ol>
	
	
	<form action="${pageContext.request.contextPath}/LogoutServlet" method="post">
    <input type="submit" value="Logout" />
	</form>
	
	<h1>Ejemplo getParameterValues</h1>
	<form action="ejemploParameterValuesServlet.do" method="post">
		<input type="checkbox" name="pasa" value="Arte y Cultura"> Arte y Cultura<br>
		<input type="checkbox" name="pasa" value="Ciencia">Ciencia<br>
		<input type="checkbox" name="pasa" value="Música">Música<br>
		<input type="checkbox" name="pasa" value="tv">TV<br>
		
		Selecciona el tipo de response:
		<select name="tipoRespuesta">
		<option value="text/html" selected="selected">HTML</option>
		<option value="application/json">JSON</option>
		</select>
		
		<input type="submit" value="Enviar">
	</form>
</body>
</html>