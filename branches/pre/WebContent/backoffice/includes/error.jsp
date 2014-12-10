<%@page isErrorPage="true"%>
<!DOCTYPE HTML>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
		<title>WOOPSIE DAISY! Something went wrong!!!</title>
		
		<style type="text/css">
			body{ margin:0; padding:0; background:#efefef; font-family:Georgia, Times, Verdana, Geneva, Arial, Helvetica, sans-serif; }
			div#mother{ margin:0 auto; width:943px; height:572px; position:relative; }
			div#errorBox{ background: url(bg-404.png) no-repeat top left; width:943px; height:572px; margin:auto; }
			div#errorText{ color:#39351e; padding:146px 0 0 446px }
			div#errorText p{ width:303px; font-size:14px; line-height:26px; }
			div.link{ /*background:#f90;*/ height:50px; width:145px; float:left; }
			div#home{ margin:20px 0 0 444px;}
			div#contact{ margin:20px 0 0 25px;}
			h1{ font-size:40px; margin-bottom:35px; }
		</style>
		
	</head>
	<body>
		<div id="mother">
			<div id="errorBox">
				<div id="errorText">
					<h1>Error: Disculpa las Moletias</h1>
					<p>
						<b>Message:</b> <%=exception.getMessage()%>	
					</p>
					
					
				</div>
				<a href="/" title="Home...">
					<div class="link" id="home"></div>
				</a>
				<a href="/contact" title="Contact...">
					<div class="link" id="contact"></div>
				</a>
			</div>
		</div>
	</body>
</html>

