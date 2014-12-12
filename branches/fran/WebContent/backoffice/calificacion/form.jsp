<%@page import="com.ipartek.formacion.helloweb.bean.Calificacion"%>
<%@page import="com.ipartek.formacion.helloweb.constantes.Constantes"%>
<%@page errorPage="../includes/error.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="util" uri="http://www.formacion.ipartek.com/tags/util"%>
<%@include file="../includes/head.jsp"%>
<%@include file="../includes/nav.jsp"%>
	<%
		String submitLabel = "";
		String op = "";
		boolean isNew = false;
		//recoger atributo de persona
		Calificacion p = (Calificacion)request.getAttribute(Constantes.ATT_CALIFICACION);
		if (p==null) {
			//La persona es vacia, vamos a crear una nueva
			//p = new Calificacion("");
			submitLabel = "Crear";
			op = Constantes.OP_INSERT;
			isNew = true;
		} else {
			//La persona viene cargada, se puede actualizar
			submitLabel = "Modificar";
			op = Constantes.OP_UPDATE;
		}
	%>

<c:set var="isNew" value="<%=isNew%>" />

<div class="row">
	<div class="col-lg-12">
		<h1>
		<c:if test="${isNew}">
			<fmt:message key="backoffice.form.calif_nueva"></fmt:message>
		</c:if>
		<c:if test="${!isNew}">
			<fmt:message key="backoffice.form.modificar_calif"></fmt:message>
		</c:if>
		</h1>
	</div>
</div>

	<%@include file="/includes/alerts.jsp" %>
	
<div class="row">
	<div class="col-lg-12">
		<a href="<%=Constantes.CONTROLLER_CALIF%>" title="<fmt:message key="backoffice.calif.lit_crear"></fmt:message>"><fmt:message key="backoffice.calif.lit_crear"></fmt:message></a>
		<br><br>
	</div>
</div>

<div class="row">
	<div class="col-lg-12">
		<form action="<%=Constantes.CONTROLLER_CALIF %>" method="post" role="form">
			<div class="row">
				<div class="col-lg-1">
					<div class="form-group">
						<label for="idcalificacion">Id</label>
						<input type="text" name="id" id="idcalificacion" class="form-control" value="<%=p.getId()%>" readonly>
					</div>
				</div>
			
				<div class="col-lg-1">
					<div class="form-group">
						<label for="valorcalificacion">Valor</label>
						<input type="text" name="nombre" id="valorcalificacion" class="form-control" value="<%=p.getClave()%>">
					</div>
				</div>
				<div class="col-lg-4">
					<div class="form-group">
						<label for="descalificacion">Descripcion</label>
						<input type="text" name="desc" id="descalificacion" class="form-control" value="<%=p.getDescripcion()%>">
					</div>
				</div>
			</div>
			
			<input type="hidden" name="<%=Constantes.OP_KEY %>" value="<%=op%>">
			<input type="submit" value="<%=submitLabel%>">
		</form>
		
		<% 
		if (!isNew) {
		%>
		<form action="<%=Constantes.CONTROLLER_CALIF %>" method="post">
			<input type="hidden" name="id" value="<%=p.getId()%>">
			<input type="hidden" name="<%=Constantes.OP_KEY %>" value="<%=Constantes.OP_DELETE%>">
			<input type="submit" value="Eliminar">
		</form>
		<%
		}
		%>
	</div>
</div>
<%@include file="../includes/footer.jsp"%>