 <%@page import="com.ipartek.formacion.helloweb.bean.Message"%>
<%@page import="com.ipartek.formacion.helloweb.Constantes"%>
<%	
  		//mostrar mensaje si existe 
        if(request.getAttribute(Constantes.ATT_MENSAJE) != null){
           Message msg =(Message)request.getAttribute(Constantes.ATT_MENSAJE);
           %>
           	   <br>
           	  <div class="alert <%=msg.getType() %>">
  				<button type="button" class="close" data-dismiss="alert"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
 					<%=msg.getMsg() %>
			  </div>
           <%
        }
  
  %>
