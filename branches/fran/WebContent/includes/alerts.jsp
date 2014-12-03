<%@page import="com.ipartek.formacion.helloweb.bean.Mensaje"%>
<%@page import="com.ipartek.formacion.helloweb.constantes.Constantes"%>
<%
	//Mostrar mensaje si existe
	if (null != request.getAttribute(Constantes.MSG_KEY)) {
		//out.print(request.getAttribute(Constantes.MSG_KEY));
		String clase = "alert-warning";
		Mensaje mensaje = (Mensaje)request.getAttribute(Constantes.MSG_KEY);
		if (mensaje.getType() == Mensaje.MsgType.ERR) {
			clase = "alert-danger";
		} else if (mensaje.getType() == Mensaje.MsgType.REG) {
			clase = "alert-success";
		} else if (mensaje.getType() == Mensaje.MsgType.LOG) {
			clase = "alert-info";
		} 
%>
		<div class="alert <%=clase%>" role="alert">
			<%=mensaje.getMsg()%>
		</div>
<%
	}
%>