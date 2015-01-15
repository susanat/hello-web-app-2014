<%@page import="java.util.List"%>
<%@page import="com.ipartek.formacion.busredsociales.bean.Usuario"%>
<%@include file="includes/head.jsp" %>
	

<% 

	//logica
	Usuario obj = null;
	
	
	if(request.getAttribute(Constantes.ATTR_LISTADO) != null) {
		
		List<Usuario> list = (List<Usuario>) request.getAttribute(Constantes.ATTR_LISTADO);
		if(list.size() == 1) {
			obj = list.get(0);
		} else {
			out.println("Algo malo ha pasado, que el ide no existe o que hay más de uno.");
		}
		
	} else {
		out.println("Algo malo ha pasado, no me ha llegado el listado.");
		obj = new Usuario(0, "mal", "mal", "mal");
	}
	
	
	if (obj == null) {
		out.println("Algo malo ha pasado, esto no puede llegar a null.");
	}

%>



<div class="jumbotron row text-center">

	<div class="col-md-4 col-md-offset-4">
		<div class="panel panel-primary">
	
			<form class="form-horizontal" role="form" method="post" id="frm_search" action="user">
				<fieldset>
									
					<div class="panel-heading">						
						<%
							out.print("<img src='" + obj.getPhoto() + "' class='photo' height='60' width='60' alt='" + obj.getUsername() + " " + obj.getApellidos() + "'>");
						%>
					</div>
					
					<input type='hidden' value='U' name = 'action' />				
				    	<input type='hidden' value='<%=obj.getId()%>' name = "index" />
					
					<div class="panel-body">
					
						<!-- Text input-->
						<div class="control-group">
						  <label class="control-label" for="nombre">Nombre</label>
						  <div class="controls">
						    <input id="nombre" name="nombre" placeholder="" class="input-xlarge" type="text"
						    value="<%= obj.getUsername()%>">	    
						  </div>
						</div>
						
						<!-- Text input-->
						<div class="control-group">
						  <label class="control-label" for="apellidos">Apellidos</label>
						  <div class="controls">
						    <input id="apellidos" name="apellidos" placeholder="Introduce los apellidos" class="input-xlarge" type="text"
						    value="<%= obj.getApellidos()%>">						    
						  </div>
						</div>
						
						<!-- Text input-->
						<div class="control-group">
						  <label class="control-label" for="photo">Photo</label>
						  <div class="controls">
						    <input id="photo" name="photo" placeholder="Introduce la url de la foto" class="input-xlarge" type="text"
						    value="<%= obj.getPhoto()%>">						    
						  </div>
						</div>
						
						<!-- Button -->
						<div class="control-group">
						  <label class="control-label" for="cmdactualizar"></label>
						  <div class="controls">						    
						    <input type='submit' name="cmdactualizar" value='Actualizar' class='btn btn-primary' />
						  </div>
						</div>
					</div>
					
				
				</fieldset>
			</form>
	
			<hr>
		</div>
	</div> <!-- fin columna -->
</div>

<a href="user" class="button"> Listar guardados </a>


<%@include file="includes/footer.jsp" %>