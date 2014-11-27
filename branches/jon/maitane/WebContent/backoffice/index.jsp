<%@page import="com.ipartek.formacion.helloweb.Constantes"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Administracion</title>
</head>
<body>
<h1>Administracion</h1>
<form action=<%=Constantes.JSP_LOGIN %> method="post"> 
  
   
    <input type="submit" name="logout" class="login login-submit" value="logout">
  </form>

</body>
</html>