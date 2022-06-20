package dbHelpers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class CreateAccountQuery {
	Connection conn;
	ResultSet rs;
	//constructor to get a db connection object
	public CreateAccountQuery() throws Exception {
		// conn = [call your static DB method]
		conn= DB.getConnection();
	}
	//method to enter a user into table when user made a new account
	public boolean doRead(String username, String password, String phoneNumber, String email, String address) throws SQLException {
		// READ your Data and save it in ResultSet
		String uname= username;
		String upassword = password;
		String uphoneNumber = phoneNumber;
		String uemail = email;
		String uaddress = address;

		if (uname != null && upassword != null && uphoneNumber != null && uemail != null && uaddress != null) {
			
			String sql1 = "SELECT * FROM user_account WHERE username=?";
			PreparedStatement st1 = conn.prepareStatement(sql1);
			st1.setString(1, uname);
			this.rs=st1.executeQuery();
			
			if(!rs.next()) {
				String sql2 = "Insert into user_account values(default,?,?,?,?,?);";
				PreparedStatement st2 = conn.prepareStatement(sql2);
				st2.setString(1, uname);
				st2.setString(2, upassword);
				st2.setString(3, uphoneNumber);
				st2.setString(4, uemail);
				st2.setString(5, uaddress);
	
				st2.executeUpdate();
				return true;
			}else
			{
				return false;
			}
		}
		return false;
	}

}

