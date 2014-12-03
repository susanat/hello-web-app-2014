 <!-- /.row -->
        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->

    <!-- jQuery Version 1.11.0 -->
    <script src="<%=Constantes.JSP_BACKOFFICE %>/js/jquery-1.11.0.js"></script>

    <script src="<%=Constantes.JSP_BACKOFFICE %>/js/bootstrap.min.js"></script>

   


    <!-- Custom Theme JavaScript -->
    <script src="<%=Constantes.JSP_BACKOFFICE %>/js/sb-admin-2.js"></script>
    <script src="<%=Constantes.JSP_BACKOFFICE %>js/jquery-1.11.0.js" type="text/javascript"></script>
	<script src="<%=Constantes.JSP_BACKOFFICE %>js/plugins/dataTables/jquery.dataTables.js" type="text/javascript"></script>
	<script src="<%=Constantes.JSP_BACKOFFICE %>js/plugins/dataTables/dataTables.bootstrap.js" type="text/javascript"></script>
	<script>
	$(document).ready(function() {
	    $('#example').DataTable();
	} );
	</script>
	<script type="text/javascript">
	// For demo to fit into DataTables site builder...
	$('#example')
		.removeClass( 'display' )
		.addClass('table table-striped table-bordered');
	</script>

</body>

</html>