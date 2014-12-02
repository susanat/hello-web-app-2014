 <%@page import="com.ipartek.formacion.helloweb.Constantes"%>
<%	
  		//mostrar mensaje si existe 
        if(request.getAttribute(Constantes.MSG_KEY) != null){
            out.print(request.getAttribute(Constantes.MSG_KEY));
        }
  
  %>