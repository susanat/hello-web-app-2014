<%@page import="com.ipartek.formacion.helloweb.bean.Mensaje"%>
<%@page import="com.ipartek.formacion.helloweb.i18n.I18n"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page import="com.ipartek.formacion.helloweb.util.Constante"%>
<%=session.getAttribute(Constante.LANG_SESSION)  %>
<c:set var="language" value="<%=session.getAttribute(Constante.LANG_SESSION)  %>" />
<fmt:setLocale value="${languaje}"/>
<fmt:setBundle basename="<%=Constante.PROPERTI_I18N %>"/>
<c:set var="mensaje" value="<%=request.getAttribute(Constante.MSG_KEY)  %>" />
<%
	if( null != request.getAttribute(Constante.MSG_KEY)){
		   // out.print("<div>"+request.getAttribute(Constante.MSG_KEY)+"</div>");
		}
%>
	<c:if test="${mensaje != null}">
		<div class="alert alert-${mensaje.type} }" role="alert">
			<fmt:message key="${mensaje.msg }"></fmt:message>
		</div>
		
	</c:if>