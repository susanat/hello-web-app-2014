<%@page import="com.ipartek.formacion.helloweb.i18n.Idioma"%>
<%@page import="com.ipartek.formacion.helloworld.util.Constante"%>
<%@page import="com.ipartek.formacion.helloweb.i18n.I18n"%>
<%@page import="com.ipartek.formacion.helloworld.bean.Persona"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="language" value="eu_ES" />
  <c:set var="language" value="<%=I18n.getBrowserLocale(response.getLocale())  %>" />
  <c:set var="localeCode" value="${pageContext.response.locale}" />
<fmt:setLocale value="${languaje}"/>
<fmt:setBundle basename="com.ipartek.formacion.helloweb.i18n.i18nmesages"/>
<!DOCTYPE html>
<html lang="${languaje} }">
<head>
	<meta charset="utf-8">
	<link rel='stylesheet' href='http://codepen.io/assets/libs/fullpage/jquery-ui.css'>
    <link rel="stylesheet" href="css/style.css" media="screen" type="text/css" />
	<title>Login</title>
</head>
<body>
	
  <div class="login-card">
    <h1><fmt:message key="login.titulo"></fmt:message></h1>
   <h2><c:out value="${localeCode }"/></h2>
  <form action="<%=Constante.SERVLET_LOGIN %>" method="post">
  	<%@ include file="includes/alerts.jsp" 	%>

    <input type="text" name="<%= Constante.PARAMETRO_USER %>" placeholder="<fmt:message key="login.form.username"></fmt:message>">
    <input type="password" name="<%=Constante.PARAMETRO_PASS %>" placeholder="<fmt:message key="login.form.password"></fmt:message>">
    <div class="forgroup">
    <select name="<%=Constante.PARAMETRO_IDIOMA%>">
  	<c:forEach items="<%=Idioma.getNames() %>" var="idioma">
  		<option value="${idioma.key}">${idioma.value}</option>
  	</c:forEach>
  	</select>
  	</div>
    <input type="submit" name="enviar" class="login login-submit" value="<fmt:message key="login.form.submit"></fmt:message>">
  </form>

  <div class="login-help">
    <a href="#">Register</a> • <a href="#">Forgot Password</a>
  </div>
</div>

<!-- <div id="error"><img src="https://dl.dropboxusercontent.com/u/23299152/Delete-icon.png" /> Your caps-lock is on.</div> -->

  <script src='http://codepen.io/assets/libs/fullpage/jquery_and_jqueryui.js'></script>

</body>
</html>