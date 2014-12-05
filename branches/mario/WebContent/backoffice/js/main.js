/*
*JavaScript personalizado para realizar todo lo que necesite-
*Se ejecuta despues de cargar todas las librerias del proyecto.
*
*/
$( document ).ready(function() {
    
     $('#tabla').dataTable( {
         "language": {
        	 "lengthMenu": "Muestra _MENU_ registros por pantalla",
             "zeroRecords": "No hay datos para mostrar",
             "info": "Mostrando pagina _PAGE_ de _PAGES_",
             "infoEmpty": "No hay datos",
             "infoFiltered": " ( filtrados de _MAX_ registro(s) )"
         }
     } );
});

