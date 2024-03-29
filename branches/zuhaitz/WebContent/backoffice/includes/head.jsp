<!DOCTYPE html>

<%@page import="com.ipartek.formacion.helloweb.util.EIdioma"%>
<%@page import="com.ipartek.formacion.helloweb.Constantes"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:set var="language" value="<%= (session.getAttribute(Constantes.USER_LANGUAGE)!=null)?session.getAttribute(Constantes.USER_LANGUAGE):EIdioma.INGLES.getLocale()%>" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="<%=Constantes.PROPERTY_I18N%>" /> 

<html lang="${language}">

<head>

	<base href="<%=request.getContextPath() + "/"%>"/>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>BackOffice</title>

    <!-- Bootstrap Core CSS -->
    <link href="<%=Constantes.JSP_BACKOFFICE%>css/bootstrap.min.css" rel="stylesheet">

    <!-- sb-admin-2 Custom CSS -->
    <link href="<%=Constantes.JSP_BACKOFFICE%>css/sb-admin-2.css" rel="stylesheet">

    <!-- font-awesome Fonts -->
    <link href="<%=Constantes.JSP_BACKOFFICE%>font-awesome-4.1.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    
    <!-- DataTables CSS -->
    <link href="<%=Constantes.JSP_BACKOFFICE%>css/plugins/dataTables.bootstrap.css" rel="stylesheet" type="text/css">
	<link href="http://cdn.datatables.net/1.10.4/css/jquery.dataTables.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

    <div id="wrapper">
