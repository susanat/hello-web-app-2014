<%@page import="com.ipartek.formacion.agenda.bean.PruebasListaPersonas"%>
<%@page import="com.ipartek.formacion.agenda.bean.Persona"%>
<%@page import="java.util.ArrayList"%>
<%@include file="includes/head.jsp"%>
<%@include file="includes/nav.jsp"%>

<%
	ArrayList<Persona> vPersonas = PruebasListaPersonas
			.getPruebaPersona().listaCompleta();
	int tamanio = vPersonas.size();
%>

<!-- Page Content -->
<div class="container">

	<div class="row">
		<div class="col-lg-12 text-center">
			<h2>
				Numero de contactos encontrados:<%=vPersonas.size()%></h2>
		</div>
		<%
			if (!vPersonas.isEmpty()) {
		%>
		<table id="idAgenda" class="display" width="100%" cellspacing="0">
			<thead>
				<tr>
					<th></th>
					<th></th>
					<th>Nombre</th>
					<th>Apellido</th>
					<th>Movil</th>
					<th>Fijo</th>
					<th>Direccion</th>
					<th>Poblacion</th>
					<th>Provincia</th>
				</tr>
			</thead>

			<tfoot>
				<tr>
					<th></th>
					<th></th>
					<th>Nombre</th>
					<th>Apellido</th>
					<th>Movil</th>
					<th>Fijo</th>
					<th>Direccion</th>
					<th>Poblacion</th>
					<th>Provincia</th>
				</tr>
			</tfoot>

			<tbody>
				<%
					Persona p = null;
						for (int iPersona = 0; iPersona < vPersonas.size(); iPersona++) {
							p = vPersonas.get(iPersona);
				%>

				<tr>
					<td><input type="checkbox" value="<%=iPersona%>"></td>
					<td>
					<a href="Detalle.jsp?id=<%=iPersona%>">
					<span class="glyphicon glyphicon-eye-open"></span>
					</a></td>
					
					<td><%=p.getNombre()%></td>
					<td><%=p.getApellidos()%></td>
					<td><%=p.getTelMovil()%></td>
					<td><%=p.getTelFijo()%></td>
					<td><%=p.getDireccion()%></td>
					<td><%=p.getPoblacion()%></td>
					<td><%=p.getProvincia()%></td>
				</tr>
				<%
					}
				%>
			</tbody>
		</table>
		<%
			}
		%>
	</div>
	<!-- /.row -->

</div>
<!-- /.container -->

<%@include file="includes/footer.jsp"%>
