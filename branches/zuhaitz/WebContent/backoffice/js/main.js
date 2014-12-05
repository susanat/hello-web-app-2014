$(document).ready(function() {
	/*
	 * $('#personasList').DataTable({ "aoColumns" : [ { "bSearchable" : false }, {
	 * "bSearchable" : true }, { "bSearchable" : false }, { "bSearchable" :
	 * false }, { "bSearchable" : false } ] });
	 */

	$('#example').dataTable({
		"aoColumns" : [ {
			"bSearchable" : false
		}, null, null, null, null ]
	});
});