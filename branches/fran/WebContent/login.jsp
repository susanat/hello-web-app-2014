<%@page import="java.util.ArrayList"%>
<%@page import="com.ipartek.formacion.helloweb.i18n.Idioma"%>
<%@page import="com.ipartek.formacion.helloweb.i18n.I18n"%>
<%@page import="com.ipartek.formacion.helloweb.constantes.Constantes"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="hello" uri="http://www.formacion.ipartek.com"%>
<%@ taglib prefix="util" uri="http://www.formacion.ipartek.com/tags/util"%>

<c:set var="language" value="<%=(session.getAttribute(Constantes.USER_SESSION_IDIOMA)!=null)?session.getAttribute(Constantes.USER_SESSION_IDIOMA):I18n.getBrowserLocale(request.getLocale()) %>" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="com.ipartek.formacion.helloweb.i18n.i18nmesages" /> 

<!DOCTYPE html>

<html lang="${language}">

<head>

  <meta charset="UTF-8">

  <title><fmt:message key="login.titulo"></fmt:message></title>
  
  <base href="<%=request.getContextPath()%>/">

  <link rel='stylesheet' href='http://codepen.io/assets/libs/fullpage/jquery-ui.css'>

  <link rel="stylesheet" href="css/style.css" media="screen" type="text/css" />

</head>

<body>
 <!-- 
 <hello:saludo/>
 <hello:saludo2/>
 <hello:saludo2 nombre="sss"/>
 -->
 
 <fmt:message key="ejem.parametros">
 	<fmt:param value="uno" />
 	<fmt:param value="dos" />
 </fmt:message>
 
 <div class="login-card">
 
  <h1><fmt:message key="login.titulo"></fmt:message></h1><br>
  <form action="<%=Constantes.PATH_LOGIN%>" method="post">
	<%@include file="/includes/alerts.jsp"%>
	<!-- 
	<select name="idioma">
	< % 
	 	String language = (String)pageContext.getAttribute("language");
		for ( Idioma idioma : Idioma.values() ) { 
		if ( language.equals(idioma.getLocale()) ){
			out.print("<option selected value="+idioma.getLocale()+" >"+idioma+"</option>");	
		} else {
			out.print("<option value="+idioma.getLocale()+" >"+idioma+"</option>");
		}				
	} % >				
	</select>
	 -->
	<%
		ArrayList<String> valores = new ArrayList<String>();
		ArrayList<String> texts = new ArrayList<String>();
		for ( Idioma idioma : Idioma.values() ) {
			valores.add(idioma.getLocale());
			texts.add(idioma.toString());
		}
	%>
	
	<util:selectoptions nombre="idioma" valores="<%=valores %>" selected="${(cookie.cidioma) == null? language:cookie.cidioma.value}" texts="<%=texts %>"/>
    <input type="text" name="<%=Constantes.PARAMETRO_USER%>" placeholder="<fmt:message key="login.form.usuario"></fmt:message>" value="${cookie.cuser.value}">
    <input type="password" name="<%=Constantes.PARAMETRO_PASS %>" placeholder="<fmt:message key="login.form.password"></fmt:message>" value="${cookie.cpass.value}">
    <input type="checkbox" name="<%=Constantes.PARAMETRO_RECUERDAME %>" id="check"
    ${(cookie.cuser == null)?"":"checked" }
    >
    <label for="check">Recuerdame</label>
    <input type="submit" name="login" class="login login-submit" value="<fmt:message key="login.form.submit"></fmt:message>">	
  </form>
</div>

  <script src='http://codepen.io/assets/libs/fullpage/jquery_and_jqueryui.js'></script>

</body>

</html>