

<%@page import="com.ipartek.formacion.helloweb.bean.Role"%>
<%@page import="com.ipartek.formacion.helloweb.bean.Persona"%>
    
<%@include file="../includes/head.jsp" %>
<%@include file="../includes/nav.jsp" %>
<%@include file="/includes/alert.jsp" %>

<%
			Role r1 = (Role)request.getAttribute(Constantes.ATT_ROLE);
			String cabecera = "Crear nuevo rol";
			String buttonValue = "Crear";
			int op = Constantes.OP_UPDATE;
			boolean isNew = false;
			
			//nueva persona
			if(r1 == null){
			    r1 = new Role("");
			    isNew = true;
			    op = Constantes.OP_INSERT;
			  
			}
			//modificar persona
			else if(Constantes.LETRERO_BORRAR.equals(request.getParameter("accion"))){
			    cabecera = "Borrar " + r1.getNombre(); 
			    buttonValue = "Modificar";
			}
			else{
			    cabecera = "Modificar " + r1.getNombre();
			    buttonValue = "Modificar";
			}
		%>
		<h1><%=cabecera %> </h1>
		
		
		
		<form action="<%=request.getContextPath() + "/" + Constantes.CONTROLLER_ROLE %>" method="post" role="form">
			<%
				if(!isNew){
			%>
			<div class="form-group">
				<label>Id</label>
				<input type="text" name="id" readonly="readonly" value="<%=r1.getId()%>" class="form-control">
			</div>
			
			<%} %>
			
			<div class="form-group">
				<label>Nombre</label>
				<input type="text" name="name" value="<%=r1.getNombre()%>" class="form-control">
			</div>
			
			<div class="form-group">
				<label>Descripcion</label>
				<input type="text" name="descripcion" value="<%=r1.getDescripcion()%>" class="form-control">
			</div>
			
					
			<input type="hidden" name="op" value=<%= op %>>
			<br>
			<%
				if(buttonValue.equals("Modificar") || buttonValue.equals("Crear")){
				    if(!Constantes.LETRERO_BORRAR.equals(request.getParameter("accion"))){
			%>
			<input type="submit" value=<%=buttonValue %> class="btn btn-primary">
			<br>
			<%
				
				    }
				}
			%>
		</form>
		<!-- TODO: Formulario eliminar -->
		
		<%
			if(!isNew && Constantes.LETRERO_BORRAR.equals(request.getParameter("accion"))){
		%>
		<form action="<%=request.getContextPath() + "/" + Constantes.CONTROLLER_ROLE %>" method="post">
			<input type="hidden" name="id" value="<%=r1.getId() %>">
			<input type="hidden" name=<%=Constantes.OP_CRUD %> value=<%=Constantes.OP_DELETE %>>
			<input type="submit" value="Eliminar" class="btn btn-danger">
		</form>
		<%} %>
		<br>
		<a href="<%=request.getContextPath() + "/" + Constantes.CONTROLLER_ROLE %>" class="btn btn-primary"><i class="fa fa-arrow-left fa-fw"></i>Volver</a>
<%@include file="../includes/footer.jsp" %>