<%@page import="com.ipartek.formacion.busredsociales.bean.Usuario"%>
<%@page import="java.util.List"%>
<%@page import="com.ipartek.formacion.busredsociales.comun.Constantes"%>

<%@include file="includes/head.jsp" %>

<h1>Listado Guardados</h1>

<%
	if(request.getAttribute(Constantes.ATTR_LISTADO) != null) {
		
		List<Usuario> list = (List<Usuario>) request.getAttribute(Constantes.ATTR_LISTADO);
		
		
		for(Usuario lst : list) {
			out.print("<hr> Este es el index: " + String.valueOf(lst.getId()) + "<br>");
			out.print("Nombre: " + lst.getUsername() + "<br>") ;
			out.print("Apellidos: " + lst.getApellidos());
			out.print("<br>");
			
			%>
			<form action="user" method="post">	
				<input type='hidden' value='E' name = 'action' />						
				<input type='hidden' value='<%=String.valueOf(lst.getId())%>' name="index" />		    	
		    	<input type='submit' name="submit" value='Eliminar' class='btn btn-outline btn-success' />
			</form>
			<%
			
			out.print("<br>");
						
		}
	}
%>

<hr>
<a href="index.jsp">Nueva búsqueda</a>

<%@include file="includes/footer.jsp" %>

