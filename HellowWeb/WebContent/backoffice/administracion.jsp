<%@page import="java.util.Enumeration"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="com.ipartek.formacion.helloweb.bean.CargasTemporales"%>
<%@page import="com.ipartek.formacion.helloweb.comun.Utils"%>
<%@page import="com.ipartek.formacion.helloweb.bean.Persona"%>
<%@page import="com.ipartek.formacion.helloweb.comun.Constantes"%>
<%
	Persona persona = null;

	//obtenemos el actual path
	String path = request.getRequestURL().toString();
	
	//creamos una session anónima
	if(session == null) {
		session = request.getSession(true);
	}
	
	//añadimos el último path visitado
	session.setAttribute(Constantes.PARAM_SESSION_LAST_URL, path);

	//miramos si existe sessión, si existe y tiene la propiedad, comprobamos que es true
	if(session == null || session.getAttribute(Constantes.PARAM_SESSION_AUTHENTICATED) ==null  || session.getAttribute(Constantes.PARAM_SESSION_AUTHENTICATED).equals(false))
	{		
		//sesion sin authentificar
		session.setAttribute(Constantes.PARAM_SESSION_AUTHENTICATED, false);
	
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
   		response.sendRedirect(Constantes.JSP_LOGIN);
   		
	} else {
		
		//comprobamos los permisos
		int[] rolesAllowed = new int[]{ 1 }; 
		
		persona = (Persona) session.getAttribute(Constantes.PARAM_SESSION_USER);
		if (persona != null) {
	
	if (! Utils.inArrayRolles(rolesAllowed, persona) ) {
		out.print("No está autorizado para ver esta página");
	}
	
	
		} else {
	
	out.print("Error al obtener la Persona en la cabecera de la sessión.");
	
		}
		
	}
%>






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
	
		//nombre por petición resquest
		String strName = "Error al obtener el nombre";
		if(persona != null) {
			strName = persona.getNombre();
		}
		
	%>

	<h1>Administración: Ongi Etorri <%= strName %> </h1>	
	 
	 <h2> Menú Administracion </h2>
	 <ul>
	 	<a href="<%= Constantes.SITE_PATH +  Constantes.CONTROLLER_PERSONA %>" title="Gestion Personas">Gestión Personas</a>
	 </ul>
	 
	 
	 
	<div class="col-xs-12 text-right">
		<a class="btn btn-success btn-lg" href="<%= Constantes.JSP_LOGOUT %>">Logout</a>			  		
	</div>
	
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
	
	
	
	
	
</body>
</html>