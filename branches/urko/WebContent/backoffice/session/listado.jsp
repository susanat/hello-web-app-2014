<%@page import="com.ipartek.formacion.helloweb.bean.Persona"%>
<%@include file="../includes/header.jsp" %>
<%@include file="../includes/menu.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
	ArrayList<Persona> personas = (ArrayList<Persona>)request.getSession().getServletContext().getAttribute(Constante.ATT_REGISTERED_USERS);

%>

<c:set var="users" value="<%=Constante.ATT_REGISTERED_USERS %>"
    scope="application" />
	<table>
	<thead>
		<tr>
      	<th>Nombre</th>
      	<th>Rol</th>
      </tr>
      </thead>
      <% for(Persona p: personas) { %>
        <tr>
        
          <td><c:out value="<%=p.getNombre() %>" /></td>
          <td><c:out value="<%=p.getRol().getNombre() %>" /></td>
           
        </tr>
     <% } %>
    </table>
	
                   
       
	
	
<%@include file="../includes/footer.jsp" %>   