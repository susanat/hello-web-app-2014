 <%@page import="com.ipartek.formacion.buscadorLinkedIn.bean.Message"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listado personas</title>
<link rel="stylesheet" type="text/css" href="css/styles.css"/>
</head>
<body>
	<h1>Listado Personas</h1>
	
	 <%	
  		//mostrar mensaje si existe 
        if(request.getAttribute("mensaje") != null){
           Message msg =(Message)request.getAttribute("mensaje");
           %>
           	  <div class="alert <%=msg.getType() %>">
  				<button type="button" class="close" data-dismiss="alert"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
 					<%=msg.getMsg() %>
			  </div>
           <%
        }
  
  %>
	${requestScope.personas}
	
	<h2><a href="buscador.jsp">Volver al buscador</a></h2>
</body>
<script src="js/jquery.js"></script>
<script src="js/bootstrap.min.js"></script>
</html>