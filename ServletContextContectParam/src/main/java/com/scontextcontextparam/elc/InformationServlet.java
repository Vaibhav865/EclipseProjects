package com.scontextcontextparam.elc;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/InformationServlet")
public class InformationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
//    public InformationServlet() {
//        super();
//           }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		ServletContext context = getServletContext();
		
		String website = context.getInitParameter("Websitename");
		String company = context.getInitParameter("We think elactic ");
		String email	   = context.getInitParameter("vaibhavpekhale@923");
		
		out.println("<h1>Website name : "+website+"</h1>");
		out.println("<h1>Company name : "+company+"</h1>");
		out.println("<h1>Email :"+email+"</h>");
				
	}

	
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//		
//		doGet(request, response);
//	}

}
