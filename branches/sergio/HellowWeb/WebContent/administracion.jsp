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
   		response.sendRedirect("login.jsp");
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
	
	 
	<div class="col-xs-12 text-right">
		<a class="btn btn-success btn-lg" href="logout.jsp">Logout</a>			  		
	</div>
	
	
	
	
	
</body>
</html>