<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
    
<!-- Etiqueta para response design -->
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Pruebas Jquery Version Desktop</title>


<!-- Includes -->

<!-- MetisMenu CSS -->
<link href="desktop/css/bootstrap.min.css" rel="stylesheet">
<link href="desktop/css/main.css" rel="stylesheet">

<!-- jQuery Version 1.11.0 -->
<script src="desktop/js/jquery-1.11.0.js"></script>
<script src="desktop/js/bootstrap.min.js"></script>


</head>
<body>
	<!-- Estructura básica -->
	<div data-role="page" class="content">
		<header data-role="header" class="navbar">		
			<h1>Cabecera Desktop bootstrap</h1>
		</header>	
		
		<section data-role="content" class="page-wrapper">
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
			<i>Pie</i>			
		</footer>	
	</div>	
	
<script>

//Manera 1 de cambiar la url
$( document ).ready(function() {	
	var newUrl = "home?u=index.jsp";
	window.history.pushState({path:newUrl},'',newUrl);	
});

</script>

<a href="#" data-location="home?u=index2.jsp">Email Item 13</a>
<script>

//manera 2 de cambiar la url
$( document ).ready(function() {

	$('a').click(function (e) {
	  e.preventDefault();
	  // Detect if pushState is available
	  if(history.pushState) {
	    history.pushState(null, null, $(this).attr('data-location')); // URL is now /inbox/N
	    // showMailItem(); // example function to show email based on link clicked
	  }
	  return false;
	});
	
	// Used to detect initial (useless) popstate.
	// If history.state exists, assume browser isn't going to fire initial popstate.
	var popped = ('state' in window.history && window.history.state !== null), initialURL = location.href;
	
	$(window).bind('popstate', function (event) {
	  // Ignore inital popstate that some browsers fire on page load
	  var initialPop = !popped && location.href == initialURL
	  popped = true
	  if (initialPop) return;
	
	  //showMailOverview(); // exmaple function to display all email since the user has click Back.
	
	});

});

</script>
	
</body>
</html>