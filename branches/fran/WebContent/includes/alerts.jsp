<%@page import="com.ipartek.formacion.helloweb.bean.Mensaje"%>
<%@page import="com.ipartek.formacion.helloweb.constantes.Constantes"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<c:if test="${requestScope.msg != null}">

	<c:if test="${requestScope.msg.type == 'ERR' }"> 
		 <c:set var="clase" value="alert-danger"></c:set>
	 </c:if>

	<c:if test="${requestScope.msg.type == 'REG' }"> 
		 <c:set var="clase" value="alert-success"></c:set>
	 </c:if>
	 
	 <c:if test="${requestScope.msg.type == 'LOG' }"> 
		 <c:set var="clase" value="alert-info"></c:set>
	 </c:if>
<div class="row">
	<div class="col-lg-4">
		<div id="msg" class="alert ${clase}" role="alert">
			${requestScope.msg.msg}
		</div>
	</div>
</div>

</c:if>