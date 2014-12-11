<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- https://jstl.java.net/ -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Blog Post - Start Bootstrap Template</title>

    <!-- Bootstrap Core CSS -->
    <link href="frontoffice/themes/blog-post/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="frontoffice/themes/blog-post/css/main.css" rel="stylesheet">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    
    <script src="frontoffice/themes/blog-post/js/modernizr-2.6.2-respond-1.1.0.min.js"></script>
</head>

<!-- ******************** LOGICA DEL LENGUAGE JSTL ******************* -->
<!-- Lenguage: prioridad si pasa el parámetro language --> 
<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />

<!-- Si le ha pasado el parámetro, prioriza sobre lo que esté puesto en session, así que modificamos session -->
<c:if test="${not empty language}">
	<c:set var="locale_user" value="${language}" scope="session" />
</c:if>

<!-- No hay parámetro de lenguage -->
	<!-- buscamos y obtenemos el de sessión -->
	<!-- si no, como último recurso, obtenemos el del navegador -->
<c:choose>  
  <c:when test="${sessionScope.locale_user != null}">  	
    <c:set var="language" value="${sessionScope.locale_user}"/>
  </c:when>    
  <c:otherwise>
    <c:set var="language" value="${pageContext.request.locale}"/>
  </c:otherwise>  						  
</c:choose>	

<fmt:setLocale value="${language}" />
<fmt:setBundle basename="com.ipartek.formacion.helloweb.i18n.lang" />

<!-- ******************** FIN LOGICA DEL LENGUAGE JSTL *************** -->