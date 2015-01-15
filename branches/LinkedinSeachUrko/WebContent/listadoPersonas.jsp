
<%@page import="com.ipartek.formacion.buscarpersonas.util.Constantes"%>
<%@page import="com.ipartek.formacion.buscarpersonas.bean.Persona"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta charset="utf-8">
  <base href="<%=request.getContextPath()+"/"%>">
  <title>Listado de personas</title>
  <link href="css/bootstrap.min.css" rel="stylesheet">
  <link href="css/main.css" rel="stylesheet">
</head>
<body>
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
		   	if (personas == null || personas.size()==0){
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
							<img alt='foto de perfil' name="<%=Constantes.PARAM_FOTO %>" src='<%=personas.get(i).getFoto() %>' class='pull-left margin-right img-circle' height='120' width='120'>
							
							<input type='hidden' name='<%=Constantes.PARAM_CODIGO %>' value='<%=personas.get(i).getCodigo() %>'>
							
							<input type='text' name='<%=Constantes.PARAM_NAME %>' value='<%=personas.get(i).getNombre() %>'>
							
							<input type='text' name='<%=Constantes.PARAM_SURNAME %>' value='<%=personas.get(i).getApellidos() %>'>
							
							<input type='text' name='<%=Constantes.PARAM_EDAD %>' value='<%=personas.get(i).getEdad() %>'>
							
							<input type='hidden' name='<%=Constantes.PARAM_OPTION %>' value='<%=Constantes.UPDATE%>'>
							<br>
							<input type='submit' value='Actualizar' class='btn btn-primary btn-xs pull-left margin'>
							
						</form>
						
						<form action='persona' method='post' >
							<input type='hidden' name='<%=Constantes.PARAM_CODIGO %>' value='<%=personas.get(i).getCodigo() %>'>
							<input type='hidden' name='<%=Constantes.PARAM_OPTION %>' value='<%=Constantes.DELETE%>'>
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