<%@page import="com.ipartek.formacion.helloweb.i18n.Idioma"%>
<%@page import="com.ipartek.formacion.helloweb.util.Constante"%>
<%@page import="com.ipartek.formacion.helloweb.i18n.I18n"%>
<%@page import="com.ipartek.formacion.helloweb.bean.Persona"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="util" uri="http://www.formacion.ipartek.com/tags/util"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="hello" uri="http://www.formacion.ipartek.com"%>
<%@ taglib prefix="saluda2" uri="http://www.formacion.ipartek.com"%>

<c:set var="language" value="eu_ES" />
<c:set var="language" value="<%=I18n.getBrowserLocale(response.getLocale())  %>" />
<c:set var="localeCode" value="${pageContext.response.locale}" />
<fmt:setLocale value="${languaje}"/>
<fmt:setBundle basename="<%=Constante.PROPERTI_I18N %>"/>
<!DOCTYPE html>
<html lang="${language }">
<head>
	<base href="<%=request.getContextPath()+"/"%>">
	<meta charset="utf-8">
	<link rel='stylesheet' href='http://codepen.io/assets/libs/fullpage/jquery-ui.css'>
    <link rel="stylesheet" href="backoffice/css/bootstrap.min.css" media="screen" type="text/css" />
    <link rel="stylesheet" href="css/style.css" media="screen" type="text/css" />
	<title>Login</title>
</head>
<body>
<!-- 
<fmt:message>
	<fmt:param value="uno"/>
	<fmt:param value="dos"/>
</fmt:message>
 -->
<saluda2:saluda2 nombre="Urko"/>
<saluda2:saluda2 />
<hello:saludo />	
  <div class="login-card">
    <h1><fmt:message key="login.titulo"></fmt:message></h1>
   <h2><c:out value="${language }"/></h2>
   <%@ include file="includes/alerts.jsp" 	%>
	<%@ include file="includes/loginForm.jsp" 	%>
</div>

<!-- <div id="error"><img src="https://dl.dropboxusercontent.com/u/23299152/Delete-icon.png" /> Your caps-lock is on.</div> -->

  <script src='http://codepen.io/assets/libs/fullpage/jquery_and_jqueryui.js'></script>

</body>
</html>