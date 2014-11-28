<!doctype html>
<%@page import="com.ipartek.formacion.helloweb.util.Rol"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.ipartek.formacion.helloweb.bean.Persona"%>
<html lang="en">

<head>
<meta charset="utf-8">
<title>Hello World</title>
<meta name="description" content="">
<meta name="author" content="">

<!--[if lt IE 9]>
		<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
		<![endif]-->
</head>

<body>
	<h1>Hello World 2</h1>
	<%
		for (int i = 1; i < 7; i++) {
			out.print("<h" + i + ">Cabecera" + i + "</h" + i + ">");
		}

		Persona p = new Persona("pepe", 89, Rol.INVITADO);
		out.print("Nombre: " + p.getNombre());
	%>
	<a href="">Login</a>
</body>

</html>