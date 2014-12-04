
<%@page import="com.ipartek.formacion.helloweb.bean.Mensaje"%>
<%@page import="com.ipartek.formacion.helloweb.Constantes"%>

<div class="alert alert-${requestScope.msg.type}" role="alert">
	${requestScope.msg.msg}
</div>	


