
<%@page import="com.ipartek.formacion.helloweb.Constantes"%>
<%
	//	mostrar mensaje si existe
	if (null != request.getAttribute(Constantes.MSG_KEY)) {
		out.print(request.getAttribute(Constantes.MSG_KEY));
	}
%>