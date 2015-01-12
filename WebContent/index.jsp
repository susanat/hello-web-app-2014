<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Buscador Personas</title>
</head>
<body>
	<a href="./persona?op=<%=Constantes.READ%>">Ver Todos</a>
	<% String text_result = (String)request.getAttribute(Constantes.ATT_SEACH_DATA);  
	if(text_result==null){
	%>
	<%@ include file="includes/searchform.jsp" 	%>
	<%}else{
	    out.println(text_result);
	  }%>
	<%@ include file="includes/listaPersonas.jsp" 	%>
</body>
</html>