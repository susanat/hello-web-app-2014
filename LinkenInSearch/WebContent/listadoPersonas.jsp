<%@page import="java.util.ArrayList"%>
<%@page import="com.ipartek.formacion.linkedin.bean.Persona"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	out.println("<a href='index.jsp'>Nueva Busqueda</a>");

	ArrayList<Persona> personas = null;
	personas = (ArrayList<Persona>)request.getAttribute("personas");

	
	out.println("<ul>");
	for(Persona p:personas){
		out.println("<form action='PersonaServlet' method='post'>");
		out.println("<img width='40' height='40' src='"+p.getFoto()+"'>");

		out.println("<input type='text' name='cmd' value='delete' hidden>");
		out.println("<input type='text' name='id' value='"+p.getId()+"'hidden>");
		out.println("<li>"+p.getNombre()+" "+p.getApellido()+"</li>");
		out.println("<input type='submit' value='Borrar'>");
		out.println("</form>");
	}
	out.println("</ul>");
	
%>


</body>
</html>