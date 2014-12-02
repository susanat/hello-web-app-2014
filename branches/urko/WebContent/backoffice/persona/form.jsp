<%@page import="com.ipartek.formacion.helloworld.bean.Persona"%>
<%@page import="com.ipartek.formacion.helloworld.util.Constante"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@include file="../../includes/alerts.jsp"	%>
<% 

	Persona persona  = (Persona)request.getAttribute(Constante.ATT_PERSONA);
	String titulo = "";
	if(persona==null){
	    persona =  new Persona("");
	}
	String property = "";
	Integer operacion = (Integer)request.getAttribute(Constante.ATT_OPERACION);
	if(operacion==null){
	    titulo = "Crear Persona";
	    operacion = Constante.OP_CREATE;
	}else{
	    if(operacion == Constante.OP_UPDATE){
			titulo = "Editar Persona";
	    }else{
			titulo = "Eliminar Persona";
			property = "readonly";
	    }
	}
	%>
	<h1><%=titulo %></h1>
	<a href="<%=request.getContextPath()+"/"+Constante.CONTROLER_PERSONA%>">Volver al listado</a>
	<% if(operacion == Constante.OP_UPDATE || operacion == Constante.OP_CREATE) %>
	<form action="<%=request.getContextPath()+"/"+Constante.CONTROLER_PERSONA %>" method="post">
		<input readonly hidden="hidden" type="text" name="id" id="id" value="<%=persona.getCodigo() %>">
		<input readonly hidden="hidden" type="text" name="<%=Constante.OP_KEY %>" id="<%=Constante.OP_KEY %>" value="<%=operacion %>">
		<div>
			<label for="name">nombre persona</label>
			<input <%=property %> type ="text" name="name" id="name" value="<%=persona.getNombre() %>">
		</div>
			
		<div>
			<label for="nombreUsuario">nombre usuario</label>
			<input <%=property %> type ="text" name="nombreUsuario" id="nombreUsuario" value="<%= persona.getUserName() %>">
		</div>
		<div>
			<label for="edad">edad</label>
			<input <%=property %> type ="number" name="edad" id="edad" value="<%= persona.getEdad()%>">
		</div>
		<div>
			<input hidden="hidden" type ="text" name="id" id="id" disabled value="<%=persona.getRol().getNombre() %>">
		</div> 
		<input type="submit" value="Enviar">
	</form>
	<%if (operacion == Constante.OP_REMOVE) { %>
	<form action="<%=request.getContextPath()+"/"+Constante.CONTROLER_PERSONA %>" method="post">
		<input readonly hidden="hidden" type="text" name="<%=Constante.OP_KEY %>" id="<%=Constante.OP_REMOVE %>" value="<%=operacion %>">
		<input readonly hidden="hidden" type="text" name="id" id="id" value="<%=persona.getCodigo() %>">
		<input type="submit" value="Eliminar">
	</form>
	<% } %>
</body>
</html>