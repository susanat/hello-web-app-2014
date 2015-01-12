<%@page import="com.ipartek.formacion.buscarpersonas.util.Constantes"%>
<form action="<%=Constantes.SEARCH_SERVLET %>" method="post">
	<input type="text" name="<%=Constantes.PARAM_NAME %>" placeholder="Nombre">
	<input type="text" name="<%=Constantes.PARAM_SURNAME %>" placeholder="Primer Apellido">
	<input type="submit" value="Enviar">
</form>