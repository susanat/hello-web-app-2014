package com.ipartek.formacion.agenda;

/**
 * Contiene Constantes a utilizar en la agenda
 * <ul>
 * <li>Acciones a Ejecutar</li>
 * <li>Nombre de las columnas de la vista de la agenda</li>
 * </ul>
 *
 * @author Curso
 *
 */
public class Constantes {
	// Listado de posibles acciones a ejecutar
	public static final String OP_KEY = "acc";
	public static final String OP_BUSCAR = "f";
	public static final String OP_ELIMINAR = "d";
	public static final String OP_ACTUALIZAR = "u";
	public static final String OP_CREAR = "c";

	// Servlet
	public static final String CONTROLLER_AGENDA = "Listado.jsp";
	public static final String CONTROLLER_DETALLE = "Detalle.jsp";

	// Atrinuttos
	public static final String ATT_PERSONA = "persona";
}
