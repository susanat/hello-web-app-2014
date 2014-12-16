<%@page import="java.util.List"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.lang.reflect.Array"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ipartek.formacion.helloweb.i18n.Idioma"%>
<%@page import="com.ipartek.formacion.helloweb.i18n.I18n"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>




<%@page import="com.ipartek.formacion.helloweb.Constantes"%>

<c:set var="language" value="<%= I18n.getBrowserLocale(request.getLocale()) %>" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="<%=Constantes.PROPERTY_I18N %>" />

<!DOCTYPE html>

<html lang="${language}">
 
<head>

  <meta charset="UTF-8">
  <base href="<%=request.getContextPath()+"/" %>">
  <title><fmt:message key="login.titulo" ></fmt:message></title>

  <link rel='stylesheet' href='http://codepen.io/assets/libs/fullpage/jquery-ui.css'>
  <link href="<%=Constantes.BACKOFFICE_FOLDER %>css/bootstrap.min.css" rel="stylesheet">
  <link rel="stylesheet" href="css/style.css" media="screen" type="text/css" />
   	
</head>

<body>
	<!-- Ejemplo de mensajes con parametros -->
	<fmt:message key="ejem.parametros">
		<fmt:param value="uno"/>
		<fmt:param value="dos"/>
	</fmt:message>
	<%@include file="includes/alerts.jsp" %>
	<!--END:  Ejemplo de mensajes con parametros -->
 	
	<!--  < %@ taglib prefix="hello" uri="http://www.formacion.ipartek.com"%>
	<hello:saluda/>	 
	
	<hello:saluda2/> 
	<hello:saluda2 nombre="pepe"/> 
	 -->
  <div class="login-card "> 	
  	
    <h1><fmt:message key="login.titulo" /></h1><br>
  	<form action="<%=Constantes.PATH_LOGIN %>" method="post"> 
	    <input type="text" name="<%=Constantes.PARAMETRO_USER %>" placeholder= <fmt:message key="login.form.usuario"/> >
	    <input type="password" name="<%=Constantes.PARAMETRO_PASS %>" placeholder=<fmt:message key="login.form.password" />>
	    
	    <input type="submit" name="login" class="login login-submit" 
	    value="<fmt:message key="login.form.submit"></fmt:message>">
	 	<%
	 		ArrayList<String> locales= new ArrayList<String>();
	 		ArrayList<String> idiomas= new ArrayList<String>();
	 		for(Idioma idi: Idioma.values()){
	 		   locales.add(idi.getLocale());
	 		   idiomas.add(idi.toString());
	 		}
	 		String browserLanguage = I18n.getBrowserLocale(request.getLocale());
	 	%>
	 	
	 	<%@ taglib prefix="util" uri="http://www.formacion.ipartek.com/tag"%>
	 	
	 	<util:selectoptions valor="<%=locales %>" 
	 						texts="<%=idiomas %>" 
	 						selectedvalue="<%=browserLanguage %>"
	 						parameterName="<%=Constantes.PARAMETRO_IDIOMA%>"
	 						className="form-control"
	 						 />
	 			
  		<!--  <select name="< % =Constantes.PARAMETRO_IDIOMA%>" class="form-control">
		    
		    	String languageBrowser = I18n.getBrowserLocale(request.getLocale());
		    	for ( Idioma idioma : Idioma.values() ){
		    		StringBuffer op = new StringBuffer();
		    		op.append("<option ");
		    		//is seleted
		    		if( languageBrowser.equals(idioma.getLocale()) ){
		    			op.append( " selected ");
		    		}
		    		op.append( "value='" +idioma.getLocale() + "' >");
		    		op.append(idioma);
		    		op.append("</option>");    	
		    		out.print(op.toString());    		
		    	}
		    
   		 </select>-->
	 		 
 	</form>

	<div class="login-help">
	    <a href="#">Register</a> • <a href="#">Forgot Password</a>
	</div> 
	<br>
	
	
</div>

<!-- <div id="error"><img src="https://dl.dropboxusercontent.com/u/23299152/Delete-icon.png" /> Your caps-lock is on.</div> -->

  <script src='http://codepen.io/assets/libs/fullpage/jquery_and_jqueryui.js'></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="<%=Constantes.BACKOFFICE_FOLDER %>js/bootstrap.min.js"></script>
</body>


</html>