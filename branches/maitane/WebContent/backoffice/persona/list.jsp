<%@include file="/includes/head.jsp" %>
<%@include file="/includes/nav.jsp" %>

<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ipartek.formacion.helloweb.Constantes"%>
<%@page import="com.ipartek.formacion.helloweb.bean.Persona"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

	

	
	<p><a href="<%= Constantes.JSP_BACK_PERSONA_FORM%>" title="crear nueva perosna">Cree una nueva persona</a></p>

<%
		ArrayList<Persona> personas = (ArrayList<Persona>)request.getAttribute( Constantes.ATT_PERSONAS );
		if ( personas == null ){
			%>
				<h2>No existe nigun persona, por favor</h2>
				<p><a href="<%=Constantes.JSP_BACK_PERSONA_FORM%>" title="crear nueva persona">cree una nueva persona</a></p>
			<%
		}else{
			%>
			
	<table id="table" class="display" width="100%" cellspacing="0">
        <thead>
            <tr>
                <th>Id</th>
                <th>Nombre</th>
                <th>Edad</th>
                <th>Rol</th>
                <th>Eliminar</th>
            </tr>
        </thead>
 
        <tfoot>
            <tr>
                <th>Id</th>
                <th>Nombre</th>
                 <th>Edad</th>
                <th>Rol</th>
                 <th>Eliminar</th>
            </tr>
        </tfoot>
 
        <tbody>
         <%
         Persona p = null;
         for ( int i=0; i < personas.size(); i++){
        	 p = personas.get(i); //detalle persona
        	 %>
        	 <tr>
        	 	<td><a href="<%=Constantes.CONTROLLER_PERSONA+"?id="+p.getId()%>"><%=p.getId()%></a></td>
						
				<td><a href="<%=Constantes.CONTROLLER_PERSONA+"?id="+p.getId()%>"><%=p.getNombre() %></a></td>
				<td><%=p.getEdad() %></td>
				<td><%=p.getRol() %></td>
				<td>
				
					<form action="<%=Constantes.CONTROLLER_PERSONA%>" method="post">
						<input type="hidden" name="id" value="<%=p.getId()%>"> 		
						<input type="hidden" name="<%=Constantes.OP_KEY %>" value="<%=Constantes.OP_DELETE%>">
						<input class="btn btn-outline btn-danger" type="submit" value="Borrar">
					</form>
				</td>
        	 
        	 </tr>
        	 
        <% }
         
         
         %>
         
            
            
        </tbody>
    </table>
					
			<!-- 
			<form action="<%=request.getContextPath()+"/"+Constantes.JSP_BACK_PERSONA_FORM%>" method="post">			
			<input type="submit" value="crear"> 
		</form>
		
		--><%
		}	%>














           
           <%@include file="/includes/footer.jsp" %>