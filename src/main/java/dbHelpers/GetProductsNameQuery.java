package dbHelpers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import models.Product;

public class GetProductsNameQuery {
	Connection conn;
	ResultSet rsProduct_Name;
	//constructor to get a db connection object
	public GetProductsNameQuery() throws Exception {
		// conn = [call your static DB method]
		conn = DB.getConnection();
	}
	//method to get all product name available to claim
	public void loadData() throws SQLException {

		String sql1 = "SELECT * FROM product_name";
		PreparedStatement st1 = conn.prepareStatement(sql1);
		this.rsProduct_Name = st1.executeQuery();

	}
	//method to create a drop down list which has all product name
	public String getSelectList() throws SQLException {
		String selectList = "";
		selectList += "<select name='productname'>";
		loadData();
		while (this.rsProduct_Name.next()) {
			Product product = new Product(this.rsProduct_Name.getString("productname")); // Change
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
			
			selectList += "<option value='"+product.getProductName()+"'>"+product.getProductName()+"</option>";
		}
		selectList+="</select>";
		return selectList;
	}

}
