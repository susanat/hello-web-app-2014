<!doctype html>

<%@page import="com.ipartek.formacion.helloweb.bean.Persona"%>
<html lang="en">
<head>
  <meta charset="utf-8">

  <title>hello world</title>
  <meta name="description" content="">
  <meta name="author" content="">

  <!--[if lt IE 9]>
  <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
  <![endif]-->
</head>

<body>
  <h1>hello world 2</h1>
  
  <% for(int i=1;i<7;i++){
		out.print("<h"+i+">cabecera "+i+"</h"+i+">");
  
  }  
  
  Persona p = new Persona("pepe", 89);
  
  out.print("Nombre: "+p.getNombre());
  %>
  
  <form method="post" action="login">
  <label for="nombre">nombre:</label>
  <input id="nombre" type="text" value=""/>
  <input type="submit" value="enviar"/>
  
  </form>
  
  
</body>
</html>