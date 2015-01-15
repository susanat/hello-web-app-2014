package ipt.fm.ipartek.test.linkedin.servlet;

import ipt.fm.ipartek.test.linkedin.bean.Mensaje;
import ipt.fm.ipartek.test.linkedin.bean.Persona;
import ipt.fm.ipartek.test.linkedin.bean.Mensaje.MsgType;
import ipt.fm.ipartek.test.linkedin.modelo.dao.DAOFactory;
import ipt.fm.ipartek.test.linkedin.modelo.dao.IPersonaDAO;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PersonaServlet
 */
public class PersonaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * Objeto de tipo Mensaje para la comunicación con el usuario.
	 */
	private static Mensaje mensaje = null;
	/**
	 * Objeto tipo DAOFactoria. Selecciona el tipo de base de datos a controlar.
	 */
	private static DAOFactory factoria = null;
	/**
	 * Objeto de tipo IPersonaDAO que realiza las consultas a base de datos.
	 */
	private static IPersonaDAO daoPersona = null;

	private String avisoSAT = "Inténtelo mas tarde y si persiste contacte con el servicio técnico.";

	@Override
	public void init() throws ServletException {
		super.init();
		factoria = DAOFactory.getFactoryDAO(DAOFactory.MYSQL);
		daoPersona = factoria.getPersonaDAO();
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		mensaje = null;
		req.setCharacterEncoding("UTF-8");
		super.service(req, resp);
	}

	@Override
	public void destroy() {
		factoria = null;
		daoPersona = null;
		super.destroy();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		cargarLista(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("id");
		String nombre = "";
		String apellidos = "";
		Persona p = null;
		if ("0".equals(request.getParameter("operacion"))) {
			// Actualizar
			nombre = request.getParameter("nombre");
			apellidos = request.getParameter("apellidos");
			p = new Persona(nombre, apellidos, Integer.parseInt(id));
			p = daoPersona.update(p);
			if (p == null) {
				// No se ha ejecutado correctamente la actualización.
				mensaje = new Mensaje(
						"No se ha podido actualizar el registro. " + avisoSAT,
						MsgType.ERR);
			} else {
				mensaje = new Mensaje("Modificación realizada con éxito.",
						MsgType.INF);
			}
		} else if ("1".equals(request.getParameter("operacion"))) {
			p = new Persona("", "", Integer.parseInt(id));
			// Borrar
			if (!daoPersona.delete(p)) {
				// No se ha ejecutado correctamente el borrado.
				mensaje = new Mensaje("No se ha podido borrar el registro. "
						+ avisoSAT, MsgType.ERR);
			} else {
				mensaje = new Mensaje("Persona eliminada de la lista.",
						MsgType.INF);
			}
		} else if ("2".equals(request.getParameter("operacion"))) {
			// Añadir
			nombre = request.getParameter("nombre");
			apellidos = request.getParameter("apellidos");
			p = new Persona(nombre, apellidos);
			if (request.getParameter("foto") != null) {
				p.setFoto(request.getParameter("foto"));
			}
			p = daoPersona.insert(p);
			if (p == null) {
				// No se ha ejecutado correctamente la inserción.
				mensaje = new Mensaje("No se ha podido insertar. " + avisoSAT,
						MsgType.ERR);
			} else {
				mensaje = new Mensaje("Persona añadida correctamente.",
						MsgType.INF);
			}
		}

		cargarLista(request, response);

	}

	/**
	 * Carga la lista de personas y redirige al jsp correspondiente.
	 * 
	 * @param request
	 */
	private void cargarLista(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Persona> personas = daoPersona.getAll();
		if (personas == null) {
			// No se ha podido recuperar la lista de personas por un error.
			mensaje = new Mensaje(
					"No se ha podido recuperar las lista de personas. "
							+ avisoSAT, MsgType.ERR);
		}
		if (mensaje != null) {
			// Si se ha grabado algún mensaje de error, se manda a la petición
			// para ser mostrado.
			request.setAttribute("mensaje", mensaje);
		}
		request.setAttribute("personas", personas);
		request.getRequestDispatcher("listadosPersonas.jsp").forward(request,
				response);
	}

	/*
	 * private Connection conectar() { Connection conexion = null;
	 * 
	 * try { // 1.- cargar driver Class.forName("com.mysql.jdbc.Driver"); // 2.-
	 * Establecer conexion conexion =
	 * DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "");
	 * 
	 * InitialContext ctx = new InitialContext(); DataSource ds = (DataSource)
	 * ctx .lookup("java:comp/env/jdbc/TestDB"); conexion = ds.getConnection();
	 * 
	 * } catch (Exception e) {
	 * 
	 * e.printStackTrace();
	 * 
	 * } return conexion; }
	 * 
	 * 
	 * private void cerrarObjetos(Statement st, ResultSet rs) { // cerrar
	 * ResultSet if (rs != null) { try { rs.close(); } catch (Exception e) {
	 * e.printStackTrace(); } }
	 * 
	 * // cerrar Statements if (st != null) { try { st.close(); } catch
	 * (Exception e) { e.printStackTrace(); } } }
	 * 
	 * private ArrayList<Persona> listar() { // StringBuilder personas = new
	 * StringBuilder(); ArrayList<Persona> personas = new ArrayList<Persona>();
	 * 
	 * Connection conexion = null; Statement st = null; ResultSet rs = null;
	 * 
	 * try { // 1.- cargar driver // Class.forName("com.mysql.jdbc.Driver"); //
	 * 2.- Establecer conexion // // conexion = DriverManager.getConnection(
	 * "jdbc:mysql://localhost/test", "root", ""); // conexion =
	 * FactoriaMySql.conectar();
	 * 
	 * // consultar tabla personas st = conexion.createStatement(); //
	 * 5.-Recoger resultados rs = st.executeQuery("select * from persona");
	 * 
	 * while (rs.next()) { // personas.append(rs.getString("nombre") + ","); //
	 * personas.append(rs.getString("apellido1") + ","); //
	 * personas.append(rs.getInt("id") + ";"); personas.add(new
	 * Persona(rs.getString("nombre"), rs .getString("apellido1"),
	 * rs.getInt("id"))); } } catch (Exception e) { e.printStackTrace(); }
	 * finally { // cerrar todos los objetos creados para el acceso a BBDD
	 * cerrarObjetos(st, rs); // FactoriaMySql.desconectar(); try {
	 * conexion.close(); } catch (Exception e) { } } return personas; }
	 * 
	 * private void insertar(Persona p) {
	 * 
	 * Connection conexion = null; PreparedStatement st2 = null; ResultSet rs =
	 * null;
	 * 
	 * try { // 1.- cargar driver // Class.forName("com.mysql.jdbc.Driver"); //
	 * 2.- Establecer conexion // conexion = DriverManager.getConnection( //
	 * "jdbc:mysql://localhost/test", "root", ""); conexion =
	 * FactoriaMySql.conectar();
	 * 
	 * // 3.- Crear Stament a traves de la conexion // insertar persona nueva
	 * String sqlInsert =
	 * "INSERT INTO persona ( nombre, apellido1) VALUES (?,?)"; st2 =
	 * conexion.prepareStatement(sqlInsert); st2.setString(1, p.getNombre());
	 * st2.setString(2, p.getApellidos());
	 * 
	 * // 4.- Ejecutar la sentencia st2.executeUpdate(); } catch (Exception e) {
	 * e.printStackTrace(); } finally { // cerrar todos los objetos creados para
	 * el acceso a BBDD cerrarObjetos(st2, rs); FactoriaMySql.desconectar(); }
	 * 
	 * }
	 * 
	 * private void actualizar(Persona p) {
	 * 
	 * Connection conexion = null; PreparedStatement st2 = null; ResultSet rs =
	 * null;
	 * 
	 * try { // 1.- cargar driver // Class.forName("com.mysql.jdbc.Driver"); //
	 * 2.- Establecer conexion // conexion = DriverManager.getConnection( //
	 * "jdbc:mysql://localhost/test", "root", ""); conexion =
	 * FactoriaMySql.conectar();
	 * 
	 * // 3.- Crear Stament a traves de la conexion // insertar persona nueva
	 * String sqlInsert = "UPDATE persona SET nombre=?, apellido1=? WHERE id=?";
	 * st2 = conexion.prepareStatement(sqlInsert); st2.setString(1,
	 * p.getNombre()); st2.setString(2, p.getApellidos()); st2.setInt(3,
	 * p.getId());
	 * 
	 * // 4.- Ejecutar la sentencia st2.executeUpdate(); } catch (Exception e) {
	 * e.printStackTrace(); } finally { // cerrar todos los objetos creados para
	 * el acceso a BBDD cerrarObjetos(st2, rs); FactoriaMySql.desconectar(); }
	 * 
	 * }
	 * 
	 * private void borrar(String id) {
	 * 
	 * Connection conexion = null; PreparedStatement st2 = null; ResultSet rs =
	 * null;
	 * 
	 * try { // 1.- cargar driver // Class.forName("com.mysql.jdbc.Driver"); //
	 * 2.- Establecer conexion // conexion = DriverManager.getConnection( //
	 * "jdbc:mysql://localhost/test", "root", ""); conexion =
	 * FactoriaMySql.conectar();
	 * 
	 * // 3.- Crear Stament a traves de la conexion // insertar persona nueva
	 * String sqlInsert = "DELETE FROM persona WHERE id=?"; st2 =
	 * conexion.prepareStatement(sqlInsert); st2.setString(1, id);
	 * 
	 * // 4.- Ejecutar la sentencia st2.executeUpdate(); } catch (Exception e) {
	 * e.printStackTrace(); } finally { // cerrar todos los objetos creados para
	 * el acceso a BBDD cerrarObjetos(st2, rs); FactoriaMySql.desconectar(); }
	 * 
	 * }
	 */
}
