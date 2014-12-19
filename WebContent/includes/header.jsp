<%@page import="com.ipartek.formacion.helloweb.util.Constante"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:setBundle basename="<%=Constante.PROPERTI_I18N %>"/>
<!DOCTYPE html>
<html lang="${language }">
<head>
	<base href="<%=request.getContextPath()+"/"%>">
	<meta charset="utf-8">
	<link rel='stylesheet' href='http://codepen.io/assets/libs/fullpage/jquery-ui.css'>
    <link rel="stylesheet" href="backoffice/css/bootstrap.min.css" media="screen" type="text/css" />
    <link rel="stylesheet" href="css/style.css" media="screen" type="text/css" />
	<title>Login</title>
</head>
<body>