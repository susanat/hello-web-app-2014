
<%@page import="com.ipartek.formacion.helloweb.bean.Mensaje"%>
<%@page import="com.ipartek.formacion.helloweb.Constantes"%>
<%
	//	mostrar mensaje si existe
	if (null != request.getAttribute(Constantes.MSG_KEY)) {
		Mensaje msg = (Mensaje)request.getAttribute(Constantes.MSG_KEY);%>
		<div class="alert alert-<%=msg.geType()%>" role="alert"><%=msg.getMsg()%></div>	
	<%}
%>