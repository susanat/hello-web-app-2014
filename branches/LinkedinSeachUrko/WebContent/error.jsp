<%@page isErrorPage = "true" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<base href="<%=request.getContextPath()+"/"%>">
<title>Error General</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<div class="container">
    <div class="row">
        <div class="col-md-12">
            <div class="error-template">
                <h1>Oops!</h1>
                <h2>Ha habido un error</h2>
                <div class="error-details">
                    ¡Lo sentimos, ha ocurrido algún problema en la petición!
                </div>
                <div class="error-actions">
                    <a href="index.jsp" class="btn btn-primary btn-lg"><span class="glyphicon glyphicon-home"></span>
                        Ir a Inicio </a>
                </div>
            </div>
        </div>
    </div>
	</div>
</body>
</html>