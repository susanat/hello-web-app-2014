<%@page import="com.ipartek.formacion.helloweb.bean.Persona"%>
<%@page pageEncoding="UTF-8" %>

<!doctype html>

<html lang="en">
<head>
  <meta charset="utf-8">

  <title>The HTML5 Hello World</title>
  <meta name="description" content="">
  <meta name="author" content="">

  <!-- <link rel="stylesheet" href="css/styles.css?v=1.0">  -->

  <!--[if lt IE 9]>
  <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
  <![endif]-->
</head>

<body>

	<h1>Hellow World 2</h1>
	<h2>
	<% 
		out.print("Hola holita");
	
		Persona p = new Persona("pepe", 89);
	
		out.print(p.toString() + System.getProperty("line.separator"));
		out.print(p.getNombre() + System.getProperty("line.separator"));
		out.print(p.getEdad() + System.getProperty("line.separator"));
	
	%>
	</h2>
	
	<form class="" role="form" method="post" id="frm_install_database">
			<div class="form-group form-group-install col-md-12">
				<label class="control-label" for="cont1">Database host * </label>
				<input class="form-control" type="text" name="cont1" id="cont1" value="127.0.0.1" required="required" placeholder="Enter the URL of the database">
			</div>
			
			<div class="form-group form-group-install col-md-12">
				<label class="control-label" for="cont2">Database username * </label>
				<input class="form-control" type="text" name="cont2" id="cont2" required="required" placeholder="Enter database username">
			</div>
			
			<div class="form-group form-group-install col-md-12">
				<label class="control-label" for="cont3">Database password </label>
				<input class="form-control" type="text" name="cont3" id="cont3" placeholder="Enter database password">
				<h6 class="help-block" name="cont3">It may be empty.</h6>
			</div>
			
			<div class="form-group form-group-install col-md-12">
				<label class="control-label" for="cont4">Database name * </label>
				<input class="form-control" type="text" name="cont4" id="cont4" required="required" placeholder="Enter database name">
			</div>
			
			<div class="form-group form-group-install col-md-12">
				<label class="control-label" for="cont5">Table prefix * </label>
				<input class="form-control" type="text" name="cont5" id="cont5" value="srn_" required="required" placeholder="Enter table prefix">
			</div>
		</form>	
	
	
	
	

  <!-- <script src="js/scripts.js"></script>  -->
</body>
</html>