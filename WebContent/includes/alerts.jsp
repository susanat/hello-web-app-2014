<%@page import="com.ipartek.formacion.helloweb.TipoMensaje"%>
<%@page import="com.ipartek.formacion.helloweb.bean.Mensaje"%>
<%@page import="com.ipartek.formacion.helloweb.Constantes"%>

	<%
 		//mostrar mensaje si existe
 		Mensaje msg= (Mensaje) request.getAttribute(Constantes.MSG_KEY);
 		if( msg != null ){
 		   TipoMensaje tipo= msg.getType();
 		  if(tipo == TipoMensaje.DANGER){
 		  %> 
 		     <div class="alert alert-danger" role="alert"><%=msg.getMsg() %></div>
 		  <%   
 		  }else if(tipo == TipoMensaje.INFO){
 		  %> 
 		     <div class="alert alert-info" role="alert"><%=msg.getMsg() %></div>
 		  <%       
 		  }else if(tipo == TipoMensaje.SUCCESS){
 		  %> 
 		     <div class="alert alert-success" role="alert"><%=msg.getMsg() %></div>
 		  <%       
 		  }else if(tipo == TipoMensaje.WARNING){
 		  %> 
 		     <div class="alert alert-warning" role="alert"><%=msg.getMsg() %></div>
 		  <%       
 		  }
 		  // out.print(request.getAttribute(Constantes.MSG_KEY));
 		}
 	%> 