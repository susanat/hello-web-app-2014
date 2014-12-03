<%@page import="com.ipartek.formacion.helloweb.Constantes" %>


 				</div>
                <!-- /.col-lg-12 -->
			</div>
            <!-- /.row -->            
        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->    

</body>

<!-- jQuery -->
    <script src="<%= Constantes.JSP_BACKOFFICE %>js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="<%= Constantes.JSP_BACKOFFICE %>js/bootstrap.min.js"></script>
       
    <!-- datatables -->
    <script type="text/javascript" language="javascript" src="<%= Constantes.JSP_BACKOFFICE %>js/plugins/dataTables/jquery.dataTables.js"></script>
	<script type="text/javascript" language="javascript" src="<%= Constantes.JSP_BACKOFFICE %>js/plugins/dataTables/dataTables.bootstrap.js"></script>
    <script type="text/javascript">
	$(document).ready(function() {
		$('#listaPersonas').dataTable();
	} );
	// For demo to fit into DataTables site builder...
	$('#listaPersonas')
		.removeClass( 'display' )
		.addClass('table table-striped table-bordered');
	</script>

</html>
