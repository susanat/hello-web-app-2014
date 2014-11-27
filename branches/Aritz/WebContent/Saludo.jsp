<%@page import="com.ipartek.formacion.bean.Persona"%>
<%@page import="com.ipartek.formacion.helloweb.Constantes"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Saludo</title>
</head>
<body>
	
	<%
		//recuperar usuario de sesion
		Persona p = (Persona)session.getAttribute(Constantes.USER_SESSION);
		
		if(p == null){
			p = new Persona("Anonimo",99);
			
			String root = request.getSession().getServletContext().getRealPath("/");
			response.sendRedirect(root + Constantes.JSP_LOGIN);
					
		}
	
	%>

	<h1>Mongi etorri <%= p.getNombre() %></h1>
	
	<input type="button" name="logout" class="login login-submit" value="logout">
</body>
</html>