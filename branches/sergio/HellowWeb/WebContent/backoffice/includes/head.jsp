
<!-- Directiva codificación de la página -->
<%@page import="com.ipartek.formacion.helloweb.bean.Persona"%>
<%@page import="com.ipartek.formacion.helloweb.temp.UtilsTemp"%>
<%@ page pageEncoding="UTF-8" %>

<!-- Includes generales -->
<%@page import="com.ipartek.formacion.helloweb.comun.Constantes"%>



<!DOCTYPE html>
<html lang="es">
<head>

	<!-- Obtenemos la base de la aplicación NO UTILIZADA PARA MULTITHEME -->
	<base href="<%= request.getContextPath() %>">


    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="<%= Constantes.adm_index_desc %>">
    <meta name="author" content="">

    <title><%=Constantes.adm_index_title %></title>
	
	<% //TODO Pasar a theme-head %>
	 <!-- Bootstrap Core CSS -->
	 <link href="<%=Constantes.PATH_BACK_ABS_THEME %>css/bootstrap.min.css" rel="stylesheet">	
	 <!-- MetisMenu CSS -->
	 <link href="<%=Constantes.PATH_BACK_ABS_THEME %>css/metisMenu/metisMenu.min.css" rel="stylesheet">	 	
	 <!-- Custom CSS -->
	 <link href="<%=Constantes.PATH_BACK_ABS_THEME %>css/main.css" rel="stylesheet">	 	
	 <!-- Custom Fonts -->
	 <link href="<%=Constantes.PATH_BACK_ABS_THEME %>fonts/css/font-awesome.min.css" rel="stylesheet" type="text/css">	
	 <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
	 <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
	 <!--[if lt IE 9]>
	     <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
	     <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
	 <![endif]-->
	 
	  <!-- jQuery Version 1.11.0 -->
	 <script src="<%=Constantes.PATH_BACK_ABS_THEME %>js/jquery-1.11.0.js"></script>
    <% //TODO fin pasar a theme-head %>

</head>

<body>
    <div id="wrapper">