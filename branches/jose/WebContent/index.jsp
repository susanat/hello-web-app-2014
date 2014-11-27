<!doctype html>

<html lang="en">
<head>
  <meta charset="utf-8">

  <title>The HTML5 Herald</title>
  <meta name="description" content="">
  <meta name="author" content="">


  <!--[if lt IE 9]>
  <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
  <![endif]-->
</head>

<body>
  <h1>Hello World</h1>
  <%
  // out.print("HOLA HOLA");
  for (int i=1; i<7; i++){
	  out.print("<h"+i+">Cabecera"+i+"</h"+i+">");
  }
  //Persona p=new Persona("pepe", 89);
  //out.print("Nombre:"+p.getNombre());
  %>
  
  <a href="">Login</a>
</body>
</html>