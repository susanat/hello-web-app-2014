<!doctype html>

<%@page import="java.util.ArrayList"%>
<%@page import="com.ipartek.formacion.linkedin.Constantes"%>
<%@page import="com.ipartek.formacion.linkedin.bean.Persona"%>
<html>
<head>
  <meta charset="utf-8">

  <title>Linkedin search</title>

</head>

<body>
  <h1>Búscate en Linkedin</h1>
   
  <form action="searchProfile" method="post"> 	
	<input type=text name="first" placeholder="Nombre..." required>
	<input type=text name="last" placeholder="Apellidos..." required>
	<input type="submit" value="Buscar">
  </form>
  
  <form action="persona" method="get"> 	
		<input type="submit" value="Ver todos">
  </form>
 
</body>
</html>