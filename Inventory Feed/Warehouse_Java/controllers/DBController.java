package controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import models.Product;
import utilities.DBConnections;

public class DBController {
	public boolean addData(List<Product> productList) {
		Connection conn = new DBConnections().getConnection();
		try {
			PreparedStatement ps;
			ps = conn.prepareStatement("drop table product_data;");
			int output = ps.executeUpdate();
			if (output == 1) {
				System.out.println("Table Drop Succeeded");
			}
			ps = conn.prepareStatement(
					"create table product_data(product_id varchar(40) primary key,quantity integer);");
			output = ps.executeUpdate();
			if (output == 1) {
				System.out.println("New table created");
			}

			for (Product p : productList) {

				ps = conn.prepareStatement("insert into product_data values (?,?);");
				ps.setString(1, p.getProductID());
				ps.setInt(2, p.getQuantity());
				output = ps.executeUpdate();
				if (output == 0) {
					System.out.println("Some errors occured");
				}
			}
			conn.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
