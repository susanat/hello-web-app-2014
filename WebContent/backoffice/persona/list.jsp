<%@include file="../includes/head.jsp" %>
<%@include file="../includes/nav.jsp" %>

<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="com.ipartek.formacion.helloweb.bean.Persona"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ipartek.formacion.helloweb.Constantes"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

	<h1>Listado Personas</h1>
	<%@include file="/includes/alert.jsp"%>
	
	<%
		ArrayList<Persona> personas = (ArrayList<Persona>) request.getAttribute(Constantes.ATTR_PERSONAS);
		if (personas == null) {
	%>
	<h2>No existe ninguna persona</h2>
	<p>
		<a href='<%=Constantes.JSP_BACKOFFICE_PERSONA_FORM%>'
			title='crear nueva persona'>Por favor crea una nueva persona</a>
	</p>
	<%
		} else {
			out.println("<a href='" + request.getContextPath() + "/backoffice/persona/" + Constantes.JSP_PERSONA_FORM + "' title='crear persona'>Crear Persona</a>");
			out.println("<h2>Personas</h2>");
			out.println("<ul>");
			for (Persona persona : personas) {
				out.println("<li>ID = <a href='" + request.getContextPath() + "/" + Constantes.CONTROLLER_PERSONA + "?id=" + persona.getId()
						+ "' title='ir al detalle de " + String.format("%04d", persona.getId()) + "'>"
						+ String.format("%04d", persona.getId()) + "</a>, " + persona + "</li>");
			}
			out.println("</ul>");
		}
	%>

<%@include file="../includes/footer.jsp" %> 	