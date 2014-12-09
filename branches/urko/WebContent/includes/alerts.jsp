<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="com.ipartek.formacion.helloworld.util.Constante"%>
<%
	if( null != request.getAttribute(Constante.MSG_KEY)){
		    out.print("<div>"+request.getAttribute(Constante.MSG_KEY)+"</div>");
		}
%>
	<c:if test="${requestScope.msg != null}">
		<div class="alert alert-${request.msg.type} }" role="alert">
			${requestScope.msg}
		</div>
		
	</c:if>