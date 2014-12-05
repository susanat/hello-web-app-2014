<%@page import="com.ipartek.formacion.helloweb.bean.Mensaje"%>
<%@page import="com.ipartek.formacion.helloweb.Constantes"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:if test="${requestScope.msg != null }" >
<div class="alert alert-${requestScope.msg.type} role="alert">
	${requestScope.msg.msg}
	</div>
</c:if>

<%  
	
  	//	mostrar mensaje si existe
/*  	if ( null != request.getAttribute(Constantes.MSG_KEY)){
  		
  		Mensaje msg = (Mensaje)request.getAttribute(Constantes.MSG_KEY);
  		out.print( "<div class=\"alert alert-"+msg.getType()+"\" role=\"alert\" >");
  			out.print( msg.getMsg() );
  		out.print("</div>");
  	}*/		  	
 %>