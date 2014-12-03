
<%@page import="com.ipartek.formacion.helloweb.util.Mensaje"%>
<%@page import="com.ipartek.formacion.helloweb.Constantes"%>
<%
	//	mostrar mensaje si existe
	if (null != request.getAttribute(Constantes.MSG_KEY)) {
		//out.print(request.getAttribute(Constantes.MSG_KEY));
		Mensaje msg = request.getAttribute(Constantes.MSG_KEY);%>
		<div class="<%=msg.geType()%>" role="alert"><%=msg.getMsg()%></div>	
	<%}
%>