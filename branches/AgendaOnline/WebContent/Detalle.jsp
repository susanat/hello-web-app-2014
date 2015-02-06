<%@page import="com.ipartek.formacion.agenda.bean.PruebasListaPersonas"%>
<%@page import="com.ipartek.formacion.agenda.bean.Persona"%>
<%@page import="java.util.ArrayList"%>

<%@include file="includes/head.jsp"%>
<%@include file="includes/nav.jsp"%>


<%
	ArrayList<Persona> vPersonas = PruebasListaPersonas.getPruebaPersona().listaCompleta();

		//recoger attributo de Persona		
		//Persona p = (Persona)request.getAttribute(Constantes.ATT_PERSONA);
		Persona p = vPersonas.get(0);
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
						<label>Nombre</label> <input type="text" class="form-control" value="<%=p.getNombre()%>">
					</div>
					<div class="form-group">
						<label>Telefono fijo</label> <input type="text"
							class="form-control" value="<%=p.getTelFijo()%>">
					</div>
				</div>
				<!-- /.col-lg-4 (nested) -->
				<div class="col-lg-4">
					<div class="form-group">
						<label>Apellidos</label> <input type="text" class="form-control" value="<%=p.getApellidos()%>">
					</div>
					<div class="form-group">
						<label>Movil</label> <input type="text" class="form-control" value="<%=p.getTelMovil()%>">
					</div>
				</div>
				<!-- /.col-lg-4 (nested) -->
				<div class="col-lg-12">
					<div class="form-group">
						<label>Domicilio</label> <input type="text" class="form-control" value="<%=p.getDireccion()%>">
					</div>
				</div>
				<!-- /.col-lg-12 (nested) -->
				<div class="col-lg-4">
					<div class="form-group">
						<label>Localidad</label> <input type="text" class="form-control" value="<%=p.getPoblacion()%>">
					</div>
				</div>
				<!-- /.col-lg-4 (nested) -->
				<div class="col-lg-4">
					<div class="form-group">
						<label>Provincia</label> <input type="text" class="form-control" value="<%=p.getProvincia()%>">
					</div>
				</div>
				<!-- /.col-lg-4 (nested) -->
				<div class="col-lg-4">
					<div class="form-group">
						<label>CP</label> <input type="text" class="form-control" value="<%=p.getCp()%>">
					</div>
				</div>
				<!-- /.col-lg-4 (nested) -->
				<div class="col-lg-12">
					<div class="form-group">
						<label>Anotaciones</label>
						<textarea class="form-control" rows="3" ><%=p.getAnotaciones()%></textarea>
					</div>
					<button type="submit" class="btn btn-default">Guardar</button>
					<a href="Listado.jsp" class="btn btn-default">Volver</a>
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