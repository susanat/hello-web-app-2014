<%@page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<HEAD>
<TITLE>Result</TITLE>
</HEAD>
<BODY>
<H1>Result</H1>

<jsp:useBean id="sampleVCardProxyid" scope="session" class="com.ipartek.formacion.pruebas.wsvcard.VCardProxy" />
<%
if (request.getParameter("endpoint") != null && request.getParameter("endpoint").length() > 0)
sampleVCardProxyid.setEndpoint(request.getParameter("endpoint"));
%>

<%
String method = request.getParameter("method");
int methodID = 0;
if (method == null) methodID = -1;

if(methodID != -1) methodID = Integer.parseInt(method);
boolean gotMethod = false;

try {
switch (methodID){ 
case 2:
        gotMethod = true;
        java.lang.String getEndpoint2mtemp = sampleVCardProxyid.getEndpoint();
if(getEndpoint2mtemp == null){
%>
<%=getEndpoint2mtemp %>
<%
}else{
        String tempResultreturnp3 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getEndpoint2mtemp));
        %>
        <%= tempResultreturnp3 %>
        <%
}
break;
case 5:
        gotMethod = true;
        String endpoint_0id=  request.getParameter("endpoint8");
            java.lang.String endpoint_0idTemp = null;
        if(!endpoint_0id.equals("")){
         endpoint_0idTemp  = endpoint_0id;
        }
        sampleVCardProxyid.setEndpoint(endpoint_0idTemp);
break;
case 10:
        gotMethod = true;
        com.ipartek.formacion.pruebas.wsvcard.VCard getVCard10mtemp = sampleVCardProxyid.getVCard();
if(getVCard10mtemp == null){
%>
<%=getVCard10mtemp %>
<%
}else{
        if(getVCard10mtemp!= null){
        String tempreturnp11 = getVCard10mtemp.toString();
        %>
        <%=tempreturnp11%>
        <%
        }}
break;
case 13:
        gotMethod = true;
        String user_1id=  request.getParameter("user24");
            java.lang.String user_1idTemp = null;
        if(!user_1id.equals("")){
         user_1idTemp  = user_1id;
        }
        String password_2id=  request.getParameter("password26");
            java.lang.String password_2idTemp = null;
        if(!password_2id.equals("")){
         password_2idTemp  = password_2id;
        }
        com.ipartek.formacion.pruebas.wsvcard.Persona getVCard13mtemp = sampleVCardProxyid.getVCard(user_1idTemp,password_2idTemp);
if(getVCard13mtemp == null){
%>
<%=getVCard13mtemp %>
<%
}else{
%>
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">returnp:</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">email:</TD>
<TD>
<%
if(getVCard13mtemp != null){
java.lang.String typeemail16 = getVCard13mtemp.getEmail();
        String tempResultemail16 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeemail16));
        %>
        <%= tempResultemail16 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">edad:</TD>
<TD>
<%
if(getVCard13mtemp != null){
%>
<%=getVCard13mtemp.getEdad()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">apellido:</TD>
<TD>
<%
if(getVCard13mtemp != null){
java.lang.String typeapellido20 = getVCard13mtemp.getApellido();
        String tempResultapellido20 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeapellido20));
        %>
        <%= tempResultapellido20 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nombre:</TD>
<TD>
<%
if(getVCard13mtemp != null){
java.lang.String typenombre22 = getVCard13mtemp.getNombre();
        String tempResultnombre22 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre22));
        %>
        <%= tempResultnombre22 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
}
} catch (Exception e) { 
%>
Exception: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.toString()) %>
Message: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.getMessage()) %>
<%
return;
}
if(!gotMethod){
%>
result: N/A
<%
}
%>
</BODY>
</HTML>