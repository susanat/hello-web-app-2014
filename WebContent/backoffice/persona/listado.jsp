<%@page import="com.ipartek.formacion.helloweb.bean.Persona"%>
<%@include file="../includes/header.jsp" %>
<%@include file="../includes/menu.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    		
	<p><a href="<%=Constante.JSP_BACKOFFICE_PERSONA_FORM%>" title="crear nueva persona">cree una nueva persona</a></p>
	<%
		ArrayList<Persona> personas = (ArrayList<Persona>)request.getAttribute( Constante.ATT_PERSONAS );
		if ( personas == null ){
			%>
				<h2>No existe nigun persona, por favor</h2>				
			<%
		}else{
			%>
			<table id="tabla" cellspacing="0" width="100%">
		        <thead>
		            <tr>
		                <th>id</th>
		                <th>Nombre</th>
		                <th>Edad</th>
		                <th>Rol</th>
		                <th><!-- Operacion para Eliminar --></th>                
		            </tr>
		        </thead>
		 
		        <tbody>
			<% 
			Persona p = null;
			for ( int i=0; i < personas.size(); i++){
				p = personas.get(i); //detalle persona								
				%>
					<tr>
		                <td>
		                	<a href="<%=Constante.CONTROLER_PERSONA+"?id="+p.getCodigo() %>">
								<%=p.getCodigo()%> 
							</a>
						</td>
		                <td>
		                	<a href="<%=Constante.CONTROLER_PERSONA+"?id="+p.getCodigo()%>">
		                		<%=p.getNombre()%>
		                	</a> 
		                </td>
		                <td><%=p.getEdad()%> </td>
		                <td><%=p.getRol()%> </td>
		                <td>
		                	<form action="<%=Constante.CONTROLER_PERSONA%>" method="post">
		                		<input type="hidden" name="id" value="<%=p.getCodigo()%>">
		                		<input type="hidden" name="<%=Constante.OP_KEY%>" value="<%=Constante.OP_REMOVE%>">
		                		<input type="submit" class="btn btn-outline btn-danger btn-xs" value="Eliminar">
		                	</form>		                	
		                </td>               
		            </tr>   
					
				<%				
			}//end:For
		%>	
		 	</tbody>
    	</table>
		<% 
		}//end:persona not null
	%>
	
	
	
                   
       
	
	
<%@include file="../includes/footer.jsp" %>   