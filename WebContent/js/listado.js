$(document).ready(function() {
	$('#idAgenda').DataTable({
		"bFilter" : false,
		"aoColumnDefs" : [ {
			"bSortable" : false,
			"aTargets" : [ 0,1 ]
		}, ]
	});

	//Borramos la clase del la primera columna
	$("#idAgenda tr").find('th:eq(0)').removeClass("sorting_asc");
	$("#idAgenda tr").find('th:eq(1)').removeClass("sorting_asc");
	//$("#idAgenda tr").find('th:eq(1)').toggleClass("sorting_asc");
	//$("#idAgenda tr").find('td:eq(0)').removeClass("sorting_1");
	//$("#idAgenda tr").find('td:eq(1)').toggleClass("sorting_1");
	
	//Funcion que pone/quita el valor de los checbox seleccionados/deseleccionados en el campo 'idEliminar' 
	$('input[type="checkbox"]').change(function() {
		//odtengo el valor de campo CheckBox
		var value = $(this).val();
		//odtengo el valor del campo IdEliminar
		var sIdEliminar = $('#idEliminar').val();
		var vIdEliminar = jQuery.makeArray(sIdEliminar.split(';'));

		//Si el campo esta chequeado
		if ($(this).prop('checked')) {
			if (!sIdEliminar){
				vIdEliminar[0]=value;
			}else{
				//Anado el valor al array de IDs a eliminar
				vIdEliminar.push(value);				
			}
		}else{		
			indEliminar=jQuery.inArray(value,vIdEliminar);
			//Elimino el valor del array de IDs a eliminar
			vIdEliminar.splice(indEliminar,1);
			/*
			vIdEliminar = jQuery.grep(vIdEliminar, function( a ) {
				return a !== value;
				});
				*/			
		}
		//cargo los datos en el campo con los identificadores a eliminar
		sIdEliminar=vIdEliminar.join(';');
		$('#idEliminar').val(sIdEliminar);	
	});
});
