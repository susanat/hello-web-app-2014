<!doctype html>

<%@page import="com.ipartek.formacion.helloweb.bean.Persona"%>
<html lang="en">
<head>
  <meta charset="utf-8">

  <title>Hello World</title>
  <meta name="description" content="">
  <meta name="author" content="">

  <link rel="stylesheet" href="css/styles.css?v=1.0">

  <!--[if lt IE 9]>
  <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
  <![endif]-->
</head>

<body>
  <h1>Hello World2</h1>
  <% 
  for(int i=1; i<7; i++) {
	  out.print("<h" + i + ">" + "Cabecera " + i + "</h" + i + ">");  
  }
  
  Persona p = new Persona("Pepe", 22);
  out.print(p.getNombre());
  %>
  
  <form action="login" method="post">
  	<button>Click</button>
  </form>
  
  <a href="http://localhost:8080/HelloWeb/login">Click</a>
</body>
</html>