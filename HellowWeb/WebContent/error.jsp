<%@page import="com.ipartek.formacion.helloweb.comun.Constantes"%>
<%@page import="com.ipartek.formacion.helloweb.temp.UtilsTemp"%>
<%@ page isErrorPage="true" import="java.io.*"%>



<html>
<head>
<title>Error Handling Example</title>

<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="bootstrap/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="bootstrap/css/main.css">

</head>

<body>
	<h1>Ha ocurrido un error en la página.</h1>

	<div class="jumbotron">
		<div class="row">
			<div class="col-md-12">
				<small><i></i>Add alerts if form ok... success, else error.</i></small>
				<div class="alert alert-success">
					<strong><span class="glyphicon glyphicon-send"></span>
						Success! Message sent. (If form ok!)</strong>
				</div>
				<div class="alert alert-danger">
					<span class="glyphicon glyphicon-alert"></span><strong>
						Error! Please check the inputs. (If form error!)</strong>
				</div>
			</div>
			<form role="form" action="" method="post">
				<div class="col-lg-6">
					<div class="well well-sm">
						<strong><i
							class="glyphicon glyphicon-ok form-control-feedback"></i>
							Required Field</strong>
					</div>
					<div class="form-group">
						<label for="InputName">Your Name</label>
						<div class="input-group">
							<input type="text" class="form-control" name="InputName"
								id="InputName" placeholder="Enter Name" required> <span
								class="input-group-addon"><i
								class="glyphicon glyphicon-ok form-control-feedback"></i></span>
						</div>
					</div>
					<div class="form-group">
						<label for="InputEmail">Your Email</label>
						<div class="input-group">
							<input type="email" class="form-control" id="InputEmail"
								name="InputEmail" placeholder="Enter Email" required>
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-ok form-control-feedback"></i></span>
						</div>
					</div>
					<div class="form-group">
						<label for="InputMessage">Message</label>
						<div class="input-group">
							<textarea name="InputMessage" id="InputMessage"
								class="form-control" rows="5" required>
Message:
<%=exception.getMessage()%>

StackTrace:
<%
	StringWriter stringWriter = new StringWriter();
	PrintWriter printWriter = new PrintWriter(stringWriter);
	exception.printStackTrace(printWriter);
	out.println(stringWriter);
	printWriter.close();
	stringWriter.close();
%>
														</textarea>
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-ok form-control-feedback"></i></span>
						</div>
					</div>
					<div class="form-group">
						<label for="InputReal">What is 4+3? (Simple Spam Checker)</label>
						<div class="input-group">
							<input type="text" class="form-control" name="InputReal"
								id="InputReal" required> <span class="input-group-addon"><i
								class="glyphicon glyphicon-ok form-control-feedback"></i></span>
						</div>
					</div>
					<input type="submit" name="submit" id="submit" value="Submit"
						class="btn btn-info pull-right">
				</div>
			</form>
			<hr class="featurette-divider hidden-lg">
			<div class="col-lg-5 col-md-push-1">
				<address>
					<h3>Puedes ir a: </h3>
					<p class="lead">
						<ul>
							<li>Home page</li>
							<li>Login</li>							
						</ul>
						
					<h3>O reintentar: </h3>
					
											
					<h2><a href="${sessionScope.lasturl}">${sessionScope.lasturl}</a></h2>
											
						
					</p>
				</address>
			</div>
		</div>

	</div>





	<script src="bootstrap/js/vendor/jquery-1.11.1.min.js"></script>
	<script>
		window.jQuery
				|| document
						.write('<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"><\/script>')
	</script>

	<script src="bootstrap/js/vendor/bootstrap.min.js"></script>
	<script src="bootstrap/js/main.js"></script>



</body>
</html>


