<%@page import="com.ipartek.formacion.helloweb.bean.Persona.Rol"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ipartek.formacion.helloweb.bean.Persona"%>
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
		Persona p = (Persona)request.getAttribute(Constantes.ATT_PERSONA);
		if (p==null) {
			//La persona es vacia, vamos a crear una nueva
			p = new Persona("");
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
			<fmt:message key="backoffice.form.persona_nueva"></fmt:message>
		</c:if>
		<c:if test="${!isNew}">
			<fmt:message key="backoffice.form.modificar_persona"></fmt:message>
			<%= " " + p.getNombre() %>
		</c:if>
		</h1>
	</div>
</div>

	<%@include file="/includes/alerts.jsp" %>
	
<div class="row">
	<div class="col-lg-12">
		<a href="<%=Constantes.CONTROLLER_PERSONA%>" title="Listado de personas">Volver al listado</a>
		<br><br>
	</div>
</div>

<div class="row">
	<div class="col-lg-12">
		<form action="<%=Constantes.CONTROLLER_PERSONA %>" method="post" role="form">
			<div class="row">
				<div class="col-lg-1">
					<div class="form-group">
						<label for="idpersona">Id</label>
						<input type="text" name="id" id="idpersona" class="form-control" value="<%=p.getId()%>" readonly>
					</div>
				</div>
			
				<div class="col-lg-5">
					<div class="form-group">
						<label for="nombrepersona">Nombre</label>
						<input type="text" name="nombre" id="nombrepersona" class="form-control" value="<%=p.getNombre()%>">
					</div>
				</div>
			</div>
			
			
			<div class="row">
				<div class="col-lg-1">
					<div class="form-group">
						<label for="edadpersona">Edad</label>
						<input type="numeric" name="edad" id="edadpersona" class="form-control" value="<%=p.getEdad()%>">
					</div>
				</div>
			
				<div class="col-lg-5">
					<div class="form-group">
						<label>Permisos</label>
						<br>
					<!-- Esto se podria hacer con un for -->
					<input type="radio" name="rol" value="<%=Persona.Rol.ADMINISTRADOR%>"
					<%
						if (Persona.Rol.ADMINISTRADOR.equals(p.getRole())) {
					%>
						checked
					<%
						}
					%>><%=Persona.Rol.ADMINISTRADOR%>
						<input type="radio" name="rol" value="<%=Persona.Rol.USER%>"
					<%
						if (Persona.Rol.USER.equals(p.getRole())) {
					%>
						checked
					<%
						}
					%>><%=Persona.Rol.USER%>
					</div>
				</div>
			</div>
			
			<input type="hidden" name="<%=Constantes.OP_KEY %>" value="<%=op%>">
			<input type="submit" value="<%=submitLabel%>">
		</form>
		
		<% 
		if (!isNew) {
		%>
		<form action="<%=Constantes.CONTROLLER_PERSONA %>" method="post">
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