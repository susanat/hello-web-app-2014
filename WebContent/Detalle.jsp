<%@page import="com.ipartek.formacion.agenda.bean.PruebasListaPersonas"%>
<%@page import="com.ipartek.formacion.agenda.bean.Persona"%>
<%@page import="java.util.ArrayList"%>

<%@include file="includes/head.jsp"%>
<%@include file="includes/nav.jsp"%>


<%
	Persona p;
	//recoger attributo de Persona		
	//Persona p = (Persona)request.getAttribute(Constantes.ATT_PERSONA);
	String txtid = request.getParameter("id");
	if (txtid == null) {
		p = null;
	} else {
		int ipersona = Integer.parseInt(txtid);
		p = PruebasListaPersonas.getPruebaPersona()
				.obtenerPersonaPorId(ipersona);
	}
	//p = null;
	//inicializar variables para el formulario		
	String buttonValue = "Modificar";
	String op = Constantes.OP_ACTUALIZAR;
	boolean isNew = false;

	//nueva persona				
	if (p == null) {
		p = new Persona();
		isNew = true;
		buttonValue = "Crear";
		op = Constantes.OP_CREAR;
		//modificar persona	
	}
%>

<div class="panel-body">
	<div class="panel panel-default">
		<div class="panel-heading">Datos del contacto</div>
		<div class="panel-body">
			<form role="form">
				<div class="col-lg-4">
					<div class="form-group">
						<label>Nombre</label> <input placeholder="Nombre" type="text"
							tabindex="1" pattern="([A-Za-z ÑñáéíóúÁÉÍÓÚ]{2,20})"
							class="form-control" required value="<%=p.getNombre()%>">
					</div>
					<div class="form-group">
						<label>Telefono fijo</label> <input placeholder="Tfno. Fijo" type="tel"
							class="form-control" tabindex="3" pattern="([0-9]{9})"
							value="<%=p.getTelFijo()%>">
					</div>
				</div>
				<!-- /.col-lg-4 (nested) -->
				<div class="col-lg-4">
					<div class="form-group">
						<label>Apellidos</label> <input placeholder="Apellidos" type="text" tabindex="2"
							pattern="([A-Za-z ÑñáéíóúÁÉÍÓÚ]{0,50})" class="form-control"
							value="<%=p.getApellidos()%>">
					</div>
					<div class="form-group">
						<label>Movil</label> <input placeholder="Tfno. Movil" type="tel" tabindex="4"
							pattern="([0-9]{9})" class="form-control" required
							value="<%=p.getTelMovil()%>">
					</div>
				</div>
				<!-- /.col-lg-4 (nested) -->
				<div class="col-lg-12">
					<div class="form-group">
						<label>Domicilio</label> <input placeholder="Domicilio" type="text" tabindex="5"
							pattern="([A-Za-z 0-9 / ª º ÑñáéíóúÁÉÍÓÚ]{0,60})"
							class="form-control" value="<%=p.getDireccion()%>">
					</div>
				</div>
				<!-- /.col-lg-12 (nested) -->
				<div class="col-lg-4">
					<div class="form-group">
						<label>Localidad</label> <input placeholder="Localidad" type="text" tabindex="6"
							pattern="([A-Za-z ÑñáéíóúÁÉÍÓÚ]{0,50})" class="form-control"
							value="<%=p.getPoblacion()%>">
					</div>
				</div>
				<!-- /.col-lg-4 (nested) -->
				<div class="col-lg-4">
					<div class="form-group">
						<label>Provincia</label> <input placeholder="Provincia" type="text" tabindex="7"
							pattern="([A-Za-z ÑñáéíóúÁÉÍÓÚ]{0,50})" class="form-control"
							value="<%=p.getProvincia()%>">
					</div>
				</div>
				<!-- /.col-lg-4 (nested) -->
				<div class="col-lg-4">
					<div class="form-group">
						<label>C.P.</label> <input placeholder="C.P." type="number" tabindex="8"
							class="form-control" pattern="([0-9]{5})" value="<%=p.getCp()%>">
					</div>
				</div>
				<!-- /.col-lg-4 (nested) -->
				<div class="col-lg-12">
					<div class="form-group">
						<label>Anotaciones</label>
						<textarea class="form-control" placeholder="Anotaciones" tabindex="9" rows="3"><%=p.getAnotaciones()%></textarea>
					</div>
					<%
						if (!isNew) {
					%>
					<input type="hidden" name="id" value="<%=p.getIdcontacto()%>">
					<input type="hidden" name="<%=Constantes.OP_KEY%>"
						value="<%=Constantes.OP_ACTUALIZAR%>"> <input
						type="submit" value="<%=buttonValue%>" class="btn btn-default"
						tabindex="10">
					<%
						} else {
					%>
					<input type="submit" value="<%=buttonValue%>"
						class="btn btn-default" tabindex="10">
					<%
						}
					%>
					<a href="<%=Constantes.CONTROLLER_AGENDA%>" class="btn btn-default"
						tabindex="11">Volver</a>
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