<%@page import="ipt.fm.ipartek.test.linkedin.bean.Persona"%>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>LinkedIn Search</title>
<!-- Bootstrap Core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/styleLinkedin.css" rel="stylesheet">

</head>
<body>
	<h1>LinkedIn Search</h1>


	<div class="container">

		<%
			ArrayList<Persona> personas = (ArrayList<Persona>) request
					.getAttribute("personas");
			if (personas != null) {
		%>
		<table id="tabla" cellspacing="0" width="100%">
			<thead>
				<tr>
					<th>id</th>
					<th>Nombre</th>
					<th>Apellidos</th>
					<th>Foto</th>
					<th>
						<!-- Operacion para Eliminar -->
					</th>
				</tr>
			</thead>

			<tbody>
				<%
					for (int i = 0; i < personas.size(); i++) {
				%>

				<tr>
					<td><a
						href="<%="PersonaServlet.do?id=" + personas.get(i).getId()%>"> <%=personas.get(i).getId()%></a></td>
					<td><%=personas.get(i).getNombre()%></td>
					<td><%=personas.get(i).getApellidos()%></td>
					<td></td>
					<td>
						<form action='PersonaServlet.do' method='post'>
							<input type='hidden' name='id'
								value='<%=personas.get(i).getId()%>'> <input
								type='submit' class="btn btn-outline btn-danger btn-xs"
								name='action' value='borrar'>
						</form>
					</td>
				</tr>
				<%
					}
				%>
			</tbody>
		</table>
		<%
			}
		%>
	</div>

</body>
</html>