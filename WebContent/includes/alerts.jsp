
<%@page import="com.ipartek.formacion.helloweb.bean.Mensaje"%>
<%@page import="com.ipartek.formacion.helloweb.Constantes"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		
		
		<c:if test="${requestScope.msg != null }" >
				<div class="alert alert-dismissible alert-<c:out value="${requestScope.msg.type}"/>" role="alert">
				     	${requestScope.msg.msg}
				     	<button type="button" class="close" data-dismiss="alert"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
				</div>
		
		</c:if>
 	
 	
 	
 	
	
 	
 	