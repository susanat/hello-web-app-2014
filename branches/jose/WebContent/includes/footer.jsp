<%@page import="com.ipartek.formacion.helloweb.Constantes"%>

</div>
<!-- /#wrapper -->

<!-- jQuery Version 1.11.0 -->
<script src="<%=Constantes.JSP_BACKOFFICE%>/js/jquery-1.11.0.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="<%=Constantes.JSP_BACKOFFICE%>/js/bootstrap.min.js"></script>

<!-- Custom Theme JavaScript -->
<script src="<%=Constantes.JSP_BACKOFFICE%>/js/sb-admin-2.js"></script>

<!-- dataTables -->
<script
	src="<%=Constantes.JSP_BACKOFFICE%>/js/plugins/dataTables/dataTables.bootstrap.js"></script>
<script
	src="<%=Constantes.JSP_BACKOFFICE%>/js/plugins/dataTables/jquery.dataTables.js"></script>

<script type="text/javascript">
$(document).ready(function() {
		$('#idPersonas').dataTable();
		
		$('input[name=rol]').val($("#selectRol option:selected").text());
		
	    $('#selectRol').change(function() {
	    	 $('input[name=rol]').val($("#selectRol option:selected").text());
	      });  

	});

	// For demo to fit into DataTables site builder...
	$('#idPersonas').removeClass('display').addClass(
			'table table-striped table-bordered');
</script>
</body>

</html>
