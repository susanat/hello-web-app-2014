<%@page import="com.ipartek.formacion.busredsociales.bean.Usuario"%>
<%@page import="java.util.List"%>
<%@page import="com.ipartek.formacion.busredsociales.comun.Constantes"%>

<%@include file="includes/head.jsp" %>


<a href="index.jsp">Nueva búsqueda</a>


	<jsp:include page="ficha.jsp" >
		<jsp:param name="showid" value="1"/>
		<jsp:param name="showButtonDelete" value="1"/>
		<jsp:param name="showButtonSave" value="1"/>
	</jsp:include>



<a href="index.jsp">Nueva búsqueda</a>

<%@include file="includes/footer.jsp" %>

