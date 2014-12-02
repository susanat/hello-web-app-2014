<%@page import="com.ipartek.formacion.helloworld.util.Constante"%>
<%@page import="com.ipartek.formacion.helloworld.bean.Persona"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@include file="../../includes/alerts.jsp" 	%>
<% 

	Persona persona  = (Persona)session.getAttribute(Constante.USER_SESSION);
 	if(persona==null || !persona.getRol().getCodigo().equals(Constante.ROL_ADMIN_CODE)){
	    String root = request.getContextPath();
	    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
	    response.sendRedirect(root+"/"+Constante.JSP_SALUDO);
 	}

	
%>
	<h1>Listado Personas</h1>
	
<p>${persona.userName} <p/><a title="Cierra tu sesion" href="<%= Constante.SERVLET_LOGOUT %>">Logout[x]</a>
	<div>Hola bienvenido al primer programa  <%=persona.getUserName() %></div>
	<c:out value="${persona.userName}"/>
	
	<%
	ArrayList<Persona> personas = (ArrayList<Persona>)request.getAttribute(Constante.ATT_PERSONAS);
	if(personas==null){
	%>
	    <h3>No existe ninguna persona</h3>
	   
	<%
	} else {
	    %><ol><%
	    String ruta = request.getContextPath()+"/"+Constante.CONTROLER_PERSONA;
	    String botonBorrar = "";
	    String botonEditar = "";
	    String elCRUD ="<a href='"+request.getContextPath()+"/"+Constante.CONTROLER_PERSONA+"?id=";
	  	String enEditar = "";
	    for (Persona p: personas){
			String rutaEditar = elCRUD+p.getCodigo()+"&"+Constante.ATT_OPERACION+"="+Constante.OP_UPDATE;
			String rutaBorrar = elCRUD+p.getCodigo()+"&"+Constante.ATT_OPERACION+"="+Constante.OP_REMOVE;
			String rutaDetail = elCRUD+p.getCodigo()+"&"+Constante.ATT_OPERACION+"="+Constante.OP_DETAIL;
			/*
			"<form action='"+ruta+"' method='post'><input hidden type ='text' name='id' id='id' disabled value='"
			+ p.getCodigo()+"'><input type='submit' value='Borrar'></form>";
			*/
			botonEditar = rutaEditar+"'>Editar</a>";
			botonBorrar = rutaBorrar+"'>Borrar</a>";
			enEditar  =rutaDetail+"'>";
			out.println("<li>"+enEditar+p.toString()+"</a>"+" "+botonBorrar+" "+botonEditar+"</li> ");
	    }
	    %></ol> <%
	}
	%>
	 <p><a href="<%=Constante.JSP_BACKOFFICE_PERSONA_FORM%>">Crear persona</a></p>
</body>
</html>