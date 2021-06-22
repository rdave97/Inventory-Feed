package utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnections {
	public Connection getConnection() {
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/product_db","root","root");
			return conn;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
