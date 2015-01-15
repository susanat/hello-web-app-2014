<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@page import="java.util.ArrayList"%>


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
</body>
</html>