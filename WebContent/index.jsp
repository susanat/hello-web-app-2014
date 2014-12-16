<!DOCTYPE html>
<%@page import="com.ipartek.formacion.helloweb.bean.Persona"%>
<html>
<head>
	<base href="<%=request.getContextPath()+"/"%>">
	<meta charset="utf-8">
	<title>Hello World!</title>
</head>
<body>
	<h1>Hello World!</h1>
	<div><% out.print("Hello World"); %></div>
	
	<div>
		<%
			for(int i = 1; i < 7; i++){
			    out.print("<h"+i+">"+"Cabezera "+i+"</h"+i+">");
			}
		Persona p = new Persona();
		
		%>
		Nombre: <%=p.getNombre() %>
	</div>
	<div>Saludos, pincha  para iniciar <a href="login.jsp">aqui</a></div>
</body>
</html>