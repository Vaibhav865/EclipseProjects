package com.jdbc.day01;

/*
 Q-1)
------
Employee Database Operations using JDBC with Oracle
--------------------------------------------------------------------
A company wants to maintain employee information using a Java application connected to an Oracle database. The application should perform basic database operations such as creating a table, inserting employee records, and retrieving employee details.

You are required to develop a Java program that demonstrates JDBC connectivity with Oracle and performs the following operations:

Load the Oracle JDBC Driver
Establish a connection with the Oracle database
Create a table named EMPLOYEE
Insert some employee records
Fetch all employee records
Display the retrieved records in tabular format

Class Structure

Create a class named EmployeeDatabaseApp.

Inside the class:

main() Method Responsibilities
The main() method should perform the following steps:

1)Load Oracle JDBC Driver
     Class.forName("--");
2) Establish Database Connection
     Use the connection URL:


3)Create EMPLOYEE Table

Table Structure:
Column Name	Data Type
EMP_ID	NUMBER
EMP_NAME	VARCHAR2(50)
DEPARTMENT	VARCHAR2(50)
SALARY	NUMBER
-------------------------------------------------------------
Insert Employee Records

Insert the following data:

EMP_ID	EMP_NAME	DEPARTMENT	SALARY
1	John	HR	45000
2	Alice	IT	60000
3	Robert	Finance	55000
-------------------------------------------------------------
Retrieve Employee Records
Use a SELECT query to retrieve all records from the table.
Display Records in Tabular Format
Display the data using a structured format.

Sample Output :
--------------------
Database Connected Successfully
Table Created Successfully
Records Inserted Successfully

EMPLOYEE DETAILS
---------------------------------------------
EMP_ID  EMP_NAME        DEPARTMENT      SALARY
---------------------------------------------
1       John            HR              45000
2       Alice           IT              60000
3       Robert          Finance         55000
-----------------------------------------------
 */



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeDatabaseApp {

	@SuppressWarnings("null")
	public static void main(String[] args) throws SQLException {
		
		Connection con = null ;
		Statement stmt = null;
		ResultSet rs= null;
		
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			IO.println("Driver has been loaded");
			
			 con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe" , "system","Vaibhav");
			IO.println("Connection successful");
				
			String createTable = "CREATE TABLE EMPLOYEE("+
								"EMP_ID NUMBER,"+
								"EMP_NAME VARCHAR(50),"+
								"DEPARTMENT VARCHAR(50),"+
								"SALARY NUMBER)";
			stmt=con.createStatement();
			stmt.executeUpdate(createTable);
			IO.println("Table Created Successfully");			
	        
			
			
			 stmt.executeUpdate("INSERT INTO EMPLOYEE VALUES (1,'John','HR',45000)");
	         stmt.executeUpdate("INSERT INTO EMPLOYEE VALUES (2,'Alice','IT',60000)");
	         stmt.executeUpdate("INSERT INTO EMPLOYEE VALUES (3,'Robert','Finance',55000)");
	         IO.println("Records Inserted Successfully");
			 
	         rs = stmt.executeQuery("SELECT * FROM EMPLOYEE");
	        

	         IO.println("\nEMPLOYEE DETAILS");
	            System.out.println("---------------------------------------------");
	            System.out.printf("%-10s %-15s %-15s %-10s\n",
	                    "EMP_ID", "EMP_NAME", "DEPARTMENT", "SALARY");
	            System.out.println("---------------------------------------------");

	            while (rs.next()) {

	                int id = rs.getInt("EMP_ID");
	                String name = rs.getString("EMP_NAME");
	                String dept = rs.getString("DEPARTMENT");
	                int salary = rs.getInt("SALARY");

	                System.out.printf("%-10d %-15s %-15s %-10d\n",
	                        id, name, dept, salary);
	            }

	            System.out.println("---------------------------------------------");

			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		finally {
			
			 try {
	                if (rs != null) rs.close();
	                if (stmt != null) stmt.close();
	                if (con != null) con.close();
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
			
		}
	}

}
