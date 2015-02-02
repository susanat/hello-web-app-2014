<%@page import="com.ipartek.formacion.agenda.Constantes"%>
<!-- Navigation -->
<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
	<div class="container-fluid row">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#navbar-collapsible">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">Agenda</a>
		</div>
		<!-- /.navbar-header-->

		<div class="navbar-collapse collapse" id="navbar-collapsible">
			<form class="navbar-form navbar-left form-inline" action="<%=Constantes.CONTROLLER_AGENDA%>" method="post">
				<div class="form-group">
					<label class="sr-only" for="inputSearch">Buscar</label> <input
						class="form-control" type="text" id="inputSearch"
						placeholder="Persona a buscar">
				</div>
				<input type="hidden" name="<%=Constantes.ACC_KEY%>"
						value="<%=Constantes.ACC_BUSCAR_CONTACTO%>">
				<button type="submit" class="btn btn-default">
					<span class="glyphicon glyphicon-search"></span> Buscar
				</button>
				<button type="submit" class="btn btn-default">
					<span class="glyphicon glyphicon-remove"></span> Buscar
				</button>
			</form>
			<!-- /.navbar-form navbar-left form-inline -->

			<form class="navbar-form navbar-right form-inline" action="<%=Constantes.CONTROLLER_AGENDA%>" method="post">
				<a type="button" class="btn btn-default" href="#"> <span
					class="glyphicon glyphicon-user"></span>Añadir
				</a>
				<input type="text" name="id" value=""> <input
						type="hidden" name="<%=Constantes.ACC_KEY%>"
						value="<%=Constantes.ACC_ELIMINAR_CONTACTO%>"> 
				<button type="button" class="btn btn-default">
					<span class="glyphicon glyphicon-trash"></span>Eliminar
				</button>
			</form>

		</div>
		<!-- /.navbar-collapse collapse-->
	</div>
	<!-- /.container-->
</nav>
