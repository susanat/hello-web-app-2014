<%@page import="java.util.Enumeration"%>
<%@page import="com.ipartek.formacion.helloworld.util.Util"%>
<%@page import="java.util.Map"%>
<%@page import="com.ipartek.formacion.helloworld.util.Constante"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html>
<%@page import="com.ipartek.formacion.helloworld.bean.Persona"%>
<html>
<head>
	<meta charset="utf-8">
	<title>Bienvenida</title>
</head>
<body>
<% 

	Persona persona  = (Persona)session.getAttribute(Constante.USER_SESSION);
	if(persona == null){
	    persona = new Persona();
	    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
	    response.sendRedirect(Constante.JSP_LOGIN);
	}
	
%>
	<h1>Bienvenida</h1>
<p>${persona.userName} <p/><a title="Cierra tu sesion" href="<%= Constante.SERVLET_LOGOUT %>">[x]Logout</a>
	<div>Hola bienvenido al primer programa  <%=persona.getUserName() %><c:out value="${persona.userName}"/></div>
	


	<h1>Backoffice</h1><a title="Cierra tu sesion" href="<%= Constante.SERVLET_LOGOUT %>">[x]Logout</a>
	<div><c:out value="<br>  Nombre: ${persona.nombre}" escapeXml="false" default="la expresión fallo"/></div>	
	<div>Hola bienvenido a la parte de backoffice </div>
	
	<c:if test="${persona != null}">
  		<p>Welcome, ${persona.nombre}</p>
  		
	</c:if>
	<h2>Request Headers</h2>
	<ol>
	
	<%
		Map<String,String> datos = Util.getRequestInfo(request);
	
	for(Map.Entry<String,String> entry: datos.entrySet()){
	    String key = entry.getKey();
	    String value =  entry.getValue();
	    out.println("<li>"+key + " = " + value+"</li>");
	}
	%>
	</ol>
	<h2>Request Parameters</h2>
	<ol>
	<%
	Enumeration<String> e = request.getHeaderNames();
     while (e.hasMoreElements()) {
            String name = (String)e.nextElement();
            String value = request.getHeader(name);
            out.println("<li>"+name + " = " + value+"</li>");
        }
     out.println("<li>"+request.getSession().getId()+"</li>");
	%>
	</ol>
	<h2>Request Parameters</h2>
	<ol>
	<%
	 e = request.getParameterNames();
	     while (e.hasMoreElements()) {
	            String name = (String)e.nextElement();
	            String value = request.getHeader(name);
	            out.println("<li>"+name + " = " + value+"</li>");
	        }
	%>
	</ol>
	<h2>Request Atributes</h2>
	<ol>
	<%
	 e = request.getAttributeNames();
	     while (e.hasMoreElements()) {
	            String name = (String)e.nextElement();
	            String value = request.getHeader(name);
	            out.println("<li>"+name + " = " + value+"</li>");
	        }
	%>
	</ol>
</body>
</html>