package com.ipartek.formacion.buscarpersonas.model.rdbms;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ipartek.formacion.buscarpersonas.bean.Persona;
import com.ipartek.formacion.buscarpersonas.model.DAOFactory;
import com.ipartek.formacion.buscarpersonas.model.IConnection;
import com.ipartek.formacion.buscarpersonas.model.IPersonaDAO;
import com.ipartek.formacion.buscarpersonas.util.Constantes;

public class PersonaDAO implements IPersonaDAO {
    private Connection connection;
    private IConnection con;
    private ResultSet rs;

    public PersonaDAO(final int whichFactory) {
	con = DAOFactory.getDAOFactory(whichFactory).getIConnection();
	connection = con.getConnection();
	con.connect();
	rs = null;
    }

    @Override
    public ArrayList<Persona> getAll() {
	ArrayList<Persona> personas = null;
	// int reg = Constantes.SQL_ERROR;
	// con.connect();
	CallableStatement cStmt = null;
	try {

	    cStmt = connection.prepareCall("{call getAll()}");
	    rs = cStmt.executeQuery();
	    Persona p = null;
	    personas = new ArrayList<Persona>();
	    while (rs.next()) {
		p = new Persona();
		rsToPojo(p);
		personas.add(p);
		p = null;
	    }
	} catch (SQLException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} finally {
	    if (cStmt != null) {
		try {
		    cStmt.close();
		} catch (SQLException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		}
	    }
	    if (rs != null) {
		try {
		    rs.close();
		} catch (SQLException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		}
	    }
	    /*
	     * if (con != null) { con.disconnect(); }
	     */
	}
	return personas;
    }

    @Override
    public Persona getById(final Persona p) {
	Persona per = null;
	CallableStatement cStmt = null;
	// int reg = Constantes.SQL_ERROR;
	// con.connect();
	try {
	    cStmt = connection.prepareCall("{call getById(?)}");
	    cStmt.setInt(1, p.getCodigo());
	    rs = cStmt.executeQuery();
	    while (rs.next()) {
		per = new Persona();
		per = rsToPojo(per);
	    }

	} catch (SQLException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} finally {
	    if (cStmt != null) {
		try {
		    cStmt.close();
		} catch (SQLException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		}
	    }
	    if (rs != null) {
		try {
		    rs.close();
		} catch (SQLException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		}
	    }
	    /*
	     * if (con != null) { con.disconnect(); }
	     */
	}
	return per;
    }

    @Override
    public int insert(final Persona p) {
	int reg = Constantes.SQL_ERROR;
	CallableStatement cStmt = null;
	// con.connect();

	try {
	    cStmt = connection.prepareCall("{call insertPersona(?,?,?)}");
	    cStmt.setString(1, p.getNombre());
	    cStmt.setString(2, p.getApellidos());
	    cStmt.setString(3, p.getFoto());
	    reg = cStmt.executeUpdate();
	    rs = cStmt.getGeneratedKeys();
	} catch (SQLException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} finally {
	    if (cStmt != null) {
		try {
		    cStmt.close();
		} catch (SQLException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		}
	    }
	    if (rs != null) {
		try {
		    rs.close();
		} catch (SQLException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		}
	    }
	    /*
	     * if (con != null) { con.disconnect(); }
	     */
	}
	return reg;
    }

    @Override
    public int delete(final Persona p) {
	int reg = Constantes.SQL_ERROR;
	CallableStatement cStmt = null;
	// con.connect();

	try {
	    cStmt = connection.prepareCall("{call deletePersona(?)}");
	    cStmt.setInt(1, p.getCodigo());

	    reg = cStmt.executeUpdate();
	} catch (SQLException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} finally {
	    if (cStmt != null) {
		try {
		    cStmt.close();
		} catch (SQLException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		}
	    }
	    if (rs != null) {
		try {
		    rs.close();
		} catch (SQLException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		}
	    }
	    /*
	     * if (con != null) { con.disconnect(); }
	     */
	}
	return reg;
    }

    @Override
    public int update(final Persona p) {
	int reg = Constantes.SQL_ERROR;
	CallableStatement cStmt = null;

	// con.connect();

	try {
	    cStmt = connection.prepareCall("{call updatePersona(?,?,?,?)}");
	    cStmt.setString(1, p.getNombre());
	    cStmt.setString(2, p.getApellidos());
	    cStmt.setString(3, p.getFoto());
	    cStmt.setInt(4, p.getCodigo());

	    reg = cStmt.executeUpdate();
	} catch (SQLException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} finally {
	    if (cStmt != null) {
		try {
		    cStmt.close();
		} catch (SQLException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		}
	    }
	}
	return reg;
    }

    private Persona rsToPojo(final Persona p) {
	try {
	    p.setCodigo(rs.getInt(CAMPOS[0]));
	    p.setNombre(rs.getString(CAMPOS[1]));
	    p.setApellidos(rs.getString(CAMPOS[2]));
	    p.setFoto(rs.getString(CAMPOS[3]));
	} catch (SQLException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} finally {
	    /*
	     * if (con != null) { con.disconnect(); }
	     */
	}

	return p;
    }
}
