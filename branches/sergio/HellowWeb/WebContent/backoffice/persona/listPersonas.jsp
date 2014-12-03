<%@include file="/backoffice/includes/head.jsp" %>       
		<%@include file="/backoffice/includes/nav.jsp" %>


<!-- Importaciones de la página -->
<%@page import="com.ipartek.formacion.helloweb.temp.UtilsTemp"%>
<%@page import="com.ipartek.formacion.helloweb.comun.Utils"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="com.ipartek.formacion.helloweb.bean.Persona"%>
<%@page import="java.util.List"%>
<%@page import="com.ipartek.formacion.helloweb.comun.Constantes"%>
	
		<!-- Insert breadcrumb
		<nav>			
			<ol class="breadcrumb">
				<li><a href="<%=Constantes.JSP_BACK_ADMIN%>">Administracion</a></li>
				<li>Listado Personas</li>
			</ol>
		</nav>
		 -->
	
		<div class="row text-center">
			<h1>Listado Personas</h1>
		</div>
		<%
			//Si no existe el atributo, ha entrado directamente en el jsp, cargamos el listado
			if( request.getAttribute(Constantes.ATTR_PERSONAS_LIST) == null) {
				response.sendRedirect(Constantes.PATH_SITE + Constantes.CONTROLLER_PERSONA);
			} else {
				List<Persona> personas = (List<Persona>) request.getAttribute(Constantes.ATTR_PERSONAS_LIST);
				if (personas == null) {
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
						            <th>Nombre</th>
						            <th>Edad</th>
						            <th>Role</th>
						            <th>Editar</th>             
						            <th>Eliminar</th>
						        </tr>
						    </thead>
						    <tbody>
					<%
						for (Persona per : personas ) {
									
									out.println("<tr>");
									out.println("<td>" + "PNG" + "</td>");
									out.println("<td>" + per.getId() + "</td>");
									out.println("<td>" + per.getNombre() + "</td>");
									out.println("<td>" + per.getEdad() + "</td>");
									out.println("<td>" + UtilsTemp.getNameFromRole(request, String.valueOf(per.getRol()) ) + "</td>");						
									out.println("<td>");
					%>						
							<form action="<%=Constantes.CONTROLLER_PERSONA%>" method="post">							
								<input type='hidden' value='<%=Constantes.EModeloAccion.GET.getValue()%>' name='<%=Constantes.PARAM_ACTION%>' />
							    <input type='hidden' value='<%=per.getId()%>' name='<%=Constantes.PARAM_PERSONAS_ID%>' />
							    <input type='hidden' value='<%=Constantes.JSP_BACK_PERSONA_FORM%>' name='<%=Constantes.PARAM_URL_TO%>' />
							    <input type='submit' name="submit" value='Editar' class='btn btn-success btn-lg'>
							</form>
						<%
							out.println("</td>");
										
										out.println("<td>");
						%>						
							<form action="<%=Constantes.CONTROLLER_PERSONA%>" method="post">							
								<input type='hidden' value='<%=Constantes.EModeloAccion.DELETE.getValue()%>' name='<%=Constantes.PARAM_ACTION%>' />
							    <input type='hidden' value='<%=per.getId()%>' name='<%=Constantes.PARAM_PERSONAS_ID%>' />							    
							    <input type='submit' name="submit" value='Eliminar' class='btn btn-success btn-lg'>
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
				<a href="<%=Constantes.JSP_BACK_PERSONA_FORM%>" type="button" class="btn btn-success btn-lg">
					Nueva Persona
				</a>
			</div>
			
			<div class="col-md-6 text-right" >					
				<a href="<%=Constantes.PATH_SITE + Constantes.CONTROLLER_PERSONA%>" type="button" class="btn btn-success btn-lg">
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
	