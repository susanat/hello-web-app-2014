        <!-- Navigation -->
        <%@page import="com.ipartek.formacion.helloweb.constantes.Constantes"%> 
        
<nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="<%=Constantes.JSP_BACKOFFICE %>/index.jsp">BackOffice</a>
            </div>
            <!-- /.navbar-header -->

			<div class="nav navbar-right">
                <a href="<%=Constantes.PATH_LOGOUT%>">[x] - <fmt:message key="menu.logout"></fmt:message></a>
            </div>

            <div class="navbar-default sidebar" role="navigation">
                <div class="sidebar-nav navbar-collapse">
                    <ul class="nav" id="side-menu">
                        <li>
                            <a class="active" href="<%=Constantes.CONTROLLER_PERSONA%>"><fmt:message key="backoffice.nav.persona"></fmt:message></a>
                        </li>
                        <li>
                            <a href="#"><fmt:message key="backoffice.nav.calificacion"></fmt:message></a>
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
                    <h1 class="page-header">Backoffice</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>