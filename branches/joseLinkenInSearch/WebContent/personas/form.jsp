<%@page import="ipt.fm.ipartek.test.linkedin.bean.Persona"%>
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
		Persona p = (Persona) request.getAttribute("persona");
	%>
	<h1>LinkedIn Search</h1>


	<div class="container col-lg-6">
		<form action="PersonaServlet" method="post" role="form">

			<div class="form-group">
				<label>Id</label> <input type="text" name="id" readonly
					value="<%=p.getId()%>" class="form-control">
			</div>

			<div class="form-group">
				<label>Nombre</label> <input type="text" name="nombre"
					value="<%=p.getNombre()%>" class="form-control">
			</div>

			<div class="form-group">
				<label>Apellidos</label> <input type="text" name="apellidos"
					value="<%=p.getApellidos()%>" class="form-control">
			</div>
			<div class="form-group">
				<input type="submit" name="action" value="guardar"
					class="form-control">
			</div>			
		</form>
	</div>
</body>
</html>