package com.connection.elc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class TestConnection1 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		IO.println("Driver is loaded");
		
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Vaibhav");
		IO.println("Connection succefully ");
		
		Statement stmt = con.createStatement();
		IO.println("Statement is created");
		
		stmt.execute("""
							CREATE USER C##VAIBHAV1 IDENTIFIED BY vaibhav1
					""");
		stmt.execute("""
							alter session set
							"_oracle_script" = true
					""");
			
		stmt.execute("""    
				
					GRANT CONNECT, RESOURCE TO C##VAIBHAV1

					""");

		
		IO.println("User is created");
		
		stmt.close();
		con.close();
	}

}
