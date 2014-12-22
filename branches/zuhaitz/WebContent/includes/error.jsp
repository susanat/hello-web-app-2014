<%@page import="java.io.PrintWriter"%>
<%@page import="java.io.StringWriter"%>
<%@page import="com.ipartek.formacion.helloweb.Constantes"%>
<%@ page isErrorPage="true" %>
    
<html lang="en"><head>
    <meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>Little Repair Monster</title>
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- Le styles -->
    <link href="<%=Constantes.JSP_BACKOFFICE%>css/error.css" rel="stylesheet">

    <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script src="js/html5shiv.js"></script>
    <![endif]-->

    <!-- Fav and touch icons -->
    <link rel="shortcut icon" href="favicon.ico">
	
	<!-- Javascript -->
	<script type="text/javascript" src="<%=Constantes.JSP_BACKOFFICE%>js/jquery-1.11.1.min.js"></script>
	<script type="text/javascript" src="<%=Constantes.JSP_BACKOFFICE%>js/error.js"></script>
	<script src="<%=Constantes.JSP_BACKOFFICE%>js/errorRotate.js"></script>
  </head>

  <body jhjlijpomuhn_m="l">
	
	<div id="loading" style="display: none;"></div>
	
	<div id="container" style="display: block;">
	<div class="background">
		<div class="wrapper">
			<div class="monster"><img src="<%=Constantes.JSP_BACKOFFICE%>images/monster.png" alt=""></div>
			<div class="ooops">
				<p>What have you done?<br>
				You broke it! but don't worry<br>
				I'm here to fix it.</p>
			</div>
			<div class="sprockets">
				<div class="frame"></div>
				<img id="img1" src="<%=Constantes.JSP_BACKOFFICE%>images/sprocket-orange.png" class="s1" alt="" style="-webkit-transform: rotate(133deg);">
				<script>rotateAnimation("img1",90);</script>
				<img id="img2" src="<%=Constantes.JSP_BACKOFFICE%>images/sprocket-red.png" class="s2" alt="" style="-webkit-transform: rotate(134deg);">
				<script>rotateAnimation("img2",90);</script>
				<img id="img3" src="<%=Constantes.JSP_BACKOFFICE%>images/sprocket-green.png" class="s3" alt="" style="-webkit-transform: rotate(132deg);">
				<script>rotateAnimation("img3",150);</script>
			</div>
			
			<div class="social">
				<a href="#"><img src="<%=Constantes.JSP_BACKOFFICE%>images/fb.png" alt=""></a>
				<a href="#"><img src="<%=Constantes.JSP_BACKOFFICE%>images/tw.png" alt=""></a>
				<a href="#"><img src="<%=Constantes.JSP_BACKOFFICE%>images/yt.png" alt=""></a>
				<a href="#"><img src="<%=Constantes.JSP_BACKOFFICE%>images/rss.png" alt=""></a>
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