<%@page errorPage="includes/error.jsp" %>

<%@include file="includes/head.jsp"%>
<%@include file="includes/nav.jsp"%>

<div class="row">
	<div class="col-lg-12">
		<fmt:message key="backoffice.index.bienvenida"></fmt:message>
		<br>
		<span>Admin: ${applicationScope.contAdmin}</span>
		<br>
		<span>User: ${applicationScope.contUser}</span>
		<br>
		<%=variableGlobal%>
	</div>
</div>

<%@include file="includes/footer.jsp"%>
    
