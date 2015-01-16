<%@page import="com.ipartek.formacion.linkedin.Constantes"%>
<%@page import="com.ipartek.formacion.linkedin.bean.Persona"%>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listado personas</title>
</head>
<body>
<a  href="index.jsp">volver</a>
<br>
<br>
<div class="panel panel-primary">
		<div class="panel-heading">
	        <h2 class="panel-title">Listado de las Personas</h2>
	    </div>
	    
	    <div class="panel-body">
	       <a href="index.jsp" class="btn btn-primary btn-sm active" role="button">
	       		<span class="glyphicon glyphicon-arrow-left" aria-hidden="true"></span>&nbsp;&nbsp;Volver a la búsqueda
	       </a>
	       <hr>
	       <%
			ArrayList<Persona> personas = (ArrayList<Persona>) request.getAttribute("personas");
		   	if (personas.size()==0){
		   	%>
		   		<div class='container'>
		   			<h3>0 resultados obtenidos </h3>
		   		</div>
				<hr>
		   	<%} else{
		       for(int i=0; i < personas.size(); i++){
			     %>
			       	 <div class='container'> 
						<form action='persona' method='post'>
							<img alt='foto de perfil' name="foto" src='<%= personas.get(i).getUrl_foto() %>' class='pull-left margin-right img-circle' height='120' width='120'>
							
							<input type='hidden' name='id' value='<%= personas.get(i).getId() %>'>
							
							<input type='text' name='nombre' value='<%= personas.get(i).getNombre() %>'>
							
							<input type='text' name='apellidos' value='<%= personas.get(i).getApellido() %>'>
							
							<input type='text' name='edad' value='<%= personas.get(i).getEdad() %>'>
							
							<input type='hidden' name='operacion' value='2'>
							<br>
							<input type='submit' value='Actualizar' class='btn btn-primary btn-xs pull-left margin'>
							
						</form>
						
						<form action='<%= Constantes.PATH_LISTADO_PERSONAS %>' method='post' >
							<input type='hidden' name='id' value='<%=personas.get(i).getId() %>'>
							<input type='hidden' name='operacion' value='3'>
							<input type='submit' value='Eliminar' class='btn btn-danger btn-xs margin'>
						</form>
					</div>
					<hr>
	       		    
	       <%
	        	} // cierre del for
		   	} // cierre del if
	       %>
	       
	    </div>
	
   </div>
 
</body>
</html>