package ipt.fm.ipartek.linkedin.modelo.dao;

import ipt.fm.ipartek.linkedin.bean.Persona;

import java.util.ArrayList;

/**
 * Interfaz para definir las operaciones de CRUD contra la tabla Persona de la
 * BBDD la cual luego deberemos implmentar segun la BBDD que usemos
 * 
 * @author Maitane Casado
 *
 */

public interface IPersonaDAO {

	static final String TABLA = "persona";
	static final String COL_ID = "id";
	static final String COL_NOMBRE = "nombre";
	static final String COL_APELLIDOS = "apellido1";
	static final String COL_FOTO = "foto";

	/**
	 * Se selecciona todos los registos de la BBDD (tabla Personas)
	 * 
	 * @return ArrayList de todos los registros de la tabla Personas
	 */

	ArrayList<Persona> getAll();

	/**
	 * Se selecciona un registo de la BBDD (tabla Personas) por su ID
	 * 
	 * @param p
	 *            Objeto Persona a buscar en la BBDD
	 * @return registro encontrado en la BBDD. Si no se encuentra este objeto
	 *         será null
	 */

	Persona getbyId(Persona p);

	/**
	 * Se inserta un nuevo registo en la BBDD (tabla Personas)
	 * 
	 * @param p
	 *            Registro a insertar en la tabla
	 * @return el ID de la persona insertada. Si hay error devolvera -1
	 */
	int insert(Persona p);

	/**
	 * Borrará un registo en la BBDD (tabla Personas)
	 * 
	 * @param p
	 *            Registro a eliminar
	 * @return true si se ha eliminado con exito. False en caso contrario
	 */

	boolean delete(Persona p);

	/**
	 * Se actualizará un registo en la BBDD (tabla Personas)
	 * 
	 * @param p
	 *            Objeto persona a actualizar en la BBDD
	 * @return true si se ha actualizado con exito. False en caso contrario
	 */
	boolean update(Persona p);
}
