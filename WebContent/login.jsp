<%@page import="com.ipartek.formacion.helloweb.i18n.Idioma"%>
<%@page import="com.ipartek.formacion.helloweb.i18n.I18n"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@page import="com.ipartek.formacion.helloweb.Constantes"%>

<c:set var="language" value="<%= I18n.getBrowserLocale(request.getLocale()) %>" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="com.ipartek.formacion.helloweb.i18n.i18nmesages" />

<!DOCTYPE html>

<html lang="${language}">
 
<head>

  <meta charset="UTF-8">

  <title><fmt:message key="login.titulo" /></title>

  <link rel='stylesheet' href='http://codepen.io/assets/libs/fullpage/jquery-ui.css'>
  <link href="<%=Constantes.BACKOFFICE_FOLDER %>css/bootstrap.min.css" rel="stylesheet">
  <link rel="stylesheet" href="css/style.css" media="screen" type="text/css" />
   	
</head>

<body>
	<%@include file="includes/alerts.jsp" %>
 	
	 
  <div class="login-card "> 	
  	
    <h1><fmt:message key="login.titulo" /></h1><br>
  	<form action="<%=Constantes.PATH_LOGIN %>" method="post"> 
	    <input type="text" name="<%=Constantes.PARAMETRO_USER %>" placeholder= <fmt:message key="login.form.usuario"/> >
	    <input type="password" name="<%=Constantes.PARAMETRO_PASS %>" placeholder=<fmt:message key="login.form.password" />>
	    <input type="submit" name="login" class="login login-submit" value=<fmt:message key="login.form.submit" />>
 	</form>

	<div class="login-help">
	    <a href="#">Register</a> • <a href="#">Forgot Password</a>
	</div> 
	<br>
	<div id="idiomas">
  		<select name="idiomas" class="form-control">
  	
  		<% for(Idioma idiom: Idioma.values()) {
  		%>	
  			<c:set var="idi" value="<%= idiom.getLocale() %>" />
  			<c:choose>
			      <c:when test="${language==idi}">
			      	<option value="<%=idiom.toString() %>" selected >
						<%=idiom.toString()%>
					</option>
			      </c:when>
			      <c:otherwise>
			      	<option value="<%=idiom.toString() %>" >
							<%=idiom.toString()%>
					</option>
			      </c:otherwise>
			</c:choose>
  		<%   
  		}
  		%>
  		</select>
 	 </div>
</div>

<!-- <div id="error"><img src="https://dl.dropboxusercontent.com/u/23299152/Delete-icon.png" /> Your caps-lock is on.</div> -->

  <script src='http://codepen.io/assets/libs/fullpage/jquery_and_jqueryui.js'></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="<%=Constantes.BACKOFFICE_FOLDER %>js/bootstrap.min.js"></script>
</body>


</html>