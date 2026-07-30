package com.vaibhav.jdbc.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Jdbc_task_day01 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		IO.println("Driver has been loaded ");
		
		Connection con = DriverManager.getConnection("jdbc:oracl:thin:@localhost:1521:xe","system","Vaibhav");
		IO.println("Connection successful");
		PreparedStatement prepareStatement = null;
		
	}
	
public void register(Jdbc_task_day01_StudentClass s ,PreparedStatement ps , Connection con) throws SQLException {
			
		
		 		ps = con.prepareStatement(
				
				"INSERT INTO students VALUES (?, ?, ?, ?, ?, ?, ?)");
		        ps.setInt(1, s.getRollNo());
		        ps.setString(2, s.getName());
		        ps.setDouble(3, s.getPercentage());
		        ps.setString(4, s.getFname());
		        ps.setString(5, s.getLname());
		        ps.setString(6, s.getMailId());
		        ps.setString(7, s.getPhoneNo());
		        ps.executeUpdate();
		        System.out.println("Student registered successfully!");
		}

}






class Jdbc_task_day01_StudentClass {

	
	private String name;
	private int rollNo;
	private double percentage;
	private String fname;
	private String lname;
	private String mailId;
	private String phoneNo;
	
	public Jdbc_task_day01_StudentClass(String name, int rollNo, double percentage, String fname, String lname,
			String mailId, String phoneNo) {
		super();
		this.name = name;
		this.rollNo = rollNo;
		this.percentage = percentage;
		this.fname = fname;
		this.lname = lname;
		this.mailId = mailId;
		this.phoneNo = phoneNo;
	}

	public String getName() {
		return name;
	}

	public int getRollNo() {
		return rollNo;
	}

	public double getPercentage() {
		return percentage;
	}

	public String getFname() {
		return fname;
	}

	public String getLname() {
		return lname;
	}

	public String getMailId() {
		return mailId;
	}

	public String getPhoneNo() {
		return phoneNo;
	}
	
	
}


