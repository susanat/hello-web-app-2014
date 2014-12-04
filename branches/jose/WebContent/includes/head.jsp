<%@page import="com.ipartek.formacion.helloweb.Constantes"%>
<%@page errorPage="includes/error.jsp" %>

<!DOCTYPE html>
<html lang="es">
<head>
<title>BackOffice</title>

<!--  base para todos nuestros paths -->
<base href="<%=request.getContextPath() + "/"%>">

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<!-- Bootstrap Core CSS -->
<link href="<%=Constantes.JSP_BACKOFFICE%>css/bootstrap.min.css"
	rel="stylesheet">

<!-- Custom CSS -->
<link href="<%=Constantes.JSP_BACKOFFICE%>css/sb-admin-2.css"
	rel="stylesheet">

<!-- Custom Fonts -->
<link
	href="<%=Constantes.JSP_BACKOFFICE%>font-awesome-4.1.0/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">

<!-- dataTables -->
<link
	href="<%=Constantes.JSP_BACKOFFICE%>css/plugins/dataTables.bootstrap.css"
	rel="stylesheet" type="text/css">



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
		<nav class="navbar navbar-default navbar-static-top" role="navigation"
			style="margin-bottom: 0">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="index.html">BackOffice</a>
			</div>
			<!-- /.navbar-header -->

			<ul class="nav navbar-top-links navbar-right">
				<li><a href="<%=Constantes.PATH_LOGOUT%>"
					title="Cierra tu session"> <i class="fa fa-sign-out fa-fw"></i>
						Logout
				</a></li>
			</ul>