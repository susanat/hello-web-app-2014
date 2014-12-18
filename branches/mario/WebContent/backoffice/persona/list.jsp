<%@include file="../includes/head.jsp" %>
<%@include file="../includes/nav.jsp" %>
 
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="com.ipartek.formacion.helloweb.bean.Persona"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ipartek.formacion.helloweb.Constantes"%>

	<div class="panel panel-primary ">
	  <div class="panel-heading">
		 <h1 class="panel-title"> Listado Personas</h1> 
	  </div>
	  <div class="panel-body">
	        
	    <!--  
		< %
		ArrayList<Persona> personas = (ArrayList<Persona>) request.getAttribute(Constantes.ATT_PERSONAS);
		
		if(personas == null){
		%>
			    <h2>No existe ninguna persona, por favor, cree una nueva persona</h2>
		< %
		}else{%>
		    <table id="tabla" class="display" cellspacing="0" width="100%">
		        <thead>
		            <tr>
		                <th>id</th>
		                <th>Nombre</th>
		                <th>Edad</th>
		                <th>Rol</th>
		                <th>[<i class="fa fa-times"></i>]</th>
		            </tr>
		        </thead>
		 
		        <tfoot>
		            <tr>
		                <th>id</th>
		                <th>Nombre</th>
		                <th>Edad</th>
		                <th>Rol</th>
		                <th>[<i class="fa fa-times"></i>]</th>
		            </tr>
		        </tfoot>
		 
		        <tbody>
		           
		            < %
					    Persona pers=null;
					    for(int i=0; i<personas.size(); i++){
							pers= personas.get(i);
					%>
							<tr>
								 <td>
								 	<a href="< %= Constantes.CONTROLLER_PERSONA+"?id="+pers.getId() %>" title="id">
								  		< %= pers.getId() %>
								  	</a>
								 </td>
								 <td>< %= pers.getNombre() %></td>
								 <td>< %= pers.getEdad() %></td>
								 <td>< %= pers.getRol() %></td>
								 <td>
								 	  <form action="< %=request.getContextPath()+"/"+ Constantes.CONTROLLER_PERSONA %>" method="post">
			
										<input type="hidden" name="id" value="< %= pers.getId() %>">
										<input type="hidden" name="< %=Constantes.OP_KEY %>" value="< %=Constantes.OP_DELETE%>">
										<input type="submit" value="Eliminar" class="btn btn-danger btn-outline btn-xs">
									</form>
								</td>
							 </tr>
						< %
					    } //end for
					    %>
				 	 
			    </tbody>
		    </table>
		 < % 
			} //end:persona not null
		%>
		
		-->
			
			<table id="tabla" class="display" cellspacing="0" width="100%">
		        <thead>
		            <tr>
		                <th>id</th>
		                <th>Nombre</th>
		                <th>Edad</th>
		                <th>Rol</th>
		                <th>[<i class="fa fa-times"></i>]</th>
		            </tr>
		        </thead>
		 
		        <tfoot>
		            <tr>
		                <th>id</th>
		                <th>Nombre</th>
		                <th>Edad</th>
		                <th>Rol</th>
		                <th>[<i class="fa fa-times"></i>]</th>
		            </tr>
		        </tfoot>
		 
		        <tbody>
		           
		          <c:forEach var="item" begin="0" items="${requestScope.personas}">
							<tr>
								 <td>
								 	<a href="<%=Constantes.CONTROLLER_PERSONA%>?id=<c:out value="${item.id}"/>" title="id">
								  		<c:out value="${item.id}"/> 
								  	</a>
								 </td>
								 <td><c:out value="${item.nombre}"/></td>
								 <td><c:out value="${item.edad}"/></td>
								 <td><c:out value="${item.rol}"/></td>
								 <td>
								 	  <form action="<%=request.getContextPath()+"/"+ Constantes.CONTROLLER_PERSONA %>" method="post">
			
										<input type="hidden" name="id" value="<c:out value="${item.id}"/>" >
										<input type="hidden" name="<%=Constantes.OP_KEY %>" value="<%=Constantes.OP_DELETE%>">
										<input type="submit" value="Eliminar" class="btn btn-danger btn-outline btn-xs">
									</form>
								</td>
							 </tr> 
					</c:forEach>  
			    </tbody> <!-- Fin del body table -->
		    </table><!-- Fin de tabla -->
			<p>
		     	<a href="<%= request.getContextPath()+"/"+Constantes.JSP_BACK_PERSONA_FORM %>" class="btn btn-primary btn-sm">
				   <span class="glyphicon glyphicon-plus" aria-hidden="true"></span> Añadir
				</a>
		    <p>
			
   		 </div>
	</div><!-- Fin panel content -->
	
<%@include file="../includes/footer.jsp" %>   