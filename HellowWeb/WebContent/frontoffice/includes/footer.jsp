    	<%@page import="com.ipartek.formacion.helloweb.comun.Constantes"%>
</div>	
        <!-- /.row -->
        <hr>

        <!-- Footer -->
        <footer>
            <div class="row">
                <div class="col-lg-12">
                    <p>Copyright &copy; Your Website 2014</p>
                </div>
            </div>
            <!-- /.row -->
        </footer>
        
        
        <!--**********  Temporal, para visualizar los datos -->	
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
        <!--********** FIN Temporal, para visualizar los datos -->
        
        

    </div>
    <!-- /.container -->

    <!-- jQuery -->
    <script src="frontoffice/themes/blog-post/js/jquery-1.11.1.min.js"></script>
	<script>window.jQuery || document.write('<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"><\/script>')</script>
       

    <!-- Bootstrap Core JavaScript -->
    <script src="frontoffice/themes/blog-post/js/bootstrap.min.js"></script>
    
    <!-- Añadimos los javascript y css para las alertas -->
	<link href="<%=Constantes.PATH_SITE%>bootstrap/js/vendor/toastr/toastr.css" rel="stylesheet"/>
	<script src="<%=Constantes.PATH_SITE%>bootstrap/js/vendor/toastr/toastr.js"></script>
    
    <script src="frontoffice/themes/blog-post/js/main.js"></script>

</body>

</html>
