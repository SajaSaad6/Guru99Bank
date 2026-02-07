package com.qa.guru99bank.config;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

public class CustomerDAO {
	
	public static void saveCustomerId(Map<String, String> customer) {
		String sql = """
				INSERT INTO customers (customer_id, name, gender, dob, address, 
										city, state, pin, mobile, email, password)
				VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
				ON CONFLICT (customer_id) DO NOTHING
				""";
		
		try (Connection conn = DatabaseManager.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1,  customer.get("Customer ID"));
			ps.setString(2,  customer.get("Customer Name"));
			ps.setString(3,  customer.get("Gender"));
			ps.setDate(4,  Date.valueOf(customer.get("Birthdate")));
			//ps.setString(5,  customer.get("Birthdate"));
			ps.setString(5,  customer.get("Address"));
			ps.setString(6,  customer.get("City"));
			ps.setString(7,  customer.get("State"));
			ps.setString(8,  customer.get("Pin"));
			ps.setString(9,  customer.get("Mobile No."));
			ps.setString(10,  customer.get("Email"));
			ps.setString(11,  customer.get("password"));
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	public static String getLatestCustomerId() {
		String sql = """
		        SELECT customer_id
		        FROM customers
		        ORDER BY created_at DESC
		        LIMIT 1
		    """;

		    try (Connection conn = DatabaseManager.getConnection();
		         Statement stmt = conn.createStatement();
		         ResultSet rs = stmt.executeQuery(sql)) {

		        if (rs.next()) {
		            return rs.getString("customer_id");
		        }

		    } catch (SQLException e) {
		        throw new RuntimeException(e);
		    }
		    return null;
	}
	
	
	public static void deleteCustomer(String customerId) {
	    String sql = "DELETE FROM customers WHERE customer_id = ?";

	    try (Connection conn = DatabaseManager.getConnection();
	         PreparedStatement ps = conn.prepareStatement(sql)) {

	        ps.setString(1, customerId);
	        ps.executeUpdate();

	    } catch (SQLException e) {
	        throw new RuntimeException(e);
	    }
	}
	
}
