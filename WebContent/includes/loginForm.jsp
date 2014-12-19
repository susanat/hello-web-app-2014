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
<%

%>
  <form action="<%=Constante.SERVLET_LOGIN %>" method="post">
  	

    <input type="text" name="<%= Constante.PARAMETRO_USER %>" value="${cookie.c_user.value}" placeholder="<fmt:message key="login.form.username"></fmt:message>">
    <input type="password" name="<%=Constante.PARAMETRO_PASS %>" value="${cookie.c_pass.value}"  placeholder="<fmt:message key="login.form.password"></fmt:message>">
    <div class="form-control">
    <!-- 
    <select name="<%=Constante.PARAMETRO_IDIOMA%>">
    
  	<c:forEach items="<%=Idioma.getNames() %>" var="idioma">
  		<c:choose>
  		<c:when test="${fn:containsIgnoreCase(idioma.key, language)}">
  			<option selected="selected" value="${idioma.key}">${idioma.value}</option>
  		</c:when>
  		<c:otherwise>
  			<option value="${idioma.key}">${idioma.value}</option>
  		</c:otherwise>
  		</c:choose>
  	</c:forEach>
  	
  	</select>
  	 -->
  	</div>
  	<c:set var="c_idioma" scope="page" value="<%=I18n.getBrowserLocale(response.getLocale())  %>"/>
	<c:if test="${not empty cookie.c_idioma}">
			<c:set var="c_idioma" scope="page" value="${cookie.c_idioma.value}"/>
	</c:if>
  	<util:selectoroptions parameterName="<%=Constante.PARAMETRO_IDIOMA %>" 
  						opValues="<%=Idioma.getIndices() %>" 
  						opTexts="<%=Idioma.getValores() %>"
  						selectedValue="${c_idioma}"
  						/>
  	<div>
  	<label for="<%=Constante.PARAMETRO_RECUERDAME%>"><fmt:message key="login.form.recuerdame"></fmt:message></label>
  	<input <c:if test="${not empty cookie.c_user}"> 
  		checked="checked"
		</c:if>
	id="<%=Constante.PARAMETRO_RECUERDAME%>"type ="checkbox" name="<%=Constante.PARAMETRO_RECUERDAME %>"></div>
    <input type="submit" name="enviar" class="login login-submit" value="<fmt:message key="login.form.submit"></fmt:message>">
  </form>
    <div class="login-help">
    <a href="#">Register</a> • <a href="#">Forgot Password</a>
  </div>