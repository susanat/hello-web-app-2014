<%@page import="com.ipartek.formacion.helloweb.bean.Persona.Roll"%>
<%@page import="com.ipartek.formacion.helloweb.bean.Persona"%>
<%@page import="com.ipartek.formacion.helloweb.Constantes"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
 <%@include file="/backoffice/includes/head.jsp" %>
<%@include file="/backoffice/includes/nav.jsp" %>   
    
    <%	
    
	Persona p = (Persona)request.getAttribute(Constantes.ATT_PERSONA);	
    
    String buttonValue= "Crear";
    String op = Constantes.OP_UPDATE;
    boolean isnew=false;
    
    //nueva persona    
	if(p==null){
		p = new Persona("");
		isnew=true;
		op = Constantes.OP_CREATE;
	}
    //modificar persona
	else{
		
		buttonValue="modificar";
		
	}
	
	%>
       
	<div class="col-lg-6">
		<form action="<%= Constantes.CONTROLLER_PERSONA %>" method="post">
			<div class="form-group">
				<input type="text" name="id" readonly class="form-control" value="<%= p.getId() %>">
			</div>
		
			<div class="form-group">
				<label>Nombre</label>
				<input type="text" name="nombre" class="form-control" value="<%= p.getNombre() %>">
			</div>
			<div class="form-group">
				<label>Edad</label>
				<input type="number" name="edad" class="form-control" value="<%= p.getEdad() %>">
			</div>
			<div class="form-group">
			<label>Roll</label>
				<select>
				<% for (Roll roll :Roll.values()){ 
					if (roll==p.getRoll()){				
					%>
						<option value="<%= roll %>" selected><%= roll %></option>
					<%
					}else{
					%>
					<option value="<%= roll %>"><%= roll %></option>
					<%
					}
				 } 
				 
				 %>	
				</select>				
			</div>
			
			<input type="hidden"name="<%= Constantes.OP_KEY %>" value="<%= op %>">
			<input type="submit" value="<%= buttonValue %>">
	
		</form>
	</div>
	
	<% 
		if (!isnew){ 
	%>		
			<div class="col-lg-6">
				<form action="<%= Constantes.CONTROLLER_PERSONA %>" method="post">
					<input type="hidden"name="id" value="<%= p.getId() %>">
					<input type="hidden"name="<%= Constantes.OP_KEY %>" value="<%=Constantes.OP_DELETE %>">
					<input type="submit" value="Eliminar">	
				</form>
			</div>
	<% 
		} 
	%>
	
	
<%@include file="/backoffice/includes/footer.jsp" %>