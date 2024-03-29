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
	<%@include file="/includes/alerts.jsp"%>
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
			<table id="listapersonas" class="table table-striped table-bordered" width="100%" cellspacing="0">
		        <thead>
		            <tr>
		                <th>Id</th>
		                <th>Nombre</th>
		                <th>Edad</th>
		                <th>Rol</th>
		                <th>Acci�n</th>
		            </tr>
		        </thead>
		 
		        <tfoot>
		            <tr>
		                <th>Id</th>
		                <th>Nombre</th>
		                <th>Edad</th>
		                <th>Rol</th>
		                <th>Acci�n</th>
		            </tr>
		        </tfoot>
		 
		        <tbody>
	<%
			String enlace = null;
			for (int j=0; j<personas.size(); j++) {
				//out.print(personas.get(j).toString());
				enlace = "<a href=\"" + request.getContextPath()+"/"+Constantes.CONTROLLER_PERSONA + "?id=" + personas.get(j).getId() + "\" title=\"Detalle\">" + personas.get(j).getId() + "</a>";
				out.print("<tr><td>" + enlace + "</td>"); 
				out.print("<td>" + personas.get(j).getNombre() + "</td>");
				out.print("<td>" + personas.get(j).getEdad() + "</td>");
				out.print("<td>" + personas.get(j).getRole() + "</td>");
	%>
				<td>
					<form action="<%=Constantes.CONTROLLER_PERSONA %>" method="post">
						<input type="hidden" name="id" value="<%=personas.get(j).getId()%>">
						<input type="hidden" name="<%=Constantes.OP_KEY %>" value="<%=Constantes.OP_DELETE%>">
						<input type="submit" class="btn btn-danger btn-outline btn-xs" value="Eliminar">
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