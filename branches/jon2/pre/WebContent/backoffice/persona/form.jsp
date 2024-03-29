
<%@include file="../includes/head.jsp" %>
<%@include file="../includes/nav.jsp" %>

<%@page import="com.ipartek.formacion.helloweb.bean.Persona.Rol"%>
<%@page import="com.ipartek.formacion.helloweb.bean.Persona"%>
<%@page import="com.ipartek.formacion.helloweb.Constantes"%>
    
<%
		//recoger attributo de Persona		
		Persona p = (Persona)request.getAttribute(Constantes.ATT_PERSONA);
		//inicializar variables para el formulario		
		String buttonValue = "Crear";
		String op = Constantes.OP_UPDATE;
		boolean isNew = false;
		
		//nueva persona				
		if ( p == null ){
			p = new Persona("");
			isNew = true;
			op = Constantes.OP_CREATE;
		//modificar persona	
		}else{			
			buttonValue = "Modificar";
		}
%>    
    

<div class="col-lg-6">
	<form action="<%=request.getContextPath()+"/"+Constantes.CONTROLLER_PERSONA%>" method="post" role="form">
	
		<div class="form-group">			
			<input type="text" name="id" readonly value="<%=p.getId()%>" class="form-control">
		</div>	
		
		<div class="form-group">
			<label>Nombre</label>	
			<input type="text"    name="name" value="<%=p.getNombre()%>" class="form-control">
		</div>	
		
		<div class="form-group">			
			<label>Edad</label>
			<input type="number" name="edad" value="<%=p.getEdad()%>" class="form-control">
		</div>		
			
		<div class="form-group">
			<label>Rol</label>
			<select name="rol">
			<% for ( Rol rol : Rol.values() ) { 
				if ( rol == p.getRol() ){
					out.print("<option selected value="+rol+" >"+rol+"</option>");	
				}else{
					out.print("<option value="+rol+" >"+rol+"</option>");
				}				
			 } %>				
			</select>				
		</div>
			
		<div class="form-group">		
			<input type="hidden" name="<%=Constantes.OP_KEY%>" value="<%=op%>" class="form-control">
		</div>		
		
		<div class="form-group">
			<input type="submit" value="<%=buttonValue%>" class="btn btn-outline btn-primary">
		</div>		
	
	</form>
</div>	
	
	<% if ( !isNew) { %>	
		<form action="<%=request.getContextPath()+"/"+Constantes.CONTROLLER_PERSONA%>" method="post">
			<input type="hidden"  name="id"  value="<%=p.getId()%>">
			<input type="hidden" name="<%=Constantes.OP_KEY%>" value="<%=Constantes.OP_DELETE%>">
			<input type="submit" value="Eliminar" class="btn btn-outline btn-danger">	
		</form>
	<% } %>	

<%@include file="../includes/footer.jsp" %>











