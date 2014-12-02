<%@page import="com.ipartek.formacion.helloworld.util.Constante"%>
<%
	if( null != request.getAttribute(Constante.MSG_KEY)){
		    out.print(request.getAttribute(Constante.MSG_KEY));
		}
%>