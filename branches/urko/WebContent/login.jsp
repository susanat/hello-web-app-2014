<%@page import="com.ipartek.formacion.helloweb.i18n.Idioma"%>
<%@page import="com.ipartek.formacion.helloworld.util.Constante"%>
<%@page import="com.ipartek.formacion.helloweb.i18n.I18n"%>
<%@page import="com.ipartek.formacion.helloworld.bean.Persona"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="util" uri="http://www.formacion.ipartek.com/tags/util"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="hello" uri="http://www.formacion.ipartek.com"%>
<%@ taglib prefix="saluda2" uri="http://www.formacion.ipartek.com"%>

<c:set var="language" value="eu_ES" />
<c:set var="language" value="<%=I18n.getBrowserLocale(response.getLocale())  %>" />
<c:set var="localeCode" value="${pageContext.response.locale}" />
<fmt:setLocale value="${languaje}"/>
<fmt:setBundle basename="<%=Constante.PROPERTI_I18N %>"/>
<!DOCTYPE html>
<html lang="${languaje} }">
<head>
	<meta charset="utf-8">
	<link rel='stylesheet' href='http://codepen.io/assets/libs/fullpage/jquery-ui.css'>
    <link rel="stylesheet" href="backoffice/css/bootstrap.min.css" media="screen" type="text/css" />
    <link rel="stylesheet" href="css/style.css" media="screen" type="text/css" />
	<title>Login</title>
</head>
<body>
<saluda2:saluda2 nombre="Urko"/>
<saluda2:saluda2 />
<hello:saludo />	
  <div class="login-card">
    <h1><fmt:message key="login.titulo"></fmt:message></h1>
   <h2><c:out value="${language }"/></h2>
  <form action="<%=Constante.SERVLET_LOGIN %>" method="post">
  	<%@ include file="includes/alerts.jsp" 	%>

    <input type="text" name="<%= Constante.PARAMETRO_USER %>" placeholder="<fmt:message key="login.form.username"></fmt:message>">
    <input type="password" name="<%=Constante.PARAMETRO_PASS %>" placeholder="<fmt:message key="login.form.password"></fmt:message>">
    <div class="form-control">
    <select name="<%=Constante.PARAMETRO_IDIOMA%>">
  	<c:forEach items="<%=Idioma.getNames() %>" var="idioma">
  		<c:choose>
  		<c:when test="${fn:containsIgnoreCase(idioma.key, language)}">
  			<option selected="selected" value="${idioma.key}">${idioma.value}</option>
  		</c:when>
  		<c:otherwise>
  			<option value="${idioma.key}">${idioma.value}</option>
  		</c:otherwise>
  		</c:choose>
  	</c:forEach>
  	</select>
  	</div>
  	<util:selectoroptinos cname=""/>
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