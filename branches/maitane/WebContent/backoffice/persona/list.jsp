<%@include file="/includes/head.jsp" %>
<%@include file="/includes/nav.jsp" %>

<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ipartek.formacion.helloweb.Constantes"%>
<%@page import="com.ipartek.formacion.helloweb.bean.Persona"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

	

	
	<!-- <p><a href="<%= Constantes.JSP_BACK_PERSONA_FORM%>" title="crear nueva perosna">Cree una nueva persona</a></p> -->

<%
		ArrayList<Persona> personas = (ArrayList<Persona>)request.getAttribute( Constantes.ATT_PERSONAS );
		if ( personas == null ){
			%>
				<h2>No existe niguna persona</h2>
				
			<%
		}else{
			%>
			
	<table id="table" class="display" width="100%" cellspacing="0">
        <thead class="miTabla">
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
        	<c:forEach var="persona" begin="0" items="${personas}">    	
    	
    			<tr>
	        	 	<td><a href="<%=Constantes.CONTROLLER_PERSONA+"?id="%>${persona.id}">${persona.id}</a></td>
	
					<td><a href="<%=Constantes.CONTROLLER_PERSONA+"?id="%>${persona.id}">${persona.nombre}</a></td>
					<td>${persona.edad}</td>
					<td>${persona.rol}</td>
					<td>
					
						<form action="<%=Constantes.CONTROLLER_PERSONA%>" method="post">
							<input type="hidden" name="id" value="${persona.id}"> 		
							<input type="hidden" name="<%=Constantes.OP_KEY %>" value="<%=Constantes.OP_DELETE%>">
							<input class="btn btn-outline btn-danger" type="submit" value="Borrar">
						</form>
					</td>
        	 
        		 </tr>
        	 
    
    		</c:forEach>
        </tbody>
    </table>
    
   
    
    <%} %>
			
			<form action="<%=Constantes.JSP_BACK_PERSONA_FORM%>" method="post">
				<button class="btn btn-primary" type="submit">Nueva Persona</button>
           </form>
           
           
           <%@include file="/includes/footer.jsp" %>