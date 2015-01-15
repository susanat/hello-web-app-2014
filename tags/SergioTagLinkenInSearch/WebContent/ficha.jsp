<%@page import="com.ipartek.formacion.busredsociales.comun.Constantes"%>
<%@page import="com.ipartek.formacion.busredsociales.bean.Usuario"%>
<%@page import="java.util.List"%>
<%


	String showid = request.getParameter("showid");
	String showButtonDelete = request.getParameter("showButtonDelete");
	String showButtonSave = request.getParameter("showButtonSave");




	out.print("<hr>");

	


	if(request.getAttribute(Constantes.ATTR_LISTADO) != null) {
		
		List<Usuario> list = (List<Usuario>) request.getAttribute(Constantes.ATTR_LISTADO);
		int index = 0;
		
		for(Usuario lst : list) {
			
			if("1".equals(showid)) {
				
				%>				
					<div class="row">
						<span>Este es el index <%=index %></span>
					</div>				
				<%
				
			}
			
			
				%>				
					<div class="row">
						<span>Nombre: <%=lst.getUsername() %></span>
					</div>
					
					<div class="row">
						<span>Apellidos: <%=lst.getApellidos() %></span>
					</div>							
				<%
			
			
			out.print("Nombre: " + lst.getUsername() + "<br>") ;
			out.print("Apellidos: " + lst.getApellidos());
			out.print("<br>");
			out.print("<img src='" + lst.getPhoto() + "' class='photo' height='60' width='60' alt='" + lst.getUsername() + " " + lst.getApellidos() + "'>");
			out.print("<br>");
			
			
			
			%>
			<div class="row">
			<%
				if("1".equals(showButtonSave)) {
					%>			
					<form action="user" method="post">	
						<input type='hidden' value='A' name = 'action' />				
				    	<input type='hidden' value='<%=lst.getUsername()%>' name = "nombre" />
				    	<input type='hidden' value='<%=lst.getApellidos()%>' name = "apellidos" />
				    	<input type='hidden' value='<%=lst.getPhoto()%>' name = "photo" />
				    	<input type='submit' name="submit" value='Guardar' class='btn btn-outline btn-success' />
					</form>
					<%
				}
				
				if("1".equals(showButtonDelete)) {
					%>			
					<form action="user" method="post">	
						<input type='hidden' value='E' name = 'action' />						
						<input type='hidden' value='<%=String.valueOf(lst.getId())%>' name="index" />		    	
				    	<input type='submit' name="submit" value='Eliminar' class='btn btn-outline btn-success' />
					</form>
					<%
				}
			%>
			</div>
			<%
			
			
			
			out.print("<br>");
			index ++;	
			
			out.print("<hr>");
			
			
			
		}
	}
%>