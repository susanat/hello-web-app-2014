<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>LinkedIn Search</title>
</head>
<body>

<h1>LinkedIn Search</h1>


${requestScope.personas}
<%
out.println("<form action='PersonaServlet' method='post'>");
out.println("<input type='text' name='cmd' value='list' hidden>");
out.println("<input type='submit' value='Ver Todos'>");
out.println("</form>");
%>

<form action="searchProfile" method="post">
	
	<input type="text" name="first" placeholder="Nombre" required>
	<br>
	<input type="text" name="last" placeholder="Apellidos" required>
	<br>
	<input type="submit" value="buscar">	
</form>

${requestScope.resulthtml}


</body>
</html>