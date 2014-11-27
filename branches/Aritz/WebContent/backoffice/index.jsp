<!doctype html>

<%@page import="com.ipartek.formacion.bean.Persona"%>
<%@page import="com.ipartek.formacion.helloweb.Constantes"%>

<html lang="es">
<head>
  <meta charset="utf-8">

  <title>The HTML5 Herald</title>
  <meta name="description" content="">
  <meta name="author" content="">

  <link rel="stylesheet" href="css/styles.css?v=1.0">

 
</head>

<body>
	
	<%
		//recuperar usuario de sesion
		Persona p = (Persona)session.getAttribute(Constantes.USER_SESSION);
	
		if(p !=(Persona)session.getAttribute(Constantes.USER_ADMIN)){
					
			String root = request.getSession().getServletContext().getRealPath("/");
			response.sendRedirect(root + Constantes.JSP_LOGIN);
				
		}
	
	
	 %>
  <h1>Hello <%= p.getNombre() %></h1>
  
  out.print( "Has entrado como  " + p.getNombre());
  <input type="button" name="logout" class="login login-submit" value="logout">
 
</body>
</html>