<!doctype html>

<%@page import="com.ipartek.formacion.helloweb.bean.Persona"%>
<%@page import="com.ipartek.formacion.helloweb.Constantes"%>

<html lang="es">
<head>
  <meta charset="utf-8">

	<%@include file="/includes/alert.jsp" %>

  <title>Backoffice</title>
  <meta name="description" content="">
  <meta name="author" content="">

  <link rel="stylesheet" href="css/styles.css?v=1.0">

 
</head>

<body>
	
	<%
		//recuperar usuario de sesion
		Persona p = (Persona)session.getAttribute(Constantes.USER_SESSION);
	
	if(p == null || p.getRoll()!=Persona.Roll.ADMINISTRADOR){
		//p = new Persona("Anonimo",99);		
		String root = request.getContextPath();  //devuelve la ruta de donde esta en el servidor
		String root2 = request.getSession().getServletContext().getRealPath("/"); //devuelve la ruta de donde esta en el disco duro
		response.sendRedirect(root + Constantes.JSP_LOGIN);
						
	}
	
	
	 %>
  <h1>Hello <%= p.getNombre() %></h1>
  
  <p>Has entrado como: <%= p.getNombre() %></p>
  
  <a href="<%=Constantes.PATH_LOGOUT %>" title="Cierra tu sesion">Logout</a>	
  
  <nav>
  	<h3>Menu administracion</h3>
  	<ul>
  		<li><a href="<%=Constantes.CONTROLLER_PERSONA %>" title="Gestionar personas">Personas</a></li> 		
  	
  	</ul>
  	
  </nav>
  
  
  
 
</body>
</html>