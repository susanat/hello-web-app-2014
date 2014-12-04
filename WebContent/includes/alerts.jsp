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
 		     <div class="alert alert-danger alert-dismissible" role="alert">
 		     	<button type="button" class="close" data-dismiss="alert"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
 		     	<%=msg.getMsg() %>
 		     </div>
 		  <%   
 		  }else if(tipo == TipoMensaje.INFO){
 		  %> 
 		     <div class="alert alert-info alert-dismissible" role="alert">
 		     	<button type="button" class="close" data-dismiss="alert"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
 		     	<%=msg.getMsg() %>
 		     </div>
 		  <%       
 		  }else if(tipo == TipoMensaje.SUCCESS){
 		  %> 
 		     <div class="alert alert-success alert-dismissible" role="alert">
 		     	<button type="button" class="close" data-dismiss="alert"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
 		     	<%=msg.getMsg() %>
 		     </div>
 		  <%       
 		  }else if(tipo == TipoMensaje.WARNING){
 		  %> 
 		     <div class="alert alert-warning alert-dismissible" role="alert">
 		     	<button type="button" class="close" data-dismiss="alert"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
 		     	<%=msg.getMsg() %>
 		     </div>
 		  <%       
 		  }
 		  // out.print(request.getAttribute(Constantes.MSG_KEY));
 		}
 	%> 