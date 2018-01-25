package my.project.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import my.project.database.Database;

@WebServlet("/consultaSimple")
public class consultaSimple extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	Database db;
	Connection connection;
	
    public consultaSimple() {
        super();
        db = new Database("jdbc/empresaReparto");
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String query = "SELECT nombre FROM empleado WHERE nombre = ? ";

		try {
			// Para consultas de selección
			connection = db.getConnection();
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1,"carlos");
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				System.out.println(rs.getString("nombre"));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//------- calendar -------------
		// -- definir fecha --
		Calendar calendar = Calendar.getInstance();
		calendar.set(2014, 12,2);
		
		//------ Obtener fecha ---------
		Date date = calendar.getTime();
		
	}

}
