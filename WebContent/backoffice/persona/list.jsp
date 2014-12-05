<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="com.ipartek.formacion.helloweb.bean.Persona"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ipartek.formacion.helloweb.Constantes"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@include file="../includes/head.jsp" %>
<%@include file="../includes/nav.jsp" %>
<%@include file="/include/alerts.jsp" %>
	
	
	<h1>Listado Personas</h1>
	
	<br>
	<%
		ArrayList<Persona> personas = (ArrayList<Persona>)request.getAttribute(Constantes.ATT_PERSONAS);
		if(personas == null){
		    %>
		    
		    	<h2>No existe ninguna persona</h2>
		    	<br>
		    	<p><a href=<%=Constantes.JSP_BACKOFFICE_PERSONA_FORM +"?accion=" + Constantes.LETRERO_CREAR %> class="btn btn-primary"><i class="fa fa-plus fa-fw"></i> Crear</a>
		    <%
		}else{
		    %>
		    <table id="miTabla" class="display" cellspacing="0" width="100%">
		     <thead>
            <tr>
                <th>Id</th>
                <th>Nombre</th>
                <th>Edad</th>
                <th>Rol</th>
            
                <th>Eliminar</th>
                
            </tr>
        </thead>
 
        <tfoot>
            <tr>
                <th>Id</th>
                <th>Nombre</th>
                <th>Edad</th>
                <th>Rol</th>
              
                <th>Eliminar</th>
                
            </tr>
        </tfoot>
         <tbody>
		    <%
		    for(int i =0; i<personas.size(); i++){
			%>
				<tr><td><a href=<%=Constantes.CONTROLLER_PERSONA +"?id=" +personas.get(i).getId()+ "&accion=" + Constantes.LETRERO_DETALLE %>><%out.print(personas.get(i).getId()); %></a>
				
				</td>
				<td><%out.print(personas.get(i).getNombre()); %></td>
				<td><%out.print(personas.get(i).getEdad()); %></td>
				<td><%out.print(personas.get(i).getRol()); %></td>
				
				<td>
				<a href=<%=Constantes.CONTROLLER_PERSONA +"?id=" +personas.get(i).getId()+"&accion=" + Constantes.LETRERO_BORRAR %> class="btn btn-xs btn-danger">Eliminar</a></td>
				</tr>
				
				
				
				<%
		    }
		    %>
		      </tbody>
    		</table>

		    <p><a href=<%=Constantes.JSP_BACKOFFICE_PERSONA_FORM +"?accion=" + Constantes.LETRERO_CREAR %> class="btn btn-primary"><i class="fa fa-plus fa-fw"></i> Crear</a>
		    </p>
		    
		    <%
		}
		
	%>
	
<%@include file="../includes/footer.jsp" %>
