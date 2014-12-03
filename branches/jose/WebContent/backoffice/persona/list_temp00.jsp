<%@page import="com.ipartek.formacion.helloweb.bean.Persona"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ipartek.formacion.helloweb.Constantes"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listado Presonas</title>
</head>
<body>
	<h1>Listado Personas</h1>
	<%
		ArrayList<Persona> personas = (ArrayList<Persona>) request
				.getAttribute(Constantes.ATT_PERSONAS);
		if (personas == null) {
	%>
	<h2>No existe ninguna persona</h2>
	<%
		} else {
	%>
	<ol>

		<%
			Persona p = null;
				for (int i = 0; i < personas.size(); i++) {
					p = personas.get(i); //detalle persona
					//out.println("<ol>");
		%>
		<li><a
			href="<%=Constantes.CONTROLLER_PERSONA + "?id="
							+ p.getId()%>"><%=p.getNombre()%></a></li>
		<%
			//out.println(personas.get(i).toString() + "</li>");
					//out.println("</ol>");
				}
			}
		%>
	</ol>
	<p>
		<a href="<%=Constantes.JSP_BACK_PERSONA_FORM%>"
			value="Crear una nueva persona"> Por favor cree una nueva persona</a>
	</p>

</body>
</html>