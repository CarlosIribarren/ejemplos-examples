import java.sql.*;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class DataSource {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//------ Vamos a utilizar la clase MysqlDataSource ------------
		// esta clase se encuentra en la libreria .jar que hemos añadido
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

			
			//utilizar una clase especifica de MYSQL desarrollada por sun/oracle
			//registrar el driver JDBC para mysql
			MysqlDataSource ds = new MysqlDataSource();
			ds.setServerConfigCacheFactory(servidor);
			ds.setPort(puerto);
			ds.setDatabaseName(nombreDB);
			ds.setUser(usuario);
			ds.setPassword(pass);
			//obtener una conexion a la BD
			con=ds.getConnection();
			
			
			System.out.println("**** Prueba de conexion con la Clase MySQL*****");
			System.out.println("********************************************");
			System.out.println("Conexion : " + con);
			System.out.println("********************************************");
			//obtener un objeto sentencia
			Statement stmt = con.createStatement();
			
			
			// --------------------- TRANSACCIONES ----------------------
			//PONEMOS QUE NOSOTROS NOS ENCARGAMOS DE LOS COMMIT
			con.setAutoCommit(false);
			// ESTAMOS INTENTANDO EJECUTAR
			//incrementar la edad en 1 año a todos los jefes
			int i = stmt.executeUpdate("update empleado set edad = edad + 1 where nombreJefe ='CARLOS'");
			System.out.println("i:" +i);
			
			//HEMOS REALIZADO UN TRANSACCION SIN REALIZAR EL COMMIT
			// ES DECIR, HEMOS REALIZADO LA OPERACION EN MEMORIA, 
			// PERO LUEGO NO HEMOS GUARDADO EN LA BASE DE DATOS
			
			//realizar el commit
			con.commit();
			
			
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
			
			
		} catch ( SQLException e) {
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
