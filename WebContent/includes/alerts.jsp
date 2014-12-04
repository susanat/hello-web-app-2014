<%@page import="com.ipartek.formacion.helloweb.bean.Message"%>
<%@page import="com.ipartek.formacion.helloweb.Constantes"%>

<div class="alert alert-${requestScope.msg.type}" role="alert" >
  		<!--  Forma abreviada de recoger el error-->
		${requestScope.msg.msg}
</div>
<%
  	
		
	
//	mostrar mensaje si existe
	/*  	if ( null != request.getAttribute(Constantes.MSG_KEY)){
  		
  		Message msg = (Message)request.getAttribute(Constantes.MSG_KEY);
  		out.print( "<div class=\"alert alert-"+msg.getType()+"\" role=\"alert\" >");
  		out.print( msg.getMsg() );
  		out.print("</div>");
  	}	*/
  
  	%>