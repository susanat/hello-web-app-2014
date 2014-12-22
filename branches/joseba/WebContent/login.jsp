<%@page import="java.util.Arrays"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.ipartek.formacion.helloweb.i18n.Idioma"%>
<%@page import="com.ipartek.formacion.helloweb.i18n.I18n"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="hello" uri="http://www.formacion.ipartek.com"%>
<%@ taglib prefix="util" uri="http://www.formacion.ipartek.com/tags/util"%>
<%@page import="com.ipartek.formacion.helloweb.Constantes"%>


<c:set var="language" value="<%= I18n.getBrowserLocale(request.getLocale())%>" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="<%=Constantes.PROPERTY_I18N %>" /> 
<!DOCTYPE html>

<html lang="${language}">

<head>

 <base href="<%=request.getContextPath()+ "/"%>">
  <meta charset="UTF-8">
 
  <title><fmt:message key="login.titulo"></fmt:message></title>

  <link rel='stylesheet' href='http://codepen.io/assets/libs/fullpage/jquery-ui.css'>
  <link href="<%=request.getContextPath() + "/" + Constantes.JSP_BACKOFFICE %>/css/bootstrap.min.css" rel="stylesheet">

    <link rel="stylesheet" href="css/style.css" media="screen" type="text/css" />

</head>

<body>

	<%
	 List<Idioma> idiomas = new ArrayList<Idioma>();
	 List<String> opvalues = new ArrayList<String>();
	 List<String> texts = new ArrayList<String>();
	String selectedValue = I18n.getBrowserLocale(request.getLocale());
	 idiomas = (Arrays.asList(Idioma.values()));
	 for(int i = 0; i< idiomas.size(); i++){
	   opvalues.add(i, idiomas.get(i).getLocale());
	   texts.add(i, idiomas.get(i).toString());
	 }
	 
	 
		
	%>

	
	<fmt:message key="ejem.parametros">
		<fmt:param value="uno"/>
		<fmt:param value="dos"/>
	</fmt:message>
	<hello:saluda/>
	<hello:saluda2 nombre="Joseba"/>
	<util:selectoptions opvalues="<%=opvalues%>" texts="<%=texts%>" selectedvalue="<%=selectedValue %>"/>
	
	
	
	
	
  <div class="login-card">
    <h1><fmt:message key="login.titulo"></fmt:message></h1><br>
  <form action="<%=Constantes.PATH_LOGIN %>" method="post">
 	<%@include file="include/alerts.jsp" %>
    <input type="text" name="<%=Constantes.PARAMETRO_USER %>" placeholder=<fmt:message key="login.form.usuario"></fmt:message>
    value ="${cookie.cuser.value }">
    <input type="password" name="<%=Constantes.PARAMETRO_PASS %>" placeholder=<fmt:message key="login.form.password"></fmt:message>
     value ="${cookie.cpass.value }">
     
     
     <%
     	String idioma = null;
     	Cookie cookies[] = request.getCookies();
     	for(int i = 0; i < cookies.length; i++){
     	    Cookie cookie = cookies[i];
     	   if( Constantes.COOKIE_USER_LANG.equals(cookie.getName())){
     	       idioma = cookie.getValue();
     	   }
     	}
     	if(idioma == null){
     	    idioma = I18n.getBrowserLocale(request.getLocale());
     	}
     
     %>
    <select name="<%=Constantes.PARAMETRO_IDIOMA %>" class="form-control">
  		<%
  			for(Idioma id: Idioma.values()){
  			  %>
  			  <c:set var="idiomaLocale" value="<%=id.getLocale()%>"/>
  			  <c:choose>
  			   <c:when test="<%=idioma.equals(id.getLocale()) %>">
                <option value=<%=id.getLocale()%> selected="selected"><%=id.toString()%></option>
              </c:when>
               <c:otherwise>
               <option value=<%=id.getLocale()%>><%=id.toString()%></option>
               </c:otherwise>
  			  	</c:choose>
  			  <%   
  			}
  		%>
  	</select>
  	<br>
  	<input type="checkbox" name="<%=Constantes.PARAMETRO_CHECK %>" ${(cookie.cuser==null) ? "" : "checked"}>
  	<label for="<%=Constantes.PARAMETRO_CHECK%>">Recuerdame</label>
  	<br>
  	<br>
    <input type="submit" name="login" class="login login-submit" value=<fmt:message key="login.form.boton"></fmt:message>>
 
  </form>


  
</div>

 

  <script src='http://codepen.io/assets/libs/fullpage/jquery_and_jqueryui.js'></script>
  <script src="<%=request.getContextPath() + "/" + Constantes.JSP_BACKOFFICE %>js/bootstrap.min.js"></script>

</body>

</html>