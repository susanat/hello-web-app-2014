<!-- Importaciones de la página -->
<%@page import="com.ipartek.formacion.helloweb.bean.Roles"%>
<%@page import="com.ipartek.formacion.helloweb.temp.UtilsTemp"%>
<%@page import="com.ipartek.formacion.helloweb.comun.Utils"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.List"%>
<%@page import="com.ipartek.formacion.helloweb.comun.Constantes"%>

<%@include file="/backoffice/includes/head.jsp" %>       
		<%@include file="/backoffice/includes/nav.jsp" %>
	
		<!-- Insert breadcrumb
		<nav>			
			<ol class="breadcrumb">
				<li><a href="<%=Constantes.JSP_BACK_ADMIN%>">Administracion</a></li>
				<li>Listado Personas</li>
			</ol>
		</nav>
		 -->
	
		<div class="row text-center">
			<h1>Listado Roles</h1>
		</div>
		<%
			//Si no existe el atributo, ha entrado directamente en el jsp, cargamos el listado
			//TODO: controlar también si ha habido algún error, si no, redirecciona eternamente
			if( request.getAttribute(Constantes.ATTR_ROLES_LIST) == null) {
				
				response.sendRedirect(Constantes.PATH_SITE + Constantes.CONTROLLER_ROLES + "?" + Constantes.PARAM_ACTION + "=" + Constantes.EModeloAccion.GET.getValue() );
				
			} else {
				List<Roles> lstObj = (List<Roles>) request.getAttribute(Constantes.ATTR_ROLES_LIST);
				if (lstObj == null) {
		%>
						<h2>No existe ningún registro relativo a la consulta </h2>
				
					<%
										} else {
									%>
						<!-- html -->
					<div class="row">
						<table class="table" id="lstPersonas">
						    <thead>
						        <tr>
						        	<th></th>
						            <th>Id</th>
						            <th>Alias</th>
						            <th>Nombre</th>
						            <th>Descripcion</th>
						            <th>Editar</th>             
						            <th>Eliminar</th>
						        </tr>
						    </thead>
						    <tbody>
					<%
						for (Roles obj : lstObj ) {									
									out.println("<tr>");
									out.println("<td>" + "<i class='fa fa-user fa-fw'>" + "</td>");
									out.println("<td>" + obj.getId() + "</td>");
									out.println("<td>" + obj.getAlias() + "</td>");
									out.println("<td>" + UtilsTemp.getTextLang(obj, obj.getNombre(),session) + "</td>");
									out.println("<td>" + UtilsTemp.getTextLang(obj, obj.getDescripcion(),session) + "</td>");						
									out.println("<td>");
					%>						
							<form action="<%=Constantes.PATH_SITE +  Constantes.CONTROLLER_ROLES%>" method="post">							
								<input type='hidden' value='<%=Constantes.EModeloAccion.GET.getValue()%>' name='<%=Constantes.PARAM_ACTION%>' />
							    <input type='hidden' value='<%=obj.getId()%>' name='<%=Constantes.PARAM_ROLES_ID%>' />
							    <input type='hidden' value='<%=Constantes.JSP_BACK_ROLES_FORM%>' name='<%=Constantes.PARAM_URL_TO%>' />
							    <input type='submit' name="submit" value='Editar' class='btn btn-outline btn-success'>
							</form>
						<%
							out.println("</td>");
										
										out.println("<td>");
						%>						
							<form action="<%=Constantes.PATH_SITE + Constantes.CONTROLLER_ROLES%>" method="post">							
								<input type='hidden' value='<%=Constantes.EModeloAccion.DELETE.getValue()%>' name='<%=Constantes.PARAM_ACTION%>' />
							    <input type='hidden' value='<%=obj.getId()%>' name='<%=Constantes.PARAM_ROLES_ID%>' />
							    <input type='hidden' value='<%=Constantes.JSP_BACK_ROLES_LIST%>' name='<%=Constantes.PARAM_URL_TO%>' />							    
							    <input type='submit' name="submit" value='Eliminar' class='btn btn-outline btn-danger'>
							</form>
						<%
							out.println("</td>");										
										
										out.println("</tr>");
									}
						%>
						<!-- html -->
						 	</tbody>
						</table>
						
						
					<%
																		}
																	%>
					<script>
					$(document).ready(function(){
						
						lanzarToast();
					
						function lanzarToast(){
							//http://codeseven.github.io/toastr/demo.html
							toastr.options = {
									  "closeButton": true,
									  "debug": false,
									  "progressBar": false,
									  "positionClass": "toast-bottom-right",
									  "onclick": null,
									  "showDuration": "200",
									  "hideDuration": "1000",
									  "timeOut": "3000",
									  "extendedTimeOut": "1000",
									  "showEasing": "swing",
									  "hideEasing": "linear",
									  "showMethod": "slideDown",
									  "hideMethod": "fadeOut"
									}
							
							// Display an info toast with no title
							toastr.success('Listado cargado correctamente.');
						}					
					});	
					</script>
				<%
					}
				%>
			
		</div>
		<div class="row" style="margin-top: 20px;">
			<div class="col-md-6">			
				<a href="<%=Constantes.JSP_BACK_ROLES_FORM%>" type="button" class="btn btn-success btn-lg">
					Nuevo Rol
				</a>
			</div>
			
			<div class="col-md-6 text-right" >					
				<a href="<%=Constantes.PATH_SITE + Constantes.CONTROLLER_ROLES%>" type="button" class="btn btn-success btn-lg">
					Actualizar
				</a>
			</div>	
		</div>
	

	<!-- Añadimos los plugins que utilice está página -->	
	<link href="<%=Constantes.PATH_BACK_ABS_THEME %>css/alerts/toastr.css" rel="stylesheet"/>
	<script src="<%=Constantes.PATH_BACK_ABS_THEME %>js/alerts/toastr.js"></script>
	
	<!-- Para el datatable: http://www.datatables.net/ -->
	<!--  
	<link href="http://cdn.datatables.net/1.10.4/css/jquery.dataTables.min.css" rel="stylesheet">
	<script src="http://cdn.datatables.net/1.10.4/js/jquery.dataTables.min.js"></script>
	-->

	<link href="<%= Constantes.PATH_BACK_ABS_THEME %>css/dataTables/jquery.dataTables.min.css" rel="stylesheet">
	<script src="<%= Constantes.PATH_BACK_ABS_THEME %>js/dataTables/jquery.dataTables.js"></script>

 <script>
    
    $(document).ready(function() {
    	$('#lstPersonas').DataTable();
	} );
	</script>



<%@include file="/backoffice/includes/footer.jsp" %>
	