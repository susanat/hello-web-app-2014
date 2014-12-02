<%@include file="../includes/head.jsp" %>
<%@include file="../includes/nav.jsp" %>


<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="com.ipartek.formacion.helloweb.bean.Persona"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ipartek.formacion.helloweb.Constantes"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>



	<%@include file="/includes/alerts.jsp" %>

	<h1>Listado Personas</h1>
	<h2><a href="<%=request.getContextPath()+"/"+Constantes.JSP_BACK_INDEX%>">volver</a></h2>
	<p><a href="<%=Constantes.JSP_BACK_PERSONA_FORM%>" title="crear nueva persona">cree una nueva persona</a></p>
	<%
		ArrayList<Persona> personas = (ArrayList<Persona>)request.getAttribute( Constantes.ATT_PERSONAS );
		if ( personas == null ){
			%>
				<h2>No existe nigun persona, por favor</h2>
				<p><a href="<%=Constantes.JSP_BACK_PERSONA_FORM%>" title="crear nueva persona">cree una nueva persona</a></p>
			<%
		}else{
			Persona p = null;
			for ( int i=0; i < personas.size(); i++){
				p = personas.get(i); //detalle persona
				out.println("<ol>");				
				%>
					<li>
						<a href="<%=Constantes.CONTROLLER_PERSONA+"?id="+p.getId()%>">
							<%=p.getNombre()%> 
						</a>
					</li>
				<%
				out.println("</ol>");
			}
		}
	%>
	
	
<%@include file="../includes/footer.jsp" %>   