<%@page import="com.ipartek.formacion.helloweb.bean.Persona"%>
<%@page import="com.ipartek.formacion.helloweb.Constantes"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

  <%
  Persona p=(Persona)session.getAttribute(Constantes.USER_SESSION);

if((p==null)||(p.getRol()!=Persona.Rol.ADMINISTRADOR)){
	p=new Persona("anonimo",99);
	String root= request.getContextPath();
	response.sendRedirect(root+"/"+Constantes.JSP_LOGIN);
	//response.sendRedirect(Constantes.LOGIN);
	
}%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Backoffice</title>
</head>
<body>
<h1>Backoffice</h1>
<h2>Ongi Etorri Adminitrador</h2>
<form action=<%=Constantes.PATH_LOGOUT %> method="post">    
    <input type="submit" name="logout" class="logout logout-submit" value="logout">
  </form>

<nav>
<h3>Menu Administracion</h3>
<ul>
<li><a href="<%=Constantes.CONTROLLER_PERSONA %>" title="Gestionar Personas">Personas</a></li>

</ul>
</nav>

</body>
</html>