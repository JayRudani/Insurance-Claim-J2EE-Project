package dbHelpers;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB {
	private static Connection conn;
	
	private DB() {
		
	}
	//method to get connection object to the database
	public static Connection getConnection() throws Exception {
		if(conn == null || conn.isClosed()) {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(
	                "jdbc:mysql://localhost:3306/project_jayrudani", "root", "Rudanijay@98");
		}
		return conn;
	}

}
