<%@page import="com.ipartek.formacion.helloweb.bean.Persona"%>
<%@page import="com.ipartek.formacion.helloweb.Constantes"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%
    
	Persona p = (Persona)session.getAttribute(Constantes.USER_SESSION);
	
	if((p == null)|| (p.getRol() != Persona.Rol.ADMINISTRADOR)) {
	  p = new Persona("anonimo", 99);
	  String root = request.getContextPath();
	  //String root = request.getSession().getServletContext().getRealPath("/");
	  response.sendRedirect(root + "/" + Constantes.JSP_LOGIN );
	}
	
	 %>
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Backoffices</title>
</head>
<body>

	<h1>Backoffices</h1>
	<h2>Ongi Etorri</h2>
	
	 <a href="<%=Constantes.PATH_LOGOUT%>" title="Cerrar session">[X] Cerrar Session</a>
	 
	 <nav>
		 
		 <h3>Menu Administracion</h3>
		 
		 <ul>
		 <!-- La peticion tiene que ser GET  //el = para que me lo pinte-->
		 	<li><a href="<%=Constantes.CONTROLER_PERSONA %>" title="Gestionar Personas">Personas</a></li>
		 	
		 
		 </ul>
		 
		 
		 
		 
	 </nav>

</body>
</html>