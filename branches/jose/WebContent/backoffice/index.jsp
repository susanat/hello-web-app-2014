<%@page import="com.ipartek.formacion.helloweb.bean.Persona"%>

<%
	//recuperar el usuario de session
	Persona p = (Persona) session.getAttribute(Constantes.USER_SESSION);
	// variable para saber si el usuario es administrador
	boolean esAdministrador = true;
	// Comprueba que exista la session
	if (p == null) {
		esAdministrador = false;
	} else {
		// Comprueba que el usuario sea administrador
		esAdministrador = Persona.Rol.ADMINISTRADOR.equals(p.getRol());
	}

	//en caso de que no sea administrador
	if (!esAdministrador) {
		response.setStatus(response.SC_UNAUTHORIZED);
		//String root = request.getSession().getServletContext().getRealPath("/");
		//String root = request.getContextPath();
		String root = request.getHeader("referer");
		response.sendRedirect(root + Constantes.JSP_LOGIN);
	}
%>
<!DOCTYPE html>

<html lang="es">

<head>
<title>BackOffice</title>



<%@include file="/includes/head.jsp"%>
<%@include file="/includes/nav.jsp"%>


<!-- 
<div id="page-wrapper">
	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">Usuarios</h1>
		</div>
		<!-- /.col-lg-12 -->
	<!-- 	
	</div>
	<!-- /.row -->
<!-- 	
</div>
<!-- /#page-wrapper -->


<%@include file="/includes/footer.jsp"%>
