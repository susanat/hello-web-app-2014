<%@page import="com.ipartek.formacion.helloweb.util.Rol"%>
<%@page import="com.ipartek.formacion.helloweb.Constantes"%>
<%@page import="com.ipartek.formacion.helloweb.bean.Persona"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		//recuperar usuario de sesion
		Persona p = (Persona)session.getAttribute(Constantes.USER_SESSION);
		if((p == null) || !p.getRol().equals(Rol.ADMINISTRADOR)){
		   p = new Persona("anonimo", 99);
		   
		   response.setStatus(response.SC_UNAUTHORIZED);
		   response.sendRedirect(request.getContextPath() + "/" + Constantes.JSP_LOGIN);
		}
	%>
	<h1>Backoffice <%= p.getNombre() %> </h1>
	<br>
	<form action="${pageContext.request.contextPath}/LogoutServlet" method="post">
    <input type="submit" value="Logout" />
</form>
</body>
</html>