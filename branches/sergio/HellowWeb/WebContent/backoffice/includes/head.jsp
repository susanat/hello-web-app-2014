
<!-- Includes generales -->
	<%@page import="com.ipartek.formacion.helloweb.comun.Constantes"%>
	<%@page import="com.ipartek.formacion.helloweb.bean.Persona"%>
	<%@page import="com.ipartek.formacion.helloweb.temp.UtilsTemp"%>

<!-- Directiva codificación de la página -->
	<%@page pageEncoding="UTF-8" %>

<!-- https://jstl.java.net/ -->
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!-- Lenguage -->
	<% 
		//intentamos obtener de sesion el lang del usuario activo
		Object lang = session.getAttribute(Constantes.PARAM_SESSION_LOCALE);
	
		//si no existe, obtenemos el del navegador
		if(lang == null) {
			session.setAttribute(Constantes.PARAM_SESSION_LOCALE, request.getLocale().toString());	
		} 
	%>
	<c:set var="language" value="<%= session.getAttribute(Constantes.PARAM_SESSION_LOCALE) %>" scope="session" />
	
	<fmt:setLocale value="${language}" />
	<fmt:setBundle basename="com.ipartek.formacion.helloweb.i18n.lang" />
<!-- FIN Lenguage -->


<!-- Titulo de la pagina -->
	<c:set var="title" value="Indefinido" />
<!-- FIN Titulo de la pagina -->


<!-- Autentificado -->
	<c:set var="isAuthenticated" scope="page" value="${sessionScope.authenticated == null ? false : true}"/>
	
	<c:choose>
	  <c:when test="${sessionScope.authenticated == null}">
	    <c:set var="isAuthenticated" scope="page" value="${false}"/>
	  </c:when>
	  <c:when test="${sessionScope.authenticated == false}">
	    <c:set var="isAuthenticated" scope="page" value="${false}"/>
	  </c:when>
	  <c:when test="${sessionScope.authenticated == true}">
	    <c:set var="isAuthenticated" scope="page" value="${true}"/>
	  </c:when>								  
	</c:choose>	
<!-- FIN Autentificado -->

<!-- URL actual -->
	<c:set var="lastUrl" scope="page" value="<%= UtilsTemp.cargaHistorial(request, session) %>"/>


<!DOCTYPE html>
<html lang="${language}">
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="<%= "ADMINISTRACION" %>">
    <meta name="author" content="">

    <title>${title}</title>
	
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