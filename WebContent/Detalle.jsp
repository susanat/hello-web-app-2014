<%@page import="com.ipartek.formacion.agenda.bean.PruebasListaPersonas"%>
<%@page import="com.ipartek.formacion.agenda.bean.Persona"%>
<%@page import="java.util.ArrayList"%>

<%@include file="includes/head.jsp"%>
<%@include file="includes/nav.jsp"%>


<%
		//recoger attributo de Persona		
		//Persona p = (Persona)request.getAttribute(Constantes.ATT_PERSONA);

		Persona p = PruebasListaPersonas.getPruebaPersona().obtenerPersonaPorId(0);
		p=null;
		//inicializar variables para el formulario		
		String buttonValue = "Crear";
		String op = Constantes.OP_ACTUALIZAR;
		boolean isNew = false;
		
		//nueva persona				
		if ( p == null ){
			p = new Persona();
			isNew = true;
			op = Constantes.OP_CREAR;
		//modificar persona	
		}else{			
			buttonValue = "Modificar";
		}
	
%>

<div class="panel-body">
	<div class="panel panel-default">
		<div class="panel-heading">Datos del contacto</div>
		<div class="panel-body">
			<form role="form">
				<div class="col-lg-4">
					<div class="form-group">
						<label>Nombre</label> <input type="text" tabindex="1" pattern="([A-Z,a-z]{2,20})" class="form-control" required value="<%=p.getNombre()%>">
					</div>
					<div class="form-group">
						<label>Telefono fijo</label> <input type="tel"
							class="form-control" tabindex="3" pattern="([0-9]{9})" value="<%=p.getTelFijo()%>">
					</div>
				</div>
				<!-- /.col-lg-4 (nested) -->
				<div class="col-lg-4">
					<div class="form-group">
						<label>Apellidos</label> <input type="text" tabindex="2" pattern="([A-Z,a-z]{7,60})" class="form-control" value="<%=p.getApellidos()%>">
					</div>
					<div class="form-group">
						<label>Movil</label> <input type="tel" tabindex="4" pattern="([0-9]{9})" class="form-control" required value="<%=p.getTelMovil()%>">
					</div>
				</div>
				<!-- /.col-lg-4 (nested) -->
				<div class="col-lg-12">
					<div class="form-group">
						<label>Domicilio</label> <input type="text" tabindex="5" pattern="([A-Za-z0-9áéíóúÁÉÍÓÚ]{8,60})" class="form-control" value="<%=p.getDireccion()%>">
					</div>
				</div>
				<!-- /.col-lg-12 (nested) -->
				<div class="col-lg-4">
					<div class="form-group">
						<label>Localidad</label> <input type="text" tabindex="6" pattern="([A-Za-z]{3,50})" class="form-control" value="<%=p.getPoblacion()%>">
					</div>
				</div>
				<!-- /.col-lg-4 (nested) -->
				<div class="col-lg-4">
					<div class="form-group">
						<label>Provincia</label> <input type="text" tabindex="7" pattern="([A-Za-záéíóúÁÉÍÓÚ]{3,50})" class="form-control" value="<%=p.getProvincia()%>">
					</div>
				</div>
				<!-- /.col-lg-4 (nested) -->
				<div class="col-lg-4">
					<div class="form-group">
						<label>CP</label> <input type="number" tabindex="8" class="form-control" pattern="([0-9]{5})" value="<%=p.getCp()%>">
					</div>
				</div>
				<!-- /.col-lg-4 (nested) -->
				<div class="col-lg-12">
					<div class="form-group">
						<label>Anotaciones</label>
						<textarea class="form-control" tabindex="9" rows="3" ><%=p.getAnotaciones()%></textarea>
					</div>
					<button type="submit"  class="btn btn-default" tabindex="10">Guardar</button>
					<a href="Listado.jsp" class="btn btn-default" tabindex="11">Volver</a>
				</div>
				<!-- /.col-lg-12 -->
			</form>
		</div>
		<!-- /.panel-body -->
	</div>
	<!-- /.panel -->
</div>
<!-- /.panel-body -->

<%@include file="includes/footer.jsp"%>