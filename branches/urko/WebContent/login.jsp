<%@page import="com.ipartek.formacion.helloworld.util.Constante"%>
<%@page import="com.ipartek.formacion.helloworld.bean.Persona"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<link rel='stylesheet' href='http://codepen.io/assets/libs/fullpage/jquery-ui.css'>
    <link rel="stylesheet" href="css/style.css" media="screen" type="text/css" />
	<title>Login</title>
</head>
<body>

  <div class="login-card">
    <h1>Log-in</h1>
    <c:out value="prueba" default="La expresion fallo"/> 
  <form action="<%=Constante.SERVLET_LOGIN %>" method="post">
  	<%@ include file="includes/alerts.jsp" 	%>
    <input type="text" name="<%= Constante.PARAMETRO_USER %>" placeholder="Username">
    <input type="password" name="<%=Constante.PARAMETRO_PASS %>" placeholder="Password">
    <input type="submit" name="enviar" class="login login-submit" value="login">
  </form>

  <div class="login-help">
    <a href="#">Register</a> • <a href="#">Forgot Password</a>
  </div>
</div>

<!-- <div id="error"><img src="https://dl.dropboxusercontent.com/u/23299152/Delete-icon.png" /> Your caps-lock is on.</div> -->

  <script src='http://codepen.io/assets/libs/fullpage/jquery_and_jqueryui.js'></script>

</body>
</html>