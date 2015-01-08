<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta charset="utf-8">
  <base href="<%=request.getContextPath()+"/"%>">
  <title>Listado de búsqueda</title>
  <link href="css/bootstrap.min.css" rel="stylesheet">
  <link href="css/main.css" rel="stylesheet">
</head>
<body>
	<div class="panel panel-primary">
	<div class="panel-heading">
        <h2 class="panel-title">LISTADO DE LAS PERSONAS EN LA BD</h2>
    </div>
    
    <div class="panel-body">
       <a href="index.jsp" class="btn btn-primary btn-sm active" role="button">Volver a la búsqueda</a>
       <br><br>
       ${requestScope.personas}	
    </div>
	
   </div>
     
</body>
</html>