<%@page import="ipt.fm.ipartek.test.linkedin.Constantes"%>
<%@page import="ipt.fm.ipartek.test.linkedin.bean.Persona"%>
<%@page import="java.util.ArrayList"%>

<%@include file="../includes/head.jsp" %>
<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
	<ul class="nav navbar-nav">
	<li class="active"><a href="<%=Constantes.CTE_SEARCH_SERVLET%>">Buscar en Linkedin</a></li>
	</ul>
</div>
	</div>
	</nav>	


	<div class="container">
		<%
			ArrayList<Persona> personas = (ArrayList<Persona>) request
					.getAttribute("personas");
			if (personas != null) {
		%>
		<table id="tabla" cellspacing="0" width="100%" class="table table-hover">
			<thead>
				<tr>
					<th>id</th>
					<th>Nombre</th>
					<th>Apellidos</th>
					<th>Foto</th>
					<th>
						<!-- Operacion para Eliminar -->
					</th>
				</tr>
			</thead>

			<tbody>
				<%
					for (int i = 0; i < personas.size(); i++) {
				%>

				<tr>
					<td><a
						href="<%="PersonaServlet.do?id=" + personas.get(i).getId()%>"> <%=personas.get(i).getId()%></a></td>
					<td><a
						href="<%="PersonaServlet.do?id=" + personas.get(i).getId()%>"><%=personas.get(i).getNombre()%></a></td>
					<td><a
						href="<%="PersonaServlet.do?id=" + personas.get(i).getId()%>"><%=personas.get(i).getApellidos()%></a></td>
					<td><%=personas.get(i).getFoto().isEmpty()?"NO":"SI"%></td>
					<td>
						<form action='PersonaServlet.do' method='post'>
							<input type='hidden' name='id'
								value='<%=personas.get(i).getId()%>'> 
								<input type='hidden' name='action'
							value='<%=Constantes.CTE_ACC_ELIMINAR%>'>
								<input
								type='submit' class="btn btn-outline btn-danger btn-xs"
								value='borrar'>
						</form>
					</td>
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

</body>
</html>