/*
*JavaScript personalizado para realizar todo lo que necesite el proyecto
*Se ejecuta despues de cargar todas las librerias del proyecto
*
*/

$(document).ready(function() {
	    $('#table').DataTable();
	} );

//For demo to fit into DataTables site builder...
$('#table')
	.removeClass( 'display' )
	.addClass('table table-striped table-bordered');