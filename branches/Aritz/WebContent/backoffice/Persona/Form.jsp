<%@include file="/backoffice/includes/head.jsp" %>

<%@include file="/backoffice/includes/nav.jsp" %>

<%@page import="com.ipartek.formacion.helloweb.bean.Persona"%>
<%@page import="com.ipartek.formacion.helloweb.Constantes"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
    <%	
    
	Persona p = (Persona)request.getAttribute(Constantes.ATT_PERSONA);	
    //inicializar variable para formulario
    String cabecera= "Crear nueva Persona";
    String buttonValue= "Crear";
    String op = Constantes.OP_UPDATE;
    boolean isnew=false;
    
    //nueva persona    
	if(p==null){
		p = new Persona("");
		isnew=true;
		op = Constantes.OP_CREATE;
	}
    //modificar persona
	else{
		cabecera= "Modificar " + p.getNombre();
		buttonValue="modificar";
		
	}
	
	%>
       
 

	<h1><%= cabecera %></h1>	
	
	<%@include file="/includes/alert.jsp" %>
	
	<form action="<%= Constantes.CONTROLLER_PERSONA %>" method="post">
	
		<input type="text" name="id" readonly value="<%=p.getId() %>">
		<br>
		<input type="text" name="nombre" value="<%=p.getNombre() %>">
		<br>
		<input type="number" name="edad" value="<%=p.getEdad() %>">
		<br>
		<input type="text" name="roll" disabled value="<%=p.getRoll() %>">
		<br>
		<%
		
		%>
		
		<input type="hidden"name="<%=Constantes.OP_KEY %>" value="<%= op %>">
		<input type="submit" value="<%= buttonValue %>">
	
	</form>
	
	
	<% if (!isnew){%>
		
	
	<form action="<%= Constantes.CONTROLLER_PERSONA %>" method="post">
		<input type="hidden"name="id"  disabled value="<%=p.getId() %>">
		<input type="hidden"name="<%=Constantes.OP_KEY %>" value="<%=Constantes.OP_DELETE %>">
		<input type="submit" value="Eliminar">
	
	</form>
	
	<% } %>
	<p><a href="<%= Constantes.CONTROLLER_PERSONA %>">Volver</a></p>
	
	
<%@include file="/backoffice/includes/footer.jsp" %>