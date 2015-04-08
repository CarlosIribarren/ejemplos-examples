package my.project.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import my.project.database.Database;

@WebServlet("/empleadoServlet")
public class Empleado extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Database db;
	Connection connection;

	public Empleado() {
		super();
		db = new Database("jdbc/empresaReparto");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String query = "SELECT * FROM empleado";
		ResultSet rs;

		try {
			connection = db.getConnection();
			Statement st = connection.createStatement();
			rs = st.executeQuery(query);
			while(rs.next()){
				System.out.println(rs.getString("nombre"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
