<%@page import="com.ipartek.formacion.helloweb.Rol"%>
<%@page import="com.ipartek.formacion.helloweb.bean.Persona"%>
<%@page import="com.ipartek.formacion.helloweb.Constantes"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
	<% 
		//recuperar usuario de session
		Persona p = (Persona) session.getAttribute(Constantes.USER_SESSION);
		if ((p == null) || (p.getRol() != Rol.ADMINISTRADOR)){
		    p = new Persona ("anonimo", 99, Rol.USUARIO);
		   
		    String root =  request.getContextPath();
		    response.sendRedirect( root + Constantes.JSP_LOGIN );   
		}
		
	%>

<!DOCTYPE html>
<%@page import="com.ipartek.formacion.helloweb.Constantes"%>
<html lang="es">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Backoffice</title>

    <!-- Bootstrap Core CSS -->
    <link href="<%=Constantes.BACKOFFICE_FOLDER %>/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="<%=Constantes.BACKOFFICE_FOLDER %>/css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="<%=Constantes.BACKOFFICE_FOLDER %>/font-awesome-4.1.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

    <div id="wrapper">

        <!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.html">Backoffice  <%= p.getNombre() %> </a>
            </div>
            <!-- /.navbar-header -->

            <ul class="nav navbar-top-links navbar-right">
                <li >
                    <a href="<%=Constantes.PATH_LOGOUT %>" title="Cierra tu sesión">
                         [x] Cerrar sesión
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
            
        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->

    <!-- jQuery -->
    <script src="<%=Constantes.BACKOFFICE_FOLDER %>js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="<%=Constantes.BACKOFFICE_FOLDER %>js/bootstrap.min.js"></script>


    <!-- Custom Theme JavaScript -->
    <script src="<%=Constantes.BACKOFFICE_FOLDER %>js/sb-admin-2.js"></script>

</body>

</html>
