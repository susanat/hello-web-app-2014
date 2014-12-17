<%@page import="com.ipartek.formacion.helloweb.bean.Role"%>
<%@page import="java.util.Enumeration"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.ipartek.formacion.helloweb.bean.Persona"%>
<%@page import="com.ipartek.formacion.helloweb.Constantes"%>

<!doctype html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Saludo</title>
</head>

<body>

	<%
		//Recuperar usuario de session
		Persona p = (Persona) session.getAttribute(Constantes.USER_SESSION);
		if (p == null) {
			p = new Persona("anónimo", 99, new Role("Invitado"));
			response.sendRedirect(Constantes.JSP_LOGIN);
		}
	%>

	<h1>
		Ongi Etorri
		<%=p.getNombre()%></h1>
	<a href="<%=Constantes.CONTROLLER_LOGOUT%>" title="Cierra tu sesión">[x] Logout</a>
	
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
 	
 	<h2>Ejemplo getParameterValues</h2>
 	<form action="ejemploParameterValueServlet" method="post">
 		¿Cuáles son tus pasatiempos favoritos?<br>
		<input type="checkbox" name="pasa" value="tv">TV<br>
		<input type="checkbox" name="pasa" value="libros">Libros<br>
		<input type="checkbox" name="pasa" value="musica">Música<br>
		<input type="checkbox" name="pasa" value="otros">Otros<br>
		
		Selecciona el tipo de response
		<select name="tipoRespuesta">
			<option value="text/html" selected>HTML</option>
			<option value="application/json">JSON</option>
		</select>
		
		<input type="submit" value="Enviar">
	</form>
 
</body>

</html>







