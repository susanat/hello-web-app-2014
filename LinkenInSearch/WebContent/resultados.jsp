<%@page import="com.ipartek.formacion.linkedin.bean.Persona"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<% ArrayList<Persona> personas = null;
personas = (ArrayList<Persona>)request.getAttribute("personas");

out.println("<form action='PersonaServlet' method='post'>");
out.println("<input type='text' name='cmd' value='list' hidden>");
out.println("<input type='submit' value='Ver Todos'>");
out.println("</form>");


for(Persona p:personas){
	out.println("<form action='PersonaServlet' method='post'>");
	out.println("<img width='40' height='40' src='"+p.getFoto()+"'>");
	out.println("<input type='text' name='cmd' value='insert' hidden>");
	out.println("<input type='text' name='foto' value='"+p.getFoto()+"' hidden>");
	out.println("<input type='text' name='nombre' value='"+p.getNombre()+"' hidden>");
	out.println("<input type='text' name='apellido' value='"+p.getApellido()+"' hidden>");
	out.println("<span>"+p.getNombre()+" "+p.getApellido()+"</span>");
	out.println("<input type='submit' value='añadir'>");
	out.println("</form>");
}
%>
</body>
</html>