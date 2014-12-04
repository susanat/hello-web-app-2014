/*
 * JavaScript personalizado para realizar todo lo que necesite
 * Se ejecuta despues de cargar todas las librerias del proyecto
 *
 */

$(document).ready(function() {
	// cargar datatable
	$('#idPersonas').dataTable();

	/*
	$('input[name=rol]').val($("#selectRol option:selected").text());

	$('#selectRol').change(function() {
		$('input[name=rol]').val($("#selectRol option:selected").text());
	});
	*/

});

// For demo to fit into DataTables site builder...
$('#idPersonas').removeClass('display').addClass(
		'table table-striped table-bordered');
