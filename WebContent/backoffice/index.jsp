<%@page import="com.ipartek.formacion.helloweb.bean.Persona"%>
<%@page import="com.ipartek.formacion.helloweb.listener.SessionListener"%>
<%@page import="com.ipartek.formacion.helloweb.util.ERole"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Map"%>
<%@page import="com.ipartek.formacion.helloweb.listener.SessionCounter"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="includes/head.jsp"%>
<%@include file="includes/nav.jsp"%>  
           
	<span><%=SessionListener.getCount()%></span>
	<%
		ArrayList<Persona> administradores = SessionListener.getSessionsByRole(ERole.ADMINISTRADOR);
	
		if((administradores != null) && (administradores.size() > 0)) {
			out.println("<h4>ADMINISTRADORES</h4>");
			out.println("<ol>");
			
			for(Persona admin : administradores) {
				out.print("<li>" + admin + "</li>");
			}
			
			out.println("</ol>");
		}
	%>

	<%	
		ArrayList<Persona> usuarios = SessionListener.getSessionsByRole(ERole.USER);
		
		if((usuarios != null) && (usuarios.size() > 0)) {
			out.println("<h4>USUARIOS</h4>");
			out.println("<ol>");
			
			for(Persona usuario : usuarios) {
				out.print("<li>" + usuario + "</li>");
			}
			
			out.println("</ol>");
		}
	%>
                                       
<%@include file="includes/footer.jsp" %>
