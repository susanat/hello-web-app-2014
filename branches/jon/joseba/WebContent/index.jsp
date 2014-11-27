<!doctype html>

<%@page import="com.ipartek.formacion.helloweb.bean.Persona"%>
<html lang="en">
<head>
  <meta charset="utf-8">

  <title>Hello Servlet!</title>
  <meta name="description" content="">
  <meta name="author" content="">


  <!--[if lt IE 9]>
  <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
  <![endif]-->
</head>

<body>
  <h1>Hello World! 2</h1>
  
  <% 
  	for(int i = 1; i <= 6; i++){
  	  out.print("<h"+ i + ">Cabecera " + i +"</h" + i + ">");
  	  
  	  
  	}
  	 Persona p = new Persona("Pepe", 89);
	 out.print("Nombre: " + p.getNombre());
	 
	 
   %>
   <br>
   <form action="login" method="post">
   	<input type="submit" value="Enviar Post">
   </form>
   <br>
   <form action="login" method="get">
   	<input type="submit" value="Enviar get">
   </form>
</body>
</html>