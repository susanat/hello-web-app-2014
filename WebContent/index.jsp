<%@include file="includes/head.jsp" %>
	


<div class="jumbotron row text-center">

	<div class="col-md-4 col-md-offset-4">
		<div class="panel panel-primary">
	
			<form class="form-horizontal" role="form" method="post" id="frm_search" action="search">
				<fieldset>
				
				
					
					<div class="panel-heading">
						<!-- Form Name -->
						<legend>Buscar en  LinkedIn </legend>
					</div>
					
					<div class="panel-body">
					
						<!-- Text input-->
						<div class="control-group">
						  <label class="control-label" for="txtnombre">Nombre</label>
						  <div class="controls">
						    <input id="txtnombre" name="txtnombre" placeholder="Introduce un nombre" class="input-xlarge" type="text">	    
						  </div>
						</div>
						
						<!-- Text input-->
						<div class="control-group">
						  <label class="control-label" for="txtapellidos">Apellidos</label>
						  <div class="controls">
						    <input id="txtapellidos" name="txtapellidos" placeholder="Introduce los apellidos" class="input-xlarge" type="text">
						    
						  </div>
						</div>
						
						<!-- Button -->
						<div class="control-group">
						  <label class="control-label" for="cmdbuscar"></label>
						  <div class="controls">
						    <button id="cmdbuscar" name="cmdbuscar" class="btn btn-primary">Buscar</button>
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