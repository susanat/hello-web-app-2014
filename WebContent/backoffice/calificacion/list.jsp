<%@include file="../includes/head.jsp" %>
<%@include file="../includes/nav.jsp" %>

<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ipartek.formacion.helloweb.Constantes"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
	
	<c:choose>
		<c:when test="${calificaciones == null}">
			<h2>No existe ninguna calificación</h2>
			<p>
				<a href='<%=Constantes.JSP_BACKOFFICE_CALIFICACION_FORM%>' title='crear nueva calificación'>
				Por favor crea una nueva calificación</a>
			</p>
		</c:when>
    	<c:otherwise>
			<a href='<%=request.getContextPath() + "/backoffice/calificacion/" + Constantes.JSP_CALIFICACION_FORM %>' title='crear calificación'>Crear Calificación</a>	
			<!-- Sintaxis para el plugin DataTable, paginación de los datos  --> 
			<table id='calificacionesList' class='display' cellspacing='0' width='100%'>
				<thead>
					<tr>
						<th>ID</th>
						<th>Valor</th>
						<th>Descripción</th>
						<th></th>
					</tr>
				</thead>
	
				<tbody>	
					<c:forEach var="calificacion" begin="0" items="${calificaciones}">
						<tr>	
							<td><a href="<%=Constantes.CONTROLLER_CALIFICACION%>?id=${calificacion.id}"
								   title='ir al detalle de <fmt:formatNumber type="number" minIntegerDigits="3" value="${calificacion.id}"/>'>
								   <fmt:formatNumber type="number" minIntegerDigits="3" value="${calificacion.id}"/></a></td>	
							<td>${calificacion.valor}</td>
							<td>${calificacion.texto}</td>
							<td>
								<form action="<%=Constantes.CONTROLLER_CALIFICACION%>" method="post">
									<input type="hidden" name="id" value="${calificacion.id}">
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