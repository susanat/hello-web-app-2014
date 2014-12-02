<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="com.ipartek.formacion.helloweb.bean.Persona"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ipartek.formacion.helloweb.Constantes"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listado Personas</title>
</head>
<body>
		<%@include file="/include/alerts.jsp" %>
	<h1>Listado Personas</h1>
	<h2><a href="<%=request.getContextPath() + "/" + Constantes.PATH_LOGIN %>">Volver</a></h2>
	<%
		ArrayList<Persona> personas = (ArrayList<Persona>)request.getAttribute(Constantes.ATT_PERSONAS);
		if(personas == null){
		    %>
		    
		    	<h2>No existe ninguna persona</h2>
		    	<p><a href=<%=Constantes.JSP_BACKOFFICE_PERSONA_FORM %>>Crear</a> una nueva persona</p>
		    <%
		}else{
		    for(int i =0; i<personas.size(); i++){
				out.print(personas.get(i).toString());
				%>
				<a href=<%=Constantes.CONTROLLER_PERSONA +"?id=" +personas.get(i).getId()+ "&accion=" + Constantes.LETRERO_DETALLE %>>Detalle</a>
				<a href=<%=Constantes.CONTROLLER_PERSONA +"?id=" +personas.get(i).getId()+"&accion=" + Constantes.LETRERO_BORRAR %>>Eliminar</a>
				<br>
				<br>
				<%
		    }
		    %>
		    <p><a href=<%=Constantes.JSP_BACKOFFICE_PERSONA_FORM +"?accion=" + Constantes.LETRERO_CREAR %>>Crear</a> una nueva persona</p>
		    <%
		}
	%>
	
</body>
</html>