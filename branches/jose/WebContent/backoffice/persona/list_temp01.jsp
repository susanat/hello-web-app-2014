<%@page import="com.ipartek.formacion.helloweb.bean.Persona"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ipartek.formacion.helloweb.Constantes"%>



<%@include file="/includes/head.jsp"%>
<%@include file="/includes/nav.jsp"%>



<!-- BOTON -->
<div class="row">
	<div class="col-lg-12">

		<!--  <button class="btn btn-primary" type="button"> -->
		<a href="<%=Constantes.JSP_BACK_PERSONA_FORM%>"
			value="Crear una nueva persona"> Nueva persona</a>
		<!-- </button> -->
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->


<!-- LISTADO -->
<div class="row">
	<div class="col-lg-12">

		<%
			ArrayList<Persona> personas = (ArrayList<Persona>) request
					.getAttribute(Constantes.ATT_PERSONAS);
			if (personas == null) {
		%>
		<h2>No existe ninguna persona</h2>
		<%
			}else {
		%>

		<div class="panel panel-default">
			<div class="panel-heading">Personas</div>
			<!-- /.panel-heading -->
			<div class="panel-body">
				<div class="table-responsive">
					<table>
						<table id="idPersonas" class="display" width="100%"
							cellspacing="0">
							<thead>
								<tr role="row">
									<th>Id</th>
									<th>Nombre</th>
									<th>Edad</th>
									<th>Rol</th>
									<th></th>
								</tr>
							</thead>
							<tbody>

								<%
									Persona p = null;
										for (int i = 0; i < personas.size(); i++) {
											p = personas.get(i); //detalle persona
											//out.println("<ol>");
								%>
								<tr>
									<td><a
										href="<%=Constantes.CONTROLLER_PERSONA + "?id="+ p.getId()%>">
											<%=p.getId()%>
									</a></td>
									<td><%=p.getNombre()%></td>
									<td><%=p.getEdad()%></td>
									<td><%=p.getRol()%></td>
									<td>
										<form action="<%=Constantes.CONTROLLER_PERSONA%>"
											method="post">
											<input type="hidden" name="id"
												value="<%=p.getId()%>"> <input type="hidden"
												name="<%=Constantes.OP_KEY%>"
												value="<%=Constantes.OP_DELETE%>">

											<button type="submit" class="btn btn-danger btn-outline">
												<i class="fa fa-trash-o fa-fw"></i>Eliminar
												<!-- 
											<button type="button" class="btn btn-default">Eliminar</button>
											 -->
											</button>
										</form>
									</td>
								</tr>

								<%
									//out.println(personas.get(i).toString() + "</li>");
											//out.println("</ol>");
										}
										 %>
							</tbody>
						</table>
						</div>
						<!-- /.table-responsive -->
						</div>
						<!-- /.panel-body -->
						</div>
						<%
							}
						 %>
						</div>
						<!-- class="col-lg-12" -->
						</div>
						<!-- class="row" -->

						</div>
						<!-- /#page-wrapper -->

						<%@include file="/includes/footer.jsp"%>