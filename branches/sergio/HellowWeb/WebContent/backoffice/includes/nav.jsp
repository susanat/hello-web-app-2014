<%@page import="com.ipartek.formacion.helloweb.bean.Persona"%>
<%@page import="com.ipartek.formacion.helloweb.temp.UtilsTemp"%>
<%@page import="com.ipartek.formacion.helloweb.comun.Constantes"%>

<% Persona persona = UtilsTemp.getAuthenticated(session); %>


 <!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
           
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="<%=Constantes.JSP_BACK_ADMIN %>">
                	<%= "Falta poner algo" %>                	
                </a>
                
            </div>
            <!-- /.navbar-header -->
            

			<!-- Iconos de navegación a la derecha de la barra superior -->
            <ul class="nav navbar-top-links navbar-right">
                
                
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-user fa-fw"></i>  <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-user">
                        <li>
                        	<a href="#">
                        		<i class="fa fa-user fa-fw"></i> 
                        		<%
                        		if(persona != null) {
                        			out.print(persona.getNombre());
                        		}
                        		%> Profile
                        	</a>
                        </li>
                        <li><a href="#"><i class="fa fa-gear fa-fw"></i> Settings</a>
                        </li>
                        <li class="divider"></li>
                        <li>
                        	<a href="<%=Constantes.PATH_SITE + Constantes.CONTROLLER_LOG_OUT %>">
                        		<i class="fa fa-sign-out fa-fw"></i> 
                        		Logout
                        	</a>
                        </li>
                    </ul>
                    <!-- /.dropdown-user -->
                </li>
                <!-- /.dropdown -->
                
                <!-- Combo para el ididoma -->
				<li style="padding-top: 10px;">
					<form role="form" method="post">
						<select class="form-control" id="language" name="language"
							onchange="submit()" style="color: gray; background-color: black;">
							<option style="background-color: white;" value="es_ES"
								${language == 'es_ES' ? 'selected' : ''}>Español</option>
							<option style="background-color: white;" value="en_GB"
								${language == 'en_GB' ? 'selected' : ''}>English</option>
							<option style="background-color: white;" value="es_EU"
								${language == 'es_EU' ? 'selected' : ''}>Euskera</option>
						</select>
					</form>
				</li>
            </ul>
            <!-- /.navbar-top-links -->
			<!-- FIN Iconos de navegación a la derecha de la barra superior -->


            <%@include file="nav_sidebar.jsp"%>
        </nav>
        
        
        <div id="page-wrapper"> <!-- Inicio content -->