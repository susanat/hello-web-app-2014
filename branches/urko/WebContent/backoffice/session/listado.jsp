<%@page import="com.ipartek.formacion.helloweb.bean.Persona"%>
<%@include file="../includes/header.jsp" %>
<%@include file="../includes/menu.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
	//ArrayList<Persona> personas = (ArrayList<Persona>)request.getSession().getServletContext().getAttribute(Constante.ATT_REGISTERED_USERS);
%>
<c:set var="usuarios" value="usuarios"
    scope="application" />
	<table>
      <TH>nombre</th>
      <TH>Rol</th>
      <c:forEach items="${usuarios}" var="p">
        <tr>
        
          <td><c:out value="${p.nombre}" /><td>
          <td><c:out value="${p.rol.nombre}" /><td>
           
        </tr>
      </c:forEach>
    </table>
	
                   
       
	
	
<%@include file="../includes/footer.jsp" %>   