package dbHelpers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ClaimQuery {
	Connection conn;
	ResultSet rs;
	//constructor to get a db connection object
	public ClaimQuery() throws Exception {
		// conn = [call your static DB method]
		conn= DB.getConnection();
	}
	//method to enter a claim into table when user made a claim and also update the number of claims
	public boolean doRead(String username,String serialno,String claimdate, String description) throws SQLException {
		// READ your Data and save it in ResultSet
		String uUsername = username;
		String pSerialNo = serialno;
		String pClaimDate= claimdate;
		String cDescription = description;

		if (uUsername!=null && pClaimDate != null && cDescription != null && pSerialNo != null) {

			String sql1 = "Insert into claim_warranty (username,serialno,claimdate,description) values(?,?,?,?);";
			PreparedStatement st1 = conn.prepareStatement(sql1);
			st1.setString(1, uUsername);
			st1.setString(2, pSerialNo);
			st1.setString(3, pClaimDate);
			st1.setString(4, cDescription);

			st1.executeUpdate();
			
			String sql2 = "SELECT claims FROM register_product WHERE username=?";
			PreparedStatement st2 = conn.prepareStatement(sql2);
			st2.setString(1, uUsername);
			this.rs=st2.executeQuery();
			
			if(this.rs.next())
			{
				int value=Integer.parseInt(this.rs.getString("claims"));
				String sql3 = "Update register_product SET claims = ? WHERE username=?";
				PreparedStatement st3 = conn.prepareStatement(sql3);
				st3.setString(1, Integer.toString(value-1));
				st3.setString(2, uUsername);
				
				st3.executeUpdate();
			}
			
			return true;
		}
			return false;
	}

}
