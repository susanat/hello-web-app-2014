<%@include file="/includes/head.jsp" %>
<%@include file="/includes/nav.jsp" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


  <h2>Usuarios Activos</h2>
  <ul>
  	<li><span class="glyphicon glyphicon-user" aria-hidden="true"></span><b>ADMINISTADORES:</b> <%= getServletContext().getAttribute(Constantes.USER_ADMIN_CONT) %></li>
  	<li><span class="glyphicon glyphicon-user" aria-hidden="true"></span><b>USUARIOS:</b> ${applicationScope.cont_user}</li>
  </ul>
          


    <%@include file="/includes/footer.jsp" %>