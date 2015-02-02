<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name=viewport content="width=device-width, initial-scale=1">
	<title>Pruebas con Jquery Mobile</title>
	
	<!-- includes de lo necesario para que funcione JqueryMobile -->
	
	
	<link rel="stylesheet" href="mobile/jquery.mobile-1.4.2.min.css">
	<link rel="stylesheet" href="mobile/jquery.mobile.theme-1.4.2.min.css">
	
	<script type="text/javascript" src="mobile/jquery.js"></script>
	<script type="text/javascript" src="mobile/jquery.mobile-1.4.2.min.js"></script>
	
</head>


<body>

	<!-- estructura basica de una pagina Jquery -->	
	<div data-role="page" id="home" data-title="WElcome">
	
		<div data-role="header">
			<h1>Home</h1>
		</div>
	
		<div data-role="content">
			
			<!-- enlace para ventana modal o de Dialog -->
			<a href="#cookies" data-rel="dialog"> Politica de Cookies</a> 
			
			
			<a href="contactos.mobile.jsp">Contactos</a>
			
			<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin lectus justo, porta non volutpat a, hendrerit eu tellus. Donec quis posuere velit. Ut sit amet justo vitae arcu semper egestas tincidunt nec elit. Etiam vulputate mi dictum, ultrices diam at, cursus ligula. Nulla non urna malesuada, dictum sem in, posuere est. Morbi vehicula sit amet ante quis venenatis. Morbi auctor ac diam vitae laoreet. Nullam turpis tortor, malesuada et auctor id, viverra vitae ante. Ut aliquam est ut leo consectetur dapibus. Mauris eu aliquam metus, et vehicula lacus. Etiam non massa tortor. Donec luctus arcu et leo dapibus, eu fringilla lacus pellentesque. </p>
		</div>
	
		<div data-role="footer">
			<a href="#pagina2">Politica Privacidad</a>
			<a href="#pagina3">Sobre Nosotros</a>
			<i> 2015 Pruebas Jquery Mobile</i>
		</div>
	
	</div>	
	
	
	<!-- Pagina 2 -->
	<div data-role="page" id="pagina2" data-title="Pagina2">
	
		<div data-role="header">
			<h1>Politica Privacidad</h1>
		</div>
	
		<div data-role="content">
			<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin lectus justo, porta non volutpat a, hendrerit eu tellus. Donec quis posuere velit. Ut sit amet justo vitae arcu semper egestas tincidunt nec elit. Etiam vulputate mi dictum, ultrices diam at, cursus ligula. Nulla non urna malesuada, dictum sem in, posuere est. Morbi vehicula sit amet ante quis venenatis. Morbi auctor ac diam vitae laoreet. Nullam turpis tortor, malesuada et auctor id, viverra vitae ante. Ut aliquam est ut leo consectetur dapibus. Mauris eu aliquam metus, et vehicula lacus. Etiam non massa tortor. Donec luctus arcu et leo dapibus, eu fringilla lacus pellentesque. </p>
		</div>
	
		<div data-role="footer">
			<i> 2015 Pruebas Jquery Mobile</i>
		</div>
	
	</div>
	
	
	<!-- Pagina 3 -->
	<div data-role="page" id="pagina3" data-title="Pagina3">
	
		<div data-role="header">
			<h1>Sobre Nosotros</h1>
		</div>
	
		<div data-role="content">
			<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin lectus justo, porta non volutpat a, hendrerit eu tellus. Donec quis posuere velit. Ut sit amet justo vitae arcu semper egestas tincidunt nec elit. Etiam vulputate mi dictum, ultrices diam at, cursus ligula. Nulla non urna malesuada, dictum sem in, posuere est. Morbi vehicula sit amet ante quis venenatis. Morbi auctor ac diam vitae laoreet. Nullam turpis tortor, malesuada et auctor id, viverra vitae ante. Ut aliquam est ut leo consectetur dapibus. Mauris eu aliquam metus, et vehicula lacus. Etiam non massa tortor. Donec luctus arcu et leo dapibus, eu fringilla lacus pellentesque. </p>
			<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin lectus justo, porta non volutpat a, hendrerit eu tellus. Donec quis posuere velit. Ut sit amet justo vitae arcu semper egestas tincidunt nec elit. Etiam vulputate mi dictum, ultrices diam at, cursus ligula. Nulla non urna malesuada, dictum sem in, posuere est. Morbi vehicula sit amet ante quis venenatis. Morbi auctor ac diam vitae laoreet. Nullam turpis tortor, malesuada et auctor id, viverra vitae ante. Ut aliquam est ut leo consectetur dapibus. Mauris eu aliquam metus, et vehicula lacus. Etiam non massa tortor. Donec luctus arcu et leo dapibus, eu fringilla lacus pellentesque. </p>
			<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin lectus justo, porta non volutpat a, hendrerit eu tellus. Donec quis posuere velit. Ut sit amet justo vitae arcu semper egestas tincidunt nec elit. Etiam vulputate mi dictum, ultrices diam at, cursus ligula. Nulla non urna malesuada, dictum sem in, posuere est. Morbi vehicula sit amet ante quis venenatis. Morbi auctor ac diam vitae laoreet. Nullam turpis tortor, malesuada et auctor id, viverra vitae ante. Ut aliquam est ut leo consectetur dapibus. Mauris eu aliquam metus, et vehicula lacus. Etiam non massa tortor. Donec luctus arcu et leo dapibus, eu fringilla lacus pellentesque. </p>
			<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin lectus justo, porta non volutpat a, hendrerit eu tellus. Donec quis posuere velit. Ut sit amet justo vitae arcu semper egestas tincidunt nec elit. Etiam vulputate mi dictum, ultrices diam at, cursus ligula. Nulla non urna malesuada, dictum sem in, posuere est. Morbi vehicula sit amet ante quis venenatis. Morbi auctor ac diam vitae laoreet. Nullam turpis tortor, malesuada et auctor id, viverra vitae ante. Ut aliquam est ut leo consectetur dapibus. Mauris eu aliquam metus, et vehicula lacus. Etiam non massa tortor. Donec luctus arcu et leo dapibus, eu fringilla lacus pellentesque. </p>
		</div>
	
		<div data-role="footer">
			<i> 2015 Pruebas Jquery Mobile</i>
		</div>
	
	</div>
	
	<!-- Pagina 4 -->
	<div data-role="page" id="cookies" data-title="Pagina3" data-theme="b">
	
		<div data-role="header">
			<h1>Politica de Cookies</h1>
		</div>
	
		<div data-role="content">
			<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin lectus justo, porta non volutpat a, hendrerit eu tellus. Donec quis posuere velit. Ut sit amet justo vitae arcu semper egestas tincidunt nec elit. Etiam vulputate mi dictum, ultrices diam at, cursus ligula. Nulla non urna malesuada, dictum sem in, posuere est. Morbi vehicula sit amet ante quis venenatis. Morbi auctor ac diam vitae laoreet. Nullam turpis tortor, malesuada et auctor id, viverra vitae ante. Ut aliquam est ut leo consectetur dapibus. Mauris eu aliquam metus, et vehicula lacus. Etiam non massa tortor. Donec luctus arcu et leo dapibus, eu fringilla lacus pellentesque. </p>
			<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin lectus justo, porta non volutpat a, hendrerit eu tellus. Donec quis posuere velit. Ut sit amet justo vitae arcu semper egestas tincidunt nec elit. Etiam vulputate mi dictum, ultrices diam at, cursus ligula. Nulla non urna malesuada, dictum sem in, posuere est. Morbi vehicula sit amet ante quis venenatis. Morbi auctor ac diam vitae laoreet. Nullam turpis tortor, malesuada et auctor id, viverra vitae ante. Ut aliquam est ut leo consectetur dapibus. Mauris eu aliquam metus, et vehicula lacus. Etiam non massa tortor. Donec luctus arcu et leo dapibus, eu fringilla lacus pellentesque. </p>
			<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin lectus justo, porta non volutpat a, hendrerit eu tellus. Donec quis posuere velit. Ut sit amet justo vitae arcu semper egestas tincidunt nec elit. Etiam vulputate mi dictum, ultrices diam at, cursus ligula. Nulla non urna malesuada, dictum sem in, posuere est. Morbi vehicula sit amet ante quis venenatis. Morbi auctor ac diam vitae laoreet. Nullam turpis tortor, malesuada et auctor id, viverra vitae ante. Ut aliquam est ut leo consectetur dapibus. Mauris eu aliquam metus, et vehicula lacus. Etiam non massa tortor. Donec luctus arcu et leo dapibus, eu fringilla lacus pellentesque. </p>
			<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin lectus justo, porta non volutpat a, hendrerit eu tellus. Donec quis posuere velit. Ut sit amet justo vitae arcu semper egestas tincidunt nec elit. Etiam vulputate mi dictum, ultrices diam at, cursus ligula. Nulla non urna malesuada, dictum sem in, posuere est. Morbi vehicula sit amet ante quis venenatis. Morbi auctor ac diam vitae laoreet. Nullam turpis tortor, malesuada et auctor id, viverra vitae ante. Ut aliquam est ut leo consectetur dapibus. Mauris eu aliquam metus, et vehicula lacus. Etiam non massa tortor. Donec luctus arcu et leo dapibus, eu fringilla lacus pellentesque. </p>
			
			<!-- Botones -->
			
			<a href="#home" id="" data-role="button" data-theme="a">Aceptar</a>
			<a href="#home" id="" data-role="button" data-theme="b">Rechazar</a>
			<a href="#home" id="" data-role="button" data-theme="c">Aceptar</a>
			<a href="#home" id="" data-role="button" data-theme="d">Aceptar</a>
			<a href="#home" id="" data-role="button" data-theme="e">Aceptar</a>
		</div>	
	
	</div>
	
	
</body>

</html>