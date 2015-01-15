<%@page import="ipt.fm.ipartek.test.linkedin.bean.Mensaje"%>
<%@page import="ipt.fm.ipartek.test.linkedin.bean.Persona"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>LinkedIn Search</title>
</head>
<body>

<h1>LinkedIn Search</h1>

<a href="http://localhost:8080/LinkenInSearch/index.jsp">Volver</a>
<br>
<%
	boolean error = false;
	if (request.getAttribute("mensaje") != null) {
		String clase = "";
		Mensaje mensaje = (Mensaje)request.getAttribute("mensaje");
		if (mensaje.getType() == Mensaje.MsgType.ERR) {
			clase = "error";
			error = true;
		} else if (mensaje.getType() == Mensaje.MsgType.INF) {
			clase = "info";
		} 
%>
		<div class="<%=clase%>" role="alert">
			<%=mensaje.getMsg()%>
		</div>

<%
	}


	ArrayList<Persona> personas = (ArrayList<Persona>)request.getAttribute("personas");
	if (personas != null && personas.size() > 0) {
		for (int i=0; i<personas.size(); i++) {
%>
			<img src="<%=personas.get(i).getFoto()%>" alt="<%=personas.get(i).getNombre()+" " +personas.get(i).getApellidos()%>" height="60" width="60">
			<form action="persona" method="post">
				<input type="text" name="id" value="<%=personas.get(i).getId()%>" readonly>
				<input type="text" name="nombre" value="<%=personas.get(i).getNombre()%>">
				<input type="text" name="apellidos" value="<%=personas.get(i).getApellidos()%>">
				<input type="hidden" name="operacion" value="0">
				<input type="submit" value="Actualizar">
			</form>
			<form action="persona" method="post">
				<input type="hidden" name="id" value="<%=personas.get(i).getId()%>">
				<input type="hidden" name="operacion" value="1">
				<input type="submit" value="Eliminar">
			</form>
<%
		}
	} else {
		if (!error) {
%>
			<p>Lista vacia</p>	
<%
		}
	}
%>


</body>
</html>