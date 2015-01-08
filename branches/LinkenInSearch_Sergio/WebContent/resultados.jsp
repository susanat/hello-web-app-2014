<%@page import="com.ipartek.formacion.busredsociales.bean.Usuario"%>
<%@page import="java.util.List"%>
<%@page import="com.ipartek.formacion.busredsociales.comun.Constantes"%>

<%@include file="includes/head.jsp" %>
<!-- Recorremos el listado para mostrarlo con expression language-->
<%
	if(request.getAttribute(Constantes.ATTR_LISTADO) != null) {
		
		List<Usuario> list = (List<Usuario>) request.getAttribute(Constantes.ATTR_LISTADO);
		int index = 0;
		
		for(Usuario lst : list) {
			out.print("<hr> Este es el index: " + index + "<br>");
			out.print("Nombre: " + lst.getUsername() + "<br>") ;
			out.print("Apellidos: " + lst.getApellidos());
			out.print("<br>");
			
			%>
			<form action="user" method="post">	
				<input type='hidden' value='A' name = 'action' />				
		    	<input type='hidden' value='<%=lst.getUsername()%>' name = "nombre" />
		    	<input type='hidden' value='<%=lst.getApellidos()%>' name = "apellidos" />
		    	<input type='submit' name="submit" value='Guardar' class='btn btn-outline btn-success' />
			</form>
			<%
			
			out.print("<br>");
			index ++;			
		}
	}
%>

<%@include file="includes/footer.jsp" %>

