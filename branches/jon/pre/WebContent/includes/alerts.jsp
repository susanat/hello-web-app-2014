<%@page import="com.ipartek.formacion.helloweb.Constantes"%>
<%  
  	//	mostrar mensaje si existe
  	if ( null != request.getAttribute(Constantes.MSG_KEY)){
  		%>
  		<div class="alert alert-success" role="alert"><%=request.getAttribute(Constantes.MSG_KEY)%></div>
  		
  		
 <% 		//out.print( request.getAttribute(Constantes.MSG_KEY) );
  	}		  	
 %>