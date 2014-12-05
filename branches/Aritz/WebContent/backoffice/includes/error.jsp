<%@page import="com.ipartek.formacion.helloweb.Constantes"%>
<%@page isErrorPage="true"%>

<html><head>
		<title>Error</title>
	<link href="http://www.newspond.com/errors/error.css" rel="stylesheet" type="text/css"></head>
	
	
	
	<body id="e404">
	
	<div id="content2">
		<div id="wrapper">
			<h1 class="e404">Missing</h1>
			<h2>The page you were looking for could not be found.</h2>
			<a href="<%= request.getContextPath() + Constantes.JSP_LOGIN%>" class="gohome">Log in</a>
		</div>
	</div>
	
	
</body></html>