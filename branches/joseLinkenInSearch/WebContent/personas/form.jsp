<%@page import="ipt.fm.ipartek.test.linkedin.Constantes"%>
<%@page import="ipt.fm.ipartek.test.linkedin.bean.Persona"%>

<%@include file="../includes/head.jsp" %>
<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
	<ul class="nav navbar-nav">
	<li class="active"><a href="<%=Constantes.CTE_PERSONA_SERVLET%>">Tabla
		Personas</a></li>
	</ul>
</div>
	</div>
	</nav>

<div class="container">
	<%
		Persona p = (Persona) request.getAttribute("persona");
	%>
	<form action="<%=Constantes.CTE_PERSONA_SERVLET%>" method="post" role="form">
		<div class='row col-md-offset-1 col-md-8 panel panel-default'>
			<div class="panel-body">
				<div class='row'>
					<div class="media col-md-2">
						<img class="media-left" alt='foto de perfil' name="foto"
							src='<%=p.getFoto()%>'>

					</div>
					<div class="media-body col-md-8 ">
						<div class="form-group">
							<label>Id</label> <input type="text" name="id" readonly
								value="<%=p.getId()%>" class="form-control">
						</div>

						<div class="form-group">
							<label>Nombre</label> <input type="text" name="nombre"
								value="<%=p.getNombre()%>" class="form-control">
						</div>

						<div class="form-group">
							<label>Apellidos</label> <input type="text" name="apellidos"
								value="<%=p.getApellidos()%>" class="form-control">
						</div>
						<div class="form-group">
							<label>Foto</label> <input type="text" name="foto"
								value="<%=p.getFoto()%>" class="form-control">
						</div>
						<input type='hidden' name='action'
							value='<%=Constantes.CTE_ACC_ACTUALIZAR%>'> <input
							type='submit' class="btn btn-primary" value='Guardar'>
					</div>
				</div>
			</div>
		</div>
	</form>
	</div>
</body>
</html>