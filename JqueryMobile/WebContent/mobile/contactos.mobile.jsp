<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<base href="http://localhost:8080/JqueryMobile/mobile/">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<!-- Etiqueta para response design -->
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Listado de contactos</title>


<!-- Includes -->

<!-- MetisMenu CSS -->
<link href="css/jquery.mobile-1.4.2.css" rel="stylesheet">
<link href="js/jquery.mobile.theme-1.4.2.css" rel="stylesheet">

<!-- jQuery Version 1.11.0 -->
<script src="js/jquery-1.11.0.js"></script>
<script src="js/jquery.mobile-1.4.2.js"></script>

<!-- https://github.com/browserstate/history.js -->
<script src="js/jquery.history.js"></script>


</head>
<body>
	<!-- Estructura básica página jquery -->
	<div data-role="page" data-title="Listado de contactos" id="listaContactos">
		<header data-role="header">		
			<h1>Listado de contactos</h1>
		</header>	
		
		<section data-role="content">
			<ul data-role="listview" data-filter="true">
				<%
					for (int i=0; i<12; i++) {						
						%> 
						<li>
							<a href="#detalle" data-rel="dialog">
								<img src="css/images/ajax-loader.gif"></img>
								<h2>Contacto <%=i %></h2>
								<p>
									Mov.: 666.444.555
								</p>
							</a> 
						</li> <%
					}				
				%>			
			</ul>				
		</section>	
	
		<footer data-role="footer">
			<a href="index.mobile.jsp">Home</a>			
			<i>Pie</i>			
		</footer>	
	</div>
	
	<div data-role="page" data-title="Detalle" id="detalle">
		<header data-role="header">		
			<h1>Detalle persona</h1>
		</header>	
		
		<section data-role="content">
						
		</section>	
	
		<footer data-role="footer">			
			<a href="#listaContactos">Aceptar</a>			
			<i>Pie</i>			
		</footer>	
	</div>		
	
	
	
</body>
</html>