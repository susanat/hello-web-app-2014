<%@page import="com.ipartek.formacion.helloweb.Constantes"%>
<%@page import="com.ipartek.formacion.helloweb.bean.Persona"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listado Personas</title>
</head>
<body>

	<%@include file="/includes/alert.jsp" %>
	
	<h1>Listado Personas</h1>
	<h2><a href="<%=request.getContextPath()  + Constantes.JSP_BACK_INDEX%>">volver</a></h2>
	
	<%
		ArrayList<Persona> personas = (ArrayList<Persona>) request.getAttribute(Constantes.ATT_PERSONAS);
	
		if(personas==null){
			%>
			<h2>no existe ninguna persona, por favor</h2>
			
			
			<%
			
		}else{
			Persona p = null;	 
			for(int i=0;i<personas.size();i++){
				
				p= personas.get(i); //detalle de personas
				out.println("<ol>");
			%>
				<li>
					<a href="<%=Constantes.CONTROLLER_PERSONA + "?id=" + p.getId()%>">
					<%=p.getNombre()%> 
				</li>
					
			<%	
				out.println("<ol>");
			}	
						
		}
			
	%>
	
	<p><a href="<%=request.getContextPath() + Constantes.JSP_BACK_PERSONA_FORM%>">cree una nueva persona</a></p>

</body>
</html>