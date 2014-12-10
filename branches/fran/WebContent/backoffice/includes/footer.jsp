<%@page import="com.ipartek.formacion.helloweb.constantes.Constantes"%>
        </div>
        <!-- /#page-wrapper -->
</div>
    <!-- /#wrapper -->
</body>

	<!-- jQuery Version 1.11.0 -->
    <script src="<%=Constantes.JSP_BACKOFFICE%>/js/jquery-1.11.0.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="<%=Constantes.JSP_BACKOFFICE%>/js/bootstrap.min.js"></script>

	<!-- DataTables -->
	<script type="text/javascript" charset="utf-8" src="<%=Constantes.JSP_BACKOFFICE%>/js/plugins/dataTables/jquery.dataTables.js"></script>
	<script type="text/javascript" charset="utf-8" src="<%=Constantes.JSP_BACKOFFICE%>/js/plugins/dataTables/dataTables.bootstrap.js"></script>
	<script type="text/javascript" charset="utf-8">
		$(document).ready(function() {
			$('#listapersonas').dataTable();
		} );
			
		//$('#listapersonas')
	    //	.removeClass( 'display' )
	   //	.addClass('table table-striped table-bordered');
	</script>
</html>