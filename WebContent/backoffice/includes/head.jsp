
<%@page import="com.ipartek.formacion.helloweb.Rol"%>
<%@page import="com.ipartek.formacion.helloweb.bean.Persona"%>
<%@page import="com.ipartek.formacion.helloweb.Constantes"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<%@page import="com.ipartek.formacion.helloweb.Constantes"%>
<html lang="es">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Backoffice</title>
    
    <!-- Ruta para todas nuestras URLs relativas -->
	<base href="<%=request.getContextPath()+"/" %>">
    <!-- Bootstrap Core CSS -->
    <link href="<%=Constantes.BACKOFFICE_FOLDER %>css/bootstrap.min.css" rel="stylesheet">
	
	
    <!-- Custom CSS -->
    <link href="<%=Constantes.BACKOFFICE_FOLDER%>css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="<%=Constantes.BACKOFFICE_FOLDER %>font-awesome-4.1.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
	<!-- Datatable Plugin -->
	<link href="<%=Constantes.BACKOFFICE_FOLDER %>css/plugins/jquery.dataTables.css" rel="stylesheet">
    <link href="<%=Constantes.BACKOFFICE_FOLDER %>css/plugins/dataTables.bootstrap.css" rel="stylesheet">
    
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

    <div id="wrapper">
