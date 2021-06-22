package utilities;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Tester {

	public static void main(String[] args) {
		Connection conn = new DBConnections().getConnection();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from product_data");
			while(rs.next()) {
				System.out.println("Product ID -> "+rs.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
