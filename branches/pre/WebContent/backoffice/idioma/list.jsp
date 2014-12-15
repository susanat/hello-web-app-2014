<%@page import="com.ipartek.formacion.helloweb.controller.IdiomaServlet"%>
<%@page import="com.ipartek.formacion.helloweb.bean.Idioma"%>
<%@include file="../includes/head.jsp" %>
<%@include file="../includes/nav.jsp" %>

<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ipartek.formacion.helloweb.Constantes"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<p><a href="<%=Constantes.JSP_BACKOFFICE_IDIOMA_FORM%>" title="Añadir un nuevo idioma">Añadir un nuevo idioma</a></p>

	<%
		ArrayList<Idioma> idiomas = (ArrayList<Idioma>)request.getAttribute( Constantes.ATT_IDIOMAS );
		if ( idiomas == null ){
			%>
				<h2>No existe nigun idioma, por favor</h2>				
			<%
		}else{
			%>
			<table class="table table-striped table-bordered table-hover dataTable no-footer" id="tabla" cellspacing="0" width="100%">
		        <thead>
		            <tr>
		                <th>id</th>
		                <th>Locale</th>
		                <th>Pais</th>
		                <th>Lenguaje</th>
		                <th>Texto</th>
		                <th><!-- Operacion para Eliminar --></th>                
		            </tr>
		        </thead>
		 
		        <tbody>
			<% 
			Idioma idm = null;
			for ( int i=0; i < idiomas.size(); i++){
			    idm = idiomas.get(i); //detalle idioma								
				%>
					<tr>
		                <td>
		                	<a href="<%=Constantes.CONTROLLER_IDIOMA+"?id="+idm.getId()%>">
								<%=idm.getId()%> 
							</a>
						</td>
		                <td> <%=idm.getLocale()%> </td>
		                <td><%=idm.getPais()%> </td>
		                <td><%=idm.getLenguaje()%> </td>
		                <td><%=idm.getTexto()%> </td>
		                <td>
		                	<form action="<%=Constantes.CONTROLLER_IDIOMA%>" method="post">
		                		<input type="hidden" name="id" value="<%=idm.getId()%>">
		                		<input type="hidden" name="<%=Constantes.OP_KEY%>" value="<%=Constantes.OP_DELETE%>">
		                		<input type="submit" class="btn btn-outline btn-danger btn-xs" value="Eliminar">
		                	</form>		                	
		                </td>               
		            </tr>   
					
				<%				
			}//end:For
		%>	
		 	</tbody>
    	</table>
		<% 
		}//end:idioma not null
	%>
	
	
	
                   
       
	
	
<%@include file="../includes/footer.jsp" %>   