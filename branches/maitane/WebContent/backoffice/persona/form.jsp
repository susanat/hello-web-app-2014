<%@page import="com.ipartek.formacion.helloweb.bean.Persona.Rol"%>
<%@include file="/includes/head.jsp" %>
<%@include file="/includes/nav.jsp" %>

<%@page import="com.ipartek.formacion.helloweb.bean.Persona"%>
<%@page import="com.ipartek.formacion.helloweb.Constantes"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%
	//recoger atributo persona
	Persona p=(Persona)request.getAttribute(Constantes.ATT_PERSONA);
    
    //inicializar variables para el formulario
    
    String buttonValue="Crear";
    String op=Constantes.OP_UPDATE;
    boolean isNew=false;
    
  //nueva persona
    if(p==null){
		//si la persona esta vacia, se crea una nueva
		p=new Persona("");
		isNew=true;
		op=Constantes.OP_CREATE;
	}
	//modificar persona
	else{
		
		buttonValue="Modificar";
	}
	%>


	
	

		
	<form action="<%=request.getContextPath()+"/"+Constantes.CONTROLLER_PERSONA%>" method="post">
	
		
		<div class="form-group">
		<label>Id</label>
		<input type="text" name="id" readonly value="<%=p.getId()%>" class="form-control"> 
		</div>
		
		<div class="form-group">
		<label>Nombre</label>
		<input type="text" name="name" value="<%=p.getNombre()%>"class="form-control">
		</div> 
		<div class="form-group">
		<label>Edad</label>
		<input type="numeric" name="edad" value="<%=p.getEdad()%>"class="form-control">
		</div>
		
		<div class="form-group"> 
		<label>Rol</label>
			<select name="rol">
			<%
				//Importa a rol todos los valores de Rol
				for (Rol rol:Rol.values()){
				
					if(rol==p.getRol()){
						out.print("<option selected value="+rol+">"+rol+" </option>");
					}
					else{
						out.print("<option value="+rol+ ">"+rol+" </option>");	
					}
				
				}
			%>
		
			</select>
		</div>
		
		<input type="hidden" name="<%=Constantes.OP_KEY %>" value="<%=op%>">
		<input type="submit" class="btn btn-primary" value="<%= buttonValue%>"> 
		
	</form>
	
	<% if(!isNew){ %>
	
	
	<form action="<%=request.getContextPath()+"/"+Constantes.CONTROLLER_PERSONA%>" method="post">
		<input type="hidden" name="id" disabled value="<%=p.getId()%>"> 		
		<input type="hidden" name="<%=Constantes.OP_KEY %>" value="<%=Constantes.OP_DELETE%>">
		<input type="submit" class="btn btn-danger" value="borrar"> 
	</form>
	<%}%>
<%@include file="/includes/footer.jsp" %>