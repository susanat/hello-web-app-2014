<%@page import="com.ipartek.formacion.helloweb.Constantes"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
 <link rel='stylesheet' href='http://codepen.io/assets/libs/fullpage/jquery-ui.css'>

    <link rel="stylesheet" href="css/style.css" media="screen" type="text/css" />
</head>
<body>
<div class="login-card">
    <h1>Log-in</h1><br>
  <form action=<%=Constantes.PATH_LOGIN %> method="post">
  
  	<%
  	
  	//	mostrar mensaje si existe
  	if (null!=request.getAttribute(Constantes.MSG_KEY)){
  		out.print(request.getAttribute(Constantes.MSG_KEY));
  	}
  	
  	%>
  
    <input type="text" name="<%=Constantes.PARAMETRO_USER%>" placeholder="Username">
    <input type="password" name="<%=Constantes.PARAMETRO_PASS%>" placeholder="Password">
    <input type="submit" name="login" class="login login-submit" value="login">
  </form>

  <div class="login-help">
    <a href="#">Register</a> • <a href="#">Forgot Password</a>
  </div>
</div>

<!-- <div id="error"><img src="https://dl.dropboxusercontent.com/u/23299152/Delete-icon.png" /> Your caps-lock is on.</div> -->

  <script src='http://codepen.io/assets/libs/fullpage/jquery_and_jqueryui.js'></script>
</body>
</html>