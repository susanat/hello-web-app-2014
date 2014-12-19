<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- https://jstl.java.net/ -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!-- Includes -->
<%@page import="com.ipartek.formacion.helloweb.temp.UtilsTemp"%>
<%@page import="com.ipartek.formacion.helloweb.comun.Constantes"%>

<!-- ******************** LOGICA DEL LENGUAGE JSTL ******************* -->
<!--1º
	Lenguage: prioridad si pasa el parámetro language 
	significa que quiere cambiar de lenguaje
	si no, se marca con el lenguaje del navegador 
--> 
<c:set var="language" value="${param.language}" scope="session" />



<!-- Si existe, añadimos a sessión -->
<c:if test="${not empty param.language}" >
	<c:set var="user_locale" value="${language}" scope="session" />
</c:if>



<!-- 2º  
	No ha querido cambiar, por lo tanto comprobamos session. 
	Si no existe en sesión:
		- 1 - Obtenemos el de la cookie
		- 2 - Por último cojemos el del navegador
-->
	<c:choose>  
	  <c:when test="${sessionScope.user_locale != null}">  	
	    <c:set var="language" value="${sessionScope.user_locale}"/>
	  </c:when>    
	  <c:otherwise>	  	
	  		<c:forEach items="${cookie}" var="currentCookie">			    	
		    	<c:set var="cookie_locale" value="<%=Constantes.cookie_user_lang %>" scope="page" />
		    			    	 
				<c:if test="${currentCookie.value.name == cookie_locale }">
			    	<c:set var="language" value="${currentCookie.value.value}" scope="page" />
			    	<c:set var="user_locale" value="${language}" scope="session" />
				</c:if>				    
			</c:forEach>
			<c:if test="${empty language}">
				<c:set var="language" value="${pageContext.request.locale}"/>
		    	<c:set var="user_locale" value="${language}" scope="session" />
			</c:if>
		    
	  </c:otherwise>  						  
	</c:choose>	


<!-- Activamos el idioma -->
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="com.ipartek.formacion.helloweb.i18n.lang" />

<!-- ******************** FIN LOGICA DEL LENGUAGE JSTL *************** -->

<!-- ******************** Autentificado *************** -->
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
<!-- ******************** FIN Autentificado *************** -->

<!-- ******************** URL Actual *************** -->
<c:set var="lastUrl" scope="page" value="<%= UtilsTemp.cargaHistorial(request, session) %>"/>
<!-- ******************** FIN URL Actual *************** -->

<!DOCTYPE html>
<html lang="${language}">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>${pgTitle}</title>

    <!-- Bootstrap Core CSS -->
    <link href="<%=Constantes.PATH_FRONT_ABS_THEME %>css/bootstrap.min.css" rel="stylesheet">

	<!-- MetisMenu CSS -->
	 <link href="<%=Constantes.PATH_FRONT_ABS_THEME %>css/metisMenu/metisMenu.min.css" rel="stylesheet">
	 
    <!-- Custom CSS -->
    <link href="<%=Constantes.PATH_FRONT_ABS_THEME %>css/main.css" rel="stylesheet">
    
    <!-- Custom Fonts -->
	 <link href="<%=Constantes.PATH_FRONT_ABS_THEME %>fonts/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    
    <script src="<%=Constantes.PATH_FRONT_ABS_THEME %>js/modernizr-2.6.2-respond-1.1.0.min.js"></script>
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