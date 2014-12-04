  <!-- Navigation -->
    <%@page import="com.ipartek.formacion.helloweb.Rol"%>
	<%@page import="com.ipartek.formacion.helloweb.bean.Persona"%>
	<%@page import="com.ipartek.formacion.helloweb.Constantes"%>
    <% 
		//recuperar usuario de session
		Persona p = (Persona) session.getAttribute(Constantes.USER_SESSION);
		if ((p == null) || (p.getRol() != Rol.ADMINISTRADOR)){
		    p = new Persona ("anonimo", 99, Rol.USUARIO);
		   
		    String root =  request.getContextPath();
		    response.sendRedirect( root + Constantes.JSP_LOGIN );   
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
                <a class="navbar-brand" href="<%=Constantes.JSP_BACK_INDEX %>">Backoffice  <%= p.getNombre() %> </a>
            </div>
            <!-- /.navbar-header -->

            <ul class="nav navbar-top-links navbar-right">
                <li >
                     <a href="<%=Constantes.PATH_LOGOUT %>" title="Cierra tu sesión">
                   	 	<i class="fa fa-sign-out fa-fw"></i>
                     	Cerrar sesión
                    </a>
                </li>
                <!-- /.dropdown -->
            </ul>
            <!-- /.navbar-top-links -->

            <div class="navbar-default sidebar" role="navigation">
                <div class="sidebar-nav navbar-collapse">
                    <ul class="nav" id="side-menu">
                        
                        <li>
                            <a href="<%=Constantes.CONTROLLER_PERSONA %>" class="active"  title="Gestionar Personas"> Persona</a>
                        </li>
                        
                    </ul>
                </div>
                <!-- /.sidebar-collapse -->
            </div>
            <!-- /.navbar-static-side -->
        </nav>

        <div id="page-wrapper">
        	<div class="row">
        		<%@include file="/includes/alerts.jsp" %>
        	</div>
        