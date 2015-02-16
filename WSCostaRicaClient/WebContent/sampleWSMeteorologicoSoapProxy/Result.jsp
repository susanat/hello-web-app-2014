<%@page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<HEAD>
<TITLE>Result</TITLE>
</HEAD>
<BODY>
<H1>Result</H1>

<jsp:useBean id="sampleWSMeteorologicoSoapProxyid" scope="session" class="org.tempuri.WSMeteorologicoSoapProxy" />
<%
if (request.getParameter("endpoint") != null && request.getParameter("endpoint").length() > 0)
sampleWSMeteorologicoSoapProxyid.setEndpoint(request.getParameter("endpoint"));
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
        java.lang.String getEndpoint2mtemp = sampleWSMeteorologicoSoapProxyid.getEndpoint();
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
        sampleWSMeteorologicoSoapProxyid.setEndpoint(endpoint_0idTemp);
break;
case 10:
        gotMethod = true;
        org.tempuri.WSMeteorologicoSoap getWSMeteorologicoSoap10mtemp = sampleWSMeteorologicoSoapProxyid.getWSMeteorologicoSoap();
if(getWSMeteorologicoSoap10mtemp == null){
%>
<%=getWSMeteorologicoSoap10mtemp %>
<%
}else{
        if(getWSMeteorologicoSoap10mtemp!= null){
        String tempreturnp11 = getWSMeteorologicoSoap10mtemp.toString();
        %>
        <%=tempreturnp11%>
        <%
        }}
break;
case 13:
        gotMethod = true;
        java.lang.String pronosticoRegional13mtemp = sampleWSMeteorologicoSoapProxyid.pronosticoRegional();
if(pronosticoRegional13mtemp == null){
%>
<%=pronosticoRegional13mtemp %>
<%
}else{
        String tempResultreturnp14 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(pronosticoRegional13mtemp));
        %>
        <%= tempResultreturnp14 %>
        <%
}
break;
case 16:
        gotMethod = true;
        String regionID_1id=  request.getParameter("regionID19");
        int regionID_1idTemp  = Integer.parseInt(regionID_1id);
        java.lang.String pronosticoRegionalxID16mtemp = sampleWSMeteorologicoSoapProxyid.pronosticoRegionalxID(regionID_1idTemp);
if(pronosticoRegionalxID16mtemp == null){
%>
<%=pronosticoRegionalxID16mtemp %>
<%
}else{
        String tempResultreturnp17 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(pronosticoRegionalxID16mtemp));
        %>
        <%= tempResultreturnp17 %>
        <%
}
break;
case 21:
        gotMethod = true;
        java.lang.String pronosticoPorCiudad21mtemp = sampleWSMeteorologicoSoapProxyid.pronosticoPorCiudad();
if(pronosticoPorCiudad21mtemp == null){
%>
<%=pronosticoPorCiudad21mtemp %>
<%
}else{
        String tempResultreturnp22 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(pronosticoPorCiudad21mtemp));
        %>
        <%= tempResultreturnp22 %>
        <%
}
break;
case 24:
        gotMethod = true;
        String ciudadID_2id=  request.getParameter("ciudadID27");
        int ciudadID_2idTemp  = Integer.parseInt(ciudadID_2id);
        java.lang.String pronosticoPorCiudadxID24mtemp = sampleWSMeteorologicoSoapProxyid.pronosticoPorCiudadxID(ciudadID_2idTemp);
if(pronosticoPorCiudadxID24mtemp == null){
%>
<%=pronosticoPorCiudadxID24mtemp %>
<%
}else{
        String tempResultreturnp25 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(pronosticoPorCiudadxID24mtemp));
        %>
        <%= tempResultreturnp25 %>
        <%
}
break;
case 29:
        gotMethod = true;
        java.lang.String efemerides29mtemp = sampleWSMeteorologicoSoapProxyid.efemerides();
if(efemerides29mtemp == null){
%>
<%=efemerides29mtemp %>
<%
}else{
        String tempResultreturnp30 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(efemerides29mtemp));
        %>
        <%= tempResultreturnp30 %>
        <%
}
break;
case 32:
        gotMethod = true;
        java.lang.String fecha32mtemp = sampleWSMeteorologicoSoapProxyid.fecha();
if(fecha32mtemp == null){
%>
<%=fecha32mtemp %>
<%
}else{
        String tempResultreturnp33 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(fecha32mtemp));
        %>
        <%= tempResultreturnp33 %>
        <%
}
break;
case 35:
        gotMethod = true;
        java.lang.String hora35mtemp = sampleWSMeteorologicoSoapProxyid.hora();
if(hora35mtemp == null){
%>
<%=hora35mtemp %>
<%
}else{
        String tempResultreturnp36 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(hora35mtemp));
        %>
        <%= tempResultreturnp36 %>
        <%
}
break;
case 38:
        gotMethod = true;
        java.lang.String estadoActualRegional38mtemp = sampleWSMeteorologicoSoapProxyid.estadoActualRegional();
if(estadoActualRegional38mtemp == null){
%>
<%=estadoActualRegional38mtemp %>
<%
}else{
        String tempResultreturnp39 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(estadoActualRegional38mtemp));
        %>
        <%= tempResultreturnp39 %>
        <%
}
break;
case 41:
        gotMethod = true;
        java.lang.String estadoActualPorCiudad41mtemp = sampleWSMeteorologicoSoapProxyid.estadoActualPorCiudad();
if(estadoActualPorCiudad41mtemp == null){
%>
<%=estadoActualPorCiudad41mtemp %>
<%
}else{
        String tempResultreturnp42 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(estadoActualPorCiudad41mtemp));
        %>
        <%= tempResultreturnp42 %>
        <%
}
break;
case 44:
        gotMethod = true;
        java.lang.String pronosticoExtendidoRegion44mtemp = sampleWSMeteorologicoSoapProxyid.pronosticoExtendidoRegion();
if(pronosticoExtendidoRegion44mtemp == null){
%>
<%=pronosticoExtendidoRegion44mtemp %>
<%
}else{
        String tempResultreturnp45 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(pronosticoExtendidoRegion44mtemp));
        %>
        <%= tempResultreturnp45 %>
        <%
}
break;
case 47:
        gotMethod = true;
        String regionID_3id=  request.getParameter("regionID50");
        int regionID_3idTemp  = Integer.parseInt(regionID_3id);
        java.lang.String pronosticoExtendidoRegionxID47mtemp = sampleWSMeteorologicoSoapProxyid.pronosticoExtendidoRegionxID(regionID_3idTemp);
if(pronosticoExtendidoRegionxID47mtemp == null){
%>
<%=pronosticoExtendidoRegionxID47mtemp %>
<%
}else{
        String tempResultreturnp48 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(pronosticoExtendidoRegionxID47mtemp));
        %>
        <%= tempResultreturnp48 %>
        <%
}
break;
case 52:
        gotMethod = true;
        java.lang.String pronosticoExtendidoCiudad52mtemp = sampleWSMeteorologicoSoapProxyid.pronosticoExtendidoCiudad();
if(pronosticoExtendidoCiudad52mtemp == null){
%>
<%=pronosticoExtendidoCiudad52mtemp %>
<%
}else{
        String tempResultreturnp53 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(pronosticoExtendidoCiudad52mtemp));
        %>
        <%= tempResultreturnp53 %>
        <%
}
break;
case 55:
        gotMethod = true;
        String ciudadID_4id=  request.getParameter("ciudadID58");
        int ciudadID_4idTemp  = Integer.parseInt(ciudadID_4id);
        java.lang.String pronosticoExtendidoCiudadxID55mtemp = sampleWSMeteorologicoSoapProxyid.pronosticoExtendidoCiudadxID(ciudadID_4idTemp);
if(pronosticoExtendidoCiudadxID55mtemp == null){
%>
<%=pronosticoExtendidoCiudadxID55mtemp %>
<%
}else{
        String tempResultreturnp56 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(pronosticoExtendidoCiudadxID55mtemp));
        %>
        <%= tempResultreturnp56 %>
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