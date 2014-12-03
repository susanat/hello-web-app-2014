<%@include file="/includes/head.jsp" %>
<%@include file="/includes/nav.jsp" %>

<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ipartek.formacion.helloweb.Constantes"%>
<%@page import="com.ipartek.formacion.helloweb.bean.Persona"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

	<%@include file="/includes/alerts.jsp" %>
<h1>Listado Personas</h1>
	<h2><a href="<%=request.getContextPath()+"/"+Constantes.JSP_BACK_INDEX%>">volver</a></h2>
	<!--<p><a href="<%= Constantes.JSP_BACK_PERSONA_FORM%>" title="crear nueva perosna">Por favor, cree una nueva persona</a></p>-->

<%
		ArrayList<Persona> personas = (ArrayList<Persona>)request.getAttribute( Constantes.ATT_PERSONAS );
		if ( personas == null ){
			%>
				<h2>No existe nigun persona, por favor</h2>
				<p><a href="<%=Constantes.JSP_BACK_PERSONA_FORM%>" title="crear nueva persona">cree una nueva persona</a></p>
			<%
		}else{
			%>
			
	<table id="example" class="display" width="100%" cellspacing="0">
        <thead>
            <tr>
                <th>Id</th>
                <th>Nombre</th>
                <th>Rol</th>
                <th>Eliminar</th>
            </tr>
        </thead>
 
        <tfoot>
            <tr>
                <th>Id</th>
                <th>Nombre</th>
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
						
				<td><%=p.getNombre() %></td>
				<td><%=p.getRol() %></td>
				<td>
					<form action="<%=request.getContextPath()+"/"+Constantes.CONTROLLER_PERSONA%>" method="post">
						<input type="hidden" name="id" value="<%=p.getId()%>"> 		
						<input type="hidden" name="<%=Constantes.OP_KEY %>" value="<%=Constantes.OP_DELETE%>">
						<input type="submit" value="borrar"> 
					</form>
				</td>
        	 
        	 </tr>
        	 
        <% }
         
         
         %>
         
            
            
        </tbody>
    </table>
					
			
			<form action="<%=request.getContextPath()+"/"+Constantes.JSP_BACK_PERSONA_FORM%>" method="post">			
			<input type="submit" value="crear"> 
		</form><%
		}	%>














           
           <%@include file="/includes/footer.jsp" %>