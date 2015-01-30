<%@include file="includes/head.jsp"%>
<%@include file="includes/nav.jsp"%>


<div class="panel-body">
	<form role="form">
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default"><br>
					<div class="panel-heading">Datos del contacto</div>
					<div class="col-lg-4">
						<div class="form-group">
							<label>Nombre</label> <input type="text" class="form-control">
						</div>
						<div class="form-group">
							<label>Telefono fijo</label> <input type="text"
								class="form-control">
						</div>
					</div>
					<!-- /.col-lg-4 (nested) -->
					<div class="col-lg-4">
						<div class="form-group">
							<label>Apellidos</label> <input type="text" class="form-control">
						</div>
						<div class="form-group">
							<label>Movil</label> <input type="text" class="form-control">
						</div>
					</div>
					<!-- /.col-lg-4 (nested) -->
					<div class="col-lg-12">
						<div class="form-group">
							<label>Domicilio</label> <input type="text" class="form-control">
						</div>
					</div>
					<!-- /.col-lg-12 (nested) -->
					<div class="col-lg-4">
						<div class="form-group">
							<label>Localidad</label> <input type="text" class="form-control">
						</div>
					</div>
					<!-- /.col-lg-4 (nested) -->
					<div class="col-lg-4">
						<div class="form-group">
							<label>Provincia</label> <input type="text" class="form-control">
						</div>
					</div>
					<!-- /.col-lg-4 (nested) -->
					<div class="col-lg-4">
						<div class="form-group">
							<label>CP</label> <input type="text" class="form-control">
						</div>
					</div>
					<!-- /.col-lg-4 (nested) -->
					<div class="col-lg-12">
						<div class="form-group">
							<label>Anotaciones</label>
							<textarea class="form-control" rows="3"></textarea>
						</div>
						<button type="submit" class="btn btn-default">Guardar</button>
						<button type="reset" class="btn btn-default">Volver</button>
					</div>
					<!-- /.col-lg-12 -->

				</div>
				<!-- /.panel -->
			</div>
			<!-- /.col-lg-12 -->
		</div>
		<!-- /.row (nested) -->
	</form>
</div>
<!-- /.panel-body -->

<%@include file="includes/footer.jsp"%>