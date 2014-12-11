<%@page import="com.ipartek.formacion.helloweb.comun.Constantes"%>
<div class="navbar-default sidebar" role="navigation">
	<div class="sidebar-nav navbar-collapse">
		<ul class="nav" id="side-menu">
			<li class="sidebar-search">
				<div class="input-group custom-search-form">
					<input type="text" class="form-control" placeholder="Search...">
					<span class="input-group-btn">
						<button class="btn btn-default" type="button">
							<i class="fa fa-search"></i>
						</button>
					</span>
				</div> <!-- /input-group -->
			</li>
			
			<!--  
			<li><a class="active" href="<%= Constantes.JSP_BACK_ADMIN %>">
					<i class="fa fa-dashboard fa-fw"></i> 
					Dashboard
				</a>
			</li>
			-->
			
			<li>
				<a href="#">
					<i class="fa fa-users fa-fw"></i>
					Personas
					<span class="fa arrow"></span>
				</a>				
				<ul class="nav nav-second-level">
					<li><a href="<%=Constantes.JSP_BACK_PERSONA_LIST %>">
						<i class="fa fa-user fa-fw"></i>
						Listar
						</a>
					</li>
					<li><a href="<%=Constantes.JSP_BACK_PERSONA_FORM %>">Crear</a></li>
				</ul> <!-- /.nav-second-level -->
			</li>
			
			<li>
				<a href="#">
					<i class="fa fa-users fa-fw"></i>
					Roles
					<span class="fa arrow"></span>
				</a>				
				<ul class="nav nav-second-level">
					<li><a href="<%=Constantes.JSP_BACK_ROLES_LIST %>">
						<i class="fa fa-user fa-fw"></i>
						Listar
						</a>
					</li>
					<li><a href="<%=Constantes.JSP_BACK_ROLES_FORM %>">Crear</a></li>
				</ul> <!-- /.nav-second-level -->
			</li>
			
		</ul>
	</div>
	<!-- /.sidebar-collapse -->
</div>
<!-- /.navbar-static-side -->