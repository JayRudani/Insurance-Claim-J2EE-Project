package dbHelpers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import models.Claim;

public class AllClaimsQuery {
	Connection conn;
	ResultSet rsClaim_Warranty;
	//constructor to get db connection object
	public AllClaimsQuery() throws Exception {
		// conn = [call your static DB method]
		conn = DB.getConnection();
	}
	//method to get all claims made by a particular user
	public void loadData(String username) throws SQLException {

		String sql1 = "SELECT * FROM claim_warranty WHERE username=?";
		PreparedStatement st1 = conn.prepareStatement(sql1);
		st1.setString(1, username);
		this.rsClaim_Warranty = st1.executeQuery();

	}
	//method to change the status of a claim made by the user
	public void loadData(String username, String condition,String claimdate) throws SQLException {

		String sql1 = "Update claim_warranty SET status = ? WHERE username=? AND claimdate=?";
		PreparedStatement st1 = conn.prepareStatement(sql1);
		st1.setString(1, condition);
		st1.setString(2, username);
		st1.setString(3, claimdate);
		st1.executeUpdate();

		String sql2 = "SELECT * FROM claim_warranty WHERE username=?";
		PreparedStatement st2 = conn.prepareStatement(sql2);
		st2.setString(1, username);
		this.rsClaim_Warranty = st2.executeQuery();

	}
	//method to create a html table of all claims made by user
	public String getHTMLTable(String username) throws SQLException {
		String table = "";
		table += "<table border=1><th>Claim Date</th><th>Description</th><th>status</th><th colspan=2>Action</th>";
		loadData(username);
		while (this.rsClaim_Warranty.next()) {
			Claim claim = new Claim(this.rsClaim_Warranty.getString("username"),this.rsClaim_Warranty.getString("serialno"),
					this.rsClaim_Warranty.getString("claimdate"), this.rsClaim_Warranty.getString("description"),
					this.rsClaim_Warranty.getString("status")); // Change
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
			table += claim.getClaimDate();
			table += "</td>";
			table += "<td>";
			table += claim.getDescription();
			table += "</td>";
			table += "<td>";
			table += claim.getStatus();
			table += "</td>";
			table += "<td>";
			table += "<a href='AdminController?username=" + claim.getUserName() + "&condition=accepted&claimdate="+claim.getClaimDate()+"'>Accept</a>";
			table += "</td>";
			table += "<td>";
			table += "<a href='AdminController?username=" + claim.getUserName() + "&condition=rejected&claimdate="+claim.getClaimDate()+"'>Reject</a>";
			table += "</td>";
			table += "</tr>";
		}

		return table;
	}
	//create an updated table with the updated status of the claim made by the user
	public String getNewHTMLTable(String username, String condition,String claimdate) throws SQLException {
		String table = "";
		table += "<table border=1><th>Claim Date</th><th>Description</th><th>status</th><th colspan=2>Action</th>";
		
		loadData(username, condition,claimdate);
		while (this.rsClaim_Warranty.next()) {
			Claim claim = new Claim(this.rsClaim_Warranty.getString("username"),this.rsClaim_Warranty.getString("serialno"),
					this.rsClaim_Warranty.getString("claimdate"), this.rsClaim_Warranty.getString("description"),
					this.rsClaim_Warranty.getString("status")); // Change
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
			table += claim.getClaimDate();
			table += "</td>";
			table += "<td>";
			table += claim.getDescription();
			table += "</td>";
			table += "<td>";
			table += claim.getStatus();
			table += "</td>";
			table += "<td>";
			table += "<a href='AdminController?username=" + claim.getUserName() + "&condition=accepted&claimdate="+claim.getClaimDate()+"'>Accept</a>";
			table += "</td>";
			table += "<td>";
			table += "<a href='AdminController?username=" + claim.getUserName() + "&condition=rejected&claimdate="+claim.getClaimDate()+"'>Reject</a>";
			table += "</td>";
			table += "</tr>";
		}
		return table;
	}

}
