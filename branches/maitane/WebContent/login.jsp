<%@page import="java.util.ArrayList"%>
<%@page import="com.ipartek.formacion.helloweb.i18n.Idioma"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ taglib prefix="util" uri="http://www.formacion.ipartek.com/tag/util"%>

<%@page import="com.ipartek.formacion.helloweb.Constantes"%>
<%@page import="com.ipartek.formacion.helloweb.i18n.I18n"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<c:set var="language" value="<%=(session.getAttribute(Constantes.USER_LANGUAGE)!=null)?session.getAttribute(Constantes.USER_LANGUAGE): I18n.getBrowserLocale(request.getLocale())%>"/>
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="<%=Constantes.PROPERTY_I18N%>" /> 



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="${language}">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><fmt:message key="login.titulo"></fmt:message></title>
 <link rel='stylesheet' href='http://codepen.io/assets/libs/fullpage/jquery-ui.css'>

    <link rel="stylesheet" href="css/style.css" media="screen" type="text/css" />
</head>
<body>
<%@ taglib prefix="hello" uri="http://www.formacion.ipartek.com"%>

<hello:saluda/><!--  Saludo -->

<hello:saluda2/><!-- Saludo -->
<hello:saluda2 nombre="pepe"/><!-- Saludo Pepe -->


<div class="login-card">





   <h1><fmt:message key="login.titulo"></fmt:message></h1><br>
  <form action=<%=Constantes.PATH_LOGIN %> method="post">
  
  	<%@include file="includes/alerts.jsp" %>
  	
  


    <input type="text" name="<%=Constantes.PARAMETRO_USER%>" placeholder="<fmt:message key="login.form.usuario"></fmt:message>">
    <input type="password" name="<%=Constantes.PARAMETRO_PASS%>" placeholder="<fmt:message key="login.form.password"></fmt:message>">
    
    <util:SelectOptionsTag opValues="<%=Idioma.devuelvelistaLocale()%>" 
    					  opTexts="<%=Idioma.devuelveListaIdioma()%>"
    					  selectedValue="<%=I18n.getBrowserLocale(request.getLocale()) %>"
    					  parameterName="<%=Constantes.PARAMETRO_IDIOMA %>"
    					  className="form-control"/>
    					  
	<!-- <select name="idioma" class="form-control">
			<%/*
			String language=I18n.getBrowserLocale(request.getLocale());
				for (Idioma idioma:Idioma.values()){
				
					if(idioma.getLocale().equals(language)){
						out.print("<option selected value="+idioma.getLocale()+">"+idioma+" </option>");
					}
					else{
						out.print("<option value="+idioma.getLocale()+ ">"+idioma+" </option>");	
					}
				
				}*/
			%>
		
			</select>
			 --> 
    
    <input type="submit" name="login" class="login login-submit" value="login">
  </form>

  <div class="login-help">
    <a href="#">Register</a> • <a href="#">Forgot Password</a>
  </div>
</div>

<!-- <div id="error"><img src="https://dl.dropboxusercontent.com/u/23299152/Delete-icon.png" /> Your caps-lock is on.</div> -->

  <script src='http://codepen.io/assets/libs/fullpage/jquery_and_jqueryui.js'></script>
</body>
</html>