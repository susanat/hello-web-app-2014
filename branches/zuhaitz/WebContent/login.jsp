<!DOCTYPE>

<%@page import="com.ipartek.formacion.helloweb.i18n.Idioma"%>
<%@page import="com.ipartek.formacion.helloweb.i18n.I18n"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.ipartek.formacion.helloweb.Constantes"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:set var="language" value="<%= I18n.getBrowserLocale(request.getLocale())%>" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="<%=Constantes.PROPERTY_I18N%>" /> 

<html lang="${language}">

<head>
<title>Log-in - CodePen</title>
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

			<div class="form-group">
				<c:set var="idiomas" value="<%=Idioma.values()%>"/>
				<select class="form-control" name='<%=Constantes.PARAMETRO_LANG%>'>
					
						<%
							String languageBrowser = I18n.getBrowserLocale(request.getLocale());
							for(Idioma idioma : Idioma.values()){
								StringBuffer op = new StringBuffer();
								op.append("<option ");
								
								if(languageBrowser.equals(idioma.getLocale())){
									op.append(" selected ");
								}
								
								op.append("value='" + idioma.getLocale() + "'>");
								op.append(idioma);
								op.append("</option>");
								out.print(op.toString());
							}
						%>
						
				</select>
			</div>

			<input type="text" name="<%=Constantes.PARAMETRO_USER%>"
				placeholder="<fmt:message key="login.form.user"></fmt:message>"/> 
			<input type="password" name="<%=Constantes.PARAMETRO_PASS%>" 
				placeholder="<fmt:message key="login.form.password"></fmt:message>"/>
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