<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@page import="ipt.fm.ipartek.test.linkedin.bean.Persona"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Persona</title>
<link rel="stylesheet" media="screen" href="css/style.css" >
</head>
<body>




 
  <form class="contact_form" action="personaServlet" method="post" name="Actualizar">
    <ul>
        <li>
             <h2>Persona</h2>
        </li>
        <li>
            <label for="name">Nombre:</label>
            <input type="text"  placeholder="nombre" />
        </li>
        <li>
            <label for="email">Email:</label>
            <input type="text" name="apellido" placeholder="apellido" />
        </li>
        
        <li>
            <input type="radio" name="Action" value="Actualizar" /> Actualizar
 			<input type="radio" name="Action" value="Eliminar" /> Eliminar
 			<input type="radio" name="Action" value="Crear" checked /> Crear
 			<input type="radio" name="Action" value="Seleccionar"  /> Seleccionar
        </li>
        <li>
        <button class="submit" type="submit">Enviar</button>
        </li>
    </ul>
</form>


<%
		ArrayList<Persona> personas = (ArrayList<Persona>)request.getAttribute( "personas");
		if ( personas == null ){
			%>
				<h2>No existe niguna persona</h2>
				
			<%
		}else{
			%>
			
	<table id="table" class="display" width="100%" cellspacing="0">
        <thead class="miTabla">
            <tr>
                <th>Id</th>
                <th>Nombre</th>
                <th>Apellido</th>

            </tr>
        </thead>
 
        <tfoot>
            <tr>
                <th>Id</th>
                <th>Nombre</th>
                 <th>Apellido</th>
            </tr>
        </tfoot>
 
        <tbody>
        	<c:forEach var="persona" begin="0" items="${personas}">    	
    	
    			<tr>
	        	 	<td><a href="">${persona.nombre}</a></td>
	
					<td><a href="">${persona.apellido}</a></td>
					<td>${persona.edad}</td>
					<td>${persona.rol}</td>
					<td>
					
						
					</td>
        	 
        		 </tr>
        	 
    
    		</c:forEach>
        </tbody>
    </table>
    
   
    
    <%} %>

</body>
</html>