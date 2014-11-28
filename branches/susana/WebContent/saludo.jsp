<%@page import="java.util.Enumeration"%>
<%@page import="com.ipartek.formacion.helloweb.bean.Persona"%>
<%@page import="com.ipartek.formacion.helloweb.Constantes"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ssludo</title>
</head>
<body>
	
	<%
	//rescuperar ususario de session - Hay que castearlo
	Persona p = (Persona)session.getAttribute(Constantes.USER_SESSION);
	
	if(p == null){
	  p = new Persona("anonimo", 99);
	 // String root = request.getSession().getServletContext().getRealPath("/");
	 // response.sendRedirect(root +Constantes.JSP_LOGIN);
	  
	  response.sendRedirect(  Constantes.JSP_LOGIN );
	}
	%>
	
	<h1>Ongi Etorri <%=p.getNombre()%></h1>
	
	 <a href="<%=Constantes.PATH_LOGOUT%>" title="Cerrar session">[X] Cerrar Session</a>
	 
	<h1>Request Info</h1>
	 <ol>
	 	<li>Method: <b><%=request.getMethod()%></b></li>
	 	<li>Request URL: <b><%=request.getRequestURL()%></b></li>
	 	<li>Request URI: <b><%=request.getRequestURI()%></b></li>
	 	<li>Protocol: <b><%=request.getProtocol()%></b></li>
	 	<li>Server Name: <b><%=request.getServerName()%></b></li>
	 	<li>Context Path: <b><%=request.getContextPath()%></b></li>
	 	<li>Server Port: <b><%=request.getServerPort()%></b></li>
	 </ol>
	 
	  <h1>Request Header</h1>
	 <ol>
	 	<%
	 	Enumeration e = request.getHeaderNames();
	    while (e.hasMoreElements()) {
	    	String Key = (String)e.nextElement();
	        String value = request.getHeader(Key);
	        out.println("<li> " + Key + " <b>" + value + "</b></li>");
	    }
	    out.print(request.getSession().getId());
	 	%>
	 </ol>
	 
	 <h1>Request Parameters</h1>
	 <ol>
	 	<%
	 		Enumeration ep = request.getParameterNames();
	 		while (ep.hasMoreElements()) {
		    	String Key = (String)ep.nextElement();
		        String value = request.getParameter(Key);
		        out.println("<li> " + Key + " <b>" + value + "</b></li>");
		    }
	 	%>
	 </ol>
	 
	  <h1>Request Attributes</h1>
	 <ol>
	 	<%
	 		Enumeration ea = request.getAttributeNames();
	 		while (ea.hasMoreElements()) {
		    	String Key = (String)ea.nextElement();
		        String value = (String)request.getAttribute(Key);
		        out.println("<li> " + Key + " <b>" + value + "</b></li>");
		    }
	 	%>
	 
	 </ol>
	
</body>
</html>