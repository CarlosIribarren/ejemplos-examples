package my.project.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import my.project.dao.EmpleadoDAO;
import my.project.database.ConnectionFactory;
import my.project.database.DatabaseUtil;
import my.project.model.Empleado;

public class EmpleadoDAOImpl implements EmpleadoDAO {
    
    public EmpleadoDAOImpl() { }
    
	@Override
	public List<Empleado> findAll() {
		String query = "SELECT * FROM empleado";
		Connection connection = null;
		Statement st = null;
		ResultSet rs = null;

		List<Empleado> empleados = new ArrayList<Empleado>();
		try {
			connection = ConnectionFactory.getConnection();
			st = connection.createStatement();
			rs = st.executeQuery(query);
			while(rs.next()){
				Empleado empleado = new Empleado();
				empleado.setNombre(rs.getString("nombre"));
				empleados.add(empleado);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DatabaseUtil.close(rs);
			DatabaseUtil.close(st);
			DatabaseUtil.close(connection);
		}
		return empleados;
	}

	@Override
	public Empleado getById(String id) {
		String query = "SELECT * FROM empleado WHERE nombre = ?";
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Empleado empleado = new Empleado();
		
		try {
			connection = ConnectionFactory.getConnection();
			ps = connection.prepareStatement(query);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				empleado.setNombre(rs.getString("nombre"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DatabaseUtil.close(rs);
			DatabaseUtil.close(ps);
			DatabaseUtil.close(connection);
		}
		
		return empleado;
	}

}
