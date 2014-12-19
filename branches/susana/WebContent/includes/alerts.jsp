<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@page import="com.ipartek.formacion.helloweb.bean.Mensaje"%>
<%@page import="com.ipartek.formacion.helloweb.Constantes"%>

	<c:if test="${requestScope.msg != null}">
		<div class="alert alert-${requestScope.msg.type}" role="alert" >
			${requestScope.msg.msg}
		</div>
	</c:if>
	
