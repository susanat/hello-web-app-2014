<!DOCTYPE html>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ipartek.formacion.helloweb.bean.Persona"%>
<%@page import="com.ipartek.formacion.helloweb.Constantes"%>
<html lang="es">

<%
		//recoger attributo de Persona		
		Persona p = (Persona)request.getAttribute(Constantes.ATT_PERSONA);
		//inicializar variables para el formulario
		String cabecera = "Crear nueva Persona";
		String buttonValue = "Crear";
		String op = Constantes.OP_UPDATE;
		boolean isNew = false;
		
		//nueva persona				
		if ( p == null ){
			p = new Persona("");
			isNew = true;
			op = Constantes.OP_CREATE;
		//modificar persona	
		}else{
			cabecera = "Modificar " + p.getNombre();
			buttonValue = "Modificar";
		}
%>    

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>BackOffice</title>

    <!-- Bootstrap Core CSS -->
    <link href="<%=request.getContextPath()+'/'+Constantes.JSP_BACKOFFICE%>/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="<%=request.getContextPath()+'/'+Constantes.JSP_BACKOFFICE%>/css/sb-admin-2.css" rel="stylesheet">

   
    <!-- Custom Fonts -->
    <link href="<%=request.getContextPath()+'/'+Constantes.JSP_BACKOFFICE%>/font-awesome-4.1.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">

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
                <a class="navbar-brand" href="index.html">Hola <%=request.getParameter(Constantes.PARAMETRO_USER)%></a>
            </div>
            <!-- /.navbar-header -->

            <ul class="nav navbar-top-links navbar-right">
                <li>
                    <a href="<%=request.getContextPath()+'/'+Constantes.JSP_LOGOUT%>">[x] Desconectar</a>
                </li>
                <!-- /.dropdown -->
            </ul>
            <!-- /.navbar-top-links -->

            <div class="navbar-default sidebar" role="navigation">
                <div class="sidebar-nav navbar-collapse">
                    <ul class="nav" id="side-menu">                        
                        <li>
                            <a class="active" href="<%=request.getContextPath()+'/'+Constantes.CONTROLLER_PERSONA%>"><i class="fa fa-dashboard fa-fw"></i> Personas</a>
                        </li>                       
                    </ul>
                </div>
                <!-- /.sidebar-collapse -->
            </div>
            <!-- /.navbar-static-side -->
        </nav>

        <div id="page-wrapper">
            
	<%@include file="/includes/alerts.jsp" %>

	<h1><%=cabecera%></h1>
	<h2><a href="<%=request.getContextPath()+"/"+Constantes.CONTROLLER_PERSONA%>">volver</a></h2>
	
	<form action="<%=request.getContextPath()+"/"+Constantes.CONTROLLER_PERSONA%>" method="post">
	
		<input type="text"    name="id" readonly value="<%=p.getId()%>">
		<br>		
		<input type="text"    name="name" value="<%=p.getNombre()%>">
		<br>
		<input type="number" name="edad" value="<%=p.getEdad()%>">
		<br>
		<input type="text"    name="rol" disabled value="<%=p.getRol()%>">
		<br>		
		<input type="hidden" name="<%=Constantes.OP_KEY%>" value="<%=op%>">	
		
		<input type="submit" class="btn btn-success" value="<%=buttonValue%>" >	
	
	</form>
	
	<% if ( !isNew) { %>	
		<form action="<%=request.getContextPath()+"/"+Constantes.CONTROLLER_PERSONA%>" method="post">
			<input type="hidden"  name="id"  value="<%=p.getId()%>">
			<input type="hidden" name="<%=Constantes.OP_KEY%>" value="<%=Constantes.OP_DELETE%>">
			<input type="submit" class="btn btn-danger" value="Eliminar" >	
		</form>
	<% } %>	
            
            
            
            
            
            
            <!-- /.row -->
        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->

    <!-- jQuery Version 1.11.0 -->
    <script src="<%=request.getContextPath()+'/'+Constantes.JSP_BACKOFFICE%>/js/jquery-1.11.0.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="<%=request.getContextPath()+'/'+Constantes.JSP_BACKOFFICE%>/js/bootstrap.min.js"></script>


    <!-- Custom Theme JavaScript -->
    <script src="<%=request.getContextPath()+'/'+Constantes.JSP_BACKOFFICE%>/js/sb-admin-2.js"></script>

</body>

</html>















