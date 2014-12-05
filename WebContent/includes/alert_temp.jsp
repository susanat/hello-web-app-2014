<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<%@page import="com.ipartek.formacion.helloweb.bean.Mensaje"%>
<%@page import="com.ipartek.formacion.helloweb.Constantes" %>


<c:if test="${requestScope.msg!=null}" >
	<div class="alert alert-${requestScope.msg.type}" role="alert">
		${requestScope.msg.msg}
	</div> 

</c:if>


<%
	//mostrar mensaje si existe
	if(null!=request.getAttribute(Constantes.MSG_KEY)){
		
		Mensaje msg = (Mensaje)request.getAttribute(Constantes.MSG_KEY);
		
		%>	
			
		<div class="alert alert-<%= msg.getType() %>" role="alert"><%= msg.getMsg() %></div>
		
		
	
		<%
		//out.print(request.getAttribute(Constantes.MSG_KEY));
	}
  	
%>



