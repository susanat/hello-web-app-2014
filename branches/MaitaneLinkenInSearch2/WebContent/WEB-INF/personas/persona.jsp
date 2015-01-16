<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Persona</title>
</head>
<body>

<h1>Persona</h1>

<form action="personaServlet" method="post" name="Actualizar"></form>
 <table>
 <tr>
 <td>Nombre</td>
 <input type="text" name="isbn" value="" size="40"/>
 </tr>
 <tr>
 <td>Apellido</td>
 <input type="text" name="titulo" value="" size="50"/>
 </tr>
 <tr><td> Action </td>
 <td>
 <input type="radio" name="Action" value="Actualizar" /> Actualizar
 <input type="radio" name="Action" value="Eliminar" /> Eliminar
 <input type="radio" name="Action" value="Crear" checked /> Crear
 <input type="radio" name="Action" value="Seleccionar"  /> Seleccionar
 </td>
 </tr>
 <input type="SUBMIT" value="Accion" />
 </tr>
 </table>
 </form>
</body>
</html>