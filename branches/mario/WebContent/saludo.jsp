<%@page import="java.util.Enumeration"%>
<%@page import="com.ipartek.formacion.helloweb.Rol"%>
<%@page import="com.ipartek.formacion.helloweb.bean.Persona"%>
<%@page import="com.ipartek.formacion.helloweb.Constantes"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Saludo</title>
</head>
<body>
		<% 
			//recuperar usuario de session
			Persona p = (Persona) session.getAttribute(Constantes.USER_SESSION);
			if (p == null){
			    p = new Persona ("anonimo", 99, Rol.USUARIO);
			    String root =  request.getSession().getServletContext().getRealPath("/");
			    response.sendRedirect( root + Constantes.JSP_LOGIN );
			}
		%>
	<h1>Ongi Etorri <%= p.getNombre() %></h1>
	<a href="<%=Constantes.PATH_LOGOUT %>" title="Cierra tu sesión">[x] Cerrar Sesión</a>
	
	<h1>Request: Info</h1>
	<ol>
		<li>Method: <b><%= request.getMethod() %></b></li>
		<li>Request URI: <b><%= request.getRequestURI() %></b></li>	
		<li>Request URL: <b><%= request.getRequestURL() %></b></li>	
		<li>Protocolo: <b><%= request.getProtocol() %></b></li>	
		<li>Server Name: <b><%= request.getServerName() %></b></li>	
		<li>Server Port: <b><%= request.getServerPort() %></b></li>	
		
	</ol>
	
	<h1>Request: Header</h1>
	<ol>
		<%
			Enumeration e = request.getHeaderNames();
	        while (e.hasMoreElements()) {
	            String name = (String)e.nextElement();
	            String value = request.getHeader(name);
	            out.println("<li>"+name + ": <b> " + value+"</b></li>");
	        }
	        out.println(request.getSession().getId());
		%>
	
	</ol>
	
	<h1>Request: Parametros</h1>
	<ol>
		<%
			Enumeration ep = request.getParameterNames();
			while (ep.hasMoreElements()) {
	            String name = (String)ep.nextElement();
	            String value = (String)request.getParameter(name);
	            out.println("<li>"+name + ": <b> " + value+"</b></li>");
	        }
		
		%>
	
	</ol>
	<h1>Request: Atributes</h1>
	<ol>
		<%
			Enumeration ea = request.getAttributeNames();
			while (ea.hasMoreElements()) {
	            String name = (String)ea.nextElement();
	            String value = (String)request.getAttribute(name);
	            out.println("<li>"+name + ": <b> " + value+"</b></li>");
	        }
		
		%>
	
	</ol>
	
	<h1>Ejemplo: getParameterValues</h1>
	<form action="ejemploParameterValuesServlet.do" metodo="post">
		¿Cuáles son tus pasatiempos favoritos?<br>
		<input type="checkbox" name="pasa" value="tv">TV<br>
		<input type="checkbox" name="pasa" value="libros">Libros<br>
		<input type="checkbox" name="pasa" value="musica">Música<br>
		<input type="checkbox" name="pasa" value="otros">Otros<br>
		
		Seleccion el MIME-TYPE de response
		<select name="tipoRespuesta">
			<option value = "text/html">HTML</option>
			<option value = "application/json">JSON</option>
		</select>
		
		<input type="submit" value="Enviar">
	</form>
	
</body>
</html>