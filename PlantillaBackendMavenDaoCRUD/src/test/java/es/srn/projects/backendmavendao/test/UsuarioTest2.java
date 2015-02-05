package es.srn.projects.backendmavendao.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import es.srn.projects.backendmavendao.bean.Usuario;
import es.srn.projects.backendmavendao.dao.factoria.DAOFactory;
import es.srn.projects.backendmavendao.dao.factoria.interfaz.IUsuarioDAO;
import es.srn.projects.backendmavendao.dao.factoria.mysql.MysqlDAOFactory;

/**
 * Test del Bean Usuario sin sus relaciones.
 * @author baskito
 *
 */
public class UsuarioTest2 {

	/**
	 * Modelo del usuario.
	 */
	private static IUsuarioDAO modelUsuario = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		try {
			DAOFactory factoria = DAOFactory.getDaoFactoriaAbstracta(DAOFactory.MYSQL);						
			modelUsuario = factoria.getUsuarioDAO();

			// borramos la tabla del usuario
			modelUsuario.deleteTable();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		// la creamos antes de cada test
		modelUsuario.createTable();
	}

	@After
	public void tearDown() throws Exception {
		// borramos la tabla después del test
		modelUsuario.deleteTable();
	}

	@Test
	public void testListAll() {
		try {

			modelUsuario.beginTrans();

			Usuario obj1 = new Usuario("Usuario 1", "primero primero");
			modelUsuario.insert(obj1);

			Usuario obj2 = new Usuario("Usuario 2", "segundo segundo");
			modelUsuario.insert(obj2);

			modelUsuario.commit();

			List<Usuario> Usuarios = modelUsuario.getAll();
			assertTrue(Usuarios.size() > 0);

		} catch (Exception ex) {
			try {
				modelUsuario.rollback();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ex.printStackTrace();
			fail(ex.getMessage());
		}
	}

	@Test
	public void testInsert() {
		try {
			// inserto el usuario
			modelUsuario.beginTrans();			
			Usuario obj1 = new Usuario("Usuario 1", "primero primero");
			obj1 = modelUsuario.insert(obj1);
			modelUsuario.commit();

			// obtengo el id. El usuario tiene que existir
			assertNotNull(modelUsuario.getById(obj1.getId()));
		} catch (Exception ex) {
			try {
				modelUsuario.rollback();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ex.printStackTrace();
		}
	}

	@Test
	public void testUpdate() {
		try {
			// inserto el usuario
			modelUsuario.beginTrans();
			Usuario obj1 = new Usuario("Usuario Para borrar", "primero primero");
			obj1 = modelUsuario.insert(obj1);
			modelUsuario.commit();

			// obtengo el id. El usuario tiene que existir
			obj1 = modelUsuario.getById(obj1.getId());

			// obtengo el id. El usuario tiene que existir
			assertNotNull(obj1);

			// Elimino el registro
			modelUsuario.beginTrans();
			modelUsuario.delete(obj1);
			modelUsuario.commit();

			// obtengo el id. El usuario tiene que existir
			obj1 = modelUsuario.getById(obj1.getId());

			assertNull(obj1);

		} catch (Exception ex) {
			try {
				modelUsuario.rollback();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ex.printStackTrace();
			fail(ex.getMessage());
		}
	}

	@Test
	public void testDelete() {

		try {

			// inserto el usuario de muestra
			modelUsuario.beginTrans();
			Usuario obj1 = new Usuario("Usuario 1", "primero primero");
			obj1 = modelUsuario.insert(obj1);
			modelUsuario.commit();

			// obtengo el id. El usuario tiene que existir
			obj1 = modelUsuario.getById(obj1.getId());
			assertNotNull(obj1);

			String strModificado = "Modificado";

			// Modifico el usuario nombre
			modelUsuario.beginTrans();
			obj1.setUsername(strModificado);
			obj1 = modelUsuario.update(obj1);
			modelUsuario.commit();

			// obtengo el id. El usuario tiene que existir
			obj1 = modelUsuario.getById(obj1.getId());
			assertTrue(obj1.getUsername().equals(strModificado));

		} catch (Exception ex) {
			try {
				modelUsuario.rollback();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ex.printStackTrace();
			fail(ex.getMessage());
		}
	}
}
