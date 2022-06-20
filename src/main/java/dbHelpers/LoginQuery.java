package dbHelpers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class LoginQuery {
	Connection conn;
	ResultSet rs;
	//constructor to get a db connection object
	public LoginQuery() throws Exception {
		// conn = [call your static DB method]
		conn= DB.getConnection();
	}
	//method to verify a valid user
	public boolean doRead(String username, String password) throws SQLException {
		// READ your Data and save it in ResultSet
		String uname= username;
		String upassword = password;

		if (uname != null && upassword != null) {

			String sql1 = "SELECT * FROM user_account WHERE username=? AND password=?";
			PreparedStatement st1 = conn.prepareStatement(sql1);
			st1.setString(1, uname);
			st1.setString(2, upassword);

			this.rs=st1.executeQuery();
			
			if(rs.next()) {
				return true;
			}
		}
			return false;
	}
	
}
