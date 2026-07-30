package com.jdbc.day01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.sun.net.httpserver.Authenticator.Success;

public class MultiLayerProductManagement {

	public static void main(String[] args) {
		
	}

}

class OperationsOnDB{
	
	public void createDb(Connection con) {
		
			String  sqlQuery = """
							CREATE TABLE PRODUCTDB(
							ID INT PRIMARY KEY,
							NAME VARCHAR(50),
							PRICE NUMBER,
							QUALITY	INT	)					
					""";
			
			try {
				Statement stmt = con.createStatement();
				stmt.executeUpdate(sqlQuery);
				System.out.println("OperationsOnDB.createDb()");
				IO.println("Table Created Successfully");	
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	public void  addProductToDB(Products products ,PreparedStatement ps, Connection con) {
		String sqlQuery = """
				INSERT INTO PRODUCTDB VALUES (?,?,?,?)
				""";
		try {
			ps = con.prepareStatement(sqlQuery);
			ps.setInt(1,products.getId());
			ps.setString(2, products.getName());
			ps.setDouble(3, products.getPrice());
			ps.executeUpdate();
			IO.println("Product data added successfully");
			
		} catch (SQLException e) {	
			e.printStackTrace();
		}
	}
	
	public void viewpackage com.dsa.bitmanipulation;

public class EvenOrOddByBitManipulation {

	public static void main(String[] args) {
		
		int bitMask = 1;
		int n = 11;
		if((n & bitMask) == 0) IO.println("Even");
		else IO.println("Odd");
		
	}

}
	ProductById( PreparedStatement ps , Connection con ) {
		int searchProductId = Integer.parseInt(IO.readln("Enter the product id which you want to search :"));

		String sqlQuery = "SELECT * FROM PRODUCTDB WHERE ID = ?";
		try {
			ps= con.prepareStatement(sqlQuery);
			ps.setInt(1,searchProductId);
			ResultSet rs  = ps.executeQuery();
			
			if(rs.next()) {
				IO.println("Product DataBase");
				IO.println("Product Id is     :"+ rs.getInt("ID"));
				IO.println("Product Name is   :"+ rs.getString("NAME"));
				IO.println("Product Price is     :"+ rs.getInt("PRICE"));
			} else {
				IO.println("Product not found");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	
	public void showAllProduct(Connection con ,PreparedStatement ps) {
			String sqlQuery = "SELECT * FROM PRODUCTDB";
			
			try {
				ps = con.prepareStatement(sqlQuery);
				ResultSet rs = ps.executeQuery();
			
				IO.println("\nPRODUCTDB DETAILS");
				 System.out.println("---------------------------------------------");
		         System.out.printf("%-10s %-15s %-10s\n",
		                    "ID", "NAME", "PRICE");
		         System.out.println("---------------------------------------------");
		         while(rs.next()) {
		        	 int id = rs.getInt("ID");
		        	 String name = rs.getString("NAME");
		        	 int price = rs.getInt("PRICE");
		        	 System.out.printf("%-10s %-15s %-10s\n",
			                    "ID", "NAME", "PRICE");
		         }
		         System.out.println("---------------------------------------------");
		         IO.println("Table printed Successfully !");
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
	}
	
	
	public static void deleteProduct(Connection con, int id){
		
		String sqlQuery = " DELETE FROM PRODUCTDB WHERE ID= ? ";
		try {
			PreparedStatement ps = con.prepareStatement(sqlQuery);
			ps.setInt(1 , id);
			int rows = ps.executeUpdate();
			
			if(rows > 0 ) {
				IO.println("Product deleted sucessfully");
				
			}else {
				IO.println("Product not found");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
}

class Products{
	private int id;
	private String name;	
	private double price;
	
	public Products(int id, String name, double price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public double getPrice() {
		return price;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
}






// system / system tomacat 





