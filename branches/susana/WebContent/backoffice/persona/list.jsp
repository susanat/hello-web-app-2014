<%@page import="com.ipartek.formacion.helloweb.bean.Persona"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ipartek.formacion.helloweb.Constantes"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listado Personas</title>
</head>
<body>

	<h1>Listado Persona</h1>
	
	<%
	ArrayList<Persona> personas = (ArrayList<Persona>) request.getAttribute(Constantes.ATT_PERSONAS);
	if( personas == null){
	 	%>
	    <h2>No existe ninguna persona, por favor</h2>
	    <p><a href="<%=Constantes.JSP_BACK_PERSONA_FORM%>" title="crear nueva persona">cree una nueva persona</a></p>
	    
	    <%
	}else{
	    Persona p = null; //fuera para qeu solo te cree una sino en cada bucle te crearia una
		for(int  i=0; i<personas.size(); i++){
		    p = personas.get(i);//detalle persona
		  	out.print("<ul>");
		  	//Maqeuto la persona
		  		%>
		  		<li>
		  			<a href="<%=Constantes.CONTROLER_PERSONA%>?id="+p.getId()%></a>
		  			<%=p.getNombre()%>
		  		</li>
		    <%
		    out.print("</ul>");
		    
		   
		    
		}	
		
	}
	
	
	
	 %>
	 <p><a href="<%=Constantes.JSP_BACK_PERSONA_FORM%>" title="crear nueva persona">cree una nueva persona</a></p>
	
</body>
</html>