<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.ipartek.formacion.helloweb.Constantes"%>

<html>

<head>
<meta charset="UTF-8">
<title>Log-in - CodePen</title>
<link rel='stylesheet' href='http://codepen.io/assets/libs/fullpage/jquery-ui.css'>
<link rel="stylesheet" href="css/style.css" media="screen" type="text/css">
<!-- Bootstrap Core CSS -->
<link href="<%=Constantes.JSP_BACKOFFICE%>css/bootstrap.min.css" rel="stylesheet">
</head>

<body>
	<div class="login-card">
		<h1>Log-in</h1>
		<br>
		<form action="<%=Constantes.CONTROLLER_LOGIN%>" method="post">
		
			<%@include file="includes/alert.jsp"%>

			<input type="text" name="<%=Constantes.PARAMETRO_USER%>"
				placeholder="Username"> <input type="password"
				name="<%=Constantes.PARAMETRO_PASS%>" placeholder="Password">
			<input type="submit" name="login" class="login login-submit"
				value="login">
		</form>

		<div class="login-help">
			<a href="#">Register</a> • <a href="#">Forgot Password</a>
		</div>
	</div>

	<script
		src='http://codepen.io/assets/libs/fullpage/jquery_and_jqueryui.js'></script>
</body>

</html>