<%@page import="com.ipartek.formacion.helloweb.comun.Constantes"%>
<%@page import="java.util.Enumeration"%>
<%@page import="com.ipartek.formacion.helloweb.bean.Persona"%>
<%@page pageEncoding="UTF-8" %>

<!doctype html>

<html lang="en">
<head>
  <meta charset="utf-8">

  <title>The HTML5 Hello World</title>
  <meta name="description" content="">
  <meta name="author" content="">

  <!-- <link rel="stylesheet" href="css/styles.css?v=1.0">  -->

  <!--[if lt IE 9]>
  <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
  <![endif]-->
</head>

<body>

	<%
		String path = request.getRequestURL().toString();
	
	%>

	<h1>Index de la página</h1>
	<h2>
		<a href="<%=Constantes.JSP_BACK_ADMIN %>">Administracion</a>
		<br>
		<a href="saludo.jsp">Saludo</a>		
	</h2>
	
	<% out.println("<h3>Request Information Example</h3>"); %>
	<ol>
		<% 
			
	        out.println("<li>Method: " + request.getMethod() + "</li>");
	        out.println("<li>Request URI: " + request.getRequestURI()  + "</li>");
	        out.println("<li>Request URL: " + request.getRequestURL()  + "</li>");
	        out.println("<li>Protocol: " + request.getProtocol()  + "</li>");
	        out.println("<li>PathInfo: " + request.getPathInfo()  + "</li>");
	        out.println("<li>Remote Address: " + request.getRemoteAddr()  + "</li>");
	        out.println("<li>Server Name: " + request.getServerName()  + "</li>");	
	        out.println("<li>Server port: " + request.getServerPort()  + "</li>");
		%>	
	</ol>
	
		
	<% out.println("<h3>Head Information Example</h3>"); %>	
	<ol>
		<%
			response.setContentType("text/html");	       
	        Enumeration e = request.getHeaderNames();
	        while (e.hasMoreElements()) {
	            String name = (String)e.nextElement();
	            String value = request.getHeader(name);
	            out.println("<li>" + name + " = " + value + "</li>");
	        }
		
		
		%>
	</ol>
	
	<% out.println("<h3>Request atribute names</h3>"); %>	
	<ol>
		<% 
		
			e = request.getAttributeNames();
	        while (e.hasMoreElements()) {
	            String name = (String)e.nextElement();
	            String value = (String) request.getAttribute(name);
	            out.println("<li>" + name + " = " + value + "</li>");
	        }
			
		
			
		%>	
	</ol>
	
	<% out.println("<h3>Session atributes</h3>"); %>
	<ol>
		<% 
		e = session.getAttributeNames();
        while (e.hasMoreElements()) {
            String name = (String)e.nextElement();
            String value = session.getAttribute(name).toString();
            out.println("<li>" + name + " = " + value + "</li>");
        }
		
		
		%>
	</ol>
	

  <!-- <script src="js/scripts.js"></script>  -->
</body>
</html>