
	<%@page import="com.ipartek.formacion.busredsociales.comun.Message"%>
<%@page import="com.ipartek.formacion.busredsociales.comun.Constantes"%>
</div> <!-- FIN container -->	
        
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
        
        
       

    <!-- jQuery -->
    <script src="<%=Constantes.PATH_ABS_THEME %>js/jquery-1.11.1.min.js"></script>
	<script>window.jQuery || document.write('<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"><\/script>')</script>
       

    <!-- Bootstrap Core JavaScript -->
    <script src="<%=Constantes.PATH_ABS_THEME %>js/bootstrap.min.js"></script>
   
    
    <script src="<%=Constantes.PATH_ABS_THEME %>js/main.js"></script>
    
    
    
    
    <% 
    	//out.print(UtilsTemp.changeTittle("Holaaaa")); 
    %>
	
	
	<script type='text/javascript'>
    $(document).ready(function() {
		document.title = '${documentTittle}';
	});
	</script>
	
	<% 
	if (request.getAttribute(Constantes.ATTR_MSG) != null) {
		
		Message msg = (Message)request.getAttribute(Constantes.ATTR_MSG);
		
		if(msg.isError()) {
		
	%>	
	
			<div class="alert alert-warning alert-dismissible" role="alert">
			  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			  <strong>Warning!</strong> Better check yourself, you're not looking too good.
			  <br>
			  <%= msg.getText() %>
			  <br>
			  
			</div>
	 
	<% 
		}
	}
	%>
	

</body>

</html>
