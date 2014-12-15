<%@page import="com.ipartek.formacion.helloweb.i18n.i18n"%>
<%@page import="com.ipartek.formacion.helloweb.i18n.Idioma"%>
<%@page import="com.ipartek.formacion.helloweb.Constantes"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>



<c:set var="language"
	value="<%=(session.getAttribute(Constantes.USER_LANGUAGE) != null) ? session
					.getAttribute(Constantes.USER_LANGUAGE) : i18n
					.getBrowserLocale(request.getLocale())%>" />

<fmt:setLocale value="${language}" />
<fmt:setBundle basename="<%=Constantes.PROPERTI_I18N%>" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="${language}">
<html>
<head>


<!--  base para todos nuestros paths -->
<base href="<%=request.getContextPath() + "/"%>">

<!--  
  <meta charset="UTF-8">
-->
<title><fmt:message key="login.titulo"></fmt:message> - CodePen</title>

<link rel='stylesheet'
	href='http://codepen.io/assets/libs/fullpage/jquery-ui.css'>

<link rel="stylesheet" href="css/style.css" media="screen"
	type="text/css" />
</head>

<body>

	<div class="login-card">
		<h1>
			<fmt:message key="login.titulo"></fmt:message>
		</h1>
		<br>
		<form action="<%=Constantes.PATH_LOGIN%>" method="post">

			
			<input type="text" name="<%=Constantes.PARAMETRO_USER%>"
				placeholder="<fmt:message key="login.form.usuario"></fmt:message>">
			<input type="password" name="<%=Constantes.PARAMETRO_PASS%>"
				placeholder="<fmt:message key="login.form.password"></fmt:message>">

			<%@ taglib prefix="util"
				uri="http://www.formacion.ipartek.com/tags/util"%>

			<util:selectoptions parameterName="<%=Constantes.PARAMETRO_IDIOMA%>"
				className="form-control"
				opValues="<%=Idioma.CASTELLANO.getLocaleArrays()%>"
				opTextos="<%=Idioma.CASTELLANO.getTextoArrays()%>"
				selectedValue="<%=(session.getAttribute(Constantes.USER_LANGUAGE) != null) ? session
					.getAttribute(Constantes.USER_LANGUAGE).toString() : i18n
					.getBrowserLocale(request.getLocale())%>"
				idValue="<%=Constantes.PARAMETRO_IDIOMA%>" />
			<br> <br> <input type="submit" name="login"
				class="login login-submit"
				value="<fmt:message key="login.form.submit"></fmt:message>">
		</form>

		<div class="login-help">
			<a href="#">Register</a> • <a href="#">Forgot Password</a>
		</div>

	</div>

	<!-- <div id="error"><img src="https://dl.dropboxusercontent.com/u/23299152/Delete-icon.png" /> Your caps-lock is on.</div> -->

	<script
		src='http://codepen.io/assets/libs/fullpage/jquery_and_jqueryui.js'></script>
</body>
</html>