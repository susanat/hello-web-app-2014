<%@page import="java.util.Enumeration"%>
<%@page import="com.ipartek.formacion.helloweb.bean.Persona"%>
<%@page import="com.ipartek.formacion.helloweb.Constantes"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Saludo</title>
</head>
<body>

<%
	//Recuperar usuario de session
Persona p=(Persona)session.getAttribute(Constantes.USER_SESSION);

if(p==null){
	p=new Persona("anonimo",99);
	String root= request.getSession().getServletContext().getRealPath("/");
	response.sendRedirect(root+Constantes.JSP_LOGIN);
	//response.sendRedirect(Constantes.LOGIN);
	
}
%>
<h1>Ongi Etorri <%=p.getNombre() %></h1>


 <form action=<%=Constantes.PATH_LOGOUT %> method="post">  
   
    <input type="submit" name="logout" class="login login-submit" value="logout" title="logout">
  </form>
   <h1>Request Info</h1>
  <ol>  	
    <li>Method: <b><%=request.getMethod()%></b></li>
    <li>Request URI: <b><%=request.getRequestURI()%></b></li>
    <li>Protocol: <b><%=request.getProtocol()%></b></li>
    <li>PathInfo: <b><%=request.getPathInfo()%></b></li>
    <li>Remote Adress: <b><%=request.getRemoteAddr()%></b></li>  
    <li>Server Name: <b><%=request.getServerName()%></b></li>  
    <li>Server Port: <b><%=request.getServerPort()%></b></li>  
    <li>Request Context: <b><%=request.getContextPath()%></b></li>  
  </ol>
  
   <h1>Request Header</h1>
   <%
  Enumeration e = request.getHeaderNames();
        while (e.hasMoreElements()) {
            String name = (String)e.nextElement();
            String value = request.getHeader(name);
            out.println("<li>" + name + " = " + value +"</li>");
        }%>


<h1>Request Parameters</h1>

<ol>
	<%
	Enumeration ep= request.getParameterNames();
	while (ep.hasMoreElements()) {
        String name = (String)ep.nextElement();
        String value = request.getParameter(name);
        out.println("<li>" + name + " = " + value +"</li>");
	}
	
	
	%>


</ol>


<h1>Request Atributes</h1>

<%
	Enumeration ea= request.getParameterNames();
	while (ea.hasMoreElements()) {
        String name = (String)ea.nextElement();
        String value = (String)request.getAttribute(name);
        out.println("<li>" + name + " = " + value +"</li>");
	}
	
	
	%>

</body>
</html>