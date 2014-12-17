
<%@page import="java.io.File"%>
<%@page import="com.ipartek.formacion.helloweb.temp.ClsUtilsFicheros"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@include file="frontoffice/includes/head.jsp" %>
	<%@include file="frontoffice/includes/nav.jsp" %>

<div class="col-xs-8">

	<%@ taglib uri="/WEB-INF/tag/tag_hello.tld" prefix="hello" %>		
	<hello:saluda />
	<br>
	<hello:saluda nombre="Sergio"/>
	
	
	
	<% 
	
	ServletContext sc2 = this.getServletContext();
	
	out.print("Context path:" + sc2.getContextPath() + "<br>");
	out.print("Context realPath:" + sc2.getRealPath(sc2.getContextPath()) + "<br>");
	out.print("Context path:" + sc2.getResourcePaths("/").toString() + "<br>");
	
	for(Object a : sc2.getResourcePaths("/")) {
		out.print(a.toString() + "<br>");
	}
	
	//Meta-inf
	for(Object a : sc2.getResourcePaths("/WEB-INF/classes/com/ipartek/formacion/helloweb/i18n")) {
		out.print(a.toString() + "<br>");
	}
	
	
	%>
	
  
	
	
	
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
            
        
    Prueba de paths 1: <br>    
    <% 
    
/*    
    	ServletContext sc = this.getServletContext();
    	String path = new File(sc.getRealPath("/")).getAbsolutePath();
    	List<String> files =  ClsUtilsFicheros.ListResursiveFolder(path);
    	for(String str : files) {
    		out.print(str + "<br>");
    	}
    */
    
    %>
    
    <br><br>
    Prueba de paths 2: <br>  
    <% 
    /*
    	files =  ClsUtilsFicheros.ListResursiveFolder(request.getContextPath());
    	for(String str : files) {
    		out.print(str + "<br>");
    	}
    	*/
    
    %>
    
    <br><br>
    Prueba de paths 3: <br>  
    <% 
    /*
    	String relativeWebPath = "pruebas.jsp";
    	String absoluteDiskPath = getServletContext().getRealPath(relativeWebPath);
    
    	files =  ClsUtilsFicheros.ListResursiveFolder(absoluteDiskPath);
    	for(String str : files) {
    		out.print(str + "<br>");
    	}
    	*/
    
    %>
          
          
    <table>
	    <c:forEach items="${properties}" var="property">
	        <tr>
	            <td>${property.key}</td>
	            <td>${property.value}</td>
	        </tr>
	    </c:forEach>    
	</table>  
	
	
	<div class="row">
	
		<h1>Ejemplo getParameterValues</h1>
		<form action="ejemploParameterValuesServlet" method="post" >
			<div class="options">
				<label class="checkbox-inline">
				  <input type="checkbox" name="checkboxEnLinea" value="opción_1"> 1
				</label>
				<label class="checkbox-inline">
				  <input type="checkbox" name="checkboxEnLinea" value="opción_2"> 2
				</label>
				<label class="checkbox-inline">
				  <input type="checkbox" name="checkboxEnLinea" value="opción_3"> 3
				</label>
				<p> Selecciona el MIME-TYPE de response:</p>
				<div class="radio">
				  <label>
				    <input type="radio" name="opciones" id="opciones_1" value="text/html" checked>
				    HTML
				  </label>
				</div>
				<div class="radio">
				  <label>
				    <input type="radio" name="opciones" id="opciones_2" value="application/json">
				    JSON
				  </label>
				</div>
			</div>
			
			
			<input type="submit" value="enviar">
		</form>
	</div>

	

</div>
           <!-- sidebar -->
        <%@include file="frontoffice/includes/sidebar.jsp" %>
<%@include file="frontoffice/includes/footer.jsp" %>