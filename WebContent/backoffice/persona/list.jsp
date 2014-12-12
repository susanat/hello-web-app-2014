<%@include file="../includes/head.jsp" %>
<%@include file="../includes/nav.jsp" %>

<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="com.ipartek.formacion.helloweb.bean.Persona"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ipartek.formacion.helloweb.Constantes"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    		
	<p><a href="<%=Constantes.JSP_BACK_PERSONA_FORM%>" title="crear nueva persona">cree una nueva persona</a></p>
	<%
		ArrayList<Persona> personas = (ArrayList<Persona>)request.getAttribute( Constantes.ATT_PERSONAS );
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
		                	<a href="<%=Constantes.CONTROLLER_PERSONA+"?id="+p.getId()%>">
								<%=p.getId()%> 
							</a>
						</td>
		                <td>
		                	<a href="<%=Constantes.CONTROLLER_PERSONA+"?id="+p.getId()%>">
		                		<%=p.getNombre()%>
		                	</a> 
		                </td>
		                <td><%=p.getEdad()%> </td>
		                <td><%=p.getRol()%> </td>
		                <td>
		                	<form action="<%=Constantes.CONTROLLER_PERSONA%>" method="post">
		                		<input type="hidden" name="id" value="<%=p.getId()%>">
		                		<input type="hidden" name="<%=Constantes.OP_KEY%>" value="<%=Constantes.OP_DELETE%>">
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