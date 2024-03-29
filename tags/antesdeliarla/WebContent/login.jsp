<%@page import="java.util.Arrays"%>
<%@page import="com.ipartek.formacion.helloweb.i18n.Idioma"%>
<%@page import="com.ipartek.formacion.helloweb.i18n.I18n"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="util" uri="http://www.formacion.ipartek.com/tags/util"%>





<%@page import="com.ipartek.formacion.helloweb.Constantes"%>

<c:set var="language" value="<%= I18n.getBrowserLocale(request.getLocale())%>" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="<%=Constantes.PROPERTI_I18N%>" /> 

<!DOCTYPE html>
<html lang="${language}">

<head>

<h1>Locale: <%=request.getLocale()%> </h1>

  <meta charset="UTF-8">

  <title><fmt:message key="login.titulo"></fmt:message></title>

  <link rel='stylesheet' href='http://codepen.io/assets/libs/fullpage/jquery-ui.css'>

    <link rel="stylesheet" href="css/style.css" media="screen" type="text/css" />

</head>

<body>
   
   
  <div class="login-card">
    <h1><fmt:message key="login.titulo"  ></fmt:message></h1><br>
  <form action="<%=Constantes.PATH_LOGIN%>" method="post">
  
  	<%@include file="includes/alerts.jsp" %>
  
    <input type="text" name="<%=Constantes.PARAMETRO_USER%>" 
           placeholder="<fmt:message key="login.form.usuario"></fmt:message>"
    >
    
    <input type="password" name="<%=Constantes.PARAMETRO_PASS%>" 
    	   placeholder="<fmt:message key="login.form.password"></fmt:message>"
    >
    
    <util:selecoptions opValues="<%=Idioma.getLocalesList()%>" 
                       opTexts="<%=Idioma.getTextosList()%>"
                       selectedValue="<%=I18n.getBrowserLocale(request.getLocale())%>"
                       parameterName="<%=Constantes.PARAMETRO_IDIOMA%>"
                       
                       />
    			  
    <br>
    
    <input type="submit" name="login" class="login login-submit" 
           value="<fmt:message key="login.form.submit"></fmt:message>"
     >
     
     
     
  </form>

  <div class="login-help">
    <a href="#">Register</a> • <a href="#">Forgot Password</a>
  </div>
</div>

  <script src='http://codepen.io/assets/libs/fullpage/jquery_and_jqueryui.js'></script>

</body>

</html>