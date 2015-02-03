<%@include file="includes/head.jsp"%>
<%@include file="includes/nav.jsp"%>


<!-- Page Content -->
<div class="container">

	<div class="row">
		<div class="col-lg-12 text-center">
			<h1>Listado de personas</h1>
		</div>
		<table id="idAgenda" class="display" width="100%" cellspacing="0">
			<thead>
				<tr>
					<th></th>
					<th>Nombre</th>
					<th>Apellido</th>
					<th>Tel Fijo</th>
					<th>Tel. Movil</th>
				</tr>
			</thead>

			<tfoot>
				<tr>
					<th></th>
					<th>Nombre</th>
					<th>Apellido</th>
					<th>Tel Fijo</th>
					<th>Tel. Movil</th>
				</tr>
			</tfoot>

			<tbody>
				<tr>
					<td><input type="checkbox" value="1"></td>
					<td>Tiger</td>
					<td>Nixon</td>
					<td>949 999 999</td>
					<td>666 666 666</td>
				</tr>
			</tbody>
		</table>
	</div>
	<!-- /.row -->

</div>
<!-- /.container -->

<%@include file="includes/footer.jsp"%>
