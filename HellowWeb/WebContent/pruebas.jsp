<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@include file="frontoffice/includes/head.jsp" %>
	<%@include file="frontoffice/includes/nav.jsp" %>

<div class="col-xs-8">

	<%@ taglib uri="/WEB-INF/tag/tag_hello.tld" prefix="hello" %>		
	<hello:saluda />
	<br>
	<hello:saluda nombre="Sergio"/>
	
	
	<br>
	TLD de combo:
	<% 
		List<String> lstValues = new ArrayList<String>();
		List<String> lstTexts = new ArrayList<String>();
	
		lstValues.add("es_ES");
		lstValues.add("en_EN");
		lstValues.add("eu_ES");
		
		lstTexts.add("Castellano");
		lstTexts.add("Ingles");
		lstTexts.add("Euskera");
			
	%>
	<%@ taglib uri="/WEB-INF/tag/tag_utils.tld" prefix="utils" %>	
	<utils:selectOptions valores="<%=lstValues %>" texts="<%=lstTexts %>" selectedValue="eu_ES" />
            

</div>
           <!-- sidebar -->
        <%@include file="frontoffice/includes/sidebar.jsp" %>
<%@include file="frontoffice/includes/footer.jsp" %>