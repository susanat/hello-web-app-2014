<!doctype html>

<%@page import="com.ipartek.formacion.helloweb.bean.Persona"%>
<html lang="en">
<head>
  <meta charset="utf-8">

  <title>Hello world</title>
  <meta name="description" content="">
  <meta name="author" content="">

  

  <!--[if lt IE 9]>
  <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
  <![endif]-->
</head>

<body>
 <h1>Hello World 2</h1>
 <P><%=request.getAttribute("entraJsp")%></P>
 
 <% out.print("HOLA MUNDO!!!!"); 
 
 for (int i=1;i<=6;i++ ){
out.print(" <h"+i+"> Cabecera" +i+ "</h"+i+">");
	
}	

Persona p = new Persona("pepe",89);
out.print("Nombre : "+ p.getNombre());
%>

<form action="LoginServlet" method="get">

<button name="GET" type="submit" value="submit"></button>
</form>

<form action="LoginServlet" method="post">
<button name="POST" type="submit" value="submit"></button>

</form>

<a href="">Login</a>
</body>
</html>