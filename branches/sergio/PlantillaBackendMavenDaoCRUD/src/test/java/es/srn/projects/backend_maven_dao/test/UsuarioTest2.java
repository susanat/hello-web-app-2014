package es.srn.projects.backend_maven_dao.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import es.srn.projects.backend_maven_dao.bean.Usuario;
import es.srn.projects.backend_maven_dao.dao.factoria.interfaz.IUsuarioDAO;
import es.srn.projects.backend_maven_dao.dao.factoria.mysql.MysqlDAOFactory;

public class UsuarioTest2 {

	private static IUsuarioDAO modelUsuario = null; 
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		modelUsuario = MysqlDAOFactory.getInstance().getUsuarioDAO();
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {

		

	}
	
	@Test
	public void testListAll() {
		
		try {
			modelUsuario.beginTrans();
			
			Usuario obj1 = new Usuario("Usuario 1","primero primero");		
			modelUsuario.insert(obj1);
			
			Usuario obj2 = new Usuario("Usuario 2", "segundo segundo");
			modelUsuario.insert(obj2);
		
			modelUsuario.commit();
			
			
			List<Usuario> Usuarios = modelUsuario.getAll();			
			assertTrue(Usuarios.size() > 0);
						
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
				
			
	}
	
	/*
	@Test
	public void testInsert() {
		
		try {
			UsuarioService objdao=new UsuarioService();
			
			Usuario obj = new Usuario();		
			obj.setNombre("Usuario a insertar y dejar");
			objdao.GuardarUsuario(obj);
			
			//obtenemos el id
			int id = obj.getId();
			
			//El Usuario tiene que existir						
			assertNotNull(objdao.BuscarUsuario(id));
								
		} catch(Exception ex) {			
        	ex.printStackTrace();        	
        	fail(ex.getMessage());
		}
	}
	
	@Test
	public void testUpdate() {
		
		try {
			UsuarioService objdao=new UsuarioService();
			
			Usuario obj = new Usuario();		
			obj.setNombre("Usuario a actualizar");
			objdao.GuardarUsuario(obj);
			
			//obtenemos el id
			int id = obj.getId();
			
			//El Usuario tiene que existir						
			Usuario obj2 =  objdao.BuscarUsuario(id);			
			obj2.setNombre("Modificado");
			objdao.ActualizarUsuario(obj2);
			
			obj2 = null;
			
			
			obj2 = objdao.BuscarUsuario(id);
			assertTrue("Modificado".equals(obj2.getNombre()));
			
			
								
		} catch(Exception ex) {			
        	ex.printStackTrace();        	
        	fail(ex.getMessage());
		}
	}
	
	
	@Test
	public void testDelete() {
		
		try {
			UsuarioService objdao=new UsuarioService();
			
			Usuario obj = new Usuario();		
			obj.setNombre("Usuario a borrar");
			objdao.GuardarUsuario(obj);
			
			//obtenemos el id
			int id = obj.getId();
			
			//El Usuario tiene que existir						
			assertNotNull(objdao.BuscarUsuario(id));
				
			//Entonces, lo elimino
			objdao.EliminarUsuario(obj);		
			
			//el Usuario no tiene que existir
			Usuario obj2 = objdao.BuscarUsuario(id); 
			
			assertNull(obj2);
					
		} catch(Exception ex) {			
        	ex.printStackTrace();        	
        	fail(ex.getMessage());
		}
		
	}
	*/
}
