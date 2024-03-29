			<%@page import="com.ipartek.formacion.helloweb.bean.Calificacion"%>

<%@include file="../includes/head.jsp" %>
<%@include file="../includes/nav.jsp" %>

<%@page import="com.ipartek.formacion.helloweb.Constantes"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%
	//recoger atributo persona
	Calificacion c=(Calificacion)request.getAttribute(Constantes.ATT_CALIFICACION);
    
    //inicializar variables para el formulario
    
    String buttonValue="boton.crear";
    String op=Constantes.OP_UPDATE;
    boolean isNew=false;
    
  //nueva persona
    if(c==null){
		//si la calificacion esta vacia, se crea una nueva
		c=new Calificacion();
		isNew=true;
		op=Constantes.OP_CREATE;
	}
	//modificar persona
	else{
		
		buttonValue="boton.modificar";
	}
	%>	

<div class="col-lg-6">
	<form action="<%=request.getContextPath()+"/"+Constantes.CONTROLLER_CALIFICACION%>" method="post">
	
		
		<div class="form-group">

		<input type="text" name="id" readonly value="<%=c.getId()%>" class="form-control"> 
		</div>
		
		<div class="form-group">
		<label><fmt:message key="calificacion.nota"></fmt:message></label>
		<input type="text" name="nota" value="<%=c.getClave()%>"class="form-control">
		</div> 
		<div class="form-group">
		<label><fmt:message key="calificacion.descripcion"></fmt:message></label>
		<% if(!isNew){%>
			<input type="text" name="descripcion" value="<%=c.getDescripcion()%>"class="form-control">
			
		<%} 
		
		else{%>
		<input type="text" name="descripcion" value=""class="form-control">
		<%} %>
		</div>
		
	
		
		<input type="hidden" name="<%=Constantes.OP_KEY %>" value="<%=op%>">
		<input type="submit" class="btn btn-outline btn-primary" value=<fmt:message key="<%=buttonValue %>"></fmt:message>> 
		
	</form>
	</div>
	<% if(!isNew){ %>
	
	
	<form action="<%=request.getContextPath()+"/"+Constantes.CONTROLLER_CALIFICACION%>" method="post">
		<input type="hidden" name="id" value="<%=c.getId()%>"> 		
		<input type="hidden" name="<%=Constantes.OP_KEY %>" value="<%=Constantes.OP_DELETE%>">
		<input type="submit" class="btn btn-outline btn-danger" value=<fmt:message key="boton.eliminar"></fmt:message>> 
	</form>
	<%}%>
<%@include file="../includes/footer.jsp" %>
