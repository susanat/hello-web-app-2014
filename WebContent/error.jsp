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
		<div class="panel-heading">Error</div>
		<div class="panel-body">
			<p>Vaya, parece que hay algun problema. Lo sentimos.</p>
		</div>
		<!-- /.panel-body -->
	</div>
	<!-- /.panel -->
</div>
<!-- /.panel-body -->

<%@include file="includes/footer.jsp"%>