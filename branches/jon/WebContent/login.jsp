<%@page import="com.ipartek.formacion.helloweb.Constantes"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>login</title>
</head>
<body>

<form action="<%=Constantes.PATH_LOGIN%>" method="post">
<%
	if(request.getAttribute(Constantes.MSG_KEY)!=null){
		out.print("<p>"+request.getAttribute(Constantes.MSG_KEY)+"</p>");
	}
%>
<label for="<%=Constantes.PARAMETRO_USER%>>">user:</label>
<input id="<%=Constantes.PARAMETRO_USER%>" name="<%=Constantes.PARAMETRO_USER%>" type="text"/>
<label for="<%=Constantes.PARAMETRO_PASS%>">password:</label>
<input id="<%=Constantes.PARAMETRO_PASS%>" name="<%=Constantes.PARAMETRO_PASS%>" type="password"/>
<input type="submit" value="enviar"/>
</form>
</body>
</html>