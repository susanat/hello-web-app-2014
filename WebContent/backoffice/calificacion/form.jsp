<%@page import="com.ipartek.formacion.helloweb.bean.Calificacion"%>
<%@include file="../includes/head.jsp" %>
<%@include file="../includes/nav.jsp" %>

<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="com.ipartek.formacion.helloweb.Constantes"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="util" uri="http://www.formacion.ipartek.com/tag/util"%>

<%
	Calificacion calificacion = (Calificacion) request.getAttribute(Constantes.ATTR_CALIFICACION);
	String buttonValue ="Crear";
	int op = Constantes.OP_UPDATE;
	boolean isNew = false;
	
	// Nueva Calificacion
	if (calificacion == null) {
		calificacion = new Calificacion(-1,"");
		isNew = true;
		op = Constantes.OP_INSERT;
	// Modificar Calificacion
	} else {
		buttonValue = "Modificar";
	}
%>

	<a href="<%=request.getContextPath() + "/" + Constantes.CONTROLLER_CALIFICACION%>" 
	   title="ir a la lista de calificaciones">Lista Calificaciones</a>

	<form action="<%=request.getContextPath() + "/" + Constantes.CONTROLLER_CALIFICACION%>" method="post">
		<div class="form-group"><input type='hidden' name='op' value=<%=op%>></div>
		
		<div class="form-group">
			<input class="form-control" type='text' name='id' readonly 
				   value="<fmt:formatNumber type="number" minIntegerDigits="3" value="${calificacion.id}"/>"/>
		</div>
		
		<div class="form-group">
			<label>Valor</label>
			<input class="form-control" type='number' name='valor' value="<%=calificacion.getValor()%>"/>
		</div>
		
		<div class="form-group">
			<label>Descripción</label>
			<input class="form-control" type='text' name='texto' value="<%=calificacion.getTexto()%>"/>
		</div> 
		
		<br>
		
		<input type='submit' class="btn btn-primary pull-left" value='<%=buttonValue%>'>
		
	</form>
	
	<% if(!isNew) { %>
		<form action='<%=request.getContextPath() + "/" + Constantes.CONTROLLER_CALIFICACION%>' method='post'>
			<input type="hidden" name="id" value="<%=calificacion.getId()%>">
			<input type='hidden' name='op' value='<%=Constantes.OP_DELETE %>'>
			<input type='submit' class="btn btn-danger pull-right" value='Eliminar'>
		</form>
	<% } %>

<%@include file="../includes/footer.jsp" %> 