<%@include file="../includes/head.jsp" %>
<%@include file="../includes/nav.jsp" %>
       

	<%@page import="com.ipartek.formacion.helloweb.Rol"%>
	<%@page import="com.ipartek.formacion.helloweb.bean.Persona"%>
	<%@page import="com.ipartek.formacion.helloweb.Constantes"%>
	
	<%
		//Crear Persona nueva
		Persona per =(Persona) request.getAttribute(Constantes.ATT_PERSONA);
		//inicializar variables para el formulario
		String cabecera= "Crear nueva Persona";
		String buttonValue = "Crear";
		boolean isNew = false;
		String op = Constantes.OP_UPDATE;
		
		//nueva persona
		if( per == null ){
		    per = new Persona("");
		    isNew= true;
		    op=Constantes.OP_CREATE;
		//modificar persona
		}else{
		    cabecera = "Modificar " + per.getNombre();
		    buttonValue = "Modificar";
		}
	%>
	<p class="top-margin">
		<a href="<%=request.getContextPath()+"/"+Constantes.CONTROLLER_PERSONA %>" class="btn btn-default btn-ms" title="volver" >
			<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span> Volver
		</a>
	</p>
	<div class="panel panel-primary ">
	  <div class="panel-heading">
		 <h1 class="panel-title"> <%=cabecera %></h1> 
	  </div>
	  <div class="panel-body">

		<form action="<%= request.getContextPath()+"/"+ Constantes.CONTROLLER_PERSONA %>" method="post">
			<div class="form-group">
				
				<input type="text" name="id" readonly value="<%= per.getId() %>" class="form-control">
			</div>
			<div class="form-group">
				<label>Nombre</label>
				<input type="text" name="nombre" value="<%= per.getNombre()%>" class="form-control">
			</div>
			<div class="form-group">
				<label>Edad</label>
				<input type="number" name="edad" value="<%= per.getEdad()%>" min="0" class="form-control">
			</div>
			
			<div class="form-group">
			
				<label>Rol</label>
				<select name="rol">
					<%
						for(Rol rol: Rol.values()){ 
							if(rol == per.getRol()){
							    out.print(" <option selected value="+rol+">"+rol+"</option>");
							}else{
							    out.print(" <option value="+rol+">"+rol+"</option>");
							}
						%>					
					<%  }
					%>
				</select>
				
			</div>
			<input type="hidden" name="<%=Constantes.OP_KEY %>" value="<%= op %>" >			
			
			<div class="form-group">
				<input type="submit" value="<%=buttonValue %>" class="btn btn-primary btn-outline btn-xs">
			</div>
		</form>
		
        </div>
		<% if (!isNew){ %>
		    <form action="<%=request.getContextPath()+"/"+ Constantes.CONTROLLER_PERSONA %>" method="post">
			
			<input type="hidden" name="id" value="<%= per.getId() %>">
			<input type="hidden" name="<%=Constantes.OP_KEY %>" value="<%=Constantes.OP_DELETE%>">
			<div class="form-group">
				<input type="submit" value="Eliminar" class="btn btn-danger btn-outline btn-xs">
			</div>
		</form>
		<%} %>	 
	
	</div>
	</div><!-- Fin panel content -->
<%@include file="../includes/footer.jsp" %>   
