package com.servlet.elc;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Users")
public class Users extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		PrintWriter pw = response.getWriter();
		// getting data from the form
		String id = request.getParameter("uid");
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String mail = request.getParameter("mail");
		String phoneNo = request.getParameter("phoneNo");
		
		pw.println("<h2>User Details</h2>");
		pw.println("UserId 		   : "+id+"</br>");
		pw.println("User First Name: "+fname+"</br>");
		pw.println("User last Name : "+lname+"</br>");
		pw.println("Mail     	   : "+mail+"</br>");
		pw.println("Phone No   	   : "+phoneNo+"</br>");
		
	}


}
