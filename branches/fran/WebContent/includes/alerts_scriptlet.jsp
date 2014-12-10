<%@page import="com.ipartek.formacion.helloweb.bean.Mensaje"%>
<%@page import="com.ipartek.formacion.helloweb.constantes.Constantes"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<c:if test="${requestScope.msg != null}">

<%
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

</c:if>