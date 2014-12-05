<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<%@page import="com.ipartek.formacion.helloweb.Constantes"%>
<%@page import="com.ipartek.formacion.helloweb.bean.Persona"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
<%@include file="/backoffice/includes/head.jsp" %>
<%@include file="/backoffice/includes/nav.jsp" %>
	
	<%
		ArrayList<Persona> personas = (ArrayList<Persona>) request.getAttribute( Constantes.ATT_PERSONAS );
		if ( personas == null ){
			%>
				<h2>No existe niguna persona, por favor</h2>
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
	                	<th>Edad</th>
	                	<th>Roll</th>
	                	<th></th>	                
	            	</tr>
	        	</thead>	
	        	<tbody>
						
						<%
			for ( int i=0; i < personas.size(); i++){
				p = personas.get(i); //detalle persona							
			%>
				<tr>
                	<td><a href="<%= Constantes.CONTROLLER_PERSONA + "?id=" + p.getId() %>"><%= p.getId() %></a></td>
                	<td><%= p.getNombre() %></td>                	
                	<td><%= p.getEdad() %></td>
                	<td><%= p.getRoll() %></td>
                	<td>
                		<form action="<%= Constantes.CONTROLLER_PERSONA %>" method="post">
							<input type="hidden"name="id" value="<%= p.getId() %>">
							<input type="hidden"name="<%= Constantes.OP_KEY %>" value="<%=Constantes.OP_DELETE %>">
							<input type="submit" class="btn btn-outline btn-danger" value="Eliminar">
	
						</form>                	
                	</td>                	
            	</tr>				
			<%			
			}//end for
			%>
					
				</tbody>
		    </table>		    
		<%
		}//end if		
	%>
		 
<%@include file="/backoffice/includes/footer.jsp" %>