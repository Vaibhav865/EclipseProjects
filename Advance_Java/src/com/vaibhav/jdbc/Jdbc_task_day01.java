package com.vaibhav.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbc_task_day01 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		IO.println("Driver has been loaded ");
		
		Connection con = DriverManager.getConnection("jdbc:oracl:thin:@localhost:1521:xe","system","Vaibhav");
		IO.println("Connection successful");
		
		
		
		IO.println("Statement created ");
	
		
	}
	
public void register(Student s , Connection con) {
			
		
		PreparedStatement ps = con.prepareStatement(
				
				"INSERT INTO students VALUES (?, ?, ?, ?, ?, ?, ?)");
		        ps.setInt(1, s.getRollNo());
		        ps.setString(2, s.getName());
		        ps.setDouble(3, s.getPercentage());
		        ps.setString(4, s.getfName());
		        ps.setString(5, s.getlName());
		        ps.setString(6, s.getMailId());
		        ps.setString(7, s.getPhoneNo());
		        ps.executeUpdate();
		        System.out.println("Student registered successfully!");
		}

}





























/*
 * 
 * import java.sql.*;
import java.util.*;

public class StudentDAO {
    private Connection con;

    public StudentDAO() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/studentdb", "root", "password");
    }

    // Register student
    public void register(Student s) throws Exception {
        PreparedStatement ps = con.prepareStatement(
            "INSERT INTO students VALUES (?, ?, ?, ?, ?, ?, ?)");
        ps.setInt(1, s.getRollNo());
        ps.setString(2, s.getName());
        ps.setDouble(3, s.getPercentage());
        ps.setString(4, s.getfName());
        ps.setString(5, s.getlName());
        ps.setString(6, s.getMailId());
        ps.setString(7, s.getPhNo());
        ps.executeUpdate();
        System.out.println("Student registered successfully!");
    }

    // Login
    public boolean login(int rollNo, String name) throws Exception {
        PreparedStatement ps = con.prepareStatement(
            "SELECT * FROM students WHERE RollNo=? AND StudentName=?");
        ps.setInt(1, rollNo);
        ps.setString(2, name);
        ResultSet rs = ps.executeQuery();
        return rs.next();
    }

    // Show students > 60%
    public void showAbove60() throws Exception {
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM students WHERE Percentage > 60");
        while(rs.next()) {
            System.out.println(rs.getInt("RollNo") + " - " + rs.getString("StudentName"));
        }
    }

    // Update MailId & PhNo
    public void updateContact(int rollNo, String mail, String ph) throws Exception {
        PreparedStatement ps = con.prepareStatement(
            "UPDATE students SET MailId=?, PhNo=? WHERE RollNo=?");
        ps.setString(1, mail);
        ps.setString(2, ph);
        ps.setInt(3, rollNo);
        ps.executeUpdate();
        System.out.println("Contact updated!");
    }

    // Delete students between 30–60%
    public void deleteBetween30And60() throws Exception {
        Statement st = con.createStatement();
        int rows = st.executeUpdate("DELETE FROM students WHERE Percentage BETWEEN 30 AND 60");
        System.out.println(rows + " students deleted.");
    }

    // Count students > 80%
    public void countAbove80() throws Exception {
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT COUNT(*) FROM students WHERE Percentage > 80");
        if(rs.next()) {
            System.out.println("Students above 80%: " + rs.getInt(1));
        }
    }
}

 */
