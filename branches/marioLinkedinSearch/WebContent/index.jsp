<%@page import="com.ipartek.formacion.linkedin.controller.PersonaServlet"%>
<%@page import="com.ipartek.formacion.linkedin.bean.Mensaje"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@page import="java.util.ArrayList"%>
<%@page import="com.ipartek.formacion.linkedin.Constantes"%>
<%@page import="com.ipartek.formacion.linkedin.bean.Persona"%>
<html>
<head>
 
  <base href="<%=request.getContextPath()+"/"%>">
  <title>Linkedin search</title>
  <link href="css/bootstrap.min.css" rel="stylesheet">
  <link href="css/main.css" rel="stylesheet">
   
</head>

<body>
  
  <div class="panel panel-primary">
	<div class="panel-heading">
        <h2 class="panel-title">Búscate en LinkedIn</h2>
    </div>
    
    <div class="panel-body">
   		<%
    	 	Mensaje mens = (Mensaje) request.getAttribute(PersonaServlet.ATTR_MENSAJE);
    	 	if(mens != null){
    	 	 %>
   	 	 	 	<div class="alert alert-<%=mens.getType()%> alert-dismissible" role="alert">
				  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
					  <span aria-hidden="true">&times;</span>
				  </button>
				  <%=mens.getMsg() %>
				</div>
				
    	 	 <%    
    	 	}
    	 %>
       <form action="searchProfile" method="post"> 	
			<input type=text name="first" placeholder="Nombre..." required>
			<input type=text name="last" placeholder="Apellidos..." required>
			<input type="submit" class="btn btn-primary btn-sm" value="Buscar">
		</form>
	  	<br>
		<form action="persona" method="get"> 	
			<input type="submit" class="btn btn-info btn-sm" value="Ver todos">
		</form>
    </div>
	
   </div>
   
     <!-- JQuery  -->
   <script src="js/jquery-1.11.1.min.js"></script>
    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>
</body>
</html>