package es.srn.projects.backendmavendao.dao.factoria.interfaz;

public interface IGenericDAO {
	
	/**
	 * Función destinada a crear una base de datos.
	 * @return true si se ha creado y false si no.
	 * @throws Exception Excepción en caso de error.
	 */
	public void createDatabase() throws Exception;
	
	/**
	 * Función destinada a crear una tabla en la base de datos.
	 * @return true si se ha creado y false si no.
	 * @throws Exception Excepción en caso de error.
	 */
	public void createTable() throws Exception;
	
	/**
	 * Función destinada a eliminar una tabla en la base de datos.
	 * @return true si se ha creado y false si no.
	 * @throws Exception Excepción en caso de error.
	 */
	public boolean deleteTable() throws Exception;
	
	
	/**
	 * Función destinada a crear una transacción.
	 * @throws Exception Excepción en caso de error.
	 */
	public void beginTrans() throws Exception;
	
	/**
	 * Función destinada a comitar una transacción.	 
	 * @throws Exception Excepción en caso de error.
	 */
	public void commit() throws Exception;
	
	/**
	 * Función destinada a realizar un rollback de una transacción.	 
	 * @throws Exception Excepción en caso de error.
	 */
	public void rollback() throws Exception;	
	
}
