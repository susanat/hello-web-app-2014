<%@page import="java.util.Enumeration"%>
<%@page import="com.ipartek.formacion.bean.Persona"%>
<%@page import="com.ipartek.formacion.helloweb.Constantes"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Saludo</title>
</head>
<body>
	
	<%
		//recuperar usuario de sesion
		Persona p = (Persona)session.getAttribute(Constantes.USER_SESSION);
		
		if(p == null){
			p = new Persona("Anonimo",99);
			
			String root = request.getContextPath();  //devuelve la ruta de donde esta en el servidor
			String root2 = request.getSession().getServletContext().getRealPath("/"); //devuelve la ruta de donde esta en el disco duro
			response.sendRedirect(root + Constantes.JSP_LOGIN);
					
		}
	
	%>

	<h1>Mongi etorri <%= p.getNombre() %></h1>
	
	<a href="<%=Constantes.PATH_LOGOUT %>" title="Cierra tu sesion">Logout</a>	
	
	<ol>
		<h1>Request info</h1>
	
		<li>Method: <%= request.getMethod() %></li>
		<li>Request URI: <%= request.getRequestURI() %></li>
		<li>Request URL: <%= request.getRequestURL() %></li>
		<li>Context Path: <%= request.getContextPath()%></li>
		<li>Protocolo: <%= request.getProtocol() %></li>
		<li>ServerName: <%= request.getServerName()%></li>
        <li>Puerto: <%= request.getServerPort()%></li>		
	</ol>
	
	<ol>
		<h1>Request Header</h1>
		<% 		
        Enumeration e = request.getHeaderNames();
        while (e.hasMoreElements()) {
            String name = (String)e.nextElement();
            String value = request.getHeader(name);
             out.println("<li>" + name + " : " + value + "</li>");	
        }    
       %>
	</ol>
	
	<ol>
		<h1>Request Parameters</h1>
		<% 		
        Enumeration ep = request.getParameterNames();
        while (ep.hasMoreElements()) {
            String name = (String)ep.nextElement();
            String value = request.getParameter(name);
             out.println("<li>" + name + " : " + value + "</li>");	
        }    
       %>
	</ol>
	
	<ol>
		<h1>Request Atributes</h1>
		<% 		
        Enumeration ea = request.getAttributeNames();
        while (ea.hasMoreElements()) {
            String name = (String)ea.nextElement();
            String value = (String)request.getAttribute(name);
             out.println("<li>" + name + " : " + value + "</li>");	
        }    
       %>
	</ol>
	
	
	
</body>
</html>