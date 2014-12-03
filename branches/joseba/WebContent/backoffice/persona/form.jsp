

<%@page import="com.ipartek.formacion.helloweb.bean.Persona"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@include file="../includes/head.jsp" %>
<%@include file="../includes/nav.jsp" %>
<%@include file="/include/alerts.jsp" %>
<%
			Persona p1 = (Persona)request.getAttribute(Constantes.ATT_PERSONA);
			String cabecera = "Crear nueva persona";
			String buttonValue = "Crear";
			String op= Constantes.OP_UPDATE;
			boolean isNew = false;
			
			//nueva persona
			if(p1 == null){
			    p1 = new Persona("");
			    isNew = true;
			    op = Constantes.OP_CREATE;
			  
			}
			//modificar persona
			else if(Constantes.LETRERO_BORRAR.equals(request.getParameter("accion"))){
			    cabecera = "Borrar " + p1.getNombre(); 
			    buttonValue = "Modificar";
			}
			else{
			    cabecera = "Modificar " + p1.getNombre();
			    buttonValue = "Modificar";
			}
		%>
		<h1><%=cabecera %> </h1>
		
		
		
		<form action="<%=request.getContextPath() + "/" + Constantes.CONTROLLER_PERSONA %>" method="post">
			<input type="text" name="id" readonly="readonly" value="<%=p1.getId()%>">
			<br>
			<input type="text" name="name" value="<%=p1.getNombre()%>">
			<br>
			<input type="number" name="edad" value="<%=p1.getEdad()%>">
			<br>
			<input type="radio" name="rol" value=<%=Persona.Rol.ADMINISTRADOR %>>Administrador<br>
			<input type="radio" name="rol" value=<%=Persona.Rol.USER %>>Usuario
			<br>
			<input type="hidden" name="op" value=<%= op %>>
			<br>
			<input type="submit" value=<%=buttonValue %> class="btn btn-primary">
		</form>
		<!-- TODO: Formulario eliminar -->
		
		<%
			if(!isNew && Constantes.LETRERO_BORRAR.equals(request.getParameter("accion"))){
		%>
		<form action="<%=request.getContextPath() + "/" + Constantes.CONTROLLER_PERSONA %>" method="post">
			<input type="hidden" name="id" value="<%=p1.getId() %>">
			<input type="hidden" name=<%=Constantes.OP_KEY %> value=<%=Constantes.OP_DELETE %>>
			<br>
			<input type="submit" value="Eliminar" class="btn btn-danger">
		</form>
		<%} %>
		<br>
		<a href="<%=request.getContextPath() + "/" + Constantes.CONTROLLER_PERSONA %>" class="btn btn-primary"><i class="fa fa-arrow-left fa-fw"></i>Volver</a>
<%@include file="../includes/footer.jsp" %>