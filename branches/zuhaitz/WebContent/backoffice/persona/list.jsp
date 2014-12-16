<%@include file="../includes/head.jsp" %>
<%@include file="../includes/nav.jsp" %>

<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="com.ipartek.formacion.helloweb.bean.Persona"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ipartek.formacion.helloweb.Constantes"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
	
	<c:choose>
		<c:when test="${personas == null}">
			<h2>No existe ninguna persona</h2>
			<p>
				<a href='<%=Constantes.JSP_BACKOFFICE_PERSONA_FORM%>' title='crear nueva persona'>
				Por favor crea una nueva persona</a>
			</p>
		</c:when>
    	<c:otherwise>
			<a href='<%=request.getContextPath() + "/backoffice/persona/" + Constantes.JSP_PERSONA_FORM %>' title='crear persona'>Crear Persona</a>	
			<!-- Sintaxis para el plugin DataTable, paginación de los datos  --> 
			<table id='personasList' class='display' cellspacing='0' width='100%'>
				<thead>
					<tr>
						<th>ID</th>
						<th>Nombre</th>
						<th>Edad</th>
						<th>Rol</th>
						<th></th>
					</tr>
				</thead>
	
				<tbody>	
					<c:forEach var="persona" begin="0" items="${personas}">
						<tr>	
							<td><a href="<%=Constantes.CONTROLLER_PERSONA%>?id=${persona.id}"
								   title='ir al detalle de <fmt:formatNumber type="number" minIntegerDigits="3" value="${persona.id}"/>'>
								   <fmt:formatNumber type="number" minIntegerDigits="3" value="${persona.id}"/></a></td>	
							<td>${persona.nombre}</td>
							<td>${persona.edad}</td>
							<td>${persona.role}</td>
							<td>
								<form action="<%=Constantes.CONTROLLER_PERSONA%>" method="post">
									<input type="hidden" name="id" value="${persona.id}">
									<input type="hidden" name="op" value="<%=Constantes.OP_DELETE%>">
									<input type="submit" class="btn btn-danger" value="Eliminar">
								</form>
							</td>
						</tr>
					</c:forEach> 	
				</tbody>
				
			</table>			
		</c:otherwise>
	</c:choose>

<%@include file="../includes/footer.jsp" %> 