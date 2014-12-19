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

  <!-- Ruta Base para todas nuestras url relativas -->
  <base href="<%=request.getContextPath()+"/"%>">
	

  <meta charset="UTF-8">

  <title><fmt:message key="login.titulo"></fmt:message></title>

  <link rel='stylesheet' href='http://codepen.io/assets/libs/fullpage/jquery-ui.css'>

    <link rel="stylesheet" href="css/style.css" media="screen" type="text/css" />

</head>

<body>
   
<!-- Ejemplo de Mensajes con paramtros -->
   <fmt:message key="ejem.parametros">
   		<fmt:param value="uno" />
   		<fmt:param value="dos" />
   </fmt:message>
<!-- end:Ejemplo de Mensajes con paramtros -->   
   
  <div class="login-card">
    <h1><fmt:message key="login.titulo"  ></fmt:message></h1><br>
  <form action="<%=Constantes.PATH_LOGIN%>" method="post">
  
  	<%@include file="includes/alerts.jsp" %>
  
    <input type="text" name="<%=Constantes.PARAMETRO_USER%>" 
           placeholder="<fmt:message key="login.form.usuario"></fmt:message>"
           value="${cookie.cuser.value}"
    >
    
    <input type="password" name="<%=Constantes.PARAMETRO_PASS%>" 
    	   placeholder="<fmt:message key="login.form.password"></fmt:message>"
    	   value="${cookie.cpass.value}"
    >
    
    
    <% // determinar el idioma para el select option
    	
    	// primero lo buscamos en las cookies del usuario    	
    	String idioma = null;
    	Cookie cookies[] = request.getCookies();    	
    	for ( int i=0; i < cookies.length; i++){
    		Cookie cookie  = cookies[i];
    		if ( Constantes.COOKIE_USER_IDIOM.equals( cookie.getName())){
    			idioma =  cookie.getValue();
    		}
    	}
    	// Si no encuentra: obtenerlo del navgeador
    	if ( idioma == null ){
    		idioma = I18n.getBrowserLocale(request.getLocale());
    	}
    	
    
    %>    
    
	<util:selecoptions opValues="<%=Idioma.getLocalesList()%>" 
	                   opTexts="<%=Idioma.getTextosList()%>"
	                   selectedValue="<%=idioma%>"
	                   parameterName="<%=Constantes.PARAMETRO_IDIOMA%>"
	 />
    			  
    <br>
    <br>
      
    <input type="checkbox" 
           name="<%=Constantes.PARAMETRO_RECUERDAME%>" 
           id="<%=Constantes.PARAMETRO_RECUERDAME%>"
    	   ${(cookie.cuser==null) ? "" : "checked"}    
    >
    
    <label for="<%=Constantes.PARAMETRO_RECUERDAME%>">Recuerdame</label> 
     
    
    <br>
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