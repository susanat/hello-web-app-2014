<%@page import="com.ipartek.formacion.helloweb.bean.Calificacion"%>
<%@include file="../includes/head.jsp" %>
<%@include file="../includes/nav.jsp" %>
 
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ipartek.formacion.helloweb.Constantes"%>

	<div class="panel panel-primary ">
	  <div class="panel-heading">
		 <h1 class="panel-title"> Listado Calificaciones</h1> 
	  </div>
	  <div class="panel-body">
	        
	    <!--  
		< %
		ArrayList<Calificacion> califiaciones = (ArrayList<Calificacion>) request.getAttribute(Constantes.ATT_CALIFICACIONES);
		
		if(califiaciones == null){
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
					    Calificacion califi=null;
					    for(int i=0; i<califiaciones.size(); i++){
							califi= califiaciones.get(i);
					%>
							<tr>
								 <td>
								 	<a href="< %= Constantes.CONTROLLER_PERSONA+"?id="+pers.getId() %>" title="id">
								  		< %= califi.getId() %>
								  	</a>
								 </td>
								 <td>< %= califi.getValor() % ></td>
								 <td>< %= califi.getDescripcion()() % ></td>
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
		                <th>Valor</th>
		                <th>Descripcion</th>
		                <th>[<i class="fa fa-times"></i>]</th>
		            </tr>
		        </thead>
		 
		        <tfoot>
		            <tr>
		                <th>id</th>
		                <th>Valor</th>
		                <th>Descripcion</th>
		                <th>[<i class="fa fa-times"></i>]</th>
		            </tr>
		        </tfoot>
		 
		        <tbody>
		           
		          <c:forEach var="item" begin="0" items="${requestScope.calificaiones}">
							<tr>
								 <td>
								 	<a href="<%=Constantes.CONTROLLER_CALIFICACION%>?id='<c:out value="${item.id}"/>'" title="id">
								  		<c:out value="${item.id}"/> 
								  	</a>
								 </td>
								 <td><c:out value="${item.valor}"/></td>
								 <td><c:out value="${item.descripcion}"/></td>
								 
								 <td>
								 	  <form action="<%=request.getContextPath()+"/"+ Constantes.CONTROLLER_CALIFICACION %>" method="post">
			
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
		     	<a href="<%= request.getContextPath()+"/"+Constantes.JSP_BACK_CALIFICACION_FORM %>" class="btn btn-primary btn-sm">
				   <span class="glyphicon glyphicon-plus" aria-hidden="true"></span> Añadir
				</a>
		    <p>
			
   		 </div>
	</div><!-- Fin panel content -->
	
<%@include file="../includes/footer.jsp" %>   