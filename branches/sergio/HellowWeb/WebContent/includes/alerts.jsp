<%@page import="com.ipartek.formacion.helloweb.comun.Constantes"%>
<%
	String msj = "";
	
if ( null != request.getAttribute(Constantes.ATTR_ERROR)) {		
		if ((Boolean)request.getAttribute(Constantes.ATTR_ERROR) == true) {
			
			/*
			if((msj = request.getAttribute(Constantes.ATTR_ERROR_MSJ).toString()) == null) {
				msj = "Error desconocido";
			}
			*/
						
			%> <div class="alert alert-danger sombra" role="alert"><%= msj %></div><%			
		}
	}
%>