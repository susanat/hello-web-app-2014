<%@include file="includes/head.jsp" %>
	

	<form class="form-horizontal" role="form" method="post" id="frm_search" action="search">
	<fieldset>
	
	<!-- Form Name -->
	<legend>Buscar en  LinkedIn </legend>
	
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
	
	</fieldset>
	</form>

	<hr>
	


<%@include file="includes/footer.jsp" %>