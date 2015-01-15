
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
	<title>Resultados de búsqueda</title>
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/main.css" rel="stylesheet">

</head>
<body>
	<div class="panel panel-primary">
		<div class="panel-heading">
	        <h2 class="panel-title">Resultados LinkedIn</h2>
	    </div>
	    <div class="panel-body">
	         <a href="index.jsp" class="btn btn-primary btn-sm active" role="button">
	        	 <span class="glyphicon glyphicon-arrow-left" aria-hidden="true"></span>&nbsp;&nbsp;Volver a la búsqueda
	         </a>
	   		 <br>
	   		 <br>
	   		 
	   		 <form action="persona" method="get"> 	
					<input type="submit" class="btn btn-info btn-sm" value="Ver todos">
			</form>
			<hr>
	      <%
			ArrayList<Persona> personas = (ArrayList<Persona>) request.getAttribute("personas");
		   	if (personas == null || personas.size()==0){
		   	%>
		   	<div class='container'>
	   			<h3>0 resultados obtenidos. Prueba a buscar con otra persona </h3>
	   		</div>
			<hr>
		   	<%} else{
		       for(int i=0; i < personas.size(); i++){
			     %>
		  		<div class='container'> 	  		
					<div class='row'>
						<img alt='foto de perfil' alt="foto" src='<%=personas.get(i).getFoto() %>' class='pull-left margin-right img-circle' height='120' width='120'>
						<h2><%=personas.get(i).getNombre()+" "+ personas.get(i).getApellidos()%> </h2>
					</div>
					<br>
					<div class='row'>
						<dl class="dl-horizontal"><%= personas.get(i).getInfo_basic() %></dl>
						<dl class="dl-horizontal"><%= personas.get(i).getInfo_expanded() %></dl>
						<form action='persona' method='post'>
					    	<input type='hidden' name='<%=Constantes.PARAM_NAME %>' value='<%=personas.get(i).getNombre()%>'>
					    	<input type='hidden' name='<%=Constantes.PARAM_SURNAME %>' value='<%=personas.get(i).getApellidos()%>'>
					   		<input type='hidden' name='<%=Constantes.PARAM_FOTO %>' value='<%=personas.get(i).getFoto()%>'>
					    	<input type='hidden' name='<%=Constantes.PARAM_OPTION %>' value='<%=Constantes.CREATE%>'>
			
					    	<input type='submit' class="btn btn-primary" value='Guardar'>
					    </form>
				    </div>
			    </div>
			    <hr>
				<%
		       }
		   	}
			%>
			
			
			
	    </div>
	
   </div>
	

	
</body>
</html>