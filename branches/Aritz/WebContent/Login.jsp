<%@page import="com.ipartek.formacion.helloweb.i18n.Idioma"%>
<%@page import="com.ipartek.formacion.helloweb.i18n.I18n"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@page import="com.ipartek.formacion.helloweb.Constantes"%>

<%@ taglib prefix="hello" uri="http://www.formacion.ipartek.com"%>
<%@ taglib prefix="util" uri="http://www.formacion.ipartek.com/tags/util"%>

<c:set var="language" value="<%= I18n.getBrowserLocale(request.getLocale())%>" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="<%= Constantes.PROPERTY_I18N%>" /> 
 

<!DOCTYPE html>
<html lang="${language}">
<head>
	<h1><%= request.getLocale() %></h1>

	<meta charset="UTF-8">

  	<title> <fmt:message key="login.titulo"></fmt:message> </title>

  	<link rel='stylesheet' href='http://codepen.io/assets/libs/fullpage/jquery-ui.css'>

    <link rel="stylesheet" href="css/style.css" media="screen" type="text/css" />

</head>

<body>	

<hello:saluda/>
<hello:saluda2/>


  <div class="login-card">
    <h1><fmt:message key="login.titulo"></fmt:message></h1><br>
  <form action="<%=Constantes.PATH_LOGIN %>" method="post">
  
  
  <!--
  <select name="< %= Constantes.PARAMETRO_IDIOMA%>" class="form-control">
    
		< %
			String languageBrowser = I18n.getBrowserLocale(request.getLocale());
			for(Idioma idioma: Idioma.values()){
				StringBuffer op= new StringBuffer();
				op.append("<option value='");				
				op.append(idioma.getLocale() + "'");
				if(languageBrowser.equals(idioma.getLocale())){
					op.append("selected");
				}		
				op.append(">");
				op.append(idioma);
				op.append("</option>");
				out.print(op.toString());				
			}
		%>			
	</select>  
	-->
		
	<util:SelectOptions opText="<%= Idioma.getTextosList() %>" 
						opValues="<%= Idioma.getLocaleList() %>" 						
						parameterName="<%= Constantes.PARAMETRO_IDIOMA %>" 
						selectedValue="<%= I18n.getBrowserLocale(request.getLocale()) %>"/>
						
	<br></br>
  
  	<%@include file="/includes/alert.jsp" %>
  
    <input type="text" name="<%=Constantes.PARAMETRO_USER %>" placeholder=<fmt:message key="login.form.usuario"></fmt:message>>
    <input type="password" name="<%=Constantes.PARAMETRO_PASS %>" placeholder=<fmt:message key="login.form.password"></fmt:message>>
    <input type="submit" name="login" class="login login-submit" value=<fmt:message key="login.form.submit"></fmt:message>>
  </form>

  <div class="login-help">
    <a href="#">Register</a> • <a href="#">Forgot Password</a>
  </div>
</div>

<!-- <div id="error"><img src="https://dl.dropboxusercontent.com/u/23299152/Delete-icon.png" /> Your caps-lock is on.</div> -->

  <script src='http://codepen.io/assets/libs/fullpage/jquery_and_jqueryui.js'></script>

</body>
</html>