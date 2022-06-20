package dbHelpers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import models.Claim;
import models.Product;

public class CreateTableQuery {
	Connection conn;
	ResultSet rsUser_Account, rsRegister_Product, rsClaim_Warranty;
	//constructor to get a db connection object
	public CreateTableQuery() throws Exception {
		// conn = [call your static DB method]
		conn = DB.getConnection();
	}
	//method to get a user and all its registered product and claims
	public void loadData(String username) throws SQLException {

		String uUsername = username;

		String sql1 = "SELECT * FROM user_account WHERE username=?";
		PreparedStatement st1 = conn.prepareStatement(sql1);
		st1.setString(1, uUsername);
		this.rsUser_Account = st1.executeQuery();

		String sql2 = "SELECT * FROM register_product WHERE username=?";
		PreparedStatement st2 = conn.prepareStatement(sql2);
		st2.setString(1, uUsername);
		this.rsRegister_Product = st2.executeQuery();

		String sql3 = "SELECT * FROM claim_warranty WHERE username=?";
		PreparedStatement st3 = conn.prepareStatement(sql3);
		st3.setString(1, uUsername);
		this.rsClaim_Warranty = st3.executeQuery();

	}
	//method to create an html table with details of a user and its registerd product and claims 
	public String getHTMLTable(String username) throws SQLException {
		String table = "";
		table += "<table border=1><th>Serial Number</th><th>Product Name</th>"
				+ "<th>Purchase Date</th><th>Claims Left</th><th>Action</th><th>Claim Date</th>" + "<th>Status</th>";
		loadData(username);
		if (this.rsClaim_Warranty.isBeforeFirst()) {
			while (this.rsRegister_Product.next()) {
				while (this.rsClaim_Warranty.next()) {
					Product product = new Product(this.rsRegister_Product.getString("username"),
							this.rsRegister_Product.getString("serialno"),
							this.rsRegister_Product.getString("productname"),
							this.rsRegister_Product.getString("purchasedate"),
							this.rsRegister_Product.getInt("claims")); // Change
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

					Claim claim = new Claim(this.rsClaim_Warranty.getString("serialno"),
							this.rsClaim_Warranty.getString("claimDate"),
							this.rsClaim_Warranty.getString("description"), this.rsClaim_Warranty.getString("status"));
					table += "<tr>";
					table += "<td>";
					table += product.getSerialNumber();
					table += "</td>";
					table += "<td>";
					table += product.getProductName();
					table += "</td>";
					table += "<td>";
					table += product.getPurchaseDate();
					table += "</td>";
					table += "<td>";
					table += product.getClaims();
					table += "</td>";
					table += "<td>";
					table += "<a href='Claim.jsp?username=" + product.getUserName() + "&serialno="
							+ product.getSerialNumber() + "&claim=" + product.getClaims() + "'>Claim</a>";
					table += "</td>";
					table += "<td>";
					table += claim.getClaimDate();
					table += "</td>";
					table += "<td>";
					table += claim.getStatus();
					table += "</td>";
					table += "</tr>";
				}
			}

		} else {
			//method to create an html table when user has not made an claim with details of a user and its registerd product
			while (this.rsRegister_Product.next()) {
				Product product = new Product(this.rsRegister_Product.getString("username"),
						this.rsRegister_Product.getString("serialno"), this.rsRegister_Product.getString("productname"),
						this.rsRegister_Product.getString("purchasedate"), this.rsRegister_Product.getInt("claims")); // Change
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
				table += product.getSerialNumber();
				table += "</td>";
				table += "<td>";
				table += product.getProductName();
				table += "</td>";
				table += "<td>";
				table += product.getPurchaseDate();
				table += "</td>";
				table += "<td>";
				table += product.getClaims();
				table += "</td>";
				table += "<td>";
				table += "<a href='Claim.jsp?username=" + product.getUserName() + "&serialno="
						+ product.getSerialNumber() + "'>Claim</a>";
				table += "</td>";
				table += "<td>";
				table += "";
				table += "</td>";
				table += "<td>";
				table += "";
				table += "</td>";
				table += "</tr>";
			}

		}
		return table;
	}

}
