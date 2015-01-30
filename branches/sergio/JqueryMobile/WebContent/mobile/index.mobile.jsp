<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<base href="http://localhost:8080/JqueryMobile/mobile/">

<!-- Etiqueta para response design -->
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Pruebas Jquery Version Movil</title>


<!-- Includes -->

<!-- MetisMenu CSS -->
<link href="http://localhost:8080/JqueryMobile/mobile/css/jquery.mobile-1.4.2.css" rel="stylesheet">
<link href="http://localhost:8080/JqueryMobile/mobile/css/jquery.mobile.theme-1.4.2.css" rel="stylesheet">

<!-- jQuery Version 1.11.0 -->
<script src="http://localhost:8080/JqueryMobile/mobile/js/jquery-1.11.0.js"></script>
<script src="http://localhost:8080/JqueryMobile/mobile/js/jquery.mobile-1.4.2.js"></script>

<!-- https://github.com/browserstate/history.js -->
<script src="js/jquery.history.js"></script>

</head>
<body>
	<!-- Estructura básica página jquery -->
	<div data-role="page" data-title="Home" id="home">
		<header data-role="header">		
			<h1>Cabecera mobile home</h1>
		</header>	
		
		<section data-role="content">
			<h2>Esto es el contenido</h2>	
			<p>
				Nulla laoreet non massa ut venenatis. Suspendisse potenti. 
				Duis dignissim nulla libero, vitae eleifend nisl sollicitudin et. 
				Proin ante tortor, iaculis ac lorem ac, blandit varius dolor. 
				In ac dignissim erat. Ut cursus ipsum id urna ultricies fermentum. 
				Aenean pretium justo quam, eget auctor sapien auctor in. 
			</p>	
			
			<!-- Enlace para ventana modal o de dialogo -->
			<a href="#cookies" data-rel="dialog">Política de Cookies</a>
			
			<a href="contactos.mobile.jsp">Contactos</a>
				
		</section>	
	
		<footer data-role="footer">
			<a href="#pagina2">Pagina 2</a>		
			<a href="#pagina3">Pagina 3</a>
			<i>Pie</i>			
		</footer>	
	</div>	
	
	<div data-role="page" data-title="Pagina 2" id="pagina2">
		<header data-role="header">		
			<h1>Cabecera mobile pagina2</h1>
		</header>	
		
		<section data-role="content">
			<h2>Esto es el contenido</h2>	
			<p>
				Nulla laoreet non massa ut venenatis. Suspendisse potenti. 
				Duis dignissim nulla libero, vitae eleifend nisl sollicitudin et. 
				Proin ante tortor, iaculis ac lorem ac, blandit varius dolor. 
				In ac dignissim erat. Ut cursus ipsum id urna ultricies fermentum. 
				Aenean pretium justo quam, eget auctor sapien auctor in. 
			</p>		
		</section>	
	
		<footer data-role="footer">	
			<a href="#home">home</a>		
			<a href="#pagina3">Pagina 3</a>	
			<i>Pie</i>			
		</footer>	
	</div>	
	
	<div data-role="page" data-title="Pagina 3" id="pagina3">
		<header data-role="header">		
			<h1>Cabecera mobile pagina3</h1>
		</header>	
		
		<section data-role="content">
			<h2>Esto es el contenido</h2>	
			<p>
				Nulla laoreet non massa ut venenatis. Suspendisse potenti. 
				Duis dignissim nulla libero, vitae eleifend nisl sollicitudin et. 
				Proin ante tortor, iaculis ac lorem ac, blandit varius dolor. 
				In ac dignissim erat. Ut cursus ipsum id urna ultricies fermentum. 
				Aenean pretium justo quam, eget auctor sapien auctor in. 
			</p>		
		</section>	
	
		<footer data-role="footer">	
			<p style="display: block;">
				<a href="#home"  data-role="button">home</a>		
				<a href="#pagina2" data-role="button">Pagina 2</a>
			</p>		
			<p>
				<i>Pie</i>
			</p>			
		</footer>	
	</div>	
	
	<div data-role="page" data-title="Política cookies" id="cookies">
		<header data-role="header">		
			<h1>Política cookies</h1>
		</header>	
		
		<section data-role="content">
			<h2>Esto es el contenido</h2>	
			<p>
				Nulla laoreet non massa ut venenatis. Suspendisse potenti. 
				Duis dignissim nulla libero, vitae eleifend nisl sollicitudin et. 
				Proin ante tortor, iaculis ac lorem ac, blandit varius dolor. 
				In ac dignissim erat. Ut cursus ipsum id urna ultricies fermentum. 
				Aenean pretium justo quam, eget auctor sapien auctor in. 
			</p>	
			
			<a href="#home"  data-role="button" data-theme="b">Aceptar</a>		
			<a href="#pagina3" data-role="button">Rechazar</a>
				
		</section>
	
		
	</div>	
	
	
	<script>
	$( document ).ready(function() {
		
		//cambiar las transiciones
		$.mobile.defaultPageTransition='flip';
		
		//transiciones de los cuadros de diálogo
		$.mobile.defaultDialogTransition='slideup';
		
		
		
	});
	
	
	//cambiar la url utilizando history.js <!-- https://github.com/browserstate/history.js -->
	(function(window,undefined){

	    // Bind to StateChange Event
	    History.Adapter.bind(window,'statechange',function(){ // Note: We are using statechange instead of popstate
	        var State = History.getState(); // Note: We are using History.getState() instead of event.state
	    });

	    // Change our States	    
	    History.replaceState({state:3}, "get", "http://localhost:8080/JqueryMobile/home?u=2234234"); // logs {state:3}, "State 3", "?state=3"
	    
	    

	})(window);
	
	</script>
	
</body>
</html>