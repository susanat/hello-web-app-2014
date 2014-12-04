<%@page isErrorPage = "true" %>

<html><head>
    <title>Page not found </title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width">
    <link rel="stylesheet" href="http://huwshimi.com/wp-content/themes/huwshimi/404.css">
    <link rel="icon" type="images/png" href="http://huwshimi.com/wp-content/themes/huwshimi/images/favicon.png">
    <link rel="alternate" type="application/rss+xml" href="http://feeds.feedburner.com/huwshimi">
    <script type="text/javascript" src="http://www.google-analytics.com/ga.js"></script><script type="text/javascript">

  var _gaq = _gaq || [];
  _gaq.push(['_setAccount', 'UA-3551564-1']);
  _gaq.push(['_trackPageview']);

  (function() {
    var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
    ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
    var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
  })();

</script>
</head>
<body>
<p>
	Mensaje:<% out.print(exception.getCause()); %>
</p>
    <div id="error">
        <img src="http://huwshimi.com/wp-content/themes/huwshimi/images/404.png" alt="404 page not found" id="error404-image">
    </div>
	

</body>
</html>