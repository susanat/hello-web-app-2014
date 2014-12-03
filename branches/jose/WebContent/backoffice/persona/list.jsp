<%@page import="com.ipartek.formacion.helloweb.bean.Persona"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ipartek.formacion.helloweb.Constantes"%>


<html lang="es">

<head>
<title>Listado Presonas</title>

<%@include file="/includes/head.jsp"%>
<%@include file="/includes/nav.jsp"%>


<div id="page-wrapper">

	<!-- TITULO -->
	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">Listado Personas</h1>
		</div>
		<!-- class="col-lg-12" -->
	</div>
	<!-- class="row" -->

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
				} else {
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
										<th class="sorting_asc">Id</th>
										<th class="sorting">Nombre</th>
										<th class="sorting">Edad</th>
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
											href="<%=Constantes.CONTROLLER_PERSONA + "?id="
							+ p.getId()%>">
												<%=p.getId()%>
										</a></td>
										<td><%=p.getNombre()%></td>
										<td><%=p.getEdad()%></td>
										<td>
											<button type="button" class="btn btn-default">Eliminar</button>
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

