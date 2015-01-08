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
	        <h2 class="panel-title">RESULTADOS LINKEDIN</h2>
	    </div>
	    
	    <div class="panel-body">
		    <form action="persona" method="get"> 	
				<input type="submit" value="Ver todos">
	 		 </form>
			
			${requestScope.resulthtml} 
	    </div>
	
   </div>
	

	
</body>
</html>