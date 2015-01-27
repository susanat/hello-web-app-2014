$(document).ready(function(){
	//función que inicializa los objetos del html
	function inicializar() {

		$('#example').dataTable();
		$('#example2').dataTable();

		$('#ano').val((new Date).getFullYear());
		$('#mes').val((new Date).getMonth() + 1);
		$('#btn').click(ejecutar);
	}


	//función que ejecuta la llamada a ajax
	function ejecutar() {	

		//limpiamos títulos y tablas
		clearTables();

		if (validar()) {
			$.ajax(
					{
						// puede ser "get" y "post"
						type: "post",
						// el módulo que hará la búsqueda
						url: "inscripcion",
						// los datos para la consulta
						data: {ano: $('#ano').val(), mes: $('#mes').val()},	                
						// que hacer si esto falla
						error: callback_error,
						// que hacer si funciona
						success: callback_ok	                
					}).done(function() {
						console.info('llamado AJAX');
					});
		}	
	}

	//función que valida los datos de entrada
	function validar() {
		//validamos el año y el mes

		var ano = $('#ano').val(); 
		if(ano == '' ) {
			alert ('Año obligatorio.');
			return false;

		}		

		//no es obligatorio
		/*
			var mes = $('#mes').val();
			if(mes == '' ) {
				alert ('Mes obligatorio.');
				return false;

			}
		 */


		return true;		
	}

	//mostramos un mensaje con la causa del problema
	function callback_error(XMLHttpRequest, textStatus, errorThrown) {
		// en ambientes serios esto debe manejarse con mucho cuidado,
		// aquí optamos por una solución simple
		alert(errorThrown);
		console.log(errorThrown);

		$('#example').dataTable();
		$('#example2').dataTable();

		if(XMLHttpRequest.status==404) {
			alert(thrownError);
		}
	}

	//limpia las tablas
	function clearTables() {

		//limpiamos los títulos
		$('#salidaIns').html();
		$('#salidaAno').html();

		//destruimos el datatable en el caso de example (ajax integrado)
		$('#example').dataTable().fnDestroy();
		$('#example2').dataTable().fnDestroy();		
		
		//$('#example').dataTable().clear();
		//$('#example2').dataTable().clear();

	}

	//crea una tabla y la llena de manera dinámica (deprecated)
	function dinamicTable( result ) {

		$('#lstPersonas_wrapper').remove();
		//creo la tabla en el body de manera dinámica
		$('body').append(			
				'<table class="table" id="lstPersonas">'
				+ '<thead>'
				+ '    <tr>'
				+ '    	<th>Id</th>'
				+ '        <th>F. Inscripcion</th>'
				+ '        <th>Nombre</th>'
				+ '        <th>Apellido</th>'
				+ '        <th>Email</th>'
				+ '        <th>Ultimo Acceso</th>'
				+ '        <th>Ultimo Login</th>'						            
				+ '    </tr>'
				+ '</thead>'
				+ '<tbody>'								
				+ '</tbody>'
				+ '</table>'	
		);											

		//recorro el result del ajax y voy introduciendo las filas
		$.each(result['data'], function(posicion, obj){							
			$('#lstPersonas tbody').append(


					'<tr>' 
					+ '<td>' + obj.id + '</td>'
					+ '<td>' + obj.firstaccess + '</td>'
					+ '<td>' + obj.firstname + '</td>'
					+ '<td>' + obj.lastname + '</td>'
					+ '<td>' + obj.email + '@asdfasd</td>'						
					+ '<td>' + obj.lastaccess + '</td>'														
					+ '<td>' + obj.lastlogin + ' </td>'					        		
					+ '</tr>'
			);
		});						
		//configuramos la tabla con el datatable
		$('#lstPersonas').DataTable();		
	}

	//función que llena las tablas si se ha realizado correctamente la llamada de ajax
	function callback_ok( result ) {
		console.log(result);						
		if ( result['response']!=0){
			$('#example').dataTable();
			$('#example2').dataTable();
			alert(result['msg']);			
		}else{



			//añadimos el texto de la principal
			var texto = "Año: " + $('#ano').val();
			if($('#mes').val() != "") {
				texto += " Mes: " + $('#mes').val();
			}
			$('#salidaIns').html(texto);

			//añadimos el al título de la de agrupaciones
			$('#salidaAno').html($('#ano').val());


			/*
			//llenamos con los datos de las personas
			$('#example').dataTable( {						    	
				"aaData": result['data'],
				"aoColumns": [
				              { "data": "id" },
				              { "data": "firstaccess" },
				              { "data": "firstname" },
				              { "data": "lastname" },
				              { "data": "email" },
				              { "data": "lastaccess" },
				              { "data": "lastlogin" }
				              ]
			} );


			$('#example2').dataTable( {						    	
				"aaData": result['group'],
				"aoColumns": [
				              { "data": "month" },
				              { "data": "count" }						            
				              ]
			});
			*/

			dinamicTable( result );	
		}
	}


	inicializar();
});
