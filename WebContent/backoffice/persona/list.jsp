<%@page import="com.ipartek.formacion.helloweb.model.ModeloPersona"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="com.ipartek.formacion.helloweb.bean.Persona"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ipartek.formacion.helloweb.constantes.Constantes"%>
<%@page errorPage="../includes/error.jsp" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@include file="../includes/head.jsp"%>
<%@include file="../includes/nav.jsp"%>
<div class="row">
	<div class="col-lg-12">
		<h1>Listado personas</h1>
	</div>
</div>

	<%@include file="/includes/alerts.jsp"%>

<div class="row">
	<div class="col-lg-12">
		<a href="<%=Constantes.JSP_BACK_PERSONA_FORM%>" title="Crear nueva persona">Crear persona</a>
		<br><br>
	</div>
</div>
	
<div class="row">
	<div class="col-lg-12">	
		<c:if test="${requestScope.personas == null}">
			<h2>No existe ninguna persona</h2>
			<p>Por favor crea una nueva persona</p>
		</c:if>
		
		<c:if test="${requestScope.personas != null}">
				<table id="listapersonas" class="table table-striped table-bordered" width="100%" cellspacing="0">
			        <thead>
			            <tr>
			                <th>Id</th>
			                <th>Nombre</th>
			                <th>Edad</th>
			                <th>Rol</th>
			                <th>Acción</th>
			            </tr>
			        </thead>
			 
			        <tfoot>
			            <tr>
			                <th>Id</th>
			                <th>Nombre</th>
			                <th>Edad</th>
			                <th>Rol</th>
			                <th>Acción</th>
			            </tr>
			        </tfoot>
			 
			 
			 <c:set var="root" value="${pageContext.request.contextPath}"></c:set>
			 
			        <tbody>
		<c:forEach var="j" begin="0" items="${requestScope.personas}">
						<tr>
							<td><a href="${root}/<%=Constantes.CONTROLLER_PERSONA%>?id=${j.id}" title="Detalle">${j.id}</a></td> 
							<td>${j.nombre}</td>
							<td>${j.edad}</td>
							<td>${j.role}</td>
							<td>
								<form action="<%=Constantes.CONTROLLER_PERSONA %>" method="post">
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