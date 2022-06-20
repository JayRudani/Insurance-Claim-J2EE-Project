package dbHelpers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import models.Users;

public class AllUserQuery {
	Connection conn;
	ResultSet rsUser_Account;
	//constructor to get db connection object
	public AllUserQuery() throws Exception {
		// conn = [call your static DB method]
		conn = DB.getConnection();
	}
	//method to get all user account
	public void loadData() throws SQLException {

		String sql1 = "SELECT * FROM user_account";
		PreparedStatement st1 = conn.prepareStatement(sql1);
		this.rsUser_Account = st1.executeQuery();

	}
	//method to get particular user account searched by the admin
	public boolean loadData(String username) throws SQLException {
		
		if(!username.isEmpty()) {
			String sql1 = "SELECT * FROM user_account WHERE username=?";
			PreparedStatement st1 = conn.prepareStatement(sql1);
			st1.setString(1, username);
			this.rsUser_Account = st1.executeQuery();
			return true;
		}
		return false;

	}
	//method to create an html table of all users
	public String getHTMLTable() throws SQLException {
		String table = "";
		table += "<table border=1><th>User ID</th><th>User Name</th>"
				+ "<th>Password</th><th>Phone Number</th><th>Email address</th><th>Address</th><th>Registered Product</th>";
		loadData();
		while (this.rsUser_Account.next()) {
				Users user = new Users(this.rsUser_Account.getInt("userid"),
						this.rsUser_Account.getString("username"), this.rsUser_Account.getString("password"),
						this.rsUser_Account.getString("phone_number"), this.rsUser_Account.getString("emailaddress"),
						this.rsUser_Account.getString("address")); // Change
																														// this
																														// object
																														// creation
																														// and
																														// add
																														// the
																														// data
																														// by
																														// using
																														// appropriate
																														// constructor

				table += "<tr>";
				table += "<td>";
				table += user.getUserID();
				table += "</td>";
				table += "<td>";
				table += user.getUserName();
				table += "</td>";
				table += "<td>";
				table += user.getPassword();
				table += "</td>";
				table += "<td>";
				table += user.getPhoneNumber();
				table += "</td>";
				table += "<td>";
				table += user.getEmailAddress();
				table += "</td>";
				table += "<td>";
				table += user.getAddress();
				table += "</td>";
				table += "<td>";
				table += "<a href='AdminController?username="+user.getUserName()+"&condition=allRegisterProduct'>See All Product</a>";
				table += "</td>";
				table += "</tr>";
			}

		return table;
}
	//method to create an html table for a particular user which was searched by admin
	public String getUserTable(String username) throws SQLException {
		String table = "";
		table += "<table border=1><th>User ID</th><th>User Name</th>"
				+ "<th>Password</th><th>Phone Number</th><th>Email address</th><th>Address</th><th>Registered Product</th>";
		if(loadData(username)) {
		while (this.rsUser_Account.next()) {
				Users user = new Users(this.rsUser_Account.getInt("userid"),
						this.rsUser_Account.getString("username"), this.rsUser_Account.getString("password"),
						this.rsUser_Account.getString("phone_number"), this.rsUser_Account.getString("emailaddress"),
						this.rsUser_Account.getString("address")); // Change
																														// this
																														// object
																														// creation
																														// and
																														// add
																														// the
																														// data
																														// by
																														// using
																														// appropriate
																														// constructor

				table += "<tr>";
				table += "<td>";
				table += user.getUserID();
				table += "</td>";
				table += "<td>";
				table += user.getUserName();
				table += "</td>";
				table += "<td>";
				table += user.getPassword();
				table += "</td>";
				table += "<td>";
				table += user.getPhoneNumber();
				table += "</td>";
				table += "<td>";
				table += user.getEmailAddress();
				table += "</td>";
				table += "<td>";
				table += user.getAddress();
				table += "</td>";
				table += "<td>";
				table += "<a href='AdminController?username="+user.getUserName()+"&condition=allRegisterProduct'>See All Product</a>";
				table += "</td>";
				table += "</tr>";
			}
		}

		return table;
}

}
