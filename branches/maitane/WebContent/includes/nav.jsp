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
                    <a href="<%=Constantes.PATH_LOGOUT%>"><fmt:message key="menu.logout"></fmt:message></a>
                </li>
                <!-- /.dropdown -->
            </ul>
            <!-- /.navbar-top-links -->
            
               <!-- /.navbar-header -->
<!-- 
            <ul class="nav navbar-top-links navbar-right">
                <li >
                 <a href="<%=Constantes.PATH_LOGOUT%>" title="Cierra tu seccion" class= navbar-right>  <fmt:message key="menu.logout"></fmt:message></a>
                </li>
            </ul>
             -->
            <!-- /.navbar-top-links -->
         

            <div class="navbar-default sidebar" role="navigation">
                <div class="sidebar-nav navbar-collapse">
                    <ul class="nav" id="side-menu">
                        <li>
                        
                            <a class="active" href="<%=Constantes.CONTROLLER_PERSONA %>"title="Gestionar Personas"> Personas</a>
                            <a class="active" href="<%=Constantes.CONTROLLER_CALIFICACION %>"title="Gestionar Calificaciones"> Calificaciones</a>
                             <a class="active" href="<%=Constantes.CONTROLLER_USUARIOS %>"title="Gestionar Usuarios"> Usuarios conectados</a>
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
                    <h1 class="page-header">Cambiar titulo</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            
            <!-- Mensajes para usuario -->
          <div class="row">
         	<%@include file="/includes/alerts.jsp" %>
         </div>
            <!-- /.row -->
            
            
            <div class="row">