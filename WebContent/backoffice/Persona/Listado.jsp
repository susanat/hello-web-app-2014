<%@page import="com.ipartek.formacion.helloweb.Constantes"%>
<%@page import="com.ipartek.formacion.helloweb.bean.Persona"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
<%@include file="/backoffice/includes/head.jsp" %>
<%@include file="/backoffice/includes/nav.jsp" %>

<%@include file="/includes/alert.jsp" %>
	
	<h1>Listado Personas</h1>
	
	<%
		ArrayList<Persona> personas = (ArrayList<Persona>) request.getAttribute( Constantes.ATT_PERSONAS );
		if ( personas == null ){
			%>
				<h2>No existe nigun persona, por favor</h2>
				<p><a href="<%= Constantes.JSP_BACK_PERSONA_FORM %>" title="Crear nueva persona">cree una nueva persona</a></p>
			<%
		}else{
			Persona p = null;
			%>
			<p><a href="<%= Constantes.JSP_BACK_PERSONA_FORM %>" title="Crear nueva persona">Crear nueva persona</a></p>
			<table id="listaPersonas" class="display" cellspacing="0" width="100%">
	        	<thead>
	            	<tr>
	                	<th>Id</th>
	                	<th>Nombre</th>
	                	<th>Roll</th>
	                	<th>Edad</th>	                
	            	</tr>
	        	</thead>
	 <!-- 
	        	<tfoot>
	            	<tr>
	                	<th>Id</th>
	                	<th>Nombre</th>
	                	<th>Roll</th>
	                	<th>Edad</th>	
	           	 	</tr>
	        	</tfoot>
	 -->
	        	<tbody>
			<%
			for ( int i=0; i < personas.size(); i++){
				p = personas.get(i); //detalle persona							
			%>
				<tr>
                	<td><a href="<%= Constantes.CONTROLLER_PERSONA + "?id=" + p.getId() %>"><%= p.getId() %></a></td>
                	<td><%= p.getNombre() %></td>
                	<td><%= p.getRoll() %></td>
                	<td><%= p.getEdad() %></td>                	
            	</tr>				
			<%			
			}
			%>
				</tbody>
		    </table>		    
		<%
		}		
	%>
		 
<%@include file="/backoffice/includes/footer.jsp" %>