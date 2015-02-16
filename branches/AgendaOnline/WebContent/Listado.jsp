<%@page import="com.ipartek.formacion.agenda.bean.PruebasListaPersonas"%>
<%@page import="com.ipartek.formacion.agenda.bean.Persona"%>
<%@page import="com.ipartek.formacion.agenda.Constantes"%>
<%@page import="java.util.ArrayList"%>

<jsp:include page="includes/head.jsp">
<jsp:param value="LISTADO" name="titulo"/>
</jsp:include>
<jsp:include page="includes/nav.jsp">
	<jsp:param value="false" name="esNuevo" />
</jsp:include>


<%
	//ArrayList<Persona> vPersonas = PruebasListaPersonas.getPruebaPersona().listaCompleta();
	//ArrayList<Persona> vPersonas = PruebasListaPersonas.getPruebaPersona().listaVacia();
	ArrayList<Persona> vPersonas = (ArrayList<Persona>)request.getAttribute( Constantes.ATT_PERSONAS );
	int tamanio = vPersonas.size();
%>

<!-- Page Content -->
<div class="container">

	<div class="alert alert-success" role="alert">Se han eliminado
		con exito los contactos</div>
	<div class="row">
		<div class="col-lg-12 ">
			<h4 class="resultados">
				Numero de contactos encontrados:<%=vPersonas.size()%></h4>
		</div>
		<%
			if (vPersonas.isEmpty()) {
		%>
		<h2>
			No existe nigun contacto, por favor cree un contacto <a
				href="<%=Constantes.JSP_DETALLE%>" title="nuevo contacto">nuevo</a>
		</h2>
		<%
			} else {
		%>
		<table id="idAgenda" class="table table-bordered table-hover"
			width="100%" cellspacing="0">
			<thead>
				<tr>
					<th></th>

					<th>Nombre</th>
					<th class="desaparecer">Apellido</th>
					<th>Movil</th>
					<th class="desaparecer">Fijo</th>
					<th class="desaparecer">Direccion</th>
					<th class="desaparecer">Poblacion</th>
					<th class="desaparecer">Provincia</th>
				</tr>
			</thead>

			<!--<tfoot>
				<tr >
					<th></th>
					
					<th>Nombre</th>
					<th >Apellido</th>
					<th>Movil</th>
					<th>Fijo</th>
					<th>Direccion</th>
					<th>Poblacion</th>
					<th>Provincia</th>
				</tr>
			</tfoot>-->

			<tbody>
				<%
					Persona p = null;
						for (int iPersona = 0; iPersona < vPersonas.size(); iPersona++) {
							p = vPersonas.get(iPersona);
				%>

				<tr>
					<td><input type="checkbox" value="<%=p.getIdcontacto()%>">

						<a
						href="<%=Constantes.CONTROLLER_AGENDA + "?id="
							+ p.getIdcontacto()%>">
							<span class="glyphicon glyphicon-eye-open"></span>
					</a></td>

					<td><%=p.getNombre()%></td>
					<td class="desaparecer"><%=p.getApellidos()%></td>
					<td><%=p.getTelMovil()%></td>
					<td class="desaparecer"><%=p.getTelFijo()%></td>
					<td class="desaparecer"><%=p.getDireccion()%></td>
					<td class="desaparecer"><%=p.getPoblacion()%></td>
					<td class="desaparecer"><%=p.getProvincia()%></td>
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

<%@include file="includes/modalDelete.jsp"%>
<%@include file="includes/footer.jsp"%>
