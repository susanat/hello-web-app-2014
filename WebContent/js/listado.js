$(document).ready(function() {
	$('#idAgenda').DataTable({
		"bFilter" : false,
		"aoColumnDefs" : [
			{ "bSortable": false, "aTargets": [ 0 ] },
		]
	});
});
