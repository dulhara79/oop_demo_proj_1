package com.customer;

import java.sql.Connection;
//import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CustomerDBUtil {
	
	private static boolean isSuccess;
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	
	public static List<Customer> validate(String userName, String password) {
		
		
		ArrayList<Customer> cus = new ArrayList<>();
		
		/*
		 * //create db connection String url =
		 * "jdbc:mysql://localhost:3306/hotel?useSSL=false"; String user = "root";
		 * String pass = "Password";
		 */
		
		//validate
		
		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			Connection con = DriverManager.getConnection(url,user,pass);
//			Statement stmt = con.createStatement();
			
			con = DBConnect.getConnection(); 
			stmt = con.createStatement();
			String sql = "select * from customer where username='" + userName + "' and password='" + password + "'";
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String email = rs.getString(3);
				String phone = rs.getString(4);
				String userU = rs.getString(5);
				String passU = rs.getString(6);
				
				Customer c = new Customer(id,name,email,phone,userU,passU);
				
				cus.add(c);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return cus;
		
	}
	
	public static boolean InsertCustomer(/* String idStr, */int id, String name, String email, String phone, String username, String password) {
		
		boolean isSuccess = false;
		
		//create db connection
		/*
		 * String url = "jdbc:mysql://localhost:3306/hotel?useSSL=false"; String user =
		 * "root"; String pass = "Password";
		 */
		
		try{
			/*
			 * Class.forName("com.mysql.jdbc.Driver"); Connection con =
			 * DriverManager.getConnection(url,user,pass); Statement stmt =
			 * con.createStatement();
			 */
			
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "insert into customer values (0, '"+name+"', '"+email+"', '"+phone+"', '"+username+"', '"+password+"')";
			
			int update = stmt.executeUpdate(sql);
			
			if(update > 0) {
				isSuccess = true;
			} else {
				
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return isSuccess;
	}
	
	
	public static boolean UpdateCustomer(String id, String name, String email, String phone, String username, String password) {
		
		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "update customer set name='"+name+"', email='"+email+"', phone='"+phone+"', username='"+username+"', password='"+password+"' where id='"+id+"'";
//			String sql = "update customer set name='"+name+"', email='"+email+"', phone='"+phone+"', username='"+username+"', password='"+password+"'" + "where id='"+id+"'";
			
			int rs = stmt.executeUpdate(sql);
			
			if (rs > 0) {
				isSuccess = true;
			} else {
				isSuccess = false;
			}

		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return isSuccess;
	}
	
	public static List<Customer> GetcustomerDetails(String id) {
		
		int convUpdID = Integer.parseInt(id);
		
		ArrayList<Customer> cus = new ArrayList<>();
		
		try {
			
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "select * from customer where id='"+convUpdID+"'";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				int Id = rs.getInt(1);
				String name = rs.getString(2);
				String email = rs.getString(3);
				String phone = rs.getString(4);
				String username = rs.getString(5);
				String password = rs.getString(6);
				
				Customer c = new Customer(Id, name, email, phone, username, password);
				cus.add(c);
			}	
			
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return cus;
	}
	
	public static boolean DeleteCustomer(String id) {
		
		int convDelID = Integer.parseInt(id);
		
		try {
			
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			
			String sql = "delete from customer where id='"+convDelID+"'";
			
			int rs = stmt.executeUpdate(sql);
			
			if(rs > 0) {
				isSuccess = true;
				
			} else {
				
				isSuccess = false;				
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return isSuccess;
		
	}
	
}
