<!DOCTYPE html>
<%@page import="com.ipartek.formacion.helloweb.Constantes"%>
<html>

<head>

  <meta charset="UTF-8">

  <title>Log-in</title>

  <link rel='stylesheet' href='http://codepen.io/assets/libs/fullpage/jquery-ui.css'>

  <link rel="stylesheet" href="css/style.css" media="screen" type="text/css" />

</head>

<body>

  <div class="login-card">
    <h1>Log-in</h1><br>
  <form action="<%=Constantes.PATH_LOGIN %>" method="post">
 	<%
 		//mostrar mensaje si existe
 		if(request.getAttribute(Constantes.MSG_KEY)!=null ){
 		    out.print(request.getAttribute(Constantes.MSG_KEY));
 		}
 	%> 
  
    <input type="text" name="<%=Constantes.PARAMETRO_USER %>" placeholder="Username">
    <input type="password" name="<%=Constantes.PARAMETRO_PASS %>" placeholder="Password">
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