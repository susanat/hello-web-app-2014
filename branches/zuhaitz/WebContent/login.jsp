<!DOCTYPE>

<%@page import="com.ipartek.formacion.helloweb.util.EIdioma"%>
<%@page import="org.eclipse.jdt.internal.compiler.ast.ForeachStatement"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="com.ipartek.formacion.helloweb.listener.InitListener"%>
<%@page import="com.ipartek.formacion.helloweb.bean.Idioma"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ipartek.formacion.helloweb.i18n.I18n"%>
<%@page import="com.ipartek.formacion.helloweb.Constantes"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="hello" uri="http://www.formacion.ipartek.com"%>
<%@ taglib prefix="util" uri="http://www.formacion.ipartek.com/tag/util"%>

<c:set var="language" value="<%= I18n.getBrowserLocale(request.getLocale())%>" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="<%=Constantes.PROPERTY_I18N%>" /> 

<html lang="${language}">

<head>
  	<base href="<%=request.getContextPath()+"/"%>">
	<title>Login</title>
	<link rel='stylesheet' href='http://codepen.io/assets/libs/fullpage/jquery-ui.css'>
	<link rel="stylesheet" href="css/style.css" media="screen" type="text/css">
	<!-- Bootstrap Core CSS -->
	<link href="<%=Constantes.JSP_BACKOFFICE%>css/bootstrap.min.css" rel="stylesheet">
</head>

<body>
	
	<div class="login-card">
		<h1><fmt:message key="login.titulo"></fmt:message></h1>
		<br>
		<form action="<%=Constantes.CONTROLLER_LOGIN%>" method="post">
		
			<%@include file="includes/alert.jsp"%>

			<%
				// Determinar el idioma
				// Primero se busca en las cookies del usuario
				// Si no encuentra: obtenerlo del navegador
				String lang = null;
				if(request.getCookies() != null){
					for(Cookie cookie : request.getCookies()) {
						if(Constantes.COOKIE_USER_LANG.equalsIgnoreCase(cookie.getName())) {
							lang = cookie.getValue();
						}
					}
				}
				
				//Si no encuentra: obtener del navegador
				if(lang == null) {
					lang = I18n.getBrowserLocale(request.getLocale());
				}
			%>
			<div class="form-group">
				<util:selectoptions tagName="lang" 
									tagClass="form-control" 
									opValues="<%=Idioma.getLocalesList(InitListener.modeloIdioma.getAll())%>" 
									opTextos="<%=Idioma.getIdiomaTextoList(InitListener.modeloIdioma.getAll())%>" 
									selectedValue="<%=lang%>"/>
			</div>

			<input type="text" name="<%=Constantes.PARAMETRO_USER%>"
				placeholder="<fmt:message key="login.form.user"></fmt:message>"
				value="${cookie.cuser.value}"> 
			<input type="password" name="<%=Constantes.PARAMETRO_PASS%>" 
				placeholder="<fmt:message key="login.form.password"></fmt:message>"
				value="${cookie.cpass.value}">
			<div class="form-group">
				<input type="checkbox" name="<%=Constantes.PARAMETRO_RECUERDAME%>" ${(cookie.cuser == null) ? "" : "checked"} >
				<span>Recuérdame</span>
			</div>
			<input type="submit" name="login" class="login login-submit"
				value="login"/>
		</form>

		<div class="login-help">
			<a href="#">Register</a> • <a href="#">Forgot Password</a>
		</div>
	</div>

	<script
		src='http://codepen.io/assets/libs/fullpage/jquery_and_jqueryui.js'></script>
</body>

</html>