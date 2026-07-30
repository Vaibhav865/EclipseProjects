package com.jdbc.day01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProductInventoryELC {

	public static void main(String[] args) {
			
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = getConnection();
			//createTableMethod(con);
			insertIntoTableMethod(con);
			searchProduct(con);
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	
	}
	
	public static Connection getConnection() {
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Vaibhav");
			IO.println("Connection Sucessfull");
		} catch(Exception e) {
			e.printStackTrace();
		}
		return con;
		
	}
	
	public static void createTableMethod(Connection con) throws SQLException {
		Statement stmt = con.createStatement();
		String createTable = """
				CREATE TABLE PRODUCT(
				PRODUCT_ID	NUMBER,
				PRODUCT_NAME	VARCHAR2(50),
				CATEGORY	 VARCHAR2(50),
				 PRICE  NUMBER)
				""";
				
		stmt.executeUpdate(createTable);
		System.out.println("ProductInventoryELC.createTableMethod()");
		IO.println("Table Created Successfully");		
	}
	
	public static void insertIntoTableMethod(Connection con) throws SQLException {
		boolean flag = true;
		while(flag) {
			String choice = IO.readln("Do you want to add product  yes / no ");
			
			if(choice.equalsIgnoreCase("yes")) {
				int productId = Integer.parseInt(IO.readln("Enter the product id :"));
				String productName = IO.readln("Enter the product name :");
				String productCategory = IO.readln("Enter the product category :");
				Double productPrice = Double.parseDouble(IO.readln("Enter the product price :"));		
				
				String insertStatement = "INSERT INTO PRODUCT VALUES(?,?,?,?)";
				PreparedStatement ps = con.prepareStatement(insertStatement);
				ps.setInt(1, productId);
				ps.setString(2,productName);
				ps.setString(3,productCategory);
				ps.setDouble(4, productPrice);
				ps.executeUpdate();
				IO.println("Data has been succefully inserted into the product table");	
			} else {
				flag = false;
			}
		}
		
		
	}
	
	
	public static void searchProduct(Connection con) throws SQLException {
		
		int searchProductId = Integer.parseInt(IO.readln("Enter the product id which you want to search :"));
		
		String searchStmt = "SELECT * FROM PRODUCT WHERE PRODUCT_ID=?";
		PreparedStatement ps = con.prepareStatement(searchStmt);
		
		ps.setInt(1, searchProductId);
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			IO.println("\n---------------------------------");
			IO.println("Product Id       :" + rs.getInt("PRODUCT_Id"));
			IO.println("Product Name     :" + rs.getString("PRODUCT_NAME"));
			IO.println("Product category :" + rs.getString("CATEGORY"));
			IO.println("Product price    :" + rs.getInt("PRICE"));
			
		}else {
			IO.println("Product not found");
		}
			
	}

}



/*
 * import java.sql.*;
import java.util.Scanner;

public class ProductInventoryELC {

    static Scanner sc = new Scanner(System.in);

    // 1️⃣ Get Connection
    public static Connection getConnection() {

        Connection con = null;

        try {
            con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:xe",
                    "system",
                    "Vaibhav");

            System.out.println("Oracle Database Connected Successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }

        return con;
    }

    // 2️ Create Table
    public static void createTable(Connection con) {

        try {

            Statement stmt = con.createStatement();

            String sql = "CREATE TABLE PRODUCT (" +
                    "PRODUCT_ID NUMBER PRIMARY KEY, " +
                    "PRODUCT_NAME VARCHAR2(50), " +
                    "CATEGORY VARCHAR2(50), " +
                    "PRICE NUMBER)";

            stmt.executeUpdate(sql);

            System.out.println("PRODUCT table created successfully");

        } catch (SQLException e) {
            System.out.println("Table already exists");
        }
    }

    // 3️ Insert Product
    public static void insertProduct(Connection con) {

        try {

            System.out.print("Enter Product ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Product Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Category: ");
            String category = sc.nextLine();

            System.out.print("Enter Price: ");
            double price = sc.nextDouble();

            String sql = "INSERT INTO PRODUCT VALUES(?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setString(3, category);
            ps.setDouble(4, price);

            ps.executeUpdate();

            System.out.println("Product inserted successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 4️⃣ Search Product
    public static void searchProduct(Connection con) {

        try {

            System.out.print("Enter Product ID to search: ");
            int id = sc.nextInt();

            String sql = "SELECT * FROM PRODUCT WHERE PRODUCT_ID=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                System.out.println("\n---------------------------------------");
                System.out.println("Product ID   : " + rs.getInt("PRODUCT_ID"));
                System.out.println("Product Name : " + rs.getString("PRODUCT_NAME"));
                System.out.println("Category     : " + rs.getString("CATEGORY"));
                System.out.println("Price        : " + rs.getDouble("PRICE"));
                System.out.println("---------------------------------------");

            } else {
                System.out.println("Product not found");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 5️⃣ Main Method
    public static void main(String[] args) {

        try {

            // Load Driver
            Class.forName("oracle.jdbc.driver.OracleDriver");

            Connection con = getConnection();

            createTable(con);

            insertProduct(con);

            searchProduct(con);

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
 */
