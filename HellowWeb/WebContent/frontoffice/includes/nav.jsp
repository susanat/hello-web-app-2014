<!-- https://jstl.java.net/ -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@page import="com.ipartek.formacion.helloweb.comun.Constantes"%>


    <!-- Navigation -->
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">Start Bootstrap</a>
            </div>

			<!-- Menu a la derecha de la barra de navegación -->
			<ul class="nav navbar-nav navbar-right">
				
				<!-- Si no está autentificado -->
				<c:if test="${isAuthenticated == false}">
					<!-- boton de registro -->
					<li id="nav-register-btn" class="">
						<a href="http://bootsnipp.com/register">
							<fmt:message key="page.register" />
						</a>
					</li>
					
					

					<!-- boton de login -->
					<li id="nav-login-btn" class=""><a href="<%=Constantes.JSP_LOGIN%>">
						<i class="icon-login"></i>
							<fmt:message key="page.login" />
						</a>
					</li>
				</c:if>

				<!-- si está autentificado -->
				<c:if test="${isAuthenticated == true}">
					<!-- Combo de usuario -->
					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#"> <i class="fa fa-user fa-fw"></i>
							<i class="fa fa-caret-down"></i>
					</a>
						<ul class="dropdown-menu dropdown-user">
							<li><a href="#"> <i class="fa fa-user fa-fw"></i> Nombre
									Usuario Profile
							</a></li>
							<li><a href="#"><i class="fa fa-gear fa-fw"></i>
									Settings</a></li>
							<li class="divider"></li>
							<li><a
								href="<%=Constantes.PATH_SITE + Constantes.CONTROLLER_LOG_OUT%>">
									<i class="fa fa-sign-out fa-fw"></i> Logout
							</a></li>
						</ul> <!-- /.dropdown-user --></li>
					<!-- /.dropdown -->
				</c:if>

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

			<!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                	<li>
                        <a href="<%=Constantes.PATH_SITE%>blog.jsp">Blog</a>
                    </li>
                    <li>
                    	<a href="<%=Constantes.PATH_SITE%>snippets.jsp">Snippets</a>
                    </li>
                    <li>
                        <a href="<%=Constantes.PATH_SITE%>pruebas.jsp">Pruebas</a>
                    </li>
                    <li>
                        <a href="#">About</a>
                    </li>
                    <li>
                        <a href="#">Services</a>
                    </li>
                    <li>
                        <a href="#">Contact</a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
            
            
            
        </div>
        <!-- /.container -->
    </nav>

<!-- Page Content -->
    <div class="container">
    	<div class="row">