<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<%@page import="com.ipartek.formacion.helloweb.Constantes"%>
<%@page import="com.ipartek.formacion.helloweb.bean.Persona"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
<%@include file="/backoffice/includes/head.jsp" %>
<%@include file="/backoffice/includes/nav.jsp" %>
	
				
	<c:if test="${requestScope.personas==null}" >		
		<h2>No existe niguna persona, por favor</h2>
		<p>
			<a href="<%= Constantes.JSP_BACK_PERSONA_FORM %>" title="Crear nueva persona">cree una nueva persona</a>
		</p>		
	</c:if>
	<c:if test="${requestScope.personas!=null}" >
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
					<c:forEach var="item" begin="0" items="${requestScope.personas}">				
						<tr>
							<td>
								<a href="<%= Constantes.CONTROLLER_PERSONA + "?id= ${item.id}" %>${item.id}">
									<c:out value="${item.id}"/>
								</a>
							</td>
							<td><c:out value="${item.nombre}"/></td>                	
                			<td><c:out value="${item.edad}"/></td>
                			<td><c:out value="${item.roll}"/></td>
                			<td>
                				<form action="<%= Constantes.CONTROLLER_PERSONA %>" method="post">
									<input type="hidden"name="id" value="${item.id}">
									<input type="hidden"name="<%= Constantes.OP_KEY %>" value="<%=Constantes.OP_DELETE %>">
									<input type="submit" class="btn btn-outline btn-danger" value="Eliminar">	
								</form>                	
                			</td>                	
            			</tr>			
					</c:forEach> 							
				</tbody>
		    </table>
		    
		    </c:if>		   		
		 
<%@include file="/backoffice/includes/footer.jsp" %>