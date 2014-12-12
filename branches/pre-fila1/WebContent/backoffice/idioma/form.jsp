<%@page import="com.ipartek.formacion.helloweb.bean.Idioma"%>


<%@include file="../includes/head.jsp" %>
<%@include file="../includes/nav.jsp" %>

<%@page import="com.ipartek.formacion.helloweb.bean.Persona.Rol"%>
<%@page import="com.ipartek.formacion.helloweb.bean.Persona"%>
<%@page import="com.ipartek.formacion.helloweb.Constantes"%>
    
<%
		//recoger attributo de Idioma	
		Idioma idm = (Idioma)request.getAttribute(Constantes.ATT_IDIOMA);
		//inicializar variables para el formulario		
		String buttonValue = "Añadir";
		String op = Constantes.OP_UPDATE;
		boolean isNew = false;
		
		//nueva idioma			
		if ( idm == null ){
			idm = new Idioma("");
			isNew = true;
			op = Constantes.OP_CREATE;
		//modificar persona	
		}else{			
			buttonValue = "Modificar";
		}
%>    
    

<div class="col-lg-6">
	<form action="<%=request.getContextPath()+"/"+Constantes.CONTROLLER_IDIOMA%>" method="post" role="form">
	
		<div class="form-group">			
			<input type="text" name="<%=Constantes.FORM_IDIOMA_ID%>" readonly value="<%=idm.getId()%>" class="form-control">
		</div>	
		
		<div class="form-group">
			<label>Locale</label>	
			<input type="text"    name="<%=Constantes.FORM_IDIOMA_LOCALE%>" value="<%=idm.getLocale()%>" class="form-control">
		</div>	
		
		<div class="form-group">			
			<label>Pais</label>
			<input type="text" name="<%=Constantes.FORM_IDIOMA_PAIS%>" value="<%=idm.getPais()%>" class="form-control">
		</div>	
		
		<div class="form-group">			
			<label>Lenguaje</label>
			<input type="text" name="<%=Constantes.FORM_IDIOMA_LENGUAJE%>" value="<%=idm.getLenguaje()%>" class="form-control">
		</div>	
		
			<div class="form-group">			
			<label>Texto</label>
			<input type="text" name="<%=Constantes.FORM_IDIOMA_TEXTO%>" value="<%=idm.getTexto()%>" class="form-control">
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
		<form action="<%=request.getContextPath()+"/"+Constantes.CONTROLLER_IDIOMA%>" method="post">
			<input type="hidden"  name="<%=Constantes.FORM_IDIOMA_ID%>"  value="<%=idm.getId()%>">
			<input type="hidden" name="<%=Constantes.OP_KEY%>" value="<%=Constantes.OP_DELETE%>">
			<input type="submit" value="Eliminar" class="btn btn-outline btn-danger">	
		</form>
	<% } %>	

<%@include file="../includes/footer.jsp" %>











