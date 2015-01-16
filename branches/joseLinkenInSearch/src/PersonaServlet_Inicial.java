

import ipt.fm.ipartek.test.linkedin.Constantes;
import ipt.fm.ipartek.test.linkedin.bean.Persona;
import ipt.fm.ipartek.test.linkedin.modelo.dao.DAOFactory;
import ipt.fm.ipartek.test.linkedin.modelo.dao.IPersonaDAO;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PersonaServlet
 */
public class PersonaServlet_Inicial extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IPersonaDAO daoPersona = null;
	RequestDispatcher dispatcher = null;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PersonaServlet_Inicial() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		DAOFactory factoria = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		daoPersona = factoria.getPersonaDAO();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		if (id == null) {
			getListado(request);
			dispatcher.forward(request, response);
		}else{
			// Accion modificar
			Persona p = new Persona();
			p.setId(Integer.parseInt(id));
			p = daoPersona.getById(p);
			request.setAttribute("persona", p);
			request.getRequestDispatcher(Constantes.CTE_PERSONAS_FORM).forward(request,
					response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Persona persona = null;
		
		// Recogemos la accion a ejecutar
		String accion = request.getParameter("action");

		// Miramos que accion ejecutamos
		// Si es una nueva persona
		if (Constantes.CTE_ACC_NUEVO.equalsIgnoreCase(accion)) {
			// Recogemos los datos de la Persona
			persona=obtenerPersona(request);
			// Anadimos la Persona a la Tabla
			daoPersona.insert(persona);
		} else {
			String id = request.getParameter("id");
			//Si es actualizar
			if(Constantes.CTE_ACC_ACTUALIZAR.equalsIgnoreCase(accion)){
				// Recogemos los datos de la Persona
				persona=obtenerPersona(request);
				persona.setId(Integer.parseInt(id));
				// Actualizamos la Persona en la Tabla
				daoPersona.update(persona);
			}else{
				//Si es eliminar
				persona=new Persona();
				persona.setId(Integer.parseInt(id));
				daoPersona.delete(persona);
			}
		}
		// Redireccionamos al Listado de Personas
		getListado(request);
		dispatcher.forward(request, response);
		}

	/**
	 * Obtiene el listado de las Personas de las tablas y redirecciona al listado de personas
	 * @param request
	 */
	private void getListado(HttpServletRequest request) {
		ArrayList<Persona> vPersonas = daoPersona.getAll();
		// pasar attributo resultado
		request.setAttribute("personas", vPersonas);
		// forward a la vista
		dispatcher = request.getRequestDispatcher(Constantes.CTE_PERSONAS_LIST);
	}
	
	/**
	 * Crea un objeto Persona a partir de sus datos (nombre, apellidos y foto)
	 * @param request
	 * @return Persona
	 */
	private Persona obtenerPersona(HttpServletRequest request){
		Persona p=null;
		
		String nombre = request.getParameter("nombre");
		String apellidos = request.getParameter("apellidos");
		String foto = request.getParameter("foto");
		p = new Persona(nombre, apellidos, foto);
		return p;
	}
	/**
	 * Inserta una Persona en la tabla
	 * 
	 * @param persona
	 *            Persona que se va insertar en la tabla
	 * @return true si se ha insertado correctamente, false eoc
	 */
	private boolean insertar(Persona persona) {
		boolean bInsertado = false;
/*
		String sqlInsert = "INSERT INTO persona ( id, nombre, apellidos, edad) VALUES (?, ?, ? ,? );";
		try {
			Connection conexion = FactoriaMySql.conectar();
			PreparedStatement st = conexion.prepareStatement(sqlInsert);
			// sustituir ? por valores en la sentencia SQL del prepareStatement
			st.setInt(1, persona.getId());
			st.setString(2, persona.getNombre());
			st.setString(3, persona.getApellidos());
			st.setInt(4, 69);

			// 4.- Ejecutar la sentencia
			st.executeUpdate();

			bInsertado = true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		return bInsertado;

	}

	/**
	 * Modifica una Persona de la tabla
	 * 
	 * @param persona
	 *            Persona a modificar
	 * @return true si se ha modificado alguien, false eoc
	 */
	private boolean modificar(Persona persona) {
		boolean bModificado = false;
		/*
		int nModificados = 0;

		String sqlUpdate = "UPDATE personas SET nombre=?, apellidos=? where id=?;";
		try {
			Connection conexion = FactoriaMySql.conectar();
			PreparedStatement st = conexion.prepareStatement(sqlUpdate);
			// sustituir ? por valores en la sentencia SQL del prepareStatement
			st.setString(1, persona.getNombre());
			st.setString(2, persona.getApellidos());
			st.setInt(3, persona.getId());

			// 4.- Ejecutar la sentencia
			nModificados = st.executeUpdate();
			bModificado = (nModificados == 0 ? false : true);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		return bModificado;
	}

	private int eliminar(String id) {
		int numEliminados = 0;
/*
		String sqlDelete = "DELETE FROM personas WHERE id=?;";
		try {
			Connection conexion = FactoriaMySql.conectar();
			PreparedStatement st = conexion.prepareStatement(sqlDelete);
			// sustituir ? por valores en la sentencia SQL del prepareStatement
			st.setInt(1, Integer.parseInt(id));

			// 4.- Ejecutar la sentencia
			numEliminados = st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
*/
		return numEliminados;
	}

	private ResultSet consultar(Persona persona) {
		ResultSet rs = null;
/*
		String sqlSelectAll = "SELECT * FROM personas;";
		String sqlSelect = "SELECT * FROM personas WHERE nombre=? OR apellidos=?;";
		Connection conexion = FactoriaMySql.conectar();
		PreparedStatement st;
		try {
			if (persona != null) {
				st = conexion.prepareStatement(sqlSelect);
				st.setString(1, persona.getNombre());
				st.setString(2, persona.getApellidos());
			} else {
				st = conexion.prepareStatement(sqlSelectAll);
			}
			rs = st.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		return rs;
	}

	private int totalRegistros() {
		int numRegistros = -1;
/*
		String sqlCount = "SELECT COUNT(*) AS total FROM personas;";
		Connection conexion = FactoriaMySql.conectar();

		try {
			PreparedStatement st = conexion.prepareStatement(sqlCount);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				numRegistros = Integer.parseInt(rs.getString("total"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
*/
		return numRegistros;
	}

	private String mostrarConsulta(ResultSet rs) {
		String resultado = "";
		try {
			while (rs.next()) {
				resultado += rs.getString("nombre");
				resultado += rs.getString("apellidos");
				resultado += rs.getInt("edad");
				resultado += "<br>";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultado;
	}

}
