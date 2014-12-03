<%@page import="com.ipartek.formacion.helloweb.model.ModeloPersona"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="com.ipartek.formacion.helloweb.bean.Persona"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ipartek.formacion.helloweb.constantes.Constantes"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@include file="../includes/head.jsp"%>
<%@include file="../includes/nav.jsp"%>
	<h1>Listado personas</h1>
	<%@include file="/includes/alerts.jsp" %>
	<a href="<%=Constantes.JSP_BACK_PERSONA_FORM%>" title="Crear nueva persona">Crear persona</a>
	<br>
	<%
		ArrayList<Persona> personas = (ArrayList<Persona>)request.getAttribute(Constantes.ATT_PERSONAS);
		if (personas == null) {
	%>
		<h2>No existe ninguna persona</h2>
		<p>Por favor crea una nueva persona</p>
	<%
		} else {
	%>
			<table id="listapersonas" class="display" width="100%" cellspacing="0">
		        <thead>
		            <tr>
		                <th>Id</th>
		                <th>Nombre</th>
		                <th>Edad</th>
		                <th>Rol</th>
		                <th>Acción</th>
		            </tr>
		        </thead>
		 
		        <tfoot>
		            <tr>
		                <th>Id</th>
		                <th>Nombre</th>
		                <th>Edad</th>
		                <th>Rol</th>
		                <th>Acción</th>
		            </tr>
		        </tfoot>
		 
		        <tbody>
	<%
			String enlace = null;
			for (int i=0; i<personas.size(); i++) {
				//out.print(personas.get(i).toString());
				enlace = "<a href=\"" + request.getContextPath()+"/"+Constantes.CONTROLLER_PERSONA + "?id=" + personas.get(i).getId() + "\" title=\"Detalle\">" + personas.get(i).getId() + "</a>";
				out.print("<tr><td>" + enlace + "</td>"); 
				out.print("<td>" + personas.get(i).getNombre() + "</td>");
				out.print("<td>" + personas.get(i).getEdad() + "</td>");
				out.print("<td>" + personas.get(i).getRole() + "</td>");
	%>
				<td>
					<form action="<%=Constantes.CONTROLLER_PERSONA %>" method="post">
						<input type="hidden" name="id" value="<%=personas.get(i).getId()%>">
						<input type="hidden" name="<%=Constantes.OP_KEY %>" value="<%=Constantes.OP_DELETE%>">
						<input type="submit" value="Eliminar">
					</form>
				</td></tr>
	<%
			}
	%>
		        	</tbody>
	    	</table>
	<%
		}
	%>		        

<%@include file="../includes/footer.jsp"%>