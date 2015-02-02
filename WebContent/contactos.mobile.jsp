<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name=viewport content="width=device-width, initial-scale=1">
	<title>Listado de Contactos</title>
	
	<!-- includes de lo necesario para que funcione JqueryMobile -->
	
	
	<link rel="stylesheet" href="mobile/jquery.mobile-1.4.2.min.css">
	<link rel="stylesheet" href="mobile/jquery.mobile.theme-1.4.2.min.css">
	
	<script type="text/javascript" src="mobile/jquery.js"></script>
	<script type="text/javascript" src="mobile/jquery.mobile-1.4.2.min.js"></script>
	
</head>


<body>

	<!-- estructura basica de una pagina Jquery -->	
	<div data-role="page" id="contactos" data-title="Listado de Contactos">
	
		<div data-role="header">
			<h1>Listado de Contactos</h1>
		</div>
	
		<div data-role="content">
				
				<ul data-role="listview" data-filter="true" >
					<% for ( int i=0; i < 100 ; i++){ %>
						<li><a href="#detalle" data-rel="dialog" >
							<img src="http://d1bvpoagx8hqbg.cloudfront.net/75_75/mantener-contacto-fdeb533054c25d6f1ebf85bb40ab9b0a.jpg" />
							<h2>Contacto <%=i%></h2>
							<p>666.555.444</p>
							</a>
						</li>
					<% } %>	
				</ul>
							
		</div>
	
	</div>	
	
	
	<!--  DEtalle del Contacto, deberia haberse maquetado por separado -->
	<div data-role="page" id="detalle" data-title="Listado de Contactos">
	
		<div data-role="header">
			<h1>DEtalle Persona</h1>
		</div>
	
		<div data-role="content">
				Nombre: Contacto Mariano
				Apellido: Gurrutxaga
				Edad: 45
				bblls fdlsf
				dsfdsfdsfs
				dsfdsfdsf			
		</div>
	
	</div>	
	
</body>

</html>