 <%@page import="com.ipartek.formacion.helloweb.Constantes"%>
 
 <!-- Navigation -->      
<nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">${sessionScope.user_session.nombre } | ${sessionScope.user_session.rol }</a>
            </div>
            <!-- /.navbar-header -->

            <ul class="nav navbar-top-links navbar-right">
                <li>
                    <a href="#"><fmt:message key="menu.logout"></fmt:message></a>
                </li>
                <!-- /.dropdown -->
            </ul>
            <!-- /.navbar-top-links -->

            <div class="navbar-default sidebar" role="navigation">
                <div class="sidebar-nav navbar-collapse">
                    <ul class="nav" id="side-menu">                        
                        <li>
                            <a class="active" href="<%=Constantes.CONTROLLER_PERSONA%>" title="Gestionar Personas"><i class="fa fa-dashboard fa-fw"></i> Personas</a>
                        </li>   
                         <li>
                            <a class="active" href="<%=Constantes.CONTROLLER_IDIOMA%>" title="Gestionar Idiomas"><i class="fa fa-dashboard fa-fw"></i> Idiomas</a>
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
                    <h1 class="page-header">CAmbiar titulo</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            
            
            <!--  Mensajes para el Usuario -->
       		<div class="row">       			
				<%@include file="/includes/alerts.jsp" %>
       		</div>
            
            
            <!-- /.row -->
            <div class="row">