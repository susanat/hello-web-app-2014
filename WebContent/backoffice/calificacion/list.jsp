<%@page import="com.ipartek.formacion.helloweb.constantes.Constantes"%>
<%@page errorPage="../includes/error.jsp" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@include file="../includes/head.jsp"%>
<%@include file="../includes/nav.jsp"%>
<div class="row">
	<div class="col-lg-12">
		<h1><fmt:message key="backoffice.calif.titular_listado"></fmt:message></h1>
	</div>
</div>

	<%@include file="/includes/alerts.jsp"%>

<div class="row">
	<div class="col-lg-12">
		<a href="<%=Constantes.JSP_BACK_CALIF_FORM%>" title="<fmt:message key="backoffice.calif.lit_crear"></fmt:message>"><fmt:message key="backoffice.calif.lit_crear"></fmt:message></a>
		<br><br>
	</div>
</div>
	
<div class="row">
	<div class="col-lg-12">	
		<c:if test="${requestScope.calificaciones == null}">
			<h2><fmt:message key="backoffice.calif.lit_crear"></fmt:message></h2>
		</c:if>
		
		<c:if test="${requestScope.calificaciones != null}">
				<table id="listacalificaciones" class="table table-striped table-bordered" width="100%" cellspacing="0">
			        <thead>
			            <tr>
			                <th>Id</th>
			                <th>Valor</th>
			                <th>Descripcion</th>
			            </tr>
			        </thead>
			 
			        <tfoot>
			            <tr>
			               	<th>Id</th>
			                <th>Valor</th>
			                <th>Descripcion</th>
			            </tr>
			        </tfoot>
			 
			 
			 <c:set var="root" value="${pageContext.request.contextPath}"></c:set>
			 
			        <tbody>
		<c:forEach var="j" begin="0" items="${requestScope.calificaciones}">
						<tr>
							<td><a href="${root}/<%=Constantes.CONTROLLER_CALIF%>?id=${j.id}" title="Detalle">${j.id}</a></td> 
							<td>${j.clave}</td>
							<td>${j.descripcion}</td>
							<td>
								<form action="<%=Constantes.CONTROLLER_CALIF %>" method="post">
									<input type="hidden" name="id" value="${j.id}">
									<input type="hidden" name="<%=Constantes.OP_KEY %>" value="<%=Constantes.OP_DELETE%>">
									<input type="submit" class="btn btn-danger btn-outline btn-xs" value="Eliminar">
								</form>
							</td>
						</tr>
		</c:forEach>
			   		</tbody>
		   		 </table>
		</c:if>
	</div>
</div>

<%@include file="../includes/footer.jsp"%>