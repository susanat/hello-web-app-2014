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
	<%@include file="/includes/alerts.jsp" %>
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
			
			<input type="text" name="id" readonly value="<%= per.getId() %>">
			<br>
			<input type="text" name="nombre" value="<%= per.getNombre()%>">
			<br>
			<input type="number" name="edad" value="<%= per.getEdad()%>">
			<br>
			<input type="radio" name="rol" value="<%= Rol.ADMINISTRADOR %>" <%= (per.getRol()==Rol.ADMINISTRADOR)?"checked":"false"%> ><%= Rol.ADMINISTRADOR %>
			<input type="radio" name="rol" value="<%= Rol.USUARIO %>"  <%= (per.getRol()==Rol.USUARIO)?"checked":"false"%> ><%= Rol.USUARIO %>

			<br>
			<input type="hidden" name="<%=Constantes.OP_KEY %>" value="<%= op %>">
			
			<input type="submit" value="<%=buttonValue %>">
		</form>
		
        </div>
		<% if (!isNew){ %>
		    <form action="<%=request.getContextPath()+"/"+ Constantes.CONTROLLER_PERSONA %>" method="post">
			
			<input type="hidden" name="id" value="<%= per.getId() %>">
			<input type="hidden" name="<%=Constantes.OP_KEY %>" value="<%=Constantes.OP_DELETE%>">
			<input type="submit" value="Eliminar">
		</form>
		<%} %>	 
	
	</div>
	</div><!-- Fin panel content -->
<%@include file="../includes/footer.jsp" %>   
