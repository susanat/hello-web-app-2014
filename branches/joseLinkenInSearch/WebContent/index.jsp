<%@page import="ipt.fm.ipartek.test.linkedin.Constantes"%>
<%@page import="ipt.fm.ipartek.test.linkedin.bean.PersonaLinkedin"%>
<%@page import="ipt.fm.ipartek.test.linkedin.bean.Persona"%>
<%@page import="java.util.ArrayList"%>

<%@include file="/includes/head.jsp"%>
<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
	<ul class="nav navbar-nav">
		<li class="active"><a href="<%=Constantes.CTE_PERSONA_SERVLET%>">Tabla
				Personas</a></li>
	</ul>
</div>
</div>
</nav>


<div class="container">

	${requestScope.personas}

	<form class="form-inline" action="<%=Constantes.CTE_SEARCH_SERVLET%>"
		method="post">
		<div class="form-group">
			<!-- <label class="sr-only" for="idNombre">Nombre</label> -->
			<input name="first" type="text" class="form-control" id="first"
				placeholder="Nombre" required>
		</div>
		<div class="form-group">
			<!-- <label class="sr-only" for="idApellidos">Apellidos</label>  -->
			<input name="last" type="text" class="form-control" id="last"
				placeholder="Apellidos" required>
		</div>
		<button type="submit" class="btn btn-default">Buscar</button>
	</form>
</div>
<br>
<br>
<div id="idResultadoLinkedin">
	<%
		String nombreApellidos = (String) request.getAttribute("nomApes");
		if (nombreApellidos != null) {
			ArrayList<PersonaLinkedin> personas = (ArrayList<PersonaLinkedin>) request
					.getAttribute("resulthtml");
			if (personas == null) {
	%>
	<div class='row col-md-offset-1 col-md-8 alert alert-info'>
		No hay resultados para
		<%=nombreApellidos%>
	</div>
	<%
		} else {
				for (int i = 0; i < personas.size(); i++) {
	%>
	<div class='row col-md-offset-1 col-md-8 panel panel-default'>
		<div class="panel-heading">
			<h3 class="panel-title"><%=personas.get(i).getNombre() + " "
								+ personas.get(i).getApellidos()%></h3>
		</div>
		<div class="panel-body">
			<div class='row'>
				<div class="media col-md-2">
					<img class="media-left" alt='foto de perfil' name="foto"
						src='<%=personas.get(i).getFoto()%>'>

				</div>
				<div class="media-body">
					<%=personas.get(i).getBasic()%>
					<%=personas.get(i).getExpanded()%>
					<br>
					<form action='<%=Constantes.CTE_PERSONA_SERVLET%>' method='post'>
						<input type='hidden' name='nombre'
							value='<%=personas.get(i).getNombre()%>'> <input
							type='hidden' name='apellidos'
							value='<%=personas.get(i).getApellidos()%>'> <input
							type='hidden' name='foto' value='<%=personas.get(i).getFoto()%>'>
						<input type='hidden' name='action'
							value='<%=Constantes.CTE_ACC_NUEVO%>'> <input
							type='submit' class="btn btn-primary" value='Guardar'>
					</form>
				</div>
			</div>
		</div>
	</div>
	<br>

	<%
		}
			}
		}
	%>
</div>
</body>
</html>