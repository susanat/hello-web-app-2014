<%@page import="com.ipartek.formacion.buscarpersonas.util.Constantes"%>
<% String text = (String)request.getAttribute(Constantes.ATT_LISTA_PERSONAS);  
	if(text!=null)
	    out.println(text);
	    %>