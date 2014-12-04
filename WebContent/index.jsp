<!doctype html>

<%@page import="com.ipartek.formacion.helloweb.Rol"%>
<%@page import="com.ipartek.formacion.helloweb.bean.Persona"%>
<html lang="en">
<head>
  <meta charset="utf-8">

  <title>The HTML5 Herald</title>
  <meta name="description" content="">
  <meta name="author" content="">
	<!-- Bootstrap Core CSS -->
 
  

  <!--[if lt IE 9]>
  <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
  <![endif]-->
</head>

<body>
  <h1>Hello World 2</h1>
  <% 
  	for( int i=1 ; i<7 ; i++ ){
  		out.print("<h" + i + ">Cabecera " + i + "</h" + i + ">\n"); 
  	}
  
  	Persona p = new Persona ("pepe",3,Rol.USUARIO);
  	out.print ( "Nombre: " + p.getNombre() );
  	
  %>  
  <br>
  <br>
  <form action="login" method="post"> 	
    <input type="submit" value="Submit POST">
  </form>
  <br>
  <br>
  <form action="login" method="get"> 	
    <input type="submit" value="Submit GET">
  </form>
</body>
</html>