<%@page import="com.ipartek.formacion.agenda.bean.PruebasListaPersonas"%>
<%@page import="com.ipartek.formacion.agenda.bean.Persona"%>
<%@page import="java.util.ArrayList"%>
<%@include file="includes/head.jsp"%>
<%@include file="includes/nav.jsp"%>

<%
	ArrayList<Persona> vPersonas =PruebasListaPersonas.getPruebaPersona().listaCompleta();
	//ArrayList<Persona> vPersonas =(ArrayList<Persona>)request.getAttribute( Constantes.ATT_PERSONAS );
	int tamanio = vPersonas.size();
%>

<!-- Page Content -->
<div class="container">

	<div class="row">
		<div class="col-lg-12 ">
			<h4 class="resultados">
				Numero de contactos encontrados:<%=vPersonas.size()%></h4>
		</div>
		<%
			if (vPersonas.isEmpty()) {
					%>
						<h2>No existe nigun contacto, por favor cree un contacto <a href="<%=Constantes.CONTROLLER_DETALLE%>" title="nueva contacto">nuevo</a></h2>				
					<%
				}else{
		%>
		<table id="idAgenda" class="table table-bordered table-hover" width="100%" cellspacing="0">
			<thead>
				<tr >
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

			<!--<tfoot>
				<tr >
					<th></th>
					
					<th>Nombre</th>
					<th>Apellido</th>
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
					<td><input type="checkbox" value="<%= p.getIdcontacto()%>">
					
		                	<a href="<%= Constantes.CONTROLLER_DETALLE+"?id="+p.getIdcontacto()%>">
								<span class="glyphicon glyphicon-eye-open"></span>
							</a>
					</td>
					
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

<%@include file="includes/modalDelete.jsp"%>
<%@include file="includes/footer.jsp"%>
