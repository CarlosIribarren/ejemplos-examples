import java.sql.*;

public class DriverManager {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//------ Vamos a utilizar el driver J ( para MySql) ------------
		//--------------------------------------------------------------
		
		//Definir una conexion
		Connection con = null;
		//Definir parametros de la conexion
		String usuario = "root";
		String pass = "passroot";
		String servidor = "localhost";
		int puerto = 3306;
		String nombreDB="empresaReparto";
		
		String url;
		
		try {
			//registrar el driver JDBC para MYSQL
			Class.forName("com.mysql.jdbc.Driver");
			
			//url del servidor de BD
			url = "jdbc:mysql://" + servidor + ":"+puerto+"/"+nombreDB;
			
			//Obtener una conexion con los parametros definidos
			con = (Connection) java.sql.DriverManager.getConnection(url, usuario, pass);
			System.out.println("************ Prueba de conexion *************");
			System.out.println("********************************************");
			System.out.println("URL" + url);
			System.out.println("********************************************");
			System.out.println("Conexion : " + con);
			System.out.println("********************************************");
			//obtener un objeto sentencia
			Statement stmt = con.createStatement();
			//Obtener un conjunto de resultados al ejecutar una sentencia
			ResultSet rs = stmt.executeQuery("Select * from empleado");
			
			//recorrer las filas del conjunto de resultados
			while(rs.next())
			{
				//obtener los valores de cada columna de una fila
				String nombre = rs.getString("nombre");
				Date fecha = rs.getDate(2);
				int edad = rs.getInt(3);
				String nombrejefe = rs.getString(4);
				System.out.println("Nombre : " + nombre + "Fecha : "+fecha
						+ "Eda : " + edad + "Nombre Jefe : " + nombrejefe);
				
			}
			
			//cerrar objetos
			rs.close();
			stmt.close();
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			//COMO FINAL se cierra la conexion SIEMPRE
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
	}
	
}
