<%@page import="com.ipartek.formacion.helloweb.bean.Persona"%>
<%@page import="com.ipartek.formacion.helloweb.comun.Constantes"%>
<%
	//miramos si existe sessión, si existe y tiene la propiedad, comprobamos que es true
	if(session == null || session.getAttribute(Constantes.SESSION_AUTHENTICATED) ==null  || session.getAttribute(Constantes.SESSION_AUTHENTICATED).equals(false))
	{
		//obtenemos el actual path
		String path = request.getRequestURL().toString();
		
		//creamos una session anónima
		if(session == null) {
			session = request.getSession(true);
		}
		
		
		//sesion sin authentificar
		session.setAttribute(Constantes.SESSION_AUTHENTICATED, false);
		session.setAttribute(Constantes.SESSION_LAST_URL, path);
		
		
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
   		response.sendRedirect("login.jsp?" + path);
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
		String strName = "";
	
		/*
		//nombre por sesión
		Persona persona = (Persona) session.getAttribute(Constantes.PARAMETRO_SESSION_USER);
		if(persona != null) {
			strName = persona.getNombre();
		}
		else {			
			//http://www.csgnetwork.com/servererrors.html
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			response.sendRedirect(Constantes.JSP_LOGIN);
			
		}
		*/
	%>

	<h1>Ongi Etorri <%= strName %> </h1>
	
	<div class="col-xs-12 text-right">
		<button class="btn btn-success btn-lg"	type="button" name="signoff" value="Sign off" title="Sign off" >
			Sign off
		</button>				  		
	</div>
	
	
</body>
</html>