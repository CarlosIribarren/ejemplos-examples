package my.project.database;
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class Database {

	private DataSource dataSource;
	
	public Database(String jndiName) {
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			this.dataSource =  (DataSource) envContext.lookup(jndiName);
		} catch (NamingException e) {
			// Handle error that it's not configured in JNDI.
			e.printStackTrace();
		}
	}
	public Connection getConnection() throws SQLException {

		return dataSource.getConnection();

	}


}