<%@page import="com.ipartek.formacion.helloweb.i18n.Idioma"%>
<%@page import="com.ipartek.formacion.helloweb.i18n.I18n"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>





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

   
   
   
   <%@ taglib prefix="hello" uri="http://www.formacion.ipartek.com"%>
   <hello:saluda/>
   
   <hello:saluda2 /> <!--  Saludo -->
   <hello:saluda2 nombre="pepe"/> <!--  Saludo Pepe -->
   
   
   
   
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
    
    
    <select name="<%=Constantes.PARAMETRO_IDIOMA%>" class="form-control">
    <%
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
    %>
    </select>
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