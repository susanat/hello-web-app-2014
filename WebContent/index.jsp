<!DOCTYPE html>
<%@page import="com.ipartek.formacion.helloweb.bean.Persona"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hello World</title>
</head>
<body>
Hello World 222!!


<% for (int i=0; i<=6; i++){
	out.println("<h" + i + ">Cabecera" + i + "</h" + i + ">");
	}

	Persona p = new Persona("Pepe", 89);
	out.print("Nombre: " + p.getNombre());
	 %>
	 
	 <form class="formulario" >
	 	<label for="text">Texto</label>
	 	<input type="text" id="text">
	 	<input type="submit" value="enviar">
	 </form>
	 
	 <form method="post" action="RecuperacionUsuario">
Ingrese nombre de usuario:
<input type="text" name="usuario" size="20"><br>
Ingrese clave:
<input type="password" name="clave" size="20"><br>
<input type="submit" value="confirmar">
</form>
	
</body>
</html>