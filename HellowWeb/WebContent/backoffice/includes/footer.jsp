<%@page import="com.ipartek.formacion.helloweb.comun.Constantes"%>
	</div> <!-- /#page-wrapper fin content -->
        
    
</div>
    <!-- /#wrapper -->

    <% //TODO Pasar a theme-footer %>	
	 <!-- Bootstrap Core JavaScript -->
	 <script src="<%=Constantes.PATH_BACK_ABS_THEME %>js/bootstrap.min.js"></script>
	
	 <!-- Metis Menu Plugin JavaScript -->
	 <script src="<%=Constantes.PATH_BACK_ABS_THEME %>js/metisMenu/metisMenu.js"></script>
		
	 <!-- Custom Theme JavaScript -->
	 <script src="<%=Constantes.PATH_BACK_ABS_THEME %>js/main.js"></script>
	<% //fin pasar a theme-footer %>




	<!--  Temporal, para visualizar los datos -->
	
		<div class="row">
			<div class="col-md-12">
				Datos temporales
			</div>
		</div>
		
		<div class="alert alert-success">
			Autentificado: ${isAuthenticated}
		<br>
			Pagina: ${lastUrl}
		<br>
			Rol: ${sessionScope.user_session.idRol}
		</div>
		
		<div class="alert alert-success">
		<% 
			String userLocale = request.getHeader("Accept-Language");
		 	//Locale locale = request.getLocale();
		 	out.print("Header lang:" + userLocale + "<br>");
		 	
		 	//Returns the preferred Locale that the client will accept content in, based on the Accept-Language header. If the 
	 		//client request doesn't provide an Accept-Language header, this method returns the default locale for the server. 
		 	out.print("Request lang:" + request.getLocale().toString() + "<br>");
		 		 	
	  	%>
			Etiqueta language tl: ${language} <br>
			Session locale: <%= session.getAttribute(Constantes.PARAM_SESSION_LOCALE) %>
		</div>
</body>

</html>
</html>