<%@page import="com.ipartek.formacion.busredsociales.comun.Constantes"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- https://jstl.java.net/ -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="${language}">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

	<!-- variable modificada por la el body -->
    <title>${documentTittle}</title>


    <!-- Bootstrap Core CSS -->
    <link href="<%=Constantes.PATH_ABS_THEME %>css/bootstrap.min.css" rel="stylesheet">

	<!-- MetisMenu CSS -->
	 <link href="<%=Constantes.PATH_ABS_THEME %>css/metisMenu/metisMenu.min.css" rel="stylesheet">
	
	<!-- Custom Fonts -->
	 <link href="<%=Constantes.PATH_ABS_THEME %>fonts/css/font-awesome.min.css" rel="stylesheet" type="text/css">
	 
    <!-- Custom CSS -->
    <link href="<%=Constantes.PATH_ABS_THEME %>css/main.css" rel="stylesheet">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    
    <script src="<%=Constantes.PATH_ABS_THEME %>js/modernizr-2.6.2-respond-1.1.0.min.js"></script>
</head>
<body>

<%
/*
Comprobar si se está autentificado:
	jstl:
		<c:if test="${isAuthenticated == true}">
		</c:if>		
	Java:
		session.getAttribute(Constantes.PARAM_SESSION_AUTHENTICATED);

Variable que contiene el lenguaje
	jstl:
		${language}
		
	Java:
		session.getAttribute(Constantes.PARAM_SESSION_LOCALE);
		
URL Actual:
	jstl:
		${lastUrl}
	Java:
		session.getAttribute(Constantes.PARAM_SESSION_LAST_URL);		
*/
%>

	<div class="container">