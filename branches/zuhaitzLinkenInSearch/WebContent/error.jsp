<%@page import="java.io.PrintWriter"%>
<%@page import="java.io.StringWriter"%>
<%@ page isErrorPage="true" %>
    
<html lang="en"><head>
    <meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>Little Repair Monster</title>
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- Le styles -->
    <link href="css/error.css" rel="stylesheet">

    <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script src="js/html5shiv.js"></script>
    <![endif]-->

    <!-- Fav and touch icons -->
    <link rel="shortcut icon" href="favicon.ico">
	
	<!-- Javascript -->
	<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
	<script type="text/javascript" src="js/error.js"></script>
	<script src="js/errorRotate.js"></script>
  </head>

  <body jhjlijpomuhn_m="l">
	
	<div id="loading" style="display: none;"></div>
	
	<div id="container" style="display: block;">
	<div class="background">
		<div class="wrapper">
			<div class="monster"><img src="images/monster.png" alt=""></div>
			<div class="ooops">
				<p>What have you done?<br>
				You broke it! but don't worry<br>
				I'm here to fix it.</p>
			</div>
			<div class="sprockets">
				<div class="frame"></div>
				<img id="img1" src="images/sprocket-orange.png" class="s1" alt="" style="-webkit-transform: rotate(133deg);">
				<script>rotateAnimation("img1",90);</script>
				<img id="img2" src="images/sprocket-red.png" class="s2" alt="" style="-webkit-transform: rotate(134deg);">
				<script>rotateAnimation("img2",90);</script>
				<img id="img3" src="images/sprocket-green.png" class="s3" alt="" style="-webkit-transform: rotate(132deg);">
				<script>rotateAnimation("img3",150);</script>
			</div>
			
			<div class="social">
				<a href="#"><img src="images/fb.png" alt=""></a>
				<a href="#"><img src="images/tw.png" alt=""></a>
				<a href="#"><img src="images/yt.png" alt=""></a>
				<a href="#"><img src="images/rss.png" alt=""></a>
			</div>
			
			

			<%
				exception.getMessage();
				StringWriter stringWriter = new StringWriter();
				PrintWriter printWriter = new PrintWriter(stringWriter);
				exception.printStackTrace(printWriter);
				out.println("<span id='error' hidden>" + stringWriter + "</span>");
				printWriter.close();
				stringWriter.close();
			%>
			
			<footer>
				<span>Akerbetz</span>
			</footer>
		</div>
	</div>
	</div>
  

</body></html>