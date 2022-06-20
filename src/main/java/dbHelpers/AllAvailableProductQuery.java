package dbHelpers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import models.Product;

public class AllAvailableProductQuery {
	Connection conn;
	ResultSet rsRegister_Product;
	
	//constructor to get db connection object 
	public AllAvailableProductQuery() throws Exception {
		// conn = [call your static DB method]
		conn = DB.getConnection();
	}
	
	///method to get all the available products
	public void loadData() throws SQLException {

		String sql1 = "SELECT * FROM all_product";
		PreparedStatement st1 = conn.prepareStatement(sql1);
		this.rsRegister_Product = st1.executeQuery();

	}
	
	//method to search for an particular product name
	public boolean loadData(String productname) throws SQLException {

		if (!productname.isEmpty()) {
			String sql1 = "SELECT * FROM all_product WHERE productname=?";
			PreparedStatement st1 = conn.prepareStatement(sql1);
			st1.setString(1, productname);
			this.rsRegister_Product = st1.executeQuery();
			return true;
		}
		return false;

	}
	//method to create a html table with all details of products
	public String getHTMLTable() throws SQLException {
		String table = "";
		table += "<table border=1><th>Serial Number</th><th>Product Name</th>";
		loadData();
		while (this.rsRegister_Product.next()) {
			Product product = new Product(
					this.rsRegister_Product.getString("serialno"), this.rsRegister_Product.getString("productname")); // Change
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
			table += "</tr>";
		}

		return table;
	}
	//method to create an html table for a particular product name which was searched
	public String getProductTable(String productname) throws SQLException {
		String table = "";
		table += "<table border=1><th>Serial Number</th><th>Product Name</th>";
		if (loadData(productname)) {
			while (this.rsRegister_Product.next()) {
				Product product = new Product(
						this.rsRegister_Product.getString("serialno"), this.rsRegister_Product.getString("productname")); // Change
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
				table += "</tr>";
			}
		}

		return table;
	}

}
