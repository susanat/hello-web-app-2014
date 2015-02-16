<%@page import="com.ipartek.formacion.agenda.bean.PruebasListaPersonas"%>
<%@page import="com.ipartek.formacion.agenda.modelo.dao.DAOFactory"%>
<%@page import="com.ipartek.formacion.agenda.modelo.dao.IPersonaDAO"%>
<%@page import="com.ipartek.formacion.agenda.bean.Persona"%>
<%@page import="com.ipartek.formacion.agenda.Constantes"%>
<%@page import="java.util.ArrayList"%>


<jsp:include page="includes/head.jsp">
	<jsp:param value="Error" name="titulo" />
</jsp:include>


<div class="panel-body">
	<div class="panel panel-default">
		<div class="panel-heading">Error 404</div>
		<div class="panel-body">
			<p>Vaya, parece que la página que buscas no existe. Revisa la URL</p>
			<img alt="error 404" src="images/error.jpg" id="error">
		</div>
		<!-- /.panel-body -->
	</div>
	<!-- /.panel -->
</div>
<!-- /.panel-body -->

<%@include file="includes/footer.jsp"%>