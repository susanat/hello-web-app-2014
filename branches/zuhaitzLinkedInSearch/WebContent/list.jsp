<%@page import="ipt.fm.ipartek.test.util.Constantes"%>
<%@page import="java.util.ArrayList"%>
<%@page import="ipt.fm.ipartek.test.bean.Persona"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Lista de Personas</title>
	</head>
	
	<body>
		<%
			ArrayList<Persona> personas = (ArrayList<Persona>)request.getAttribute("personas");
		
			out.print("<tr>");
			for(Persona persona : personas) {
				out.print("<a href='" + Constantes.CONTROLLER_PERSONA + "?id=" + persona.getId() + "'><td>" 
					+ persona.getNombre() + " " + persona.getApellidos() + "</td></a><br>");
			}
			out.print("</tr>");
		
		%>
		<a href="<%=Constantes.JSP_INDEX%>" title="volver">Volver</a>
	</body>
	
</html>