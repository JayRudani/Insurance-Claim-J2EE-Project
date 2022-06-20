package dbHelpers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import models.Product;

public class AllRegisteredProductQuery {
	Connection conn;
	ResultSet rsRegister_Product;
	//constructor to get db connection object 
	public AllRegisteredProductQuery() throws Exception {
		// conn = [call your static DB method]
		conn = DB.getConnection();
	}
	//method to get all registered product by a user
	public void loadData(String username) throws SQLException {

		String sql1 = "SELECT * FROM register_product WHERE username=?";
		PreparedStatement st1 = conn.prepareStatement(sql1);
		st1.setString(1, username);
		this.rsRegister_Product = st1.executeQuery();

	}
	//method to get a registered product searched by the admin
	public boolean loadData(String username,String productname) throws SQLException {

		if (!productname.isEmpty()) {
			String sql1 = "SELECT * FROM register_product WHERE username=? AND productname=?";
			PreparedStatement st1 = conn.prepareStatement(sql1);
			st1.setString(1, username);
			st1.setString(2, productname);
			this.rsRegister_Product = st1.executeQuery();
			return true;
		}
		return false;

	}
	//method to create an html table which all registered product
	public String getHTMLTable(String username) throws SQLException {
		String table = "";
		table += "<table border=1><th>Serial Number</th><th>Product Name</th><th>Purchase Date</th><th>Claims Left</th><th>All Claims</th>";
		loadData(username);
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
			table += "<a href='AdminController?username="+product.getUserName()+"&condition=allClaims'>See All Claims</a>";
			table += "</td>";
			table += "</tr>";
		}

		return table;
	}
	//method to create an html table which a particular registered product which was searched
	public String getProductTable(String username,String productname) throws SQLException {
		String table = "";
		table += "<table border=1><th>Serial Number</th><th>Product Name</th><th>Purchase Date</th><th>Claims Left</th><th>All Claims</th>";
		if (loadData(username,productname)) {
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
				table += "<a href='AdminController?username="+product.getUserName()+"&condition=allClaims'>See All Claims</a>";
				table += "</td>";
				table += "</tr>";
			}
		}

		return table;
	}

}
