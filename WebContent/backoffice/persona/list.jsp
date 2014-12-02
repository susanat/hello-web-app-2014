<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="com.ipartek.formacion.helloweb.bean.Persona"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ipartek.formacion.helloweb.Constantes"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listado Personas</title>
</head>
<body>
	<h1>Listado Personas</h1>
	<p><a href="<%=Constantes.JSP_BACK_INDEX %>" title="volver">Volver</a></p>
	
	<p><a href="<%= Constantes.JSP_BACK_PERSONA_FORM %>" title="crear nueva persona">+ Crear nueva persona</a></p>
	<%
	ArrayList<Persona> personas = (ArrayList<Persona>) request.getAttribute(Constantes.ATT_PERSONAS);
	
	if(personas == null){
	%>
		    <h2>No existe ninguna persona, por favor, cree una nueva persona</h2>
	<%
		}else{
		    Persona p=null;
		    out.print("<ol>");
		    for(int i=0; i<personas.size(); i++){
				p= personas.get(i);
				out.print("<li>");
				%>
				 	<a href="<%= Constantes.CONTROLLER_PERSONA+"?id="+p.getId() %>" title="nombre">
				  		<%= p.getNombre() %>
				  	</a>
				<%
				out.print("</li>");
				out.print("<br>");
		    }
		    out.print("</ol>");
		}
	
	%>


</body>
</html>