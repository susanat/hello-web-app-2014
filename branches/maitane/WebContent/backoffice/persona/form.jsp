<%@page import="com.ipartek.formacion.helloweb.bean.Persona.Rol"%>
<%@include file="/includes/head.jsp" %>
<%@include file="/includes/nav.jsp" %>

<%@page import="com.ipartek.formacion.helloweb.bean.Persona"%>
<%@page import="com.ipartek.formacion.helloweb.Constantes"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%
	//recoger atributo persona
	Persona p=(Persona)request.getAttribute(Constantes.ATT_PERSONA);
    
    //inicializar variables para el formulario
    String cabecera="Crear nueva persona";
    String buttonValue="Crear";
    String op=Constantes.OP_UPDATE;
    boolean isNew=false;
    
  //nueva persona
    if(p==null){
		//si la persona esta vacia, se crea una nueva
		p=new Persona("");
		isNew=true;
		op=Constantes.OP_CREATE;
	}
	//modificar persona
	else{
		cabecera="Modificar" + p.getNombre();
		buttonValue="Modificar";
	}
	%>


	<h1><%=cabecera%></h1>
	<h2><a href="<%=request.getContextPath()+"/"+Constantes.CONTROLLER_PERSONA%>">volver</a></h2>
	
		<%@include file="/includes/alerts.jsp" %>
		
	<form action="<%=request.getContextPath()+"/"+Constantes.CONTROLLER_PERSONA%>" method="post">
	
		
		<br>
		<input type="text" name="id" readonly value="<%=p.getId()%>"> 
		<br>
		<input type="text" name="name" value="<%=p.getNombre()%>">
		<br> 
		<input type="numeric" name="edad" value="<%=p.getEdad()%>">
		<br> 
		
		<input type="radio" name="rol" value="<%=Rol.valueOf("ADMINISTRADOR")%>" >Administrador
		
		<input type="radio" name="rol" value="<%=Rol.valueOf("USER")%>">Usuario
		<br>
		
		<input type="hidden" name="<%=Constantes.OP_KEY %>" value="<%=op%>">
		<input type="submit" value="<%= buttonValue%>"> 
	</form>
	
	<% if(!isNew){ %>
	
	
	<form action="<%=request.getContextPath()+"/"+Constantes.CONTROLLER_PERSONA%>" method="post">
		<input type="hidden" name="id" disabled value="<%=p.getId()%>"> 		
		<input type="hidden" name="<%=Constantes.OP_KEY %>" value="<%=Constantes.OP_DELETE%>">
		<input type="submit" value="borrar"> 
	</form>
	<%}%>
<%@include file="/includes/footer.jsp" %>