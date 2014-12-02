<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html>
<%@page import="com.ipartek.formacion.helloworld.bean.Persona"%>
<html>
<head>
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
		<c:out value="<br>  Nombre: ${p.nombre}" escapeXml="false" default="la expresión fallo"/>
		<c:out value="${pageContext.request.requestURL}"/>
	</div>
	<div>Saludos, pincha  para iniciar <a href="login.jsp">aqui</a></div>
</body>
</html>