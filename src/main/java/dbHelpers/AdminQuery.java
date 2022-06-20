package dbHelpers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class AdminQuery {
	Connection conn;
	ResultSet rs;
	
	public AdminQuery() throws Exception {
		// conn = [call your static DB method]
		conn= DB.getConnection();
	}
	
	//method to check if admin credential are true or not 
	public boolean doRead(String username, String password) throws SQLException {
		// READ your Data and save it in ResultSet
		String aname= username;
		String apassword = password;

		if (aname != null && apassword != null) {

			String sql1 = "SELECT * FROM admin_account WHERE adminname=? AND password=?";
			PreparedStatement st1 = conn.prepareStatement(sql1);
			st1.setString(1, aname);
			st1.setString(2, apassword);

			this.rs=st1.executeQuery();
			
			if(rs.next()) {
				return true;
			}
		}
			return false;
	}
	
}
