package dbHelpers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class RegisterProductQuery {
	Connection conn;
	ResultSet rs;
	//constructor to get a db connection object
	public RegisterProductQuery() throws Exception {
		// conn = [call your static DB method]
		conn = DB.getConnection();
	}
	//method called when a user wants to register a product under his/her account
	public boolean doRead(String username, String productname, String serialno, String purchasedate)
			throws SQLException {
		// READ your Data and save it in ResultSet
		String uname = username;
		String pProductName = productname;
		String pSerialno = serialno;
		String pPurchaseDate = purchasedate;

		if (uname != null && pProductName != null && pSerialno != null && pPurchaseDate != null) {

			String sql1 = "SELECT * FROM all_product WHERE productname=? AND serialno=?";
			PreparedStatement st1 = conn.prepareStatement(sql1);
			st1.setString(1, pProductName);
			st1.setString(2, pSerialno);
			this.rs = st1.executeQuery();

			if (rs.next()) {
				String sql2 = "Insert into register_product (username,serialno,productname,purchasedate) values(?,?,?,?);";
				PreparedStatement st2 = conn.prepareStatement(sql2);
				st2.setString(1, uname);
				st2.setString(2, pSerialno);
				st2.setString(3, pProductName);
				st2.setString(4, pPurchaseDate);

				st2.executeUpdate();
				return true;
			} else {
				return false;
			}
		}
		return false;
	}

}
