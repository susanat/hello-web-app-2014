     <!-- Navigation -->
        <%@page import="com.ipartek.formacion.helloweb.util.Rol"%>
		<%@page import="com.ipartek.formacion.helloweb.bean.Persona"%>
		<%@page import="com.ipartek.formacion.helloweb.Constantes"%>
	
		<%
			String root = request.getContextPath() + "/";
			Persona pUser = (Persona) session.getAttribute(Constantes.USER_SESSION);
			
			if (pUser == null || pUser.getRol() != Rol.ADMINISTRADOR) {
				request.setAttribute(Constantes.MSG_KEY, Constantes.MSG_NO_AUTORIZADO);
				response.sendRedirect(root + Constantes.CONTROLLER_LOGIN);
			}
		%>
        
		<nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="backoffice/index.jsp">BackOffice - <%=pUser.getNombre()%></a>
            </div>
            <!-- /.navbar-header -->

            <ul class="nav navbar-top-links navbar-right">
            	<li><a href="<%=root + Constantes.CONTROLLER_LOGOUT%>"><i class="fa fa-sign-out fa-fw"></i> Logout</a></li>
            </ul>
            <!-- /.navbar-top-links -->

            <div class="navbar-default sidebar" role="navigation">
                <div class="sidebar-nav navbar-collapse">
                    <ul class="nav" id="side-menu">
                        <li>
                            <a class="active" href="<%=Constantes.CONTROLLER_PERSONA%>" title="Gestionar Personas"><i class="fa fa-dashboard fa-fw"></i> Personas</a>
                        </li>                                     
                    </ul>
                </div>
                <!-- /.sidebar-collapse -->
            </div>
            <!-- /.navbar-static-side -->
        </nav>       
         
        <div id="page-wrapper">   
            
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header" id="contentHeader">Cambiar Título</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            
            <div class"">
	            <%@include file="/includes/alert.jsp"%>
            </div>
            
            <div class="row">