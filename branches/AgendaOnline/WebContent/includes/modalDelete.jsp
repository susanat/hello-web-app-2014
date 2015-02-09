<input type="hidden" name="idTextoVacio" id="idTextoVacio" value="No hay ningun contacto seleccionado">
<input type="hidden" name="idTextoSeleccion" id="idTextoSeleccion" value="¿Desea eliminar los siguientes contactos?">

<div class="modal fade" id="modalEliminar" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">Eliminar Contactos</h4>
      </div>
      <div class="modal-body">
        <p></p>
      </div>
      <div class="modal-footer">
      	<!-- TODO: Hacer que se muestre o no un boton en funcion de si hay o no elementos que eliminar -->
        <button type="button" class="btn btn-default" data-dismiss="modal" id="eliminarNo" style="display:solid;">No</button>
        <button type="button" class="btn btn-primary" id="eliminarSi" style="display:solid;">Si</button>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->