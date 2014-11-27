<%@page import="com.ipartek.formacion.helloweb.bean.Persona"%>
<%@page import="com.ipartek.formacion.helloweb.Constantes"%>
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
		//recuperar usuario de session
		Persona p = (Persona)session.getAttribute(Constantes.USER_SESSION);
		if ( p == null ){
			p = new Persona("anonimo", 99 );			
			//String root = request.getSession().getServletContext().getRealPath("/");
			//response.sendRedirect( root +  Constantes.JSP_LOGIN );				
			
			response.sendRedirect( Constantes.JSP_LOGIN );
		}
		
	%>

	<h1>Ongi Etorri  <%=p.getNombre()%></h1>

</body>
</html>







