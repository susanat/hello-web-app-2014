<%@page import="com.ipartek.formacion.helloweb.bean.Persona"%>
<%@page pageEncoding="UTF-8" %>

<!doctype html>

<html lang="en">
<head>
  <meta charset="utf-8">

  <title>The HTML5 Hello World</title>
  <meta name="description" content="">
  <meta name="author" content="">

  <!-- <link rel="stylesheet" href="css/styles.css?v=1.0">  -->

  <!--[if lt IE 9]>
  <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
  <![endif]-->
</head>

<body>

	<%
		String path = request.getRequestURL().toString();
	
	%>

	<h1>Index de la página</h1>
	<h2>
		<a href="<%=path %>administracion.jsp">Administracion</a>
		<br>
		<a href="saludo.jsp">Saludo</a>		
	</h2>
	
	
	

  <!-- <script src="js/scripts.js"></script>  -->
</body>
</html>